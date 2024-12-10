package com.example.myapplication;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButton(R.id.button_C, R.raw.note_c);
        setupButton(R.id.button_D, R.raw.note_d);
        setupButton(R.id.button_E, R.raw.note_e);
        setupButton(R.id.button_F, R.raw.note_f);
        setupButton(R.id.button_G, R.raw.note_g);
        setupButton(R.id.button_A, R.raw.note_a);
        setupButton(R.id.button_B, R.raw.note_b);
    }

    private void setupButton(int buttonId, int soundId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> playSound(soundId));
    }

    private void playSound(int soundId) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, soundId);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}