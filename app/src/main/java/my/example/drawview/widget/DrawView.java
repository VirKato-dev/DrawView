package my.example.drawview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;


public class DrawView extends View {

    WindowManager wm;
    Paint p = new Paint();
    Rect rect = new Rect();
    float dpi;
    String text = "VirKato";


    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        drawIt(canvas);
    }


    public void setText(String text) {
        this.text = text;
        invalidate();
    }


    void drawIt(Canvas canvas) {
        dpi = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics());
//        canvas.drawARGB(80, 102, 204, 255);

        p.setColor(Color.RED);
        p.setStrokeWidth(1);
//        p.setStrokeCap(Paint.Cap.SQUARE);

        int pad_h = getPaddingStart() + getPaddingEnd();
        int pad_v = getPaddingTop() + getPaddingBottom();

        int width = canvas.getWidth() - pad_h;
        int height = canvas.getHeight() - pad_v;
        float size = Math.min(width, height);
        float textWidth = size - 20 * dpi;

        canvas.drawCircle(getPaddingStart() + width / 2f,
                getPaddingTop() + height / 2f,
                (size) / 2f, p);

        p.setColor(Color.WHITE);
        p.setTextSize(size);
        p.setTextAlign(Paint.Align.CENTER);
        p.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        // вычислить ширину текста
        rect = new Rect();
        p.getTextBounds(text, 0, text.length(), rect);
        p.setTextSize(size * textWidth / rect.width());
        // вычислить вертикальное смещение к центру текста
        float line = ((p.getFontMetrics().bottom - p.getFontMetrics().top) * 1.4f) / dpi;

        canvas.drawText(text, getPaddingStart() + width / 2f, line / 2f + getPaddingTop() + height / 2f, p);
    }

}
