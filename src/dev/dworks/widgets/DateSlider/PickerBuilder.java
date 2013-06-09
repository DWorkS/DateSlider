package dev.dworks.widgets.DateSlider;

import java.util.Calendar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/**
 * User: derek Date: 5/2/13 Time: 7:55 PM
 */
public class PickerBuilder {

    private FragmentManager manager; // Required
    private Integer styleResId = -1;
    private Fragment targetFragment;
    
    private Calendar mInitialTime; // Required
    private Calendar minTime = null;
    private Calendar maxTime = null;
    private int minuteInterval = 1;
    private int mReference = -1;

    public PickerBuilder setFragmentManager(FragmentManager manager) {
        this.manager = manager;
        return this;
    }

    public PickerBuilder setStyleResId(int styleResId) {
        this.styleResId = styleResId;
        return this;
    }

    public PickerBuilder setTargetFragment(Fragment targetFragment) {
        this.targetFragment = targetFragment;
        return this;
    }

    public PickerBuilder setReference(int reference) {
        this.mReference = reference;
        return this;
    }

    public PickerBuilder setInitialTime(Calendar initialTime) {
        this.mInitialTime = initialTime;
        return this;
    }

    public PickerBuilder setMinTime(Calendar minTime) {
        this.minTime = minTime;
        return this;
    }
    
    public PickerBuilder setMaxTime(Calendar maxTime) {
        this.maxTime = maxTime;
        return this;
    }

    public PickerBuilder setMinuteInterval(int minuteInterval) {
        this.minuteInterval = minuteInterval;
        return this;
    }

    public void show() {
        if (manager == null){// || styleResId == null) {
            Log.e("PickerBuilder", "setFragmentManager() and setStyleResId() must be called.");
            return;
        }
        final FragmentTransaction ft = manager.beginTransaction();
        final Fragment prev = manager.findFragmentByTag("date_dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        final PickerDialogFragment fragment = PickerDialogFragment.newInstance(mReference, styleResId, mInitialTime, minTime, maxTime, minuteInterval);
        if (targetFragment != null) {
        	fragment.setTargetFragment(targetFragment, 0);
        }
        fragment.show(ft, "date_dialog");
    }
}
