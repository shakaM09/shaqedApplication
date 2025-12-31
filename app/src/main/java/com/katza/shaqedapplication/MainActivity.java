package com.katza.shaqedapplication;

import static android.view.View.INVISIBLE;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  {
    ImageView imageView;
    ImageView imageVisability;
    float alpha = 1;
    Button btnlistener;
    private Switch myswitch;
    private SeekBar SeekBar1;
    TextView tv;


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
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id==R.id.action_login){
            Toast.makeText(this, "You selected Login", Toast.LENGTH_SHORT).show();
        }
       else if (id==R.id.action_register){
            Toast.makeText(this, "You selected Register", Toast.LENGTH_SHORT).show();
        }
       else if (id==R.id.action_exit){
            Toast.makeText(this, "You selected Exit", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    @Override
    public void  onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.firstline){
            Toast.makeText(this, "You selected first line", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(item.getItemId()==R.id.secondline){
            Toast.makeText(this, "You selected second line", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }


    private void initViews() {
        tv=findViewById(R.id.tv);
        registerForContextMenu(tv);
        imageView = findViewById(R.id.imageView);
        imageVisability = findViewById(R.id.imageVisability);
        imageView.setVisibility(View.VISIBLE);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch mySwitch = findViewById(R.id.switch1);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    imageView.setVisibility(View.INVISIBLE);
                }
                else{
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });
        imageVisability.setVisibility(INVISIBLE);
        btnlistener= findViewById(R.id.button2);
        btnlistener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "aaa", Toast.LENGTH_SHORT).show();
            }
        });
        SeekBar1 = findViewById(R.id.seekBar1);
        SeekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               alpha = progress/100f;
               imageView.setAlpha(alpha);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "started traking", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "stopped traking", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void imgChange(View view) {
        if (view.getId() == R.id.press) {

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