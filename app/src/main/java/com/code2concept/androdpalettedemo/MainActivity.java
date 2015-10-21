package com.code2concept.androdpalettedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.code2concept.androdpalettedemo.i.INotifyTimer;
import com.code2concept.androdpalettedemo.utils.AppUtils;
import com.code2concept.androdpalettedemo.utils.CountDownTimerPalette;

import java.util.List;

public class MainActivity extends AppCompatActivity implements INotifyTimer {

    private static final String TAG = MainActivity.class.getName();

    private List<Palette.Swatch> swatchesList;
    private CountDownTimerPalette countDownTimer;

    private int size ;

    private RelativeLayout mainContainer;
    private ImageView circularImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        extractColorFromBitmap();
    }

    private void init() {
        mainContainer = (RelativeLayout)findViewById(R.id.mainContainer);
        circularImageView = (ImageView)findViewById(R.id.circularImageView);
    }

    private void extractColorFromBitmap() {

        Bitmap bitmap = AppUtils.getCircleBitmap(BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.capture_palette));
        circularImageView.setImageBitmap(bitmap);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                swatchesList = palette.getSwatches();

                if (swatchesList != null && swatchesList.size() > 0) {
                    countDownTimer = new CountDownTimerPalette(1000 * swatchesList.size(), 1000, MainActivity.this);
                    countDownTimer.start();
                }
            }
        });
    }

    @Override
    public void onTick(int tick) {

        Palette.Swatch swatch = swatchesList.get(tick - 1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mainContainer.setBackground(AppUtils.createGradient(swatch.getRgb()));
        }else {
            mainContainer.setBackgroundDrawable(AppUtils.createGradient(swatch.getRgb()));
        }

    }

    @Override
    public void onFinish() {
        countDownTimer.start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (countDownTimer != null){
            countDownTimer.cancel();
        }
    }

}
