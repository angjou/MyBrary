package com.example.mybrary.ui.myWishes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybrary.R;


import java.util.ArrayList;
import java.util.List;

public class MyWishesFragment extends Fragment {

    private MyWishesViewModel myWishesViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Wishes> mWishes ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myWishesViewModel =
                ViewModelProviders.of(this).get(MyWishesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = root.findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapterWishes(mWishes);
        recyclerView.setAdapter(mAdapter);
        initializeData();
        if(mWishes.isEmpty()){
            Toast.makeText(getActivity(),"Empty List",Toast.LENGTH_LONG).show();
        }else{
            mAdapter = new MyAdapterWishes(mWishes);
            recyclerView.setAdapter(mAdapter);
        }

        return root;
    }

    public void initializeData()
    {
        mWishes = new ArrayList<>();
        mWishes.add(new Wishes("Kome zvono zvoni", " E.Hemingway"));
        mWishes.add(new Wishes("100 godina samoće", "G. Garcia Marquez"));
        mWishes.add(new Wishes("The tango singer", "Tomás Eloy Martínez"));
    }
}