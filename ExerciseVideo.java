package com.example.shiva.cureall;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.Vector;

public class ExerciseVideo extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.exercise_video,container,false);
        RecyclerView recyclerView;
        Vector<YouTubeVideos> youtubeVideos = new Vector<>();
        int i=Secondone.listposition1;
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(v.getContext()));
        TextView textView=v.findViewById(R.id.showtitle);


        VideoAdapter videoAdapter;
        switch( i)
        {
            case 0:
                textView.setText("Pregnant and Breastfeeding Women");
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"500\" src=\"https://www.youtube.com/embed/r-5UguU42zo\" ></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/EeBz1xGFGa4\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/8nSmFwFNit0\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                videoAdapter = new VideoAdapter(youtubeVideos);
                recyclerView.setAdapter(videoAdapter);break;
            case 1:
                textView.setText("Babies and Young Children Exercise Videos");
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/J1CBXewohDQ\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/vTqJabU0Rx0\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/KqSzgzsDeaU\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                videoAdapter = new VideoAdapter(youtubeVideos);
                recyclerView.setAdapter(videoAdapter);break;
            case 2:
                textView.setText("Kids and Teens Exercise Videos");
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/6LndXdPdKaQ\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/RMrnJIHcfgo\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/M-d11QiWdm8\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/P88aPJ9KDA8\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                videoAdapter = new VideoAdapter(youtubeVideos);
                recyclerView.setAdapter(videoAdapter);break;
            case 3:
                textView.setText("Adults Exercise Videos");
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/M9Ps6gbUNEA\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/aQn_jQ3-xDk\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/7ru73VjKdMM\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/ZB4WTUpkQEQ\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"350\" height=\"315\" src=\"https://www.youtube.com/embed/hQBrLPPsaEM\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                videoAdapter = new VideoAdapter(youtubeVideos);
                recyclerView.setAdapter(videoAdapter);break;
            case 4:
                textView.setText("Older Adults Exercise Videos");
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/qhwFdkcBlEc\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/Ev6yE55kYGw\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/BI_ntVdVz8M\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                youtubeVideos.add( new YouTubeVideos("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/8BcPHWGQO44\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>") );
                videoAdapter = new VideoAdapter(youtubeVideos);

                recyclerView.setAdapter(videoAdapter);break;

        }
        return v;
    }

}
