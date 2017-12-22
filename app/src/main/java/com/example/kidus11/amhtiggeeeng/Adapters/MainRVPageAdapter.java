package com.example.kidus11.amhtiggeeeng.Adapters;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kidus11.amhtiggeeeng.Activities.LangaugeActivity;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.PrayersMain;

import java.util.ArrayList;

/**
 * Created by kidus11 on 12/7/17.
 */

public class MainRVPageAdapter extends RecyclerView.Adapter<MainRVPageAdapter.ViewHolder> {

    private ArrayList<PrayersMain> prayers;
    private Context context;
    PrayersMain option;



    public MainRVPageAdapter(Context context, ArrayList<PrayersMain> prayers) {
        this.prayers = prayers;
        this.context = context;

    }


    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView prayerTitle;
        private ImageView prayerImage;
        private View parentView;


        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            this.parentView = itemView;
            prayerTitle = (TextView) itemView.findViewById(R.id.option_name);
            prayerImage = (ImageView) itemView.findViewById(R.id.option_bk);


            this.parentView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            switch (position) {
                case 0:
                    Intent intent = new Intent(context, LangaugeActivity.class);

                    ActivityOptions options =
                            ActivityOptions.makeCustomAnimation(context, R.anim.in, R.anim.out);
                    context.startActivity(intent, options.toBundle());
                    break;
                case 1:
                    Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(context, "Hi there", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
    @Override
    public MainRVPageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View optionView = inflater.inflate(R.layout.single_row_main_page, parent, false);

        // Return a new holder instance
        return new ViewHolder(optionView);
    }

    @Override
    public void onBindViewHolder(MainRVPageAdapter.ViewHolder holder, final int position) {
        PrayersMain option = prayers.get(position);
        holder.prayerTitle.setText(option.getTitle());
        holder.prayerImage.setImageResource(option.getIcon());
    }


    @Override
    public int getItemCount() {
        return prayers.size();
    }
}
