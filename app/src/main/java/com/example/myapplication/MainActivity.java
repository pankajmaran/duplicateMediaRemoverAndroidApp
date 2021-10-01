package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button video, images, docs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
    }
    public void loadVideos(View view)
    {
        Toast.makeText(this, "video list is loading", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, videoList.class);
        startActivity(intent);
    }
    public void loadImages(View view)
    {
        Toast.makeText(this, "image list is loading", Toast.LENGTH_SHORT).show();
    }
    public void loadDocuments(View view)
    {
        Toast.makeText(this, "documents list is loading", Toast.LENGTH_SHORT).show();
    }
}