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


public class CorrectChange extends DialogFragment {


    public CorrectChange(){}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Dialog dialog =
                builder.setMessage("You were able to make the correct change")
                        .setCancelable(false)
                        .setTitle("You did it!")
                        .setPositiveButton("Woo!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity ma = (MainActivity) getActivity();
                                ma.reset();
                                ma.addCount();
                            }
                        }).create();

        return dialog;
    }



}
