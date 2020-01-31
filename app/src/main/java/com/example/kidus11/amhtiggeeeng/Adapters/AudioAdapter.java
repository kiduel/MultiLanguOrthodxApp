package com.example.kidus11.amhtiggeeeng.Adapters;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kidus11.amhtiggeeeng.Activities.AudioActivity;
import com.example.kidus11.amhtiggeeeng.Activities.BottomAudioActivity;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.Audio;

import java.util.ArrayList;

/**
 * Created by kidus11 on 12/26/17.
 */

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.ViewHolder> {
    private final ArrayList<Audio> audio;
    private final Context context;

    public AudioAdapter(Context context, ArrayList<Audio> audio) {
        this.audio = audio;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final View parentView;
        private final TextView title;



        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            this.parentView = itemView;
            title = itemView.findViewById(R.id.audio_title_tv);


            this.parentView.setOnClickListener(this);
        }

        @Override
        public void onClick(View parentView) {

            String day_to_be_passed = (String) title.getText();
            Intent intent = new Intent(context, BottomAudioActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            ActivityOptions options =
                    ActivityOptions.makeCustomAnimation(context, R.anim.in, R.anim.out);
            intent.putExtra("audio_passed",day_to_be_passed);
            context.startActivity(intent, options.toBundle());
        }
    }

    @Override
    public AudioAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View optionView = inflater.inflate(R.layout.single_audio, parent, false);

        // Return a new holder instance
        return new AudioAdapter.ViewHolder(optionView);
    }

    @Override
    public void onBindViewHolder(AudioAdapter.ViewHolder holder, int position) {
        Audio audios = audio.get(position);
        holder.title.setText(audios.getAudio_title());

    }

    @Override
    public int getItemCount() {
        return audio.size();
    }
}
