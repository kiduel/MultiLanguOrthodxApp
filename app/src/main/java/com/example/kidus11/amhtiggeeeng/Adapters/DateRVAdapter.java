package com.example.kidus11.amhtiggeeeng.Adapters;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kidus11.amhtiggeeeng.Activities.DaysActivity;
import com.example.kidus11.amhtiggeeeng.Activities.MezdawitActivity;
import com.example.kidus11.amhtiggeeeng.Activities.PrayerFragmentActivity;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.Utility;
import com.example.kidus11.amhtiggeeeng.data.Day;

import java.util.ArrayList;

/**
 * Created by kidus11 on 12/9/17.
 */

public class DateRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final ArrayList<Object> days;
    private final Context context;
    private final int Day = 1;
    private final int Dawit = 2;



    public DateRVAdapter(Context context, ArrayList<Object> days) {
        this.days = days;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final View parentView;
        private final TextView days;
        private final TextView days_desc;


        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            this.parentView = itemView;
            days = itemView.findViewById(R.id.day);
            days_desc = itemView.findViewById(R.id.day_des);

            this.parentView.setOnClickListener(this);
        }

        @Override
        public void onClick(View parentView) {
            Intent intent = new Intent(context, PrayerFragmentActivity.class);
            ActivityOptions options =
                    ActivityOptions.makeCustomAnimation(context, R.anim.in, R.anim.out);
            String day_to_be_passed = (String) days.getText();
            //  Toast.makeText(context, pospos, Toast.LENGTH_SHORT).show();
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

    public class ViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final View parentView;
        private final TextView dawit;


        public ViewHolder2(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            this.parentView = itemView;
            dawit = itemView.findViewById(R.id.dawit_card);

            this.parentView.setOnClickListener(this);
        }

        @Override
        public void onClick(View parentView) {
            Intent intent = new Intent(context, PrayerFragmentActivity.class);
            ActivityOptions options =
                    ActivityOptions.makeCustomAnimation(context, R.anim.in, R.anim.out);
            String day_to_be_passed = (String) dawit.getText();
            //  Toast.makeText(context, pospos, Toast.LENGTH_SHORT).show();
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
    public int getItemViewType(int position) {
        if (days.get(position) instanceof Day) {
            return Day;
        } else if (days.get(position) instanceof String) {
            return Dawit;
        }
        return -1;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     //   DateRVAdapter.ViewHolder viewHolder = null;
        RecyclerView.ViewHolder viewHolder_org = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());


        switch (viewType) {
            case Day:
                View v1 = inflater.inflate(R.layout.sing_row_date, parent, false);
                viewHolder_org = new ViewHolder(v1);
                break;
            case Dawit:
                View v2 = inflater.inflate(R.layout.singe_row_dawit, parent, false);
                viewHolder_org = new ViewHolder2(v2);
                break;
        }
        return viewHolder_org;

        // Inflate the custom layout
       // View optionView = inflater.inflate(R.layout.sing_row_date, parent, false);

        // Return a new holder instance
       // return new DateRVAdapter.ViewHolder(optionView);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case Day:
                ViewHolder vh1 = (ViewHolder) holder;
                configureViewHolder1(vh1, position);
                break;
            case Dawit:
                ViewHolder2 vh2 = (ViewHolder2) holder;
                configureViewHolder2(vh2);
                break;
        }

        /*
         RecyclerView. ViewHolder viewHolder;
       LayoutInflater inflater


        Day option = days.get(position);
        holder.days.setText(option.getDate());
        holder.days_desc.setText(option.getDateDesc());
         */
    }


    private void configureViewHolder1(ViewHolder vh1, int position) {
        Day option = (com.example.kidus11.amhtiggeeeng.data.Day) days.get(position);
        if (option != null) {
            vh1.days.setText(option.getDate());
            vh1.days_desc.setText(option.getDateDesc());
        }


    }

    private void configureViewHolder2(ViewHolder2 vh2) {
        if (DaysActivity.LANGUAGE == Utility.ENGLISH){
        vh2.dawit.setText(context.getResources().getString(R.string.mez_eng_title));
        } else if (DaysActivity.LANGUAGE == Utility.AMHARIC){
            vh2.dawit.setText(context.getResources().getString(R.string.mez_amh_title));
        } else if (DaysActivity.LANGUAGE == Utility.GEEZ) {
            vh2.dawit.setText(context.getResources().getString(R.string.mez_geez_title));
        } else if (DaysActivity.LANGUAGE == Utility.TIGRIGNA) {
            vh2.dawit.setText(context.getResources().getString(R.string.mez_tig_title));
        }
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

}
