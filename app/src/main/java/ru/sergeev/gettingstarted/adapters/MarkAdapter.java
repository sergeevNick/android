package ru.sergeev.gettingstarted.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import io.realm.RealmList;
import io.realm.RealmResults;
import ru.sergeev.gettingstarted.R;
import ru.sergeev.gettingstarted.entities.Mark;

/**
 * Created by serge on 21.04.2018.
 */

public class MarkAdapter extends RecyclerView.Adapter<MarkAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private RealmResults<Mark> marks;

    public MarkAdapter(Context context, RealmResults<Mark> marks) {
        this.mInflater = LayoutInflater.from(context);
        this.marks = marks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.single_mark, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SimpleDateFormat sm = new SimpleDateFormat("E dd MM yyyy");
        String date = sm.format(marks.get(position).getDate());
        holder.markValue.setText(marks.get(position).getValue().toString());
        holder.markDate.setText(date);
    }

    @Override
    public int getItemCount() {
        return marks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView markValue;
        TextView markDate;

        ViewHolder(View itemView) {
            super(itemView);
            markValue = itemView.findViewById(R.id.markValueText);
            markDate = itemView.findViewById(R.id.markDataText);
        }
    }
}
