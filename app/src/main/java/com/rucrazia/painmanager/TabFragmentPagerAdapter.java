package com.rucrazia.painmanager;

import com.rucrazia.painmanager.home.HomeFragment;
import com.rucrazia.painmanager.pain.PainFragment;
import com.rucrazia.painmanager.report.ReportFragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {

	// _______________________PRIVATE_MEMBERS________________________________________________________________//
	private Context mContext;
	private boolean mInit = false;
	private Fragment[] mFragments;
	
	// _______________________PROTECTED_MEMBERS______________________________________________________________//

	// _______________________PUBLIC_MEMBERS_________________________________________________________________//
	public static final int FRAGMENT_SIZE = 3;
	
	// _______________________CONSTRUCTOR____________________________________________________________________//
	public TabFragmentPagerAdapter(Context context, FragmentManager fm) {
		super(fm);
		mContext = context;
		init();
	}

	// _______________________PUBLIC_METHOD__________________________________________________________________//
	@Override
	public Fragment getItem(int position) {
		return mFragments[position];
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return mFragments[position].getText(position);
	}

	@Override
	public int getCount() {
		return FRAGMENT_SIZE;
	}
	
	public void onResume(int tabPosition) {
		
	}
	
	// _______________________PROTECTED_METHOD_______________________________________________________________//

	// _______________________PRIAVE_METHOD__________________________________________________________________//
	private void init() {
		if (!mInit) {
			mInit = true;
			mFragments = new Fragment[FRAGMENT_SIZE];
			mFragments[0] = new HomeFragment();
			mFragments[1] = new PainFragment();
			mFragments[2] = new ReportFragment();
		}
	}

}