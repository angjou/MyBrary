package com.example.mybrary.ui.myWishes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mybrary.R;

public class MyWishesFragment extends Fragment {

    private MyWishesViewModel myWishesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myWishesViewModel =
                ViewModelProviders.of(this).get(MyWishesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mywishes, container, false);
        final TextView textView = root.findViewById(R.id.text_myWishes);
        myWishesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}