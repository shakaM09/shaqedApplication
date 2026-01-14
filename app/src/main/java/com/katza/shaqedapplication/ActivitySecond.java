package com.katza.shaqedapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitySecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            TextView tvDisplayInfo = findViewById(R.id.tvDisplayInfo);
            Button btnClose = findViewById(R.id.btnClose);

            // Retrieve the data from the Intent
            String name = getIntent().getStringExtra("EXTRA_NAME");
            int age = getIntent().getIntExtra("EXTRA_AGE", 0);
            boolean isMale = getIntent().getBooleanExtra("EXTRA_MALE", false);

            String maleString = isMale ? "Yes" : "No";

            // Format the string for display
            String result = "Name: " + name + "\n" +
                    "Age: " + age + "\n" +
                    "Male: " + maleString;

            tvDisplayInfo.setText(result);

            // Close the activity when the button is clicked
            btnClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            EditText etBirthYear = findViewById(R.id.etBirthYear);
            Button btnOk = findViewById(R.id.btnOk);

            btnOk.setOnClickListener(t -> {
                String yearStr = etBirthYear.getText().toString();
                if (!yearStr.isEmpty()) {
                    int birthYear = Integer.parseInt(yearStr);

                    // Create intent to hold the result data
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("BIRTH_YEAR", birthYear);

                    // Set the result and close activity
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            });
            return insets;

        });
    }
}