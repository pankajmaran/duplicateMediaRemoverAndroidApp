package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class recycleVideo extends AppCompatActivity {

//    String arr[] = new String[20];
//    RecyclerView videoListView;
      ListView videoListView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("recycle video class");
//        setContentView(R.layout.activity_recycle_video);
         setContentView(R.layout.activity_video_list);
        ArrayList<File> videos = fetch(Environment.getStorageDirectory());
//        ArrayList<File> video = fetch(new File("/"));
        System.out.println(videos.size());
        String []arr = new String[videos.size()];
        for(int i=1;i<=arr.length;i++)
        {
//            arr[i-1] = "video number "+i;
            arr[i-1] = videos.get(i-1).getName().replace(".mp4", "");
        }

//        for(String each: arr) {
//            System.out.println(each);
//        }

//        videoListView = findViewById(R.id.recyclerViewVideo);
//        videoListView.setLayoutManager(new LinearLayoutManager(this));
//        VideoCustomAdaptor videoCustomAdaptor = new VideoCustomAdaptor(arr);

        videoListView = findViewById(R.id.videoListView);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        videoListView.setAdapter(ad);
//        VideoAdapter videoAdapter = new VideoAdapter(this, R.layout.video, arr);

//        videoListView.setAdapter(videoCustomAdaptor);
    }
    public ArrayList<File> fetch(File file){
        ArrayList videoList = new ArrayList();
        System.out.println("Fetch executing");
        File [] arr = file.listFiles();
        if( arr != null){
            System.out.println(arr.length);
            for( File eachFile : arr)
            {
                if( !eachFile.isHidden()  && eachFile.isDirectory())
                {
                    videoList.addAll(fetch(eachFile));
                }
                else
                {
                    if( eachFile.getName().endsWith(".mp4") && !eachFile.getName().startsWith(".")){
                        videoList.add(eachFile);
                    }
                }
            }
        }
        return videoList;
    }
}