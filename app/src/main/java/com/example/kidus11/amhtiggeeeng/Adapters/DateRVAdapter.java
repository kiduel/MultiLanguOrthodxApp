package com.example.kidus11.amhtiggeeeng.Adapters;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kidus11.amhtiggeeeng.Activities.MezdawitActivity;
import com.example.kidus11.amhtiggeeeng.Activities.PrayerFragmentActivity;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.Day;

import java.util.ArrayList;

/**
 * Created by kidus11 on 12/9/17.
 */

public class DateRVAdapter extends RecyclerView.Adapter<DateRVAdapter.ViewHolder> {
    private ArrayList<Day> days;
    private Context context;
    int pos = 0;


    public DateRVAdapter(Context context, ArrayList<Day> days) {
        this.days = days;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View parentView;
        private TextView days;
        private TextView days_desc;


        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            this.parentView = itemView;
            days = (TextView) itemView.findViewById(R.id.day);
            days_desc = (TextView) itemView.findViewById(R.id.day_des);

            this.parentView.setOnClickListener(this);
        }

        @Override
        public void onClick(View parentView) {
            Intent intent = new Intent(context, PrayerFragmentActivity.class);
            ActivityOptions options =
                    ActivityOptions.makeCustomAnimation(context, R.anim.in, R.anim.out);
            String day_to_be_passed = (String) days.getText();
            if (day_to_be_passed.equals(context.getResources().getString(R.string.mez_geez_title)) ||
                    day_to_be_passed.equals(context.getResources().getString(R.string.mez_tig_title)) ||
                    day_to_be_passed.equals(context.getResources().getString(R.string.mez_eng_title)) ||
                    day_to_be_passed.equals(context.getResources().getString(R.string.mez_amh_title))) {
                {
                    Intent intent_mez = new Intent(context, MezdawitActivity.class);
                    intent_mez.putExtra("mez_language",day_to_be_passed);
                    context.startActivity(intent_mez);
                    return;
                }
            }
            intent.putExtra("day",day_to_be_passed);
            context.startActivity(intent, options.toBundle());
     }
    }

    @Override
    public DateRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View optionView = inflater.inflate(R.layout.sing_row_date, parent, false);

        // Return a new holder instance
        return new DateRVAdapter.ViewHolder(optionView);
    }

    @Override
    public void onBindViewHolder(DateRVAdapter.ViewHolder holder, int position) {
        Day option = days.get(position);
        holder.days.setText(option.getDate());
        holder.days_desc.setText(option.getDateDesc());


    }

    @Override
    public int getItemCount() {
        return days.size();
    }

}
