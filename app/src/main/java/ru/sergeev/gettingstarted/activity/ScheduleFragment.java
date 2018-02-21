package ru.sergeev.gettingstarted.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ru.sergeev.gettingstarted.R;
import ru.sergeev.gettingstarted.adapters.ScheduleAdapter;
import ru.sergeev.gettingstarted.classes.DayCard;
import ru.sergeev.gettingstarted.classes.ScheduleRow;

/**
 * Created by serge on 21.02.2018.
 */

public class ScheduleFragment extends Fragment {

    private RecyclerView recyclerView;
    private ScheduleAdapter scheduleAdapter;
    private ArrayList<DayCard> card1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_schedule, container, false);

        ArrayList<ScheduleRow> row = new ArrayList<>();
        ArrayList<ScheduleRow> row2 = new ArrayList<>();
        row.add(new ScheduleRow(1, "Математика", "33 каб", "Петров А. А.", "9:00", "10:00"));
        row.add(new ScheduleRow(2, "Физика", "2 каб", "Семенова К. В.", "10:00", "11:00"));
        row.add(new ScheduleRow(3, "Русский язык", "5 каб", "Иванова Е. Д.", "11:00", "12:00"));

        row2.add(new ScheduleRow(1, "Литература", "13 каб", "Романова Н. Н.", "9:00", "10:00"));
        row2.add(new ScheduleRow(2, "Биология", "66 каб", "Петров А. А.", "10:00", "11:00"));

        card1 = new ArrayList<>();
        card1.add(new DayCard("Понедельник", row));
        card1.add(new DayCard("Вторник", row2));
        card1.add(new DayCard("Среда", row2));

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.scheduleDay);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        scheduleAdapter = new ScheduleAdapter(getActivity(), card1);
        recyclerView.setAdapter(scheduleAdapter);
        getActivity().setTitle("Расписание");
    }
}
