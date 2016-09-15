package com.rucrazia.painmanager;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;import com.rucrazia.iotmanager.R;

public class TabItem {

	// _______________________PRIVATE_MEMBERS________________________________________________________________//
	private int mId;
	private String mText;
	private ImageView mImgView;
	private View mViewIndicator;

	private Listener mListener;

	// _______________________PROTECTED_MEMBERS______________________________________________________________//

	// _______________________PUBLIC_MEMBERS_________________________________________________________________//
	public interface Listener {
		public void onClick(int id);
	}

	// _______________________CONSTRUCTOR____________________________________________________________________//
	public TabItem(Context context, int id, View rootView, int imgId, String text, Listener listener) {
		mId = id;
		mText = text;
		mListener = listener;

		mImgView = (ImageView) rootView.findViewById(R.id.tab_icon);
		mViewIndicator = rootView.findViewById(R.id.tab_indicator);

		mImgView.setImageResource(imgId);

		rootView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println(":::::::::::: onClick "+mId);
				mListener.onClick(mId);
			}
		});

		changedNormal();
	}

	// _______________________PUBLIC_METHOD__________________________________________________________________//
	public String getText() {
		return mText;
	}
 	public void setState(boolean selected) {
		if (selected) {
			chagedSelected();
		} else {
			changedNormal();
		}
	}
	
	// _______________________PROTECTED_METHOD_______________________________________________________________//

	// _______________________PRIAVE_METHOD__________________________________________________________________//
	private void chagedSelected() {
		mViewIndicator.setVisibility(View.VISIBLE);
	}

	private void changedNormal() {
		mViewIndicator.setVisibility(View.INVISIBLE);
	}

}
