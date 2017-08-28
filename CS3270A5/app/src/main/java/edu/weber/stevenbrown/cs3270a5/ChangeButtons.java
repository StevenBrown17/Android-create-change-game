package edu.weber.stevenbrown.cs3270a5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ChangeButtons extends Fragment {

    Button btn50d, btn20d, btn10d, btn5d, btn1d, btn50c, btn25c, btn10c, btn5c, btn1c;
    double total = 0.00;

    public ChangeButtons(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change_buttons, container, false);

        btn50d = (Button)view.findViewById(R.id.btn50d);
        btn50d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) getActivity();
                total+=50.00;
                ma.setTotal(total);
            }
        });

        btn20d = (Button)view.findViewById(R.id.btn20d);
        btn20d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) getActivity();
                total+=20.00;
                ma.setTotal(total);
            }
        });

        btn10d = (Button)view.findViewById(R.id.btn10d);
        btn10d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) getActivity();
                total+=10.00;
                ma.setTotal(total);
            }
        });

        btn5d = (Button)view.findViewById(R.id.btn5d);
        btn5d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) getActivity();
                total+=5.00;
                ma.setTotal(total);
            }
        });

        btn1d = (Button)view.findViewById(R.id.btn1d);
        btn1d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) getActivity();
                total+=1.00;
                ma.setTotal(total);
            }
        });
        btn50c = (Button)view.findViewById(R.id.btn50c);
        btn50c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) getActivity();
                total+=0.50;
                ma.setTotal(total);
            }
        });

        btn25c = (Button)view.findViewById(R.id.btn25c);
        btn25c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) getActivity();
                total+=0.25;
                ma.setTotal(total);
            }
        });

        btn10c = (Button)view.findViewById(R.id.btn10c);
        btn10c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) getActivity();
                total+=0.10;
                ma.setTotal(total);
            }
        });

        btn5c = (Button)view.findViewById(R.id.btn5c);
        btn5c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) getActivity();
                total+=0.05;
                ma.setTotal(total);
            }
        });

        btn1c = (Button)view.findViewById(R.id.btn1c);
        btn1c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) getActivity();
                total+=0.01;
                ma.setTotal(total);
            }
        });

        MainActivity ma = (MainActivity) getActivity();
        ma.setChange();

        return view;
    }


    public double getTotal() {

        return this.total;
    }

    public void resetTotal(){
        total = 0.00;
    }
}
