package com.katza.shaqedapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class ActivityFirst extends AppCompatActivity {
    private TextView tvAgeDisplay;

    // Register a callback for the result from ActivitySecond
    private final ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    int birthYear = result.getData().getIntExtra("BIRTH_YEAR", 0);
                    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                    int age = currentYear - birthYear;
                    tvAgeDisplay.setText("Age: " + age);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        EditText etName = findViewById(R.id.etName);
        EditText etAge = findViewById(R.id.etAge);
        CheckBox cbMale = findViewById(R.id.cbMale);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String ageStr = etAge.getText().toString();
                int age = ageStr.isEmpty() ? 0 : Integer.parseInt(ageStr);
                boolean isMale = cbMale.isChecked();

                Intent intent = new Intent(ActivityFirst.this, ActivitySecond.class);
                intent.putExtra("EXTRA_NAME", name);
                intent.putExtra("EXTRA_AGE", age);
                intent.putExtra("EXTRA_MALE", isMale);
                startActivity(intent);
            }
        });
            tvAgeDisplay = findViewById(R.id.tvAgeDisplay);
            Button btnSelectBirthYear = findViewById(R.id.btnSelectBirthYear);

            btnSelectBirthYear.setOnClickListener(t -> {
                Intent intent = new Intent(ActivityFirst.this, ActivitySecond.class);
                startForResult.launch(intent);
            });
            return insets;
        });
    }
}