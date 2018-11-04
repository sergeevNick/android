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
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.R;
import ru.sergeev.gettingstarted.adapters.MarkAdapter;
import ru.sergeev.gettingstarted.entities.Mark;
import ru.sergeev.gettingstarted.entities.Subject;

/**
 * Created by serge on 20.02.2018.
 */

public class MarkFragment extends Fragment {
    private RecyclerView marksRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MarkAdapter markAdapter;
    private RealmResults<Mark> marks;
    private Spinner spinner;
    private Adapter spinnerAdapter;
    private Realm realm;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RequestQueue queue = Volley.newRequestQueue(this.getContext());
        String url = "http://192.168.0.102:8080/marks";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {
                        Gson gson = new Gson();
                        ArrayList<Mark> marks1 = gson.fromJson(response, new TypeToken<ArrayList<Mark>>() {
                        }.getType());
                        for (final Mark mark : marks1) {
                            try {
                                realm = Realm.getDefaultInstance();
                                realm.executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {
                                        realm.insertOrUpdate(mark);
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                realm.close();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
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
        mLayoutManager = new LinearLayoutManager(this.getContext());
        marksRecyclerView.setLayoutManager(mLayoutManager);
        marksRecyclerView.setItemAnimator(new DefaultItemAnimator());

        spinner = view.findViewById(R.id.spinnerSubjectChooser);
        realm = Realm.getDefaultInstance();

        spinner.setSelected(false);  // otherwise listener will be called on initialization
        spinner.setSelection(0, true);  // otherwise listener will be called on initialization
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    getMarksList(spinner.getSelectedItem().toString());
                    Toast.makeText(parent.getContext(), "Getting marks for subject: " + spinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
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

    void getMarksList(String subjectName) {
        try {
            realm = Realm.getDefaultInstance();
            marks = realm.where(Mark.class).findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        markAdapter = new MarkAdapter(getActivity(), marks);
        marksRecyclerView.setAdapter(markAdapter);
    }

    void refreshSpinner() {
        RealmResults<Subject> subjects;
        ArrayList<String> subjectsNames = new ArrayList<>();
        try {
            realm = Realm.getDefaultInstance();
            subjects = realm.where(Subject.class).findAll();
            for (Subject subject : subjects) {
                subjectsNames.add(subject.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        spinnerAdapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, subjectsNames);
        spinner.setAdapter((SpinnerAdapter) spinnerAdapter);
    }
}