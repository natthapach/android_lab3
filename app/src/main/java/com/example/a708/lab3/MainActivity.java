package com.example.a708.lab3;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button increasePlayer1Btn;
    private Button decreasePlayer1Btn;
    private View layout;
    private TextView player1TextView;
    private TextView player2TextView;
    private TextView player3TextView;
    private TextView player4TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int display_mode = getResources().getConfiguration().orientation;

        if (display_mode == Configuration.ORIENTATION_PORTRAIT) {
            Log.d("display_mode", "Portrait");
        } else {
            Log.d("display_mode", "land");
            initLandInstance();
        }
    }

    private void initLandInstance() {
        layout = findViewById(R.id.layout);
        player1TextView = (TextView) findViewById(R.id.tv_player1);
        player2TextView = (TextView) findViewById(R.id.tv_player2);
        player3TextView = (TextView) findViewById(R.id.tv_player3);
        player4TextView = (TextView) findViewById(R.id.tv_player4);
    }

    public void increasePoint(View view){
        String tag = (String) view.getTag();
        Log.d("click inc", tag);

        TextView textView = layout.findViewWithTag(tag);
        int score = Integer.parseInt(textView.getText().toString());
        score++;
        textView.setText(score + "");
    }

    public void decreasePoint(View view){
        String tag = (String) view.getTag();
        Log.d("click dec", tag);
        View layout = findViewById(R.id.layout);

        TextView textView = layout.findViewWithTag(tag);
        int score = Integer.parseInt(textView.getText().toString());
        score--;
        textView.setText(score + "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if(item.getItemId() == R.id.menu_20){
            Log.d("clickMenu", "20");
            builder.setTitle("Are you sure?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Log.d("clickMenu", "yes");
                            resetScore(20);
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
            builder.setTitle("Are you sure?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            resetScore(40);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create().show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void resetScore(int score){
        player1TextView.setText(score + "");
        player2TextView.setText(score + "");
        player3TextView.setText(score + "");
        player4TextView.setText(score + "");
    }
}
