package com.daakknights.radiosample;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    // creating a variable for array list and context.
    private ArrayList<RadioStation> radioStationArrayList;
    private MediaPlayer mediaPlayer;

    // creating a constructor for our variables.
    public Adapter(ArrayList<RadioStation> radioStationArrayList, Context context) {
        this.radioStationArrayList = radioStationArrayList;
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // below line is to inflate our layout.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        // setting data to our views of recycler view.
        RadioStation modal = radioStationArrayList.get(position);
        holder.name.setText(modal.getName());
        Picasso.get().load(modal.getFavicon()).into(holder.favicon);
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return radioStationArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private TextView name;
        private ImageView favicon;
        private Button play;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.idName);
            favicon = itemView.findViewById(R.id.idImg);
            play = itemView.findViewById(R.id.play);
            play.setOnClickListener(view -> onPlayClick());
        }

        public void onPlayClick() {
            stopPlaying();
            startPlaying();
        }

        private void startPlaying() {
            try {
                mediaPlayer.setDataSource(radioStationArrayList.get(getAdapterPosition()).getUrl_resolved());
                mediaPlayer.setOnPreparedListener(mp -> {
                    mediaPlayer.start();
                    Log.v("DINKAR", "Started");
                });
                mediaPlayer.setOnErrorListener((mp, what, extra) -> {
                    Log.e("DINKAR", "Error");
                    return false;
                });
                mediaPlayer.prepareAsync();
            } catch (IOException e) {
                Log.e("DINKAR", "failed");
            }
        }

        private void stopPlaying() {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
    }

}