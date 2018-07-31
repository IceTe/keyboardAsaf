package com.example.barhama_bcmid.keyboardasaf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

import java.util.List;


public class CostumKeyboardView extends KeyboardView {
     Context context;

    public CostumKeyboardView(Context context, AttributeSet attrs, Context context1) {
        super(context, attrs);
        this.context = context1;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint mpaint = new Paint();

        Typeface font = Typeface.createFromAsset(context.getAssets(),
                "fonts/asafgrenier.tff"); //Insert your font here.
        mpaint.setTypeface(font);



        List<Keyboard.Key> keys = getKeyboard().getKeys();
        for (Keyboard.Key key : keys) {

            if (key.label != null) {
                String keyLabel = key.label.toString();
                canvas.drawText(keyLabel, key.x + key.width, key.y + key.height, mpaint);
            } else if (key.icon != null) {
                key.icon.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                key.icon.draw(canvas); }
        }
    }
}
