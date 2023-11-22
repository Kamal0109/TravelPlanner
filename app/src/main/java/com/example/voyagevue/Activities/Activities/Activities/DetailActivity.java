package com.example.voyagevue.Activities.Activities.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.voyagevue.Activities.Activities.Domains.PopularDomain;
import com.example.voyagevue.R;

public class DetailActivity extends AppCompatActivity {

    private TextView titleTxt, locationTxt, bedTxt, guideTxt, descriptionTxt, scoreTxt, wifiTxt;
    private PopularDomain item;
    private ImageView picImg, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        setVariable();
    }

    private void setVariable() {
        item = (PopularDomain) getIntent().getSerializableExtra("object");

        titleTxt.setText(item.getTitle());
        scoreTxt.setText(String.valueOf((int) item.getScore())); // Use String.valueOf() to convert int to String
        locationTxt.setText(item.getLocation());
        bedTxt.setText(item.getBet() + " Bed");
        descriptionTxt.setText(item.getDescription());

        if (item.isGuide()) {
            guideTxt.setText("Guide");
        } else {
            guideTxt.setText("No Guide");
        }

        if (item.isWifi()) {
            wifiTxt.setText("Wifi");
        } else {
            wifiTxt.setText("No Wifi");
        }

        // You need to initialize the backBtn view before using it
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        int drawableResId = getResources().getIdentifier(item.getPic(), "drawable", getPackageName());

        picImg = findViewById(R.id.picImg);
        Glide.with(this)
                .load(drawableResId)
                .into(picImg);
    }

    private void initView() {
        titleTxt = findViewById(R.id.titleTxt);
        locationTxt = findViewById(R.id.locationTxt);
        bedTxt = findViewById(R.id.bedTxt);
        guideTxt = findViewById(R.id.guideTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt); // Use correct ID
        scoreTxt = findViewById(R.id.scoreTxt);
        picImg = findViewById(R.id.picImg);
        backBtn = findViewById(R.id.backBtn);
        wifiTxt = findViewById(R.id.wifiTxt);
    }
}