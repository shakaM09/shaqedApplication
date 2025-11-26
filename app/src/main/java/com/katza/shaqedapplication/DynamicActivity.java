package com.katza.shaqedapplication;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DynamicActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dynamic);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        linearLayout = findViewById(R.id.main);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        horizontalScrollView.setLayoutParams(layoutParams2);

        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);

        for (int i=1;i<=10;i++) {
            imageView = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200, 200);
            layoutParams.setMargins(5, 5, 5, 5);
            imageView.setLayoutParams(layoutParams);
            int imagekey = getResources().getIdentifier("img" + i % 3, "drawable", getPackageName());
            imageView.setImageResource(imagekey);
            linearLayout2.addView(imageView);
        }
        horizontalScrollView.addView(linearLayout2);
        linearLayout.addView(horizontalScrollView);

        ScrollView ScrollView = new ScrollView(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        ScrollView.setLayoutParams(layoutParams3);

        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setLayoutParams(layoutParams3);
        linearLayout3.setOrientation(LinearLayout.VERTICAL);

        for (int i=1;i<=100;i++) {
            imageView = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200, 200);
            layoutParams.setMargins(5, 5, 5, 5);
            imageView.setLayoutParams(layoutParams);
            int imagekey = getResources().getIdentifier("img" + i % 3, "drawable", getPackageName());
            imageView.setImageResource(imagekey);
            linearLayout3.addView(imageView);
        }
        ScrollView.addView(linearLayout3);
        linearLayout.addView(ScrollView);

    }
}