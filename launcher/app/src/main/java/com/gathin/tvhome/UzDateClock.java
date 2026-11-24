package com.gathin.tvhome;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextClock;

/**
 * A TextClock whose text is written in the 2026 Uzbek alphabet when uz_new_alphabet is on and the TV's language
 * is Uzbek: Android's own weekday names (seshanba, chorshanba) come out as seşanba, çorşanba. Otherwise the
 * same as TextClock.
 */
public class UzDateClock extends TextClock {
    public UzDateClock(Context context) {
        super(context);
    }

    public UzDateClock(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UzDateClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(convertIfUzbek(text), type);
    }

    private CharSequence convertIfUzbek(CharSequence text) {
        if (text == null || text.length() == 0) return text;
        Resources res = getResources();
        if (res == null || !res.getBoolean(R.bool.uz_new_alphabet)) return text;
        if (!"uz".equals(res.getConfiguration().getLocales().get(0).getLanguage())) return text;
        return UzLatin.convert(text);
    }
}
