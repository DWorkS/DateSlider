package dev.dworks.widgets.DateSlider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass. Use the
 * {@link PickerFragment#newInstance} factory method to create an instance of
 * this fragment.
 * 
 */
public class PickerFragment extends Fragment {
	private static final String LAYOUT_KEY = "LayoutKey";

	private int mLayoutId;

	private View root;
    protected SliderContainer mContainer;

	public static PickerFragment newInstance(int layoutId) {
		PickerFragment fragment = new PickerFragment();
		Bundle args = new Bundle();
		args.putInt(LAYOUT_KEY, layoutId);
		fragment.setArguments(args);
		return fragment;
	}

	public PickerFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mLayoutId = getArguments().getInt(LAYOUT_KEY);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		root = inflater.inflate(mLayoutId, container, false);
		return root;
	}

}
