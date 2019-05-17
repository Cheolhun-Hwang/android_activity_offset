package com.hch.hooney.talkproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        setBar(getSupportActionBar());
    }

    private void setBar(ActionBar bar) {
        bar.setTitle("Add");
        bar.setHomeAsUpIndicator(R.drawable.ic_close);
    }
}
