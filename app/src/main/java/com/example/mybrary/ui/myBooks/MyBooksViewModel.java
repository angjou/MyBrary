package com.example.mybrary.ui.myBooks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyBooksViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public MyBooksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is my Books fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
