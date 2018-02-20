package ru.sergeev.gettingstarted.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ru.sergeev.gettingstarted.R;
import ru.sergeev.gettingstarted.classes.DayCard;

/**
 * Created by serge on 16.02.2018.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    private static ArrayList<DayCard> cardList;
    private static RecyclerView childList;

    // data is passed into the constructor
    public ScheduleAdapter(Context context, ArrayList<DayCard> objects) {
        this.context = context;
        this.cardList = objects;
        this.mInflater = LayoutInflater.from(context);
    }

    // inflates the row layout from xml when needed
    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.schedule_list_layout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ScheduleAdapter.ViewHolder holder, int position) {
        DayCard card = cardList.get(position);
        holder.dayName.setText(card.getDayName());
        holder.scheduleRowAdapter.setRowList(card.getSubjects());
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dayName;
        public RecyclerView rowList;
        private ScheduleRowAdapter scheduleRowAdapter;

        public ViewHolder(View itemView) {
            super(itemView);
            Context context = itemView.getContext();
            dayName = itemView.findViewById(R.id.dayName);
            //rowList = itemView.findViewById(R.id.scheduleRowId);
            childList = (RecyclerView) itemView.findViewById(R.id.scheduleRowId);
            childList.setLayoutManager(new LinearLayoutManager(context));
            scheduleRowAdapter= new ScheduleRowAdapter();
            childList.setAdapter(scheduleRowAdapter);

            //itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
//        }
    }
}
