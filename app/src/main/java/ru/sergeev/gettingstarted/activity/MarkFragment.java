package ru.sergeev.gettingstarted.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.R;
import ru.sergeev.gettingstarted.entities.Day;
import ru.sergeev.gettingstarted.service.Service;

/**
 * Created by serge on 20.02.2018.
 */

public class MarkFragment extends Fragment {

    private EditText textForAddDay;
    private Button buttonAddDay;
    private Spinner spinner;
    private Adapter spinnerAdapter;
    private Realm realm;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_mark, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        refreshSpinner();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner = view.findViewById(R.id.spinnerSubjectChooser);
        textForAddDay = view.findViewById(R.id.textDayName);
        buttonAddDay = view.findViewById(R.id.buttonAddDay);
        buttonAddDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDayToDB();
            }
        });
        realm = Realm.getDefaultInstance();

        spinner.setSelected(false);  // otherwise listener will be called on initialization
        spinner.setSelection(0, true);  // otherwise listener will be called on initialization
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Service.getInstance().deleteDayByName(spinner.getSelectedItem().toString(), realm);
                    Toast.makeText(parent.getContext(), "Item deleted with name: " + spinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        getActivity().setTitle("Оценки");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    void refreshSpinner() {

        ArrayList<String> dayArray = new ArrayList<>();
        RealmResults<Day> results = Service.getInstance().listAllDays();
        if (results == null) {
            return;
        }

        for (Day d : results) {
            if (d == null) {
                return;
            }
            dayArray.add(d.getDayName());
        }
        spinnerAdapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, dayArray);
        spinner.setAdapter((SpinnerAdapter) spinnerAdapter);
    }

    void saveDayToDB() {
        Service.getInstance().addDay(textForAddDay.getText().toString());
        refreshSpinner();
        Toast.makeText(getContext(), "Item added with name: " + textForAddDay.getText().toString(), Toast.LENGTH_LONG).show();
    }
}