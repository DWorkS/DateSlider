/*
 * Copyright (C) 2011 Daniel Berndt - Codeus Ltd  -  DateSlider
 *
 * This is a small demo application which demonstrates the use of the
 * dateSelector
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.dworks.widgets.DateSlider;

import java.util.Calendar;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import dev.dworks.widgets.DateSlider.labeler.TimeLabeler;

/**
 * Small Demo activity which demonstrates the use of the DateSlideSelector
 *
 * @author Daniel Berndt - Codeus Ltd
 *
 */
public class Demo extends FragmentActivity {

static final int DEFAULTDATESELECTOR_ID = 0;
static final int DEFAULTDATESELECTOR_WITHLIMIT_ID = 6;
static final int ALTERNATIVEDATESELECTOR_ID = 1;
static final int CUSTOMDATESELECTOR_ID = 2;
static final int MONTHYEARDATESELECTOR_ID = 3;
static final int TIMESELECTOR_ID = 4;
static final int TIMESELECTOR_WITHLIMIT_ID = 7;
static final int DATETIMESELECTOR_ID = 5;

    private static TextView dateText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // load and initialise the Activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        dateText = (TextView) this.findViewById(R.id.selectedDateLabel);
        Button defaultButton = (Button) this.findViewById(R.id.defaultDateSelectButton);
        // set up a listener for when the button is pressed
        defaultButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // call the internal showDialog method using the predefined ID
                showDialogFragment(DEFAULTDATESELECTOR_ID);
            }
        });
        
        Button defaultLimitButton = (Button) this.findViewById(R.id.defaultDateLimitSelectButton);
        // set up a listener for when the button is pressed
        defaultLimitButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // call the internal showDialog method using the predefined ID
                showDialogFragment(DEFAULTDATESELECTOR_WITHLIMIT_ID);
            }
        });

        Button alternativeButton = (Button) this.findViewById(R.id.alternativeDateSelectButton);
        // set up a listener for when the button is pressed
        alternativeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // call the internal showDialog method using the predefined ID
                showDialogFragment(ALTERNATIVEDATESELECTOR_ID);
            }
        });

        Button customButton = (Button) this.findViewById(R.id.customDateSelectButton);
        // set up a listener for when the button is pressed
        customButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // call the internal showDialog method using the predefined ID
                showDialogFragment(CUSTOMDATESELECTOR_ID);
            }
        });

        Button monthYearButton = (Button) this.findViewById(R.id.monthYearDateSelectButton);
        // set up a listener for when the button is pressed
        monthYearButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // call the internal showDialog method using the predefined ID
                showDialogFragment(MONTHYEARDATESELECTOR_ID);
            }
        });

        Button timeButton = (Button) this.findViewById(R.id.timeSelectButton);
        // set up a listener for when the button is pressed
        timeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // call the internal showDialog method using the predefined ID
                showDialogFragment(TIMESELECTOR_ID);
            }
        });
        
        Button timeLimitButton = (Button) this.findViewById(R.id.timeLimitSelectButton);
        // set up a listener for when the button is pressed
        timeLimitButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // call the internal showDialog method using the predefined ID
                showDialogFragment(TIMESELECTOR_WITHLIMIT_ID);
            }
        });

        Button dateTimeButton = (Button) this.findViewById(R.id.dateTimeSelectButton);
        // set up a listener for when the button is pressed
        dateTimeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // call the internal showDialog method using the predefined ID
                showDialogFragment(DATETIMESELECTOR_ID); 
            }
        });
    }

    // define the listener which is called once a user selected the date.
    private static DateSlider.OnDateSetListener mDateSetListener =
        new DateSlider.OnDateSetListener() {
            public void onDateSet(DateSlider view, Calendar selectedDate) {
                // update the dateText view with the corresponding date
                dateText.setText(String.format("The chosen date:%n%te. %tB %tY", selectedDate, selectedDate, selectedDate));
            }
    };

    private static DateSlider.OnDateSetListener mMonthYearSetListener =
        new DateSlider.OnDateSetListener() {
            public void onDateSet(DateSlider view, Calendar selectedDate) {
                // update the dateText view with the corresponding date
                dateText.setText(String.format("The chosen date:%n%tB %tY", selectedDate, selectedDate));
            }
    };

    private static DateSlider.OnDateSetListener mTimeSetListener =
        new DateSlider.OnDateSetListener() {
            public void onDateSet(DateSlider view, Calendar selectedDate) {
                // update the dateText view with the corresponding date
                dateText.setText(String.format("The chosen time:%n%tR", selectedDate));
            }
    };

    private static DateSlider.OnDateSetListener mDateTimeSetListener =
        new DateSlider.OnDateSetListener() {
            public void onDateSet(DateSlider view, Calendar selectedDate) {
                // update the dateText view with the corresponding date
                int minute = selectedDate.get(Calendar.MINUTE) /
                        TimeLabeler.MINUTEINTERVAL*TimeLabeler.MINUTEINTERVAL;
                dateText.setText(String.format("The chosen date and time:%n%te. %tB %tY%n%tH:%02d",
                        selectedDate, selectedDate, selectedDate, selectedDate, minute));
            }
    };

    public void showDialogFragment(int id) {
        // this method is called after invoking 'showDialog' for the first time
        // here we initiate the corresponding DateSlideSelector and return the dialog to its caller
        
        DateSliderFragment DateSliderFragment = new DateSliderFragment(this, id);
        DateSliderFragment.show(getSupportFragmentManager(), "");
    }
    
    public static class DateSliderFragment extends DialogFragment{
    	
    	Context context;
    	int id;
    	
    	public DateSliderFragment() {
		}
    	
    	public DateSliderFragment(Context context, int id) {
    		this.context = context;
    		this.id = id;
		}
    	
    	@Override
    	public void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		setStyle(DialogFragment.STYLE_NO_FRAME, R.style.DialogTheme);
    	}
    	
    	@Override
    	public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            switch (id) {
            case DEFAULTDATESELECTOR_ID:
                return new DefaultDateSlider(context, mDateSetListener,c);
            case DEFAULTDATESELECTOR_WITHLIMIT_ID:
            	final Calendar maxTime = Calendar.getInstance();
            	maxTime.add(Calendar.DAY_OF_MONTH, 14);
                return new DefaultDateSlider(context, mDateSetListener,c,c,maxTime);
            case ALTERNATIVEDATESELECTOR_ID:
                return new AlternativeDateSlider(context, mDateSetListener,c,c,null);
            case CUSTOMDATESELECTOR_ID:
                return new CustomDateSlider(context, mDateSetListener,c);
            case MONTHYEARDATESELECTOR_ID:
                return new MonthYearDateSlider(context, mMonthYearSetListener,c);
            case TIMESELECTOR_ID:
                return new TimeSlider(context, mTimeSetListener,c,15);
            case TIMESELECTOR_WITHLIMIT_ID:
            	final Calendar minTime = Calendar.getInstance();
            	minTime.add(Calendar.HOUR, -2);
                return new TimeSlider(context, mTimeSetListener,c,minTime,c,5);
            case DATETIMESELECTOR_ID:
                return new DateTimeSlider(context, mDateTimeSetListener,c);
            }
			return null;
    	}
    }
}