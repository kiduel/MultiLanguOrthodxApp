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
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.Language;

import java.util.ArrayList;

/**
 * Created by kidus11 on 12/7/17.
 */

public class LanguageRVAdapter extends RecyclerView.Adapter<LanguageRVAdapter.ViewHolder> {
    private ArrayList<Language> languageOptions;
    private Context context;

    public LanguageRVAdapter(Context context, ArrayList<Language> languageOptions) {
        this.languageOptions = languageOptions;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View parentView;
        private TextView language;
        private TextView language_description;


        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            this.parentView = itemView;
            language = (TextView) itemView.findViewById(R.id.language_name);
            language_description = (TextView) itemView.findViewById(R.id.language_desc);

            this.parentView.setOnClickListener(this);
        }

        @Override
        public void onClick(View parentView) {
            Intent intent = new Intent(context, DaysActivity.class);
            if (language.getText() == context.getResources().getString(R.string.card_title_Geez)){
                intent.putExtra("Prayer_ID", context.getResources().getString(R.string.card_title_Geez));

            } else if  (language.getText() == context.getResources().getString(R.string.card_title_Amharic)){
                intent.putExtra("Prayer_ID", context.getResources().getString(R.string.card_title_Amharic));
            } else if  (language.getText() == context.getResources().getString(R.string.card_title_Eng)){
                intent.putExtra("Prayer_ID", context.getResources().getString(R.string.card_title_Eng));
            } else
                intent.putExtra("Prayer_ID", context.getResources().getString(R.string.card_title_Tig));

            ActivityOptions options =
                    ActivityOptions.makeCustomAnimation(context, R.anim.in, R.anim.out);
            context.startActivity(intent);
        }
    }

    @Override
    public LanguageRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View optionView = inflater.inflate(R.layout.single_row_language, parent, false);

        // Return a new holder instance
        return new LanguageRVAdapter.ViewHolder(optionView);
    }

    @Override
    public void onBindViewHolder(LanguageRVAdapter.ViewHolder holder, int position) {
        Language option = languageOptions.get(position);
        holder.language.setText(option.getLanguageName());
        holder.language_description.setText(option.getDescription());



    }

    @Override
    public int getItemCount() {
        return languageOptions.size();
    }

}
