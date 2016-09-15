package com.rucrazia.painmanager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

public class MainActivity extends FragmentActivity {

    // _______________________PRIVATE_MEMBERS________________________________________________________________//
    private Context mContext;
    private MainUiManager mMainUiManager;
    private MainUiManager.Listener mMainUiMangerListener = new MainUiManager.Listener() {
        @Override
        public void changePage(int tabPosition) {
            //System.out.println(":: MainActivity changePage :: " + tabPosition);
        }
    };

    // _______________________PROTECTED_MEMBERS______________________________________________________________//

    // _______________________PUBLIC_MEMBERS_________________________________________________________________//

    // _______________________CONSTRUCTOR____________________________________________________________________//

    // _______________________PUBLIC_METHOD__________________________________________________________________//

    // _______________________PROTECTED_METHOD_______________________________________________________________//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_main);
        View rootView = findViewById(R.id.rootview);
        mMainUiManager = new MainUiManager(this, rootView, mMainUiMangerListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainUiManager.onResume();
    }

    // _______________________PRIAVE_METHOD__________________________________________________________________//

}
