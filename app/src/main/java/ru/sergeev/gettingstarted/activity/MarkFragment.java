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
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import ru.sergeev.gettingstarted.R;

/**
 * Created by serge on 20.02.2018.
 */

public class MarkFragment extends Fragment {

    private Spinner spinner;
    private Adapter spinnerAdapter;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)  {
        return inflater.inflate(R.layout.activity_mark, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        spinner = (Spinner) view.findViewById(R.id.spinnerSubjectChooser);

        spinnerAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.subjectArray, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), (CharSequence) parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        getActivity().setTitle("Оценки");
    }
}