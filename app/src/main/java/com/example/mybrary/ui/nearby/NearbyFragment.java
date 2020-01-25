package com.example.mybrary.ui.nearby;

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

public class NearbyFragment extends Fragment {

    private NearbyViewModel nearbyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        nearbyViewModel =
                ViewModelProviders.of(this).get(NearbyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_nearby, container, false);
        final TextView textView = root.findViewById(R.id.text_nearby);
        nearbyViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}