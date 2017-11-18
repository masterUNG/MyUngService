package app.ewtc.masterung.myungsrvice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.ewtc.masterung.myungsrvice.R;

/**
 * Created by masterung on 18/11/2017 AD.
 */

public class MainFragment extends Fragment{

//    Create Main Method


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Button Controller
        buttonController();


    }   // Main Method

    private void buttonController() {

        Button button = getView().findViewById(R.id.btnGoToSecond);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Replace Fragment
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentFragmentMain, new SecondFragment())
                        .addToBackStack(null).commit();

            }
        });


    }

    //    Create View
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }

}   // Main Class
