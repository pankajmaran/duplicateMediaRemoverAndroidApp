package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
    private Button video, images, docs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
        Dexter.withContext(this )
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener(){

                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        Toast.makeText(MainActivity.this,"permission granted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                })
                .check();

    }
    public void loadVideos(View view)
    {
        Toast.makeText(this, "video list is loading", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this, videoList.class);
        Intent intent = new Intent(this, recycleVideo.class);
        startActivity(intent);
    }
    public void loadImages(View view)
    {
        Toast.makeText(this, "image list is loading", Toast.LENGTH_SHORT).show();
    }
    public void loadDocuments(View view)
    {
        Toast.makeText(this, "documents list is loading", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DocList.class);
        startActivity(intent);
    }

}