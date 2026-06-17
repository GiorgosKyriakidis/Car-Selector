package com.example.carpickerdbxampp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


public class CarDetailsActivity extends AppCompatActivity {
    TextView brand_model_textview;
    ImageView car_imageview;
    Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_car_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });
            brand_model_textview = findViewById(R.id.brand_model_textview);
            car_imageview = findViewById(R.id.car_imageview);
            back_button = findViewById(R.id.back_button);
            car_imageview.setVisibility(View.VISIBLE);
            Intent intent = getIntent();
            String imageUri = intent.getStringExtra("IMAGE");
            String full_name = intent.getStringExtra("FULL_NAME");
            brand_model_textview.setText(full_name);
            Picasso.with(getApplicationContext()).load(Uri.parse(imageUri)).
                    resize(300, 0).into(car_imageview);
            back_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }

                });
    }}
