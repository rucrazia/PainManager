package com.rucrazia.painmanager.pain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public final class PainFragment extends Fragment {

	// _______________________PRIVATE_MEMBERS________________________________________________________________//
	
	// _______________________PROTECTED_MEMBERS______________________________________________________________//

	// _______________________PUBLIC_MEMBERS_________________________________________________________________//

	// _______________________CONSTRUCTOR____________________________________________________________________//

	// _______________________PUBLIC_METHOD__________________________________________________________________//
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		TextView text = new TextView(getActivity());
		text.setGravity(Gravity.CENTER);
		text.setText("PainFragment");
		text.setTextSize(20 * getResources().getDisplayMetrics().density);
		text.setPadding(20, 20, 20, 20);

		LinearLayout layout = new LinearLayout(getActivity());
		layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		layout.setGravity(Gravity.CENTER);
		layout.addView(text);

		return layout;
	}

	// _______________________PROTECTED_METHOD_______________________________________________________________//

	// _______________________PRIAVE_METHOD__________________________________________________________________//

}
