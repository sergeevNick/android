package ru.sergeev.gettingstarted.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.DAO.MarkRepository;
import ru.sergeev.gettingstarted.DAO.SubjectRepository;
import ru.sergeev.gettingstarted.R;
import ru.sergeev.gettingstarted.adapters.MarkAdapter;
import ru.sergeev.gettingstarted.entities.Mark;
import ru.sergeev.gettingstarted.entities.Subject;
import ru.sergeev.gettingstarted.environment.Environment;
import ru.sergeev.gettingstarted.environment.Params;
import ru.sergeev.gettingstarted.service.RequestServiceData;

/**
 * Created by serge on 20.02.2018.
 */

public class MarkFragment extends Fragment {
    private RecyclerView marksRecyclerView;
    private Spinner spinner;
    private Spinner addMarkSpinner;
    private Realm realm = Realm.getDefaultInstance();
    private MarkRepository markRepository = new MarkRepository(realm);
    private SubjectRepository subjectRepository = new SubjectRepository(realm);

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RequestQueue queue = Volley.newRequestQueue(this.getContext());
        String url = Environment.Mark.all;

        // Request a string response from the provided URL.
        StringRequest stringRequest = RequestServiceData.get(url, new Params(), Mark.class);
        queue.add(stringRequest);
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
        marksRecyclerView = view.findViewById(R.id.markListView);
        marksRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        marksRecyclerView.setLayoutManager(mLayoutManager);
        marksRecyclerView.setItemAnimator(new DefaultItemAnimator());

        Button addMarkButton = view.findViewById(R.id.addMarkButton);
        addMarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postMark(1, spinner.getSelectedItem().toString(), addMarkSpinner.getSelectedItem().toString());

                Toast.makeText(getContext(), "Added mark: " + addMarkSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        spinner = view.findViewById(R.id.spinnerSubjectChooser);
        addMarkSpinner = view.findViewById(R.id.addMarkSpinner);

        spinner.setSelected(false);  // otherwise listener will be called on initialization
        addMarkSpinner.setSelected(false);  // otherwise listener will be called on initialization
        spinner.setSelection(0, true);  // otherwise listener will be called on initialization
        addMarkSpinner.setSelection(0, true);  // otherwise listener will be called on initialization
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getMarksList(1, spinner.getSelectedItem().toString());
                Toast.makeText(parent.getContext(), "Getting marks for subject: " + spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
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
        this.realm.close();
    }

    private void getMarksList(Integer studentId, String subjectName) {
        try {
            RealmResults<Mark> marks = this.markRepository.findMarksByStudentIdAndSubjectName(studentId, subjectName);
            MarkAdapter markAdapter = new MarkAdapter(getActivity(), marks);
            marksRecyclerView.setAdapter(markAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void postMark(final Integer studentId, final String subjectName, String markValue) {
        try {
            RequestQueue queue = Volley.newRequestQueue(this.getContext());
            String url = Environment.Mark.byStudentAndSubject;

            Subject subject = this.subjectRepository.findSubjectByName(subjectName);
            Params params = new Params();
            params.studentId = studentId.toString();
            params.subjectId = subject.getSubjectId().toString();

            JSONObject body = new JSONObject();
            body.put("value", Integer.parseInt(markValue));

            // Request a string response from the provided URL.
            JsonObjectRequest jsonObjectRequest = RequestServiceData.post(url, params, Mark.class, body);
            queue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshSpinner() {
        try {
            ArrayList<String> subjectsNames = new ArrayList<>();

            RealmResults<Subject> subjects = this.subjectRepository.findAll();
            for (Subject subject : subjects) {
                subjectsNames.add(subject.getName());
            }
            Adapter spinnerAdapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, subjectsNames);
            spinner.setAdapter((SpinnerAdapter) spinnerAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}