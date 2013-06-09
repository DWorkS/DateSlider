package dev.dworks.widgets.DateSlider.timeview;

import java.util.Calendar;

import android.content.Context;
import android.os.Bundle;
import dev.dworks.widgets.DateSlider.TimeObject;
import dev.dworks.widgets.DateSlider.labeler.Util;

/**
 * This is a subclass of the TimeLayoutView that represents a day. It uses
 * a different color to distinguish Sundays from other days.
 */
public class DayTimeLayoutView extends TimeLayoutView {

    protected boolean isSunday=false;
    protected Bundle bundle;

    /**
     * Constructor
     * @param context
     * @param isCenterView true if the element is the centered view in the ScrollLayout
     * @param topTextSize	text size of the top TextView in dps
     * @param bottomTextSize	text size of the bottom TextView in dps
     * @param lineHeight	LineHeight of the top TextView
     */
    public DayTimeLayoutView(Context context, boolean isCenterView, Bundle bundle) {
        super(context, isCenterView, bundle);
    	this.bundle = bundle;
    }

    @Override
    public void setVals(TimeObject to) {
        super.setVals(to);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(to.endTime);
        if (c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY && !isSunday) {
            isSunday=true;
            colorMeSunday();
        } else if (isSunday && c.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY) {
            isSunday=false;
            colorMeWorkday();
        }
    }

    /**
     * this method is called when the current View takes a Sunday as time unit
     */
    protected void colorMeSunday() {
    	if (isOutOfBounds) return;
        if (isCenter) {
            bottomView.setTextColor(0xFF773333);
            topView.setTextColor(0xFF553333);
        }
        else {
            bottomView.setTextColor(0xFF442222);
            topView.setTextColor(0xFF553333);
        }
    }

    /**
     * this method is called when the current View takes no Sunday as time unit
     */
    protected void colorMeWorkday() {
    	if (isOutOfBounds) return;
        if (isCenter) {
            bottomView.setTextColor(bundle.getInt(Util.SECONDARY_TEXT_COLOR_BOLD));
            topView.setTextColor(bundle.getInt(Util.PRIMARY_TEXT_COLOR_BOLD));
        }
        else {
            bottomView.setTextColor(bundle.getInt(Util.SECONDARY_TEXT_COLOR));
            topView.setTextColor(bundle.getInt(Util.PRIMARY_TEXT_COLOR));
        }
    }

    @Override
    public void setVals(TimeView other) {
        super.setVals(other);
        DayTimeLayoutView otherDay = (DayTimeLayoutView) other;
        if (otherDay.isSunday && !isSunday) {
            isSunday = true;
            colorMeSunday();
        } else if (isSunday && !otherDay.isSunday) {
            isSunday = false;
            colorMeWorkday();
        }
    }
}