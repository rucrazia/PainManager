package com.rucrazia.painmanager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rucrazia.iotmanager.R;import java.util.ArrayList;

public class TabManager {

	// _______________________PRIVATE_MEMBERS________________________________________________________________//
	private Context mContext;
	private Listener mListener;

	private int mSelectedIndex = 0;
	private TextView mTabTitle;
	private ArrayList<TabItem> mTabItemList;
	private TabItem.Listener mTabItemListener = new TabItem.Listener() {
		@Override
		public void onClick(int id) {
			if (mSelectedIndex != id) {
				setTab(id);
				mListener.onClick(mSelectedIndex);
			}
		}
	};

	// _______________________PROTECTED_MEMBERS______________________________________________________________//

	// _______________________PUBLIC_MEMBERS_________________________________________________________________//
	public interface Listener {
		public void onClick(int id);
	}

	// _______________________CONSTRUCTOR____________________________________________________________________//
	public TabManager(Context context, View rootView, Listener listener) {
		mContext = context;
		mListener = listener;

		mTabTitle = (TextView) rootView.findViewById(R.id.tab_title);
	
		View tab0 = rootView.findViewById(R.id.tab0);
		View tab1 = rootView.findViewById(R.id.tab1);
		View tab2 = rootView.findViewById(R.id.tab2);

		TabItem tabItem0 = new TabItem(context, 0, tab0, R.drawable.tab_home, "HOME", mTabItemListener);
		TabItem tabItem1 = new TabItem(context, 1, tab1, R.drawable.tab_pain, "PAIN", mTabItemListener);
		TabItem tabItem2 = new TabItem(context, 2, tab2, R.drawable.tab_report, "REPORT", mTabItemListener);
		mTabItemList = new ArrayList<TabItem>();
		mTabItemList.add(tabItem0);
		mTabItemList.add(tabItem1);
		mTabItemList.add(tabItem2);

		mTabTitle.setText(mTabItemList.get(0).getText());
		tabItem0.setState(true);
	}

	// _______________________PUBLIC_METHOD__________________________________________________________________//
	public void setTab(int index) {
		if (mSelectedIndex != index) {
			mTabItemList.get(mSelectedIndex).setState(false);
			mTabItemList.get(index).setState(true);
			mTabTitle.setText(mTabItemList.get(index).getText());
			mSelectedIndex = index;
		}
	}

	// _______________________PROTECTED_METHOD_______________________________________________________________//

	// _______________________PRIAVE_METHOD__________________________________________________________________//

}
