package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class videoList extends AppCompatActivity {

    String arr[] = new String[20];
    ListView videoListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        for(int i=1;i<=arr.length;i++)
        {
            arr[i-1] = "video number "+i;
        }
        for(String each: arr)
        {
            System.out.println(each);
        }
        videoListView = findViewById(R.id.videoListView);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        videoListView.setAdapter(ad);
//        VideoAdapter videoAdapter = new VideoAdapter(this, R.layout.video, arr);
//        videoListView.setAdapter(videoAdapter);
    }
}