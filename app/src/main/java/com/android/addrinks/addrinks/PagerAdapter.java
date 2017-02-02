package com.android.addrinks.addrinks;

import android.content.ComponentCallbacks;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Florian on 22.01.2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                MainActivityFragment tab1 = new MainActivityFragment();
                return tab1;
            case 1:
                CoffeeFragment tab2 = new CoffeeFragment();
                return tab2;
            case 2:
                CommercialFragment tab3 = new CommercialFragment();
                return tab3;
            case 3:
                AccountFragment tab4 = new AccountFragment();
                return tab4;
            case 4:
                VideoFragment tab5 = new VideoFragment();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
