package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.Expression;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {
    private TextView textview1;
    private EditText displayEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview1=findViewById(R.id.previous_calculationTv);
        displayEt=findViewById(R.id.input_textView);


    }


    private void updateText(String stringtoadd) {


        String oldString=displayEt.getText().toString().trim();
        int CurserPosition=displayEt.getSelectionStart();

        String leftString=oldString.substring(0,CurserPosition);
        String rightString=oldString.substring(CurserPosition);
        displayEt.setText(String.format("%s%s%s",leftString, stringtoadd, rightString));

        displayEt.setSelection(CurserPosition+stringtoadd.length());
    }
    public void zerobtn(View view){

        updateText(getResources().getString(R.string.zero));

    }
    public void onebtn(View view){

        updateText(getResources().getString(R.string.one));

    }
    public void twobtn(View view){

        updateText(getResources().getString(R.string.two));

    }
    public void threebtn(View view){

        updateText(getResources().getString(R.string.three));

    }
    public void fourbtn(View view){

        updateText(getResources().getString(R.string.four));

    }
    public void fivebtn(View view){

        updateText(getResources().getString(R.string.five));

    }
    public void sixbtn(View view){

        updateText(getResources().getString(R.string.six));

    } public void sevenbtn(View view){

        updateText(getResources().getString(R.string.seven));

    } public void eightbtn(View view){

        updateText(getResources().getString(R.string.eight));

    } public void ninebtn(View view){

        updateText(getResources().getString(R.string.nine));

    }
    public void dotbtn(View view){

        updateText(getResources().getString(R.string.dot));

    }
    public void plusbtn(View view){

        updateText(getResources().getString(R.string.plus));

    }
    public void substractbtn(View view){

        updateText(getResources().getString(R.string.substract));

    }
    public void multiplybtn(View view){

        updateText(getResources().getString(R.string.multiply));

    }
    public void dividebtn(View view){

        updateText(getResources().getString(R.string.divide));

    }
    public void percentbtn(View view){

        updateText(getResources().getString(R.string.percent));

    }
    public void openParantha(View view){

        updateText(getResources().getString(R.string.open_parantha));

    }
    public void closeParantha(View view){

        updateText(getResources().getString(R.string.close_parantha));

    }
    public void sinbtn(View view){

        updateText("sin(");

    }
    public void cosbtn(View view){

        updateText("cos(");

    }
    public void tanbtn(View view){

        updateText("tan(");

    }
    public void arcsin(View view){

        updateText("arcsin(");

    }
    public void arccos(View view){

        updateText("arccos(");

    }

    public void arctan(View view){

        updateText("arctan(");

    }
    public void logbtn(View view){

        updateText("log10(");

    }

    public void lnbtn(View view){

        updateText("ln(");

    }
    public void squareroot(View view){

        updateText("sqrt(");

    }
    public void pibtn(View view){

        updateText("pi");

    }
    public void exponentbtn(View view){

        updateText("e");

    }
    public void absValue(View view){

        updateText("abs(");

    }
    public void primebtn(View view){

        updateText("ispr(");
    }
    public void factorial(View view){

        updateText("!");

    }
    public void xsquarey(View view){

        updateText("^(");

    }
public void equalbtn(View view) {
    String userExp = displayEt.getText().toString();
    textview1.setText(userExp);
    userExp = userExp.replaceAll(getResources().getString(R.string.divide), "/");

    Expression exp = new Expression(userExp);
    String result = String.valueOf(exp.calculate());
    if (result.contains("NaN")) {
        Animation shake = AnimationUtils.loadAnimation(this,R.anim.shake_animation);

        displayEt.setText("bad Expression");
        //displayEt.setTextColor(Color.RED);
        textview1.setText("");
        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                displayEt.setTextColor(Color.RED);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                displayEt.setTextColor(Color.WHITE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        displayEt.startAnimation(shake);


    } else {
        displayEt.setTextColor(Color.WHITE);
        displayEt.setText(result);
        displayEt.setSelection(result.length());
    }

}


    public void clearbtn(View view){
        if(displayEt!=null){
            displayEt.setText("");
            textview1.setText("");
        }

    }
    public void backspacebtn(View view){

        int currentpos=displayEt.getSelectionStart();
        int lenght=displayEt.getText().length();
        if(currentpos!=0&&lenght!=0){
            SpannableStringBuilder selection= (SpannableStringBuilder) displayEt.getText();
            selection.replace(currentpos-1,currentpos,"");
            displayEt.setText(selection);
            displayEt.setSelection(currentpos-1);
        }
    }
    private void shakeanimation(){
        Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.shake_animation);


    }

}