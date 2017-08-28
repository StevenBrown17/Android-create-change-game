package edu.weber.stevenbrown.cs3270a5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class ChangeMax extends DialogFragment {

    Button btnSave;
    EditText maxAmount;


    public ChangeMax(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change_max, container, false);
        maxAmount = (EditText)view.findViewById(R.id.maxAmount);
//
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                MainActivity ma = (MainActivity) getActivity();
//
//                double amount=100;
//                if (maxAmount == null || !maxAmount.getText().toString().matches("[0-9]+(\\.[0-9][0-9]?)?")) {
//                    amount = 100;
//                }else {
//                    amount = Double.parseDouble(maxAmount.getText().toString());
//                    ma.setAmount((int)amount);
//                }
//            }
//        });

        return view;
    }





}
