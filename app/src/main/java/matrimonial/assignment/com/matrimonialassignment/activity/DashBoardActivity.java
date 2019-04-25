package matrimonial.assignment.com.matrimonialassignment.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.fragments.ExploreFragment;
import matrimonial.assignment.com.matrimonialassignment.fragments.InboxFragment;
import matrimonial.assignment.com.matrimonialassignment.fragments.InterestFragment;
import matrimonial.assignment.com.matrimonialassignment.fragments.MoreFragment;
import matrimonial.assignment.com.matrimonialassignment.fragments.NotificationFragment;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView explore_tv, inbox_tv, notification_tv, interest_tv, more_tv;
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
        }
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
}
