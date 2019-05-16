package matrimonial.assignment.com.matrimonialassignment.activity;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseActivity;
import matrimonial.assignment.com.matrimonialassignment.exploreModule.view.ExploreFragment;
import matrimonial.assignment.com.matrimonialassignment.fragments.InboxFragment;
import matrimonial.assignment.com.matrimonialassignment.fragments.InterestFragment;
import matrimonial.assignment.com.matrimonialassignment.fragments.MoreFragment;
import matrimonial.assignment.com.matrimonialassignment.fragments.NotificationFragment;
import matrimonial.assignment.com.matrimonialassignment.loginModule.view.LoginActivity;
import matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager;
import matrimonial.assignment.com.matrimonialassignment.utils.CommonMethods;

public class DashBoardActivity extends BaseActivity implements View.OnClickListener {

    private TextView explore_tv, inbox_tv, notification_tv, interest_tv, more_tv;
    private ImageView logout_iv;
    private ExploreFragment exploreFragment;
    private InboxFragment inboxFragment;
    private InterestFragment interestFragment;
    private MoreFragment moreFragment;
    private NotificationFragment notificationFragment;
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
        inbox_tv = findViewById(R.id.inbox_tv);
        notification_tv = findViewById(R.id.notification_tv);
        interest_tv = findViewById(R.id.interest_tv);
        more_tv = findViewById(R.id.more_tv);
        explore_tv.setOnClickListener(this);
        interest_tv.setOnClickListener(this);
        inbox_tv.setOnClickListener(this);
        notification_tv.setOnClickListener(this);
        more_tv.setOnClickListener(this);
        logout_iv.setOnClickListener(this);
        exploreFragment = new ExploreFragment();
        inboxFragment = new InboxFragment();
        interestFragment = new InterestFragment();
        moreFragment = new MoreFragment();
        notificationFragment = new NotificationFragment();
        loadExploreFragment();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.explore_tv:
                loadExploreFragment();
                break;

            case R.id.inbox_tv:
                toolbar.setTitle("Inbox");
                inbox_tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                explore_tv.setBackgroundColor(getResources().getColor(R.color.white));
                notification_tv.setBackgroundColor(getResources().getColor(R.color.white));
                interest_tv.setBackgroundColor(getResources().getColor(R.color.white));
                more_tv.setBackgroundColor(getResources().getColor(R.color.white));

                inbox_tv.setTextColor(getResources().getColor(R.color.white));
                explore_tv.setTextColor(getResources().getColor(R.color.black));
                notification_tv.setTextColor(getResources().getColor(R.color.black));
                interest_tv.setTextColor(getResources().getColor(R.color.black));
                more_tv.setTextColor(getResources().getColor(R.color.black));
                loadFragment(inboxFragment);
                break;

            case R.id.notification_tv:
                toolbar.setTitle("Notification");
                notification_tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                explore_tv.setBackgroundColor(getResources().getColor(R.color.white));
                inbox_tv.setBackgroundColor(getResources().getColor(R.color.white));
                interest_tv.setBackgroundColor(getResources().getColor(R.color.white));
                more_tv.setBackgroundColor(getResources().getColor(R.color.white));

                notification_tv.setTextColor(getResources().getColor(R.color.white));
                explore_tv.setTextColor(getResources().getColor(R.color.black));
                inbox_tv.setTextColor(getResources().getColor(R.color.black));
                interest_tv.setTextColor(getResources().getColor(R.color.black));
                more_tv.setTextColor(getResources().getColor(R.color.black));
                loadFragment(notificationFragment);
                break;

            case R.id.interest_tv:
                toolbar.setTitle("Interest");
                interest_tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                explore_tv.setBackgroundColor(getResources().getColor(R.color.white));
                inbox_tv.setBackgroundColor(getResources().getColor(R.color.white));
                notification_tv.setBackgroundColor(getResources().getColor(R.color.white));
                more_tv.setBackgroundColor(getResources().getColor(R.color.white));

                interest_tv.setTextColor(getResources().getColor(R.color.white));
                explore_tv.setTextColor(getResources().getColor(R.color.black));
                inbox_tv.setTextColor(getResources().getColor(R.color.black));
                notification_tv.setTextColor(getResources().getColor(R.color.black));
                more_tv.setTextColor(getResources().getColor(R.color.black));
                loadFragment(interestFragment);
                break;

            case R.id.more_tv:
                toolbar.setTitle("More");
                more_tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                explore_tv.setBackgroundColor(getResources().getColor(R.color.white));
                inbox_tv.setBackgroundColor(getResources().getColor(R.color.white));
                notification_tv.setBackgroundColor(getResources().getColor(R.color.white));
                interest_tv.setBackgroundColor(getResources().getColor(R.color.white));

                more_tv.setTextColor(getResources().getColor(R.color.white));
                explore_tv.setTextColor(getResources().getColor(R.color.black));
                inbox_tv.setTextColor(getResources().getColor(R.color.black));
                notification_tv.setTextColor(getResources().getColor(R.color.black));
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
                SharedPrefManager.writeInt(SharedPrefManager.NAVIGATION_VALUE, 0);
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
        inbox_tv.setBackgroundColor(getResources().getColor(R.color.white));
        notification_tv.setBackgroundColor(getResources().getColor(R.color.white));
        interest_tv.setBackgroundColor(getResources().getColor(R.color.white));
        more_tv.setBackgroundColor(getResources().getColor(R.color.white));

        explore_tv.setTextColor(getResources().getColor(R.color.white));
        inbox_tv.setTextColor(getResources().getColor(R.color.black));
        notification_tv.setTextColor(getResources().getColor(R.color.black));
        interest_tv.setTextColor(getResources().getColor(R.color.black));
        more_tv.setTextColor(getResources().getColor(R.color.black));
        loadFragment(exploreFragment);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
