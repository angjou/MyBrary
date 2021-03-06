package com.example.mybrary.ui.nearby;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybrary.R;

import java.util.ArrayList;
import java.util.List;

public class NearbyFragment extends Fragment {

    private NearbyViewModel nearbyViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Person> mperson;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        nearbyViewModel =
                ViewModelProviders.of(this).get(NearbyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        initializeData();
        if(mperson.isEmpty()){
            Toast.makeText(getActivity(),"Empty List",Toast.LENGTH_LONG).show();
        }else{
            mAdapter = new MyAdapter(mperson);
            recyclerView.setAdapter(mAdapter);
        }



        return root;
    }

    public void initializeData()
    {
        mperson = new ArrayList<>();
        mperson.add(new Person("Ivo", " Anić"));
        mperson.add(new Person("Mate", "Krolo"));
        mperson.add(new Person("Jure", "Papak"));
        mperson.add(new Person("Duje", "Lalić"));
        mperson.add(new Person("Ana", "Kumrić"));
        mperson.add(new Person("Sara", "Gvozdanović"));
        mperson.add(new Person("Antea", "Kordić"));
        mperson.add(new Person("Sanja", "Gotovac"));
        mperson.add(new Person("Latica", "Livakopvić"));
        mperson.add(new Person("Kim", "Pleter"));
    }
}