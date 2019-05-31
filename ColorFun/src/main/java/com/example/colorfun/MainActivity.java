package com.example.colorfun;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar redBar, blueBar, greenBar, alphaBar;
    TextView redValue, blueValue, greenValue, alphaValue;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redBar = (SeekBar) findViewById(R.id.seekBar);
        blueBar = (SeekBar) findViewById(R.id.seekBar2);
        greenBar = (SeekBar) findViewById(R.id.seekBar3);
        alphaBar = (SeekBar) findViewById(R.id.seekBar4);
        redValue = (TextView) findViewById(R.id.textViewRedValue);
        blueValue = (TextView) findViewById(R.id.textViewBlueValue);
        greenValue = (TextView) findViewById(R.id.textViewGreenValue);
        alphaValue = (TextView) findViewById(R.id.textViewAlphaValue);
        view = (View) findViewById(R.id.view);

        view.setBackgroundColor(Color.argb(alphaBar.getProgress(), redBar.getProgress(), greenBar.getProgress(), blueBar.getProgress()));

        redBar.setMax(255);
        blueBar.setMax(255);
        greenBar.setMax(255);
        alphaBar.setMax(255);

        redValue.setText(String.valueOf(redBar.getProgress()));
        blueValue.setText(String.valueOf(blueBar.getProgress()));
        greenValue.setText(String.valueOf(greenBar.getProgress()));
        alphaValue.setText(String.valueOf(alphaBar.getProgress()));

        redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redValue.setText(String.valueOf(progress));
                view.setBackgroundColor(Color.argb(alphaBar.getProgress(), redBar.getProgress(), greenBar.getProgress(), blueBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueValue.setText(String.valueOf(progress));
                view.setBackgroundColor(Color.argb(alphaBar.getProgress(), redBar.getProgress(), greenBar.getProgress(), blueBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenValue.setText(String.valueOf(progress));
                view.setBackgroundColor(Color.argb(alphaBar.getProgress(), redBar.getProgress(), greenBar.getProgress(), blueBar.getProgress()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        alphaBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                alphaValue.setText(String.valueOf(progress));
                view.setBackgroundColor(Color.argb(alphaBar.getProgress(), redBar.getProgress(), greenBar.getProgress(), blueBar.getProgress()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
