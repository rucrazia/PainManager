package com.rucrazia.painmanager;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;import com.rucrazia.iotmanager.R;

public class MainUiManager {

	// _______________________PRIVATE_MEMBERS________________________________________________________________//
	private FragmentActivity mContext;
	private View mRootView;
	private Listener mListener;
	
	private TabManager mTabManager;
	private TabManager.Listener mTabManagerListener = new TabManager.Listener() {
		@Override
		public void onClick(int id) {
			System.out.println(": onclick 13232 -> "+id);
			mViewPager.setCurrentItem(id);
			mListener.changePage(mChangeIndex);
		}
	};
	
	private int mChangeIndex = 0;
	private ViewPager mViewPager;
	private TabFragmentPagerAdapter mAdapter;
	private ViewPager.OnPageChangeListener mViewPagerListener = new ViewPager.OnPageChangeListener() {
		@Override
		public void onPageSelected(int arg0) {
			System.out.println(":: 1onPageSelected "+arg0);
			if (mChangeIndex != arg0) {
				System.out.println(":: 2onPageSelected "+arg0);
				
				mChangeIndex = arg0;
				mTabManager.setTab(mChangeIndex);
				mAdapter.onResume(mChangeIndex);
				mListener.changePage(mChangeIndex);
			}
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	};
	
	// _______________________PROTECTED_MEMBERS______________________________________________________________//

	// _______________________PUBLIC_MEMBERS_________________________________________________________________//
	public interface Listener {
		public void changePage(int tapPosition);
	}
	
	// _______________________CONSTRUCTOR____________________________________________________________________//
	public MainUiManager(FragmentActivity context, View rootView, Listener listener) {
		mContext = context;
		mRootView = rootView;
		mListener = listener;
		
		init();
	}

	// _______________________PUBLIC_METHOD__________________________________________________________________//
	public void onResume() {
		mAdapter.onResume(0);
	}
	
	// _______________________PROTECTED_METHOD_______________________________________________________________//

	// _______________________PRIAVE_METHOD__________________________________________________________________//
	private void init() {
		View view = mRootView.findViewById(R.id.main_tab);
		mTabManager = new TabManager(mContext, view, mTabManagerListener);
		mTabManager.setTab(0);
		
		mAdapter = new TabFragmentPagerAdapter(mContext, mContext.getSupportFragmentManager());
		mViewPager = (ViewPager) mRootView.findViewById(R.id.main_pager);
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(mViewPagerListener);
	}

}
