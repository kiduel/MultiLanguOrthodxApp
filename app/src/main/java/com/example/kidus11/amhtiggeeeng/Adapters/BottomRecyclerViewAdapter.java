package com.example.kidus11.amhtiggeeeng.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kidus11.amhtiggeeeng.Activities.BottomAudioActivity;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.Audio;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BottomRecyclerViewAdapter extends RecyclerView.Adapter<BottomRecyclerViewAdapter.ViewHolder>{

    ArrayList<Audio> audio;

    BottomAudioActivity mBottomAudioActivity;

    public BottomRecyclerViewAdapter(BottomAudioActivity bottomAudioActivity, ArrayList<Audio> audio) {
        this.mBottomAudioActivity = bottomAudioActivity;
        this.audio = audio;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_audio_two, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Audio audios = audio.get(position);
        holder.title.setText(audios.getAudio_title());
        holder.artist.setText(audios.getArtist());

        Picasso
                .get()
                .load(audios.getImageUrl())
                .placeholder(R.drawable.placeholder) // can also be a drawable
                .into(holder.audio_img);

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomAudioActivity.onAudioSelected(audio.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return audio.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView audio_img;
        TextView title;
        TextView artist;
        ConstraintLayout parent_layout;

        public ViewHolder(View itemView)
        {
            super(itemView);

            audio_img = itemView.findViewById(R.id.audio_photo_tv);
            title = itemView.findViewById(R.id.audio_title_tv);
            artist = itemView.findViewById(R.id.audio_artist_tv);
//            url = itemView.findViewById(R.id.url);
            parent_layout = itemView.findViewById(R.id.cardView);
        }
    }
}
