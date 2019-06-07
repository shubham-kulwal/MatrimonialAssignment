package matrimonial.assignment.com.matrimonialassignment.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.adapter.ListAdapter;

public class InterestFragment extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_interest_layout, null);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        List<Fragment> tabFragmentList = new ArrayList<>();
        tabFragmentList.add(acuteMedicationFragment);
        tabFragmentList.add(preventiveMedicationFragment);
    }
}
