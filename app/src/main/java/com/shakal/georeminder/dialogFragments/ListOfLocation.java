package com.shakal.georeminder.dialogFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shakal.georeminder.R;

public class ListOfLocation extends DialogFragment {
    RecyclerView r;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_of_location,container);
        r = v.findViewById(R.id.recycle_list_of_location);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
