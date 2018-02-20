package ru.sergeev.gettingstarted.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ru.sergeev.gettingstarted.R;
import ru.sergeev.gettingstarted.classes.ScheduleRow;

/**
 * Created by serge on 17.02.2018.
 */
//https://irpdevelop.wordpress.com/2016/02/10/horizontal-recyclerview-inside-a-vertical-recyclerview/
//https://stackoverflow.com/questions/32011995/how-to-have-a-listview-recyclerview-inside-a-parent-recyclerview/32086918#32086918
//https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example
//https://github.com/mitchtabian/AppBarLayouts/blob/master/ActionBar%20CardView%20Tutorial/ActionBar/app/src/main/java/tabian/com/actionbar/CustomListAdapter.java

public class ScheduleRowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ScheduleRow> rowList;

    public ScheduleRowAdapter() {
    }

    public void setRowList(ArrayList<ScheduleRow> rowList) {
        if (this.rowList != rowList) {
            this.rowList = rowList;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView lessonNumber;
        public TextView startTime;
        public TextView endTime;
        public TextView subjectName;
        public TextView teacherFIO;
        public TextView roomNumber;


        public ViewHolder(View itemView) {
            super(itemView);
            lessonNumber = itemView.findViewById(R.id.lessonNumber);
            startTime = itemView.findViewById(R.id.startTime);
            endTime = itemView.findViewById(R.id.endTime);
            subjectName = itemView.findViewById(R.id.subjectName);
            teacherFIO = itemView.findViewById(R.id.teacherFIO);
            roomNumber = itemView.findViewById(R.id.roomNumber);
            System.out.println(lessonNumber.getText());
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
        holder.lessonNumber.setText(Integer.toString(rowList.get(position).getLessonNumber()));
        holder.startTime.setText(rowList.get(position).getStartTime());
        holder.endTime.setText(rowList.get(position).getEndTime());
        holder.subjectName.setText(rowList.get(position).getSubjectName());
        holder.teacherFIO.setText(rowList.get(position).getTeacherName());
        holder.roomNumber.setText(rowList.get(position).getRoom());
    }

    @Override
    public int getItemCount() {
        return rowList.size();
    }


}
