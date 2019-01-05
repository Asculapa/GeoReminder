package com.shakal.georeminder.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.shakal.georeminder.R;
import com.shakal.georeminder.dialogFragments.ListOfLocation;

import java.util.Arrays;
import java.util.Objects;

public class NewRecord extends Fragment {

    private Button btnAadd;
    private Button btnLocation;
    private Button btnTime;
    private FragmentManager fragmentManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_record, container, false);

        btnAadd = view.findViewById(R.id.btn_add);
        btnLocation = view.findViewById(R.id.btn_location);
        btnTime = view.findViewById(R.id.btn_time);
        fragmentManager = getFragmentManager();
        setBtnLocation();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        final FloatingActionButton btn = Objects.requireNonNull(getActivity()).findViewById(R.id.btn_add_remind);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.show_btn);
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

    private void setBtnLocation() {
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String list_of_location = getResources().getString(R.string.list_of_location);
                final String select_location = getResources().getString(R.string.select_location);
                String title = getResources().getString(R.string.choose_variant);

                final String[] list = {list_of_location,select_location};

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(title);
                builder.setItems(list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       String selectedText = Arrays.asList(list).get(which);

                       if (selectedText.equals(list_of_location)){
                            listOfLocation();
                       }else if (selectedText.equals(select_location)){
                            selectLocation();
                       }else {
                           Toast.makeText(getActivity(),getResources().getText(R.string.developer_is_debil),Toast.LENGTH_LONG).show();
                       }
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private void listOfLocation(){
        ListOfLocation listOfLocation = new ListOfLocation();
        listOfLocation.show(fragmentManager,null);
    }

    private void selectLocation(){
        Map map = new Map();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction
                .addToBackStack(null)
                .replace(R.id.container_for_new_record, map)
                .commit();
    }
}
