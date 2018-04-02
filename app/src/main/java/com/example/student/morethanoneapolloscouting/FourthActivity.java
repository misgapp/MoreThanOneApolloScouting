package com.example.student.morethanoneapolloscouting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


    Switch balance;
    Switch rs2;
    Switch rs1;
    CheckBox first_relic_one;
    CheckBox second_relic_one;
    CheckBox first_relic_two;
    CheckBox second_relic_two;
    CheckBox first_relic_three;
    CheckBox second_relic_three;
    TextView score;
    int scoreByBalance = 0;
    int scoreByRelicFirst = 0;
    int scoreByRelicSecond = 0;
    int scoreByRelic1Stending = 0;
    int scoreByRelic2Stending = 0;
    boolean relic1scored = false;
    boolean relic2scored = false;
    boolean firstRelicOne = false;
    boolean firstRelicTwo = false;
    boolean firstRelicThree = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fourth);
        final MainActivity activity_one = new MainActivity();

        balance = (Switch) findViewById(R.id.balancing);
        rs2 = (Switch) findViewById(R.id.rs2);
        rs1 = (Switch) findViewById(R.id.rs1);
        score = (TextView) findViewById(R.id.end_game);
        Button calculate = (Button) findViewById(R.id.calculate);
        Button prePsge = (Button) findViewById(R.id.previousPage);
        first_relic_one = (CheckBox) findViewById(R.id.first_relic_one);
        second_relic_one = (CheckBox) findViewById(R.id.second_relic_one);
        first_relic_two = (CheckBox) findViewById(R.id.fisrt_relic_two);
        second_relic_two = (CheckBox) findViewById(R.id.second_relic_two);
        first_relic_three = (CheckBox) findViewById(R.id.first_relic_three);
        second_relic_three = (CheckBox) findViewById(R.id.second_relic_three);
        balance.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        rs1.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        rs2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = scoreByBalance + scoreByRelicFirst + scoreByRelicSecond + scoreByRelic1Stending + scoreByRelic2Stending;
                score.setText(result + "");
                scoreByRelicFirst = 0;
                scoreByRelicSecond = 0;
                scoreByBalance = 0;
            }
        });
        prePsge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activity_one.corner == true) {
                    Intent goToPreviousPage = new Intent(FourthActivity.this, ThirdActivity.class);
                    startActivity(goToPreviousPage);
                } else {
                    Intent goToPreviousPage = new Intent(FourthActivity.this, SecondActivity.class);
                    startActivity(goToPreviousPage);
                }
            }
        });
    }

    public void isisnotszpiler(View view) {
        if (first_relic_one.isChecked()) {
            scoreByRelicFirst = 10;
            relic1scored = true;
            first_relic_two.setChecked(false);
            first_relic_three.setChecked(false);
        }
        if (first_relic_two.isChecked()) {
            scoreByRelicFirst = 20;
            relic1scored = true;
            first_relic_one.setChecked(false);
            first_relic_three.setChecked(false);
        }
        if (first_relic_three.isChecked()) {
            scoreByRelicFirst = 40;
            relic1scored = true;
            first_relic_one.setChecked(false);
            first_relic_two.setChecked(false);
        }

        if (second_relic_one.isChecked()) {
            scoreByRelicSecond = 10;
            relic2scored = true;
            second_relic_two.setChecked(false);
            second_relic_three.setChecked(false);
        }
        if (second_relic_two.isChecked()) {
            scoreByRelicSecond = 20;
            relic2scored = true;
            second_relic_one.setChecked(false);
            second_relic_three.setChecked(false);
        }
        if (second_relic_three.isChecked()) {
            scoreByRelicSecond = 40;
            relic2scored = true;
            second_relic_one.setChecked(false);
            second_relic_two.setChecked(false);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (balance.isChecked()) {
            scoreByBalance = 20;
        } else {
            scoreByBalance = 0;
        }
        if (relic2scored == true) {
            if (rs2.isChecked()) {
                scoreByRelic2Stending = 15;
            }
        }
        if (relic1scored == true) {
            if (rs1.isChecked()) {
                scoreByRelic1Stending = 15;
            }
        }
    }
}

