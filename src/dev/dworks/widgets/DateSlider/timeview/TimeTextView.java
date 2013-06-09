package dev.dworks.widgets.DateSlider.timeview;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;
import dev.dworks.widgets.DateSlider.TimeObject;
import dev.dworks.widgets.DateSlider.labeler.Util;

/**
 * This is a simple implementation of a TimeView which is implemented
 * as a TextView. It is aware of whether or not it is the center view
 * in the ScrollLayout so that it can alter its appearance to indicate
 * that it is currently selected.
 */
public class TimeTextView extends TextView implements TimeView {
    protected long endTime, startTime;
    protected boolean isOutOfBounds = false;

    /**
     * constructor
     * @param context
     * @param isCenterView true if the element is the centered view in the ScrollLayout
     * @param textSize text size in dps
     */
    public TimeTextView(Context context, boolean isCenterView, Bundle textSize) {
        super(context);
        setupView(isCenterView, textSize);
    }

    /**
     * this method should be overwritten by inheriting classes to define its own look and feel
     * @param isCenterView true if the element is in the center of the scrollLayout
     * @param textSize textSize in dps
     */
    protected void setupView(boolean isCenterView, Bundle textSize) {
        setGravity(Gravity.CENTER);
        setTextSize(textSize.getFloat(Util.PRIMARY_TEXT_SIZE));
        if (isCenterView) {
            setTypeface(Typeface.DEFAULT_BOLD);
            setTextColor(textSize.getInt(Util.PRIMARY_TEXT_COLOR_BOLD));
        } else {
            setTextColor(textSize.getInt(Util.PRIMARY_TEXT_COLOR));
        }
    }

    
    public void setVals(TimeObject to) {
        setText(to.text);
        this.startTime = to.startTime;
        this.endTime = to.endTime;
    }

    
    public void setVals(TimeView other) {
        setText(other.getTimeText());
        startTime = other.getStartTime();
        endTime = other.getEndTime();
    }
    
    public long getStartTime() {
        return this.startTime;
    }

    
    public long getEndTime() {
        return this.endTime;
    }

    
    public String getTimeText() {
        return getText().toString();
    }

	public boolean isOutOfBounds() {
		return isOutOfBounds;
	}

	public void setOutOfBounds(boolean outOfBounds) {
		if (outOfBounds && !isOutOfBounds) {
			setTextColor(0x44666666);
		}
		else if (!outOfBounds && isOutOfBounds) {
            setTextColor(0xFF666666);
		}
		isOutOfBounds = outOfBounds;
	}

}