package com.shakal.georeminder.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.shakal.georeminder.R;

import java.util.Objects;

public class NewRecord extends Fragment {

    private Button btn_add;
    private Button btn_location;
    private Button btn_time;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_record,container,false);

        btn_add = view.findViewById(R.id.btn_add);
        btn_location = view.findViewById(R.id.btn_location);
        btn_time = view.findViewById(R.id.btn_time);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        final FloatingActionButton btn = Objects.requireNonNull(getActivity()).findViewById(R.id.btn_add_remind);
        Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.show_btn);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                btn.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btn.setClickable(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        btn.startAnimation(animation);
    }
}
