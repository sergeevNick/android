package ru.sergeev.gettingstarted.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.RealmList;
import ru.sergeev.gettingstarted.R;
import ru.sergeev.gettingstarted.entities.ScheduleRow;

/**
 * Created by serge on 17.02.2018.
 */
//https://irpdevelop.wordpress.com/2016/02/10/horizontal-recyclerview-inside-a-vertical-recyclerview/
//https://stackoverflow.com/questions/32011995/how-to-have-a-listview-recyclerview-inside-a-parent-recyclerview/32086918#32086918
//https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example
//https://github.com/mitchtabian/AppBarLayouts/blob/master/ActionBar%20CardView%20Tutorial/ActionBar/app/src/main/java/tabian/com/actionbar/CustomListAdapter.java

public class ScheduleRowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private RealmList<ScheduleRow> rowList;

    public ScheduleRowAdapter() {
    }

    public void setRowList(RealmList<ScheduleRow> rowList) {
        if (this.rowList != rowList) {
            this.rowList = rowList;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lessonNumber;
        TextView startTime;
        TextView endTime;
        TextView subjectName;
        TextView teacherFIO;
        TextView roomNumber;


        public ViewHolder(View itemView) {
            super(itemView);
            lessonNumber = itemView.findViewById(R.id.lessonNumber);
            startTime = itemView.findViewById(R.id.startTime);
            endTime = itemView.findViewById(R.id.endTime);
            subjectName = itemView.findViewById(R.id.subject);
            teacherFIO = itemView.findViewById(R.id.teacherFIO);
            roomNumber = itemView.findViewById(R.id.roomNumber);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.schedule_row, parent, false);
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder RowHolder, int position) {
        ViewHolder holder = (ViewHolder) RowHolder;
        String startTime = rowList.get(position).getLesson().getStartTime();
        String endTime = rowList.get(position).getLesson().getEndTime();
        startTime = startTime.substring(0, startTime.length() - 3);
        endTime = endTime.substring(0, endTime.length() - 3);
        try {
            holder.lessonNumber.setText(Integer.toString(rowList.get(position).getLesson().getLessonId()));
            holder.startTime.setText(startTime);
            holder.endTime.setText(endTime);
            holder.subjectName.setText(rowList.get(position).getSubject().getName());
            holder.teacherFIO.setText(rowList.get(position).getTeacher().getSecondName() + " "
            +rowList.get(position).getTeacher().getFirstName() + " "
            +rowList.get(position).getTeacher().getLastName());
            holder.roomNumber.setText(rowList.get(position).getSubject().getRoom().toString() + " каб.");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }

    }

    @Override
    public int getItemCount() {
        return rowList.size();
    }
}
