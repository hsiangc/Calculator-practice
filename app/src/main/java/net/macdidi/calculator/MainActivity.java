package net.macdidi.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnp, btnm, btnx, btnd, btnpt, btne, btnc;
    private TextView display; //運算顯示
    public double finalNum, newNum;
    public String stringNum = "0"; //輸入的文字
    public char opt;//按鈕選擇紀錄
    public boolean optonce;//防止重複

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initKeyboard();
    }

    private void initKeyboard() {

        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btnp = (Button) findViewById(R.id.buttonp);
        btnm = (Button) findViewById(R.id.buttonm);
        btnx = (Button) findViewById(R.id.buttonx);
        btnd = (Button) findViewById(R.id.buttond);
        btnpt = (Button) findViewById(R.id.buttonpt);
        btne = (Button) findViewById(R.id.buttone);
        btnc = (Button) findViewById(R.id.buttonc);
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

    public void back(View view){


    }


    public void clickEqual(View view) {

        newNum = Double.parseDouble(stringNum);
        stringNum = "0";
        calculate();
        opt = 'e';


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

