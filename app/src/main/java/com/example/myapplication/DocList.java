package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class DocList extends AppCompatActivity {
    String arr[] = new String[20];
    ListView docListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_list);

        for(int i=1;i<=arr.length;i++)
        {
            arr[i-1] = "document number "+i;
        }
        for(String each: arr)
        {
            System.out.println(each);
        }
        docListView = findViewById(R.id.docListView);

//        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
//        docListView.setAdapter(ad);
        DocAdapter docAdapter = new DocAdapter(this, R.layout.document, arr);
        docListView.setAdapter(docAdapter);
    }
}
