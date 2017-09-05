package com.example.a708.lab3;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button increasePlayer1Btn;
    private Button decreasePlayer1Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int display_mode = getResources().getConfiguration().orientation;

        if (display_mode == Configuration.ORIENTATION_PORTRAIT) {
            Log.d("lab3", "Portrait");
        } else {
            Log.d("lab3", "land");
            initLandInstance();
        }
    }

    private void initLandInstance() {
        increasePlayer1Btn = (Button) findViewById(R.id.inc_1_btn);
        decreasePlayer1Btn = (Button) findViewById(R.id.dec_1_btn);

        Log.d("btn", increasePlayer1Btn + "");

        increasePlayer1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increasePoint(view);
            }
        });
    }

    private void increasePoint(View view){
        String tag = (String) view.getTag();
        Log.d("click btn", tag);
        View layout = findViewById(R.id.layout);

        TextView textView = layout.findViewWithTag(tag);
        int score = Integer.parseInt(textView.getText().toString());
        score++;
        textView.setText(score + "");
        Log.d("lab3", score + "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_20){
            Log.d("clickMenu", "20");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Are you sure?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Log.d("clickMenu", "yes");
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Log.d("clickMenu", "No");
                        }
                    })
                    .create().show();

        }else if(item.getItemId() == R.id.menu_40){
            Log.d("clickMenu", "40");
        }
        return super.onOptionsItemSelected(item);
    }
}
