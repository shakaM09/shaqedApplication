package com.katza.shaqedapplication;

import static android.view.View.INVISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  {
    ImageView imageView;
    ImageView imageVisability;
    float alpha = 1;
    Button btnlistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toast.makeText(this, "start", Toast.LENGTH_SHORT).show();
        initViews();
    }

    private void initViews() {
        imageView = findViewById(R.id.imageView);
        imageVisability = findViewById(R.id.imageVisability);
        imageView.setVisibility(View.VISIBLE);
        imageVisability.setVisibility(View.INVISIBLE);
        btnlistener= findViewById(R.id.button2);
        btnlistener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "aaa", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void imgChange(View view) {
        if (view.getId() == R.id.press) {
            Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
            if (imageView.getVisibility() == View.VISIBLE) {
                imageView.setVisibility(View.INVISIBLE);
            } else {
                imageView.setVisibility(View.VISIBLE);
                imageVisability.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void imgsecond(View view) {
        if (view.getId() == R.id.surprise) {
            Toast.makeText(this, "Boooo!", Toast.LENGTH_SHORT).show();
            if (imageView.getVisibility() == View.VISIBLE) {
                imageVisability.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.INVISIBLE);
            } else {
                imageView.setVisibility(View.VISIBLE);
                imageVisability.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void dark(View view) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        if (view.getId() == R.id.press){
            if(alpha<1) {
                alpha += 0.1f;
                imageView.setAlpha(alpha);
                imageVisability.setAlpha(alpha);
            }
        }

    }
    public void lighter(View view) {
        if (view.getId() == R.id.button){
            if(alpha>0) {
                alpha -= 0.1f;
                imageView.setAlpha(alpha);
                imageVisability.setAlpha(alpha);
            }
        }

    }

}