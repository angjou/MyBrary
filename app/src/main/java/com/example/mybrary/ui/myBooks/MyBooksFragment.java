package com.example.mybrary.ui.myBooks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybrary.R;


import java.util.ArrayList;
import java.util.List;

public class MyBooksFragment extends Fragment {

    private MyBooksViewModel myBooksViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Books> mBooks;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myBooksViewModel =
                ViewModelProviders.of(this).get(MyBooksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = root.findViewById(R.id.recycler_view);
        initializeData();
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        if(mBooks.isEmpty()){
            Toast.makeText(getActivity(),"Empty List",Toast.LENGTH_LONG).show();
        }else{
            mAdapter = new MyAdapterBooks(mBooks);
            recyclerView.setAdapter(mAdapter);
        }




        return root;
}
    public void initializeData() {
        mBooks = new ArrayList<>();
        mBooks.add(new Books("Great Gatsby", " F. Scotta Fitzgeralda"));
        mBooks.add(new Books("Marulov san", "Dino Milinović"));
        mBooks.add(new Books("Split kontra Splita", "Dražen Lalić"));

    }
    }

