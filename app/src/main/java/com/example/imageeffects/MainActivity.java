package com.example.imageeffects;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    Button btnGS;
    public ImageView imageView;
    SeekBar sbBrightness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.demo_image);
        btnGS = findViewById(R.id.btnGrayscale);
        btnGS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0.0f);
                imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            }
        });
        sbBrightness = findViewById(R.id.seekBarBrightness);
        sbBrightness.setProgress(125);
        sbBrightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                imageView.setColorFilter(setBrightness(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public static PorterDuffColorFilter setBrightness(int progress){
        if(progress >= 100){
            int value = (int)(progress-100)*255/100;
            return new PorterDuffColorFilter(Color.argb(value, 255, 255, 255), PorterDuff.Mode.SRC_OVER);
        }
        else
        {
            int value = (int)(100-progress)*255/100;
            return new PorterDuffColorFilter(Color.argb(value, 0,0,0), PorterDuff.Mode.SRC_ATOP);
        }
    }
}