package dev.dworks.widgets.DateSlider.labeler;

import android.content.Context;
import android.os.Bundle;
import dev.dworks.widgets.DateSlider.timeview.TextParams;
import dev.dworks.widgets.DateSlider.timeview.TimeLayoutView;
import dev.dworks.widgets.DateSlider.timeview.TimeView;

/**
 * A Labeler that displays months using TimeLayoutViews.
 */
public class MonthYearLabeler extends MonthLabeler {
    /**
     * The format string that specifies how to display the month. Since this class
     * uses a TimeLayoutView, the format string should consist of two strings
     * separated by a space.
     *
     * @param formatString
     */
    public MonthYearLabeler(String formatString) {
        super(formatString);
    }
    
    @Override
    public TimeView createView(Context context, boolean isCenterView, Bundle bundle) {
        return new TimeLayoutView(context, isCenterView, bundle);
        		//25, 8, 0.95f);
    }
}