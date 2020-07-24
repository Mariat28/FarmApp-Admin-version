package ug.global.glofarmadmin.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import ug.global.glofarmadmin.fragments.Farmers;
import ug.global.glofarmadmin.fragments.Supplies;
import ug.global.glofarmadmin.fragments.Tools;


public class TabsAdapter extends FragmentStatePagerAdapter {
    private int nooftabs;

    public TabsAdapter(FragmentManager fm, int nooftabs) {
        super(fm);
        this.nooftabs = nooftabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Farmers();
        } else if (position == 1) {
            return new Supplies();
        } else {
            return new Tools();
        }
    }

    @Override
    public int getCount() {
        return nooftabs;
    }
}
