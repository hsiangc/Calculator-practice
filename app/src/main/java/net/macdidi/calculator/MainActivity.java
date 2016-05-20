package net.macdidi.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView display; //運算顯示
    public double finalNum, newNum;
    public String stringNum = "0"; //輸入的文字
    public String temp = "0";//倒退鍵暫存
    public char opt;//按鈕選擇紀錄
    public boolean optonce;//防止重複

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.calculate);
    }



    public void clickNum(View view) {

        if (opt == 'e') {
            display.setText("");
            opt = ' ';
        }
        optonce=true;

        //顯示你輸入了什麼
        display.setText(display.getText().toString() + ((Button) view).getText());
        //把輸入的數字存起來
        stringNum = (stringNum + ((Button) view).getText());

    }


    public void clickPlus(View view) {

        if(optonce!=false) {
            newNum = Double.parseDouble(stringNum);
            stringNum = "0";
            calculate();
            opt = 'p';
            display.setText(display.getText().toString() + "" + "+" + "");
            optonce = false;
        }

    }

    public void clickMinus(View view) {

        if(optonce!=false) {

            newNum = Double.parseDouble(stringNum);
            stringNum = "0";
            calculate();
            opt = 'm';
            display.setText(display.getText().toString() + "" + "-" + "");
            optonce = false;
        }

    }

    public void clickMulti(View view) {

        if(optonce!=false) {
            newNum = Double.parseDouble(stringNum);
            stringNum = "0";
            calculate();
            opt = 'x';
            display.setText(display.getText().toString() + "" + "x" + "");
            optonce = false;
        }
    }

    public void clickDivide(View view) {

        if(optonce!=false) {
            newNum = Double.parseDouble(stringNum);
            stringNum = "0";
            calculate();
            opt = 'd';
            display.setText(display.getText().toString() + "" + "÷" + "");
            optonce = false;
        }
    }

    public void clickClear(View view) {

        display.setText("");
        stringNum = "0";
        finalNum = 0;
        newNum = 0;
    }

    public void clickBack(View view){

            temp = display.getText().toString();
            display.setText(temp.substring(0, temp.length() - 1));
            stringNum = stringNum.substring(0, stringNum.length() - 1);
    }


    public void clickEqual(View view) {

        newNum = Double.parseDouble(stringNum);
        stringNum = "0";
        calculate();
        opt = 'e';


    }

    public void clickMap(View view){

        Log.d("clickMap", "test google");

        startActivity(new Intent(this, MapsActivity.class));

    }

    public void clickWebMap(View view){


        startActivity(new Intent(this, WebMapActivity.class));

    }

    public void calculate() {

        switch (opt) {

            case 'p':
                finalNum = finalNum + newNum;

                display.setText(String.valueOf(finalNum));
                newNum = 0;
                break;

            case 'm':
                finalNum = finalNum - newNum;

                display.setText(String.valueOf(finalNum));
                newNum = 0;
                break;

            case 'x':
                finalNum = finalNum * newNum;

                display.setText(String.valueOf(finalNum));
                newNum = 0;
                break;

            case 'd':
                finalNum = finalNum / newNum;

                display.setText(String.valueOf(finalNum));
                newNum = 0;
                break;

            case 'e':
                break;

            default:
                finalNum = newNum;
                break;

        }

    }
}

