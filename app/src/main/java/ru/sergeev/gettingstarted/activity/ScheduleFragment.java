package ru.sergeev.gettingstarted.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.internal.IOException;
import ru.sergeev.gettingstarted.R;
import ru.sergeev.gettingstarted.adapters.ScheduleAdapter;
import ru.sergeev.gettingstarted.entities.Grade;
import ru.sergeev.gettingstarted.entities.Schedule;
import ru.sergeev.gettingstarted.service.Service;

/**
 * Created by serge on 21.02.2018.
 */

public class ScheduleFragment extends Fragment {
    private RecyclerView recyclerView;
    private ScheduleAdapter scheduleAdapter;
    private RealmResults<Schedule> schedules;
    private Realm realm;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_schedule, container, false);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this.getContext());
        String url = "http://192.168.0.102:8080/grades/1/schedule";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {
                        Gson gson = new Gson();
                        ArrayList<Schedule> schedules1 = gson.fromJson(response, new TypeToken<ArrayList<Schedule>>() {
                        }.getType());
                        for (final Schedule schedule : schedules1) {
                            try {
                                realm = Realm.getDefaultInstance();
                                realm.executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {
                                        realm.insertOrUpdate(schedule);
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

        try {
            realm = Realm.getDefaultInstance();
            schedules = realm.where(Schedule.class).findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        queue.add(stringRequest);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.scheduleDay);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (schedules != null) {
            scheduleAdapter = new ScheduleAdapter(getActivity(), schedules);
            recyclerView.setAdapter(scheduleAdapter);
        }
        getActivity().setTitle("Расписание");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (realm != null) {
            realm.close();
        }
    }
}
