package com.example.carpickerdbxampp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner brands_spinner;
    private RadioGroup models_radio_group;
    private Button button;
    private final String serverNameOrIpAddress = "10.0.2.2";
private ImageButton thumbnail_imagebutton;
private String imageUri;
private String full_name;

    private BrandsList brandsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thumbnail_imagebutton=findViewById(R.id.thumbnail_imagebutton);


        brands_spinner = findViewById(R.id.brands_spinner);

        models_radio_group = findViewById(R.id.models_radio_group);

        brandsList = new BrandsList(serverNameOrIpAddress);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                brandsList.getAllBrandNames());

        brands_spinner.setAdapter(arrayAdapter);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showModels(view);
            }
        });

        thumbnail_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(view);
            }
        });
    }

    public void showModels(View view) {
        String brandName = brands_spinner.getSelectedItem().toString();
        List<String> modelsList = brandsList.getModels(brandName);
        models_radio_group.removeAllViews();
        for (int i = 0; i < modelsList.size(); i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(modelsList.get(i));
            radioButton.setId(i + 100);
            models_radio_group.addView(radioButton);
        }
        models_radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String url = "http://" + serverNameOrIpAddress +
                        "/multimediaDBServices/logHistory.php?brand=" + brandName +
                        "&model=" + radioButton.getText().toString() +
                        "&timestamp=" + new Date(System.currentTimeMillis());

                imageUri = brandsList.lookup(brandName, radioButton.getText().toString()).getImage();
                full_name = brandName + " " + radioButton.getText().toString();
                thumbnail_imagebutton.setVisibility(View.VISIBLE);
                Picasso.with(getApplicationContext()).load(Uri.parse(imageUri)).
                        resize(300, 0).into(thumbnail_imagebutton);
                try {
                    OkHttpHandler okHttpHandler = new OkHttpHandler();
                    okHttpHandler.logHistory(url);
                    Toast.makeText(getApplicationContext(), "Selection Logged",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, CarDetailsActivity.class);
        intent.putExtra("IMAGE", imageUri);
        intent.putExtra("FULL_NAME", full_name);
        startActivity(intent);
    }


        }


