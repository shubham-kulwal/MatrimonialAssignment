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
import matrimonial.assignment.com.matrimonialassignment.dtos.Person;

public class InterestFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interest_layout, null);
        recyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ListAdapter mAdapter = new ListAdapter(getPersonList());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    private List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        for (int i=0; i<=10; i++){
            Person person=new Person();
            person.setName("Pandurang Kumbhar");
            person.setAge(24);
            person.setMobile("9999999999");
            person.setAddress("Baner, Pune");
            person.setDateOfBirth("10-01-1995");
            personList.add(person);
        }
        return personList;
    }
}
