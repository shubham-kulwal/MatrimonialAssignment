package matrimonial.assignment.com.matrimonialassignment.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseActivity;
import matrimonial.assignment.com.matrimonialassignment.exploreModule.view.ExploreFragment;
import matrimonial.assignment.com.matrimonialassignment.fragments.VisitorFragment;
import matrimonial.assignment.com.matrimonialassignment.shortListModule.view.ShortListFragment;
import matrimonial.assignment.com.matrimonialassignment.interestModule.view.InterestFragment;
import matrimonial.assignment.com.matrimonialassignment.profileModule.view.ProfileFragment;
import matrimonial.assignment.com.matrimonialassignment.loginModule.view.LoginActivity;
import matrimonial.assignment.com.matrimonialassignment.utils.CommonMethods;

import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.NAVIGATION_VALUE;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.USER_ID;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.writeInt;

public class DashBoardActivity extends BaseActivity implements View.OnClickListener {

    private TextView explore_tv, visitor_tv, shortlist_tv, interest_tv, more_tv;
    private ImageView logout_iv;
    private ExploreFragment exploreFragment;
    private VisitorFragment inboxFragment;
    private InterestFragment interestFragment;
    private ProfileFragment moreFragment;
    private ShortListFragment shortListFragment;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_layout);
        init();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Explore");
        logout_iv = findViewById(R.id.logout_iv);
        explore_tv = findViewById(R.id.explore_tv);
        visitor_tv = findViewById(R.id.visitor_tv);
        shortlist_tv = findViewById(R.id.shortlist_tv);
        interest_tv = findViewById(R.id.interest_tv);
        more_tv = findViewById(R.id.profile_tv);
        explore_tv.setOnClickListener(this);
        interest_tv.setOnClickListener(this);
        visitor_tv.setOnClickListener(this);
        shortlist_tv.setOnClickListener(this);
        more_tv.setOnClickListener(this);
        logout_iv.setOnClickListener(this);
        exploreFragment = new ExploreFragment();
        inboxFragment = new VisitorFragment();
        interestFragment = new InterestFragment();
        moreFragment = new ProfileFragment();
        shortListFragment = new ShortListFragment();
        loadExploreFragment();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.explore_tv:
                loadExploreFragment();
                break;

            case R.id.visitor_tv:
                toolbar.setTitle("Visitor");
                visitor_tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                explore_tv.setBackgroundColor(getResources().getColor(R.color.white));
                shortlist_tv.setBackgroundColor(getResources().getColor(R.color.white));
                interest_tv.setBackgroundColor(getResources().getColor(R.color.white));
                more_tv.setBackgroundColor(getResources().getColor(R.color.white));

                visitor_tv.setTextColor(getResources().getColor(R.color.white));
                explore_tv.setTextColor(getResources().getColor(R.color.black));
                shortlist_tv.setTextColor(getResources().getColor(R.color.black));
                interest_tv.setTextColor(getResources().getColor(R.color.black));
                more_tv.setTextColor(getResources().getColor(R.color.black));
                loadFragment(inboxFragment);
                break;

            case R.id.shortlist_tv:
                toolbar.setTitle("Shortlist");
                shortlist_tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                explore_tv.setBackgroundColor(getResources().getColor(R.color.white));
                visitor_tv.setBackgroundColor(getResources().getColor(R.color.white));
                interest_tv.setBackgroundColor(getResources().getColor(R.color.white));
                more_tv.setBackgroundColor(getResources().getColor(R.color.white));

                shortlist_tv.setTextColor(getResources().getColor(R.color.white));
                explore_tv.setTextColor(getResources().getColor(R.color.black));
                visitor_tv.setTextColor(getResources().getColor(R.color.black));
                interest_tv.setTextColor(getResources().getColor(R.color.black));
                more_tv.setTextColor(getResources().getColor(R.color.black));
                loadFragment(shortListFragment);
                break;

            case R.id.interest_tv:
                toolbar.setTitle("Interest");
                interest_tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                explore_tv.setBackgroundColor(getResources().getColor(R.color.white));
                visitor_tv.setBackgroundColor(getResources().getColor(R.color.white));
                shortlist_tv.setBackgroundColor(getResources().getColor(R.color.white));
                more_tv.setBackgroundColor(getResources().getColor(R.color.white));

                interest_tv.setTextColor(getResources().getColor(R.color.white));
                explore_tv.setTextColor(getResources().getColor(R.color.black));
                visitor_tv.setTextColor(getResources().getColor(R.color.black));
                shortlist_tv.setTextColor(getResources().getColor(R.color.black));
                more_tv.setTextColor(getResources().getColor(R.color.black));
                loadFragment(interestFragment);
                break;

            case R.id.profile_tv:
                toolbar.setTitle("Profile");
                more_tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                explore_tv.setBackgroundColor(getResources().getColor(R.color.white));
                visitor_tv.setBackgroundColor(getResources().getColor(R.color.white));
                shortlist_tv.setBackgroundColor(getResources().getColor(R.color.white));
                interest_tv.setBackgroundColor(getResources().getColor(R.color.white));

                more_tv.setTextColor(getResources().getColor(R.color.white));
                explore_tv.setTextColor(getResources().getColor(R.color.black));
                visitor_tv.setTextColor(getResources().getColor(R.color.black));
                shortlist_tv.setTextColor(getResources().getColor(R.color.black));
                interest_tv.setTextColor(getResources().getColor(R.color.black));
                loadFragment(moreFragment);
                break;

            case R.id.logout_iv:
                showLogoutDialog();
                break;
        }
    }

    private void showLogoutDialog() {
        CommonMethods.showDialog(this, "Are you sure, you want to logout?", "SignOut", "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                writeInt(NAVIGATION_VALUE, 0);
                writeInt(USER_ID, 0);
                callActivity(DashBoardActivity.this, LoginActivity.class);
                finish();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        },false);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private void loadExploreFragment() {
        toolbar.setTitle("Explore");
        explore_tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        visitor_tv.setBackgroundColor(getResources().getColor(R.color.white));
        shortlist_tv.setBackgroundColor(getResources().getColor(R.color.white));
        interest_tv.setBackgroundColor(getResources().getColor(R.color.white));
        more_tv.setBackgroundColor(getResources().getColor(R.color.white));

        explore_tv.setTextColor(getResources().getColor(R.color.white));
        visitor_tv.setTextColor(getResources().getColor(R.color.black));
        shortlist_tv.setTextColor(getResources().getColor(R.color.black));
        interest_tv.setTextColor(getResources().getColor(R.color.black));
        more_tv.setTextColor(getResources().getColor(R.color.black));
        loadFragment(exploreFragment);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment != null) {
                if (fragment instanceof ProfileFragment) {
                    fragment.onActivityResult(requestCode, resultCode, data);
                    break;
                }
            }
        }

    }
}
