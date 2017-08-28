package edu.weber.stevenbrown.cs3270a5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;


public class ChangeResults extends Fragment {


    TextView txtChange, txtTotal, txtTime;

    CountDownTimer timer;


    public ChangeResults(){}


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change_results, container, false);

        txtChange = (TextView)view.findViewById(R.id.txtChange);
        txtTotal = (TextView)view.findViewById(R.id.txtTotal);
        txtTime = (TextView)view.findViewById(R.id.txtTime);

        newTimer();

        return view;
    }

    public void setTotal(double total){
        String stotal = "$"+ String.format(Locale.getDefault(),"%.2f",total);
        txtTotal.setText(stotal);
    }



    public void setChange(double change) {
        String schange = "$"+ String.format(Locale.getDefault(),"%.2f",change);
        txtChange.setText(schange);
    }



    public void checkResults(double total, double change){

        MainActivity ma = (MainActivity) getActivity();

        if(total == ma.change){ //win
            stopTimer();
            CorrectChange dialog = new CorrectChange();
            dialog.setCancelable(false);
            dialog.show(getFragmentManager(),"Win");
        }else if(total>ma.change){//lose
            stopTimer();
            IncorrectChange dialog = new IncorrectChange();
            dialog.setCancelable(false);
            dialog.show(getFragmentManager(),"Lose");
        }
        else{

        }
    }

    public void stopTimer(){
        txtTime.setText("0");
        timer.cancel();
    }

    public void newTimer(){

        this.timer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                txtTime.setText(""+millisUntilFinished / 1000);
            }

            public void onFinish() {
                txtTime.setText("0");
                TooLong dialog = new TooLong();
                dialog.setCancelable(false);
                dialog.show(getFragmentManager(),"Times up!");
            }

        }.start();

    }//end Timer()

}
