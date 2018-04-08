package com.example.kidus11.amhtiggeeeng.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kidus11.amhtiggeeeng.Activities.MusicPlayerAct;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.Audio;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by kidus11 on 1/5/18.
 */

public class AudioAdapter_two extends RecyclerView.Adapter<AudioAdapter_two.ViewHolder> {
    private final ArrayList<Audio> audio;
    private final Context context;

    public AudioAdapter_two(Context context, ArrayList<Audio> audio) {
        this.audio = audio;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final View parentView;
        private final TextView title;
        private final TextView artist;
        private final ImageView audio_img;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            this.parentView = itemView;
            title = itemView.findViewById(R.id.audio_title_tv);
            artist = itemView.findViewById(R.id.audio_artist_tv);
            audio_img = itemView.findViewById(R.id.audio_photo_tv);

            this.parentView.setOnClickListener(this);
        }

        @Override
        public void onClick(View parentView) {
            Intent intent = new Intent(context, MusicPlayerAct.class);
            Audio audios = audio.get(getAdapterPosition());
            String url = audios.getAudioUrl();
            String img_url = audios.getImageUrl();
            String title_url = audios.getAudio_title();
            intent.putExtra("audio_url",url);
            intent.putExtra("img_url",img_url);
            intent.putExtra("title_url",title_url);
            context.startActivity(intent);
        }
    }

    @Override
    public AudioAdapter_two.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View optionView = inflater.inflate(R.layout.single_audio_two, parent, false);

        // Return a new holder instance
        return new AudioAdapter_two.ViewHolder(optionView);
    }

    @Override

    public void onBindViewHolder(AudioAdapter_two.ViewHolder holder, int position) {
        Audio audios = audio.get(position);
        holder.title.setText(audios.getAudio_title());
        holder.artist.setText(audios.getArtist());

        Picasso
                .with(context)
                .load(audios.getImageUrl())
                .placeholder(R.drawable.placeholder) // can also be a drawable
                .into(holder.audio_img);
    }


    @Override
    public int getItemCount() {
        return audio.size();
    }
}

