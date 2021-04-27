package com.example.simplecanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.my_imageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(),
                R.color.black, null));
        mPaintText.setTextSize(60);
    }

    public void drawSomething(View view) {
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(Color.CYAN);

        mPaint.setColor(ContextCompat.getColor(this, R.color.dark_blue));
        Rect mRect = new Rect();
        mRect.set(180, 620, 720, 900);
        mCanvas.drawRect(mRect, mPaint);

        mPaint.setColor(ContextCompat.getColor(this, R.color.purple_200));
        mRect.set(380, 700, 530, 900);
        mCanvas.drawRect(mRect, mPaint);

        mPaint.setColor(ContextCompat.getColor(this, R.color.brown));
        Path path = new Path();
        path.moveTo(520, 410); // Atas
        path.lineTo(175, 625); // Bawah kiri
        path.lineTo(725, 625); // Bawah kanan
        path.lineTo(456, 450); // Balik ke atas
        path.close();
        mCanvas.drawPath(path, mPaint);

        mPaint.setColor(Color.LTGRAY);
        mCanvas.drawCircle(625, 750, 50, mPaint);

        mPaint.setColor(Color.LTGRAY);
        mCanvas.drawCircle(280, 750, 50, mPaint);

        mCanvas.drawText("Christian Lamhot Tua",175,200,mPaintText);

        view.invalidate();
    }

}
























