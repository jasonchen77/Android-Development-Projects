package com.example.jchen319_game;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer = new Timer();
    ImageButton rabbitButton, rabbitButton2;
    int imageX = 0, imageY = 0, imageX2 = 100, imageY2 = 500;
    int speed = 5;
    int directionX = 1, directionY = 1, directionX2 = 1, directionY2 = 1;
    int screenX, screenY;
    int score = 0;
    TextView tvScore, tvWinLose, tvLevel, tvCollisions;
    Button againButton;
    Rect rabbit1Rect, rabbit2Rect;
    int collisions = 0;
    SoundPool soundPool;
    int mySound = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .build();

        } else {
            soundPool = new SoundPool(20,AudioManager.STREAM_MUSIC,0);
        }

        AssetManager assetManager = getAssets();

        try {
            AssetFileDescriptor descriptor = assetManager.openFd("dada.wav");
            mySound = soundPool.load(descriptor, 1);
        } catch (IOException e){
            e.printStackTrace();
        }



        tvScore = (TextView) findViewById(R.id.textViewScore);
        tvWinLose = (TextView) findViewById(R.id.textViewWinLose);
        tvLevel = (TextView) findViewById(R.id.textViewLevel);
        tvCollisions = (TextView) findViewById(R.id.textViewCollisions);
        rabbitButton = (ImageButton) findViewById(R.id.imageButton);
        rabbitButton2 = (ImageButton) findViewById(R.id.imageButton2);
        againButton = (Button) findViewById(R.id.buttonAgain);
        final int FPS = 40;
        TimerTask updateGame = new UpdateGameTask();
        timer.scheduleAtFixedRate(updateGame,0, 1000/FPS);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenX = size.x;
        screenY = size.y;

    }

    class UpdateGameTask extends TimerTask  {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    imageX += (speed * directionX);
                    imageY += (speed * directionY);

                    imageX2 += (speed * directionX2);
                    imageY2 += (speed * directionY2);

                    rabbitButton.setX(imageX);
                    rabbitButton.setY(imageY);

                    rabbitButton2.setX(imageX2);
                    rabbitButton2.setY(imageY2);

                    rabbit1Rect = new Rect (imageX, imageY, imageX + rabbitButton.getWidth(), imageY + rabbitButton.getHeight());
                    rabbit2Rect = new Rect (imageX2, imageY2, imageX2 + rabbitButton2.getWidth(), imageY2 + rabbitButton2.getHeight());

                    if (Rect.intersects(rabbit1Rect, rabbit2Rect)){
                        collisions++;
                        tvCollisions.setText("Collisions: " + collisions);
                    }

                    if ((imageX + rabbitButton.getWidth()) > screenX || imageX < 0){
                        directionX = directionX * -1;
                    }

                    if ((imageY + rabbitButton.getHeight()) > screenY || imageY < 0){
                        directionY = directionY * -1;
                    }

                    if ((imageX2 + rabbitButton2.getWidth()) > screenX || imageX2 < 0){
                        directionX2 = directionX2 * -1;
                    }

                    if ((imageY2 + rabbitButton2.getHeight()) > screenY || imageY2 < 0){
                        directionY2 = directionY2 * -1;
                    }

                    if (score > 20 && score < 40){
                        tvLevel.setText("Level: 2");
                        speed = 10;
                    }
                    else if (score > 40 && score < 60){
                        tvLevel.setText("Level: 3");
                        speed = 15;
                    }
                    else if (score > 60 && score < 80){
                        tvLevel.setText("Level: 4");
                        speed = 20;
                    }
                    else if (score > 100){
                        tvWinLose.setVisibility(View.VISIBLE);
                        againButton.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }

    public void rabbitClicked (View view) {
        score += 5;
        tvScore.setText("Score: " + score);
        soundPool.play(mySound, 1, 1, 0, 0, 1);

    }

    public void again (View view){
        score = 0;
        speed = 5;
        collisions = 0;
        tvScore.setText("Score: " + score);
        tvLevel.setText("Level: 1");
        tvWinLose.setVisibility(View.INVISIBLE);
        againButton.setVisibility(View.INVISIBLE);
    }
}
