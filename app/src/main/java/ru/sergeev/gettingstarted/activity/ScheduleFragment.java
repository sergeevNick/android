package ru.sergeev.gettingstarted.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.R;
import ru.sergeev.gettingstarted.adapters.ScheduleAdapter;
import ru.sergeev.gettingstarted.entities.Schedule;
import ru.sergeev.gettingstarted.environment.Environment;
import ru.sergeev.gettingstarted.environment.Params;
import ru.sergeev.gettingstarted.service.RequestServiceData;

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
        String url = Environment.Schedule.byGrade;

        Params params = new Params();
        params.gradeId = "1";

        // Request a string response from the provided URL.
        StringRequest stringRequest = RequestServiceData.get(url, params, Schedule.class);

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
