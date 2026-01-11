package com.katza.shaqedapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SharedProgressionActivity extends AppCompatActivity {
    SharedPreferences sp;
    Button btnSave;
    EditText etFname,etLname;
    TextView tvDisplay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_progression);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnSave=findViewById(R.id.btnSubmit);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("fname", etFname.getText().toString());
                editor.putString("lname", etLname.getText().toString());
                editor.commit();
            }
        });
        etFname=findViewById(R.id.etFname);
        etLname=findViewById(R.id.etLname);
        tvDisplay=findViewById(R.id.tvDisplay);

        sp=getSharedPreferences("deatils1",0);

        String strfname = sp.getString("fname",null);
        String strlname = sp.getString("lname",null);
        if(strlname!=null && strfname!=null){
            tvDisplay.setText("Welcome: " + strfname +"" + strlname);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id==R.id.action_main){
            Toast.makeText(this, "You selected main", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else if (id==R.id.action_dynamic){
            Toast.makeText(this, "You selected dynamic", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DynamicActivity.class);
            startActivity(intent);
            finish();
        }
        else if (id==R.id.action_prefrences){
            Toast.makeText(this, "You selected prefrences", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SharedProgressionActivity.class);
            startActivity(intent);
            finish();
        }
        return true;
    }
}