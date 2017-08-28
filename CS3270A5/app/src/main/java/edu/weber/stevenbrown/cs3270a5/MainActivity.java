package edu.weber.stevenbrown.cs3270a5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    double change=0;
    int amount=100, count=0;
    public static String inputvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.resultsContainer, new ChangeResults(), "CR").addToBackStack(null).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.buttonsContainer, new ChangeButtons(), "CB").addToBackStack(null).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.actionsContainer, new ChangeActions(), "CA").addToBackStack(null).commit();

    }

    public void setAmount(int amount){
        this.amount = amount;
        ChangeActions changeActions = (ChangeActions)getSupportFragmentManager().findFragmentByTag("CA");
        changeActions.setTxtMaxAmount(amount);
    }

    public void setTotal(double total){

        ChangeResults changeResults = (ChangeResults)getSupportFragmentManager().findFragmentByTag("CR");
        changeResults.setTotal(total);
        checkResults();

    }

    public void checkResults(){

        ChangeResults changeResults = (ChangeResults)getSupportFragmentManager().findFragmentByTag("CR");
        ChangeButtons changeButtons = (ChangeButtons)getSupportFragmentManager().findFragmentByTag("CB");
        double total = round(changeButtons.getTotal(),2);
        changeResults.checkResults(total, this.change);
    }


    public void setChange(){
        Random random = new Random();
        change = random.nextDouble() * amount;
        change = round(change, 2);

        ChangeResults changeResults = (ChangeResults)getSupportFragmentManager().findFragmentByTag("CR");
        changeResults.setChange(change);

    }

    public void startTimer(){
        ChangeResults changeResults = (ChangeResults)getSupportFragmentManager().findFragmentByTag("CR");
        changeResults.newTimer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        ChangeActions changeActions = (ChangeActions)getSupportFragmentManager().findFragmentByTag("CA");
        switch(item.getItemId()){
            case R.id.zeroCount:

                changeActions.setTxtCount("0");
                count=0;
                return true;
            case R.id.changeMax:
                changeActions.setTxtMaxAmount(amount);
                showNoticeDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void reset(){
        ChangeResults changeResults = (ChangeResults)getSupportFragmentManager().findFragmentByTag("CR");
        ChangeButtons changeButtons = (ChangeButtons)getSupportFragmentManager().findFragmentByTag("CB");

        changeResults.setTotal(0.00);
        changeResults.stopTimer();
        changeResults.newTimer();
        changeResults.setChange(0.00);
        changeButtons.resetTotal();
        setChange();

    }

    public void addCount(){
        ChangeActions changeActions = (ChangeActions)getSupportFragmentManager().findFragmentByTag("CA");
        count++;
        changeActions.setTxtCount(count+"");
    }



    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }



    public void showNoticeDialog() {

        LayoutInflater inflater = LayoutInflater.from(this);
        final View textenter = inflater.inflate(R.layout.fragment_change_max, null);
        final EditText userinput = (EditText) textenter.findViewById(R.id.maxAmount);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(textenter)
                .setTitle("Set Max Change");
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int id) {
                if (userinput.getText().toString() == null || !userinput.getText().toString().matches("[0-9]+(\\.[0-9][0-9]?)?")) {
                    setAmount(100);
                }else {
                    //inputvalue =  userinput.getText().toString();
                    setAmount(Integer.parseInt(userinput.getText().toString()));
                }


            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                    }
                });
        AlertDialog dialog = builder.create();
        builder.show();
    }




}
