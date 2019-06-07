package matrimonial.assignment.com.matrimonialassignment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class InterestPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> tabFragmentList;

    public InterestPagerAdapter(FragmentManager fm, List<Fragment> tabFragmentList) {
        super(fm);
        this.tabFragmentList = tabFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return tabFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {

            case 0:
                return "Blocked User";

            case 1:
                return "ShortListed User";

                default:
                    return null;
        }
    }
}
