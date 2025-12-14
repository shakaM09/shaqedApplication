package com.katza.shaqedapplication;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class costumDialogActivity extends AppCompatActivity {
    SharedPreferences sp;
    Dialog d;
    EditText etUserName,etPass;
    Button btnCustomLogin,btnLogin,btnShow;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_costum_dialog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createLoginDialog();
            }
        });
        sp=getSharedPreferences("details1",0);
        btnShow=findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(costumDialogActivity.this, sp.getString("username","") + " " + sp.getString("password",""), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void createLoginDialog(){
        d=new Dialog(this);
        d.setContentView(R.layout.custom_layout);
        d.setTitle("Login");
        d.setCancelable(false);
        etUserName=d.findViewById(R.id.etUserName);
        etPass=d.findViewById(R.id.etPassword);
        btnCustomLogin=d.findViewById(R.id.btnDialogLogin);
        btnCustomLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                d.dismiss();
            }
        });
        d.show();
    }
}