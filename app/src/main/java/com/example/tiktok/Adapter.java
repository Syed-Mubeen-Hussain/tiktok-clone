package com.example.tiktok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktok.databinding.ReelsBgBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.VideoHolder>{

    Context context;
    ArrayList<Model> modelArrayList=new ArrayList<>();
    boolean isPlaying = true;

    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.reels_bg, parent, false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
        holder.binding.videoView.setVideoPath(modelArrayList.get(position).getVideoUrl());
        holder.binding.name.setText(modelArrayList.get(position).getName());
        holder.binding.profileImage.setImageResource(modelArrayList.get(position).getProfile());
        holder.binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
//                mediaPlayer.setLooping(true);
                isPlaying = true;
            }
        });
        holder.binding.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                isPlaying = true;
            }
        });
        holder.binding.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying){
                    holder.binding.videoView.pause();
                    isPlaying=false;
                }else{
                    holder.binding.videoView.resume();
                    isPlaying=true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder {
        ReelsBgBinding binding;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            binding=ReelsBgBinding.bind(itemView);
        }
    }

}
