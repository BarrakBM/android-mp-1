package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Define a variable x = connecting to xml

        // EditText x = Findviewbyid(r.id. );
        // button setonclicklitsener
        // x.getText().tostring();

        EditText a = findViewById(R.id.Quiz);
        EditText b = findViewById(R.id.Homework);
        EditText c = findViewById(R.id.Midterms);
        EditText d = findViewById(R.id.Finalexam);
        TextView s = findViewById(R.id.Res);
        Button Calc = findViewById(R.id.button);
        Button Rest = findViewById(R.id.button2);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.nooo);
        final MediaPlayer np = MediaPlayer.create(this, R.raw.yes);
        final MediaPlayer gd = MediaPlayer.create(this, R.raw.good);
        final MediaPlayer sc = MediaPlayer.create(this, R.raw.shock);
        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double Q = Double.parseDouble(a.getText().toString());
                double H = Double.parseDouble(b.getText().toString());
                double M = Double.parseDouble(c.getText().toString());
                double F = Double.parseDouble(d.getText().toString());
                double R = ((Q * 15) + (H * 25) + (M * 30) + (F * 30)) * 4 / 100;
                //System.out.println("///"+R);
                //s.setText(R+""); // percent got printed to the app


                if (R >= 101) {
                    s.setTextColor(Color.BLACK);
                    s.setText("Error");
                } else if (R >= 90) {
                    System.out.println("A");
                    s.setTextColor(Color.GREEN);
                    s.setText("A");
                    np.start();

                } else if (R >= 80) {
                    s.setTextColor(Color.BLUE);
                    s.setText("B");
                    gd.start();
                } else if (R >= 70) {
                    s.setTextColor(Color.YELLOW);
                    s.setText("C");
                } else if (R >= 60) {
                    s.setTextColor(Color.DKGRAY);
                    s.setText("D");
                    mp.start();
                } else {
                    s.setTextColor(Color.RED);
                    s.setText("F");
                    sc.start();


                }


            }


        });

        Rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to Reset the it the original activity
                if (v == Rest) {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }
            }
        });

    }
}