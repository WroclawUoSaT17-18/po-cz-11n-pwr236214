package dev.edmt.flagsquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

import dev.edmt.flagsquizapp.Common.Common;
import dev.edmt.flagsquizapp.DbHelper.DbHelper;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar; // pasek
    TextView txtMode; // wyświetlany text
    Button btnPlay,btnScore; // przyciski
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        txtMode = (TextView)findViewById(R.id.txtMode);
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnScore = (Button)findViewById(R.id.btnScore);


        db = new DbHelper(this);
        try{
            db.createDataBase();
        }
        catch (IOException e){
            e.printStackTrace();
        }




        //pasek, opcja w zależności od poziomu przesuwu
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override // pozwala uniknąć błędów
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress == 0)
                    txtMode.setText(Common.MODE.Łatwy.toString());
                else if(progress == 1)
                    txtMode.setText(Common.MODE.Średni.toString());
                else if(progress == 2)
                    txtMode.setText(Common.MODE.Trudny.toString());
                else if(progress == 3)
                    txtMode.setText(Common.MODE.WiktorMode.toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        // funkcja czekająca na nacisniecie przycisku
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Playing.class);
                intent.putExtra("MODE",getPlayMode()); // jeśli nacisniesz startuje "play mode"
                startActivity(intent);
                finish();
            }
        });

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Score.class);
                startActivity(intent);
                finish();
            }
        });
    }
// wybór trybu
    private String getPlayMode() {
        if(seekBar.getProgress()==0)
            return Common.MODE.Łatwy.toString();
        else if(seekBar.getProgress()==1)
            return Common.MODE.Średni.toString();
        else if(seekBar.getProgress()==2)
            return Common.MODE.Trudny.toString();
        else
            return Common.MODE.WiktorMode.toString();
    }
}
