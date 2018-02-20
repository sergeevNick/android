package ru.sergeev.gettingstarted.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import ru.sergeev.gettingstarted.R;
import ru.sergeev.gettingstarted.adapters.ScheduleAdapter;
import ru.sergeev.gettingstarted.classes.DayCard;
import ru.sergeev.gettingstarted.classes.ScheduleRow;

public class ScheduleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ScheduleAdapter scheduleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayList<ScheduleRow> row = new ArrayList<>();
        ArrayList<ScheduleRow> row2 = new ArrayList<>();
        row.add(new ScheduleRow(1, "math", "33", "Vasya", "9:00", "10:00"));
        row.add(new ScheduleRow(2, "phis", "33", "Vasya", "9:00", "10:00"));
        row.add(new ScheduleRow(3, "russ", "33", "Vasya", "9:00", "10:00"));

        row2.add(new ScheduleRow(1, "litra", "33", "Vasya", "9:00", "10:00"));
        row2.add(new ScheduleRow(2, "biologic", "33", "Vasya", "9:00", "10:00"));

        ArrayList<DayCard> card1 = new ArrayList<>();
        card1.add(new DayCard("Понедельник", row));
        card1.add(new DayCard("Вторник", row2));
        card1.add(new DayCard("Четверг", row2));

        //recyclerView.setHasFixedSize(true);
        recyclerView = (RecyclerView) findViewById(R.id.scheduleDay);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        scheduleAdapter = new ScheduleAdapter(this, card1);
        recyclerView.setAdapter(scheduleAdapter);
        //recyclerView = (RecyclerView) findViewById(R.id.scheduleDay);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}
