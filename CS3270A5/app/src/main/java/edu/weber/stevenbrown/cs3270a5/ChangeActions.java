package edu.weber.stevenbrown.cs3270a5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class ChangeActions extends Fragment {

    Button btnStart, btnNew;
    TextView txtCount, txtMaxAmount;


    public ChangeActions(){}


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change_actions, container, false);
        btnStart = (Button)view.findViewById(R.id.btnStart);
        btnNew = (Button)view.findViewById(R.id.btnNew);
        txtCount = (TextView)view.findViewById(R.id.txtCount);
        txtMaxAmount = (TextView)view.findViewById(R.id.txtMaxAmount);



        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) getActivity();
                ma.reset();
            }
        });

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) getActivity();
                ma.setChange();
            }
        });

        MainActivity ma = (MainActivity)getActivity();
        setTxtMaxAmount(ma.amount);

        return view;
    }

    public void setTxtCount(String txtCount) {
        this.txtCount.setText(txtCount);
    }

    public void setTxtMaxAmount(int txtMaxAmount) {
        this.txtMaxAmount.setText("max amount: "+txtMaxAmount);
    }

}//end class
