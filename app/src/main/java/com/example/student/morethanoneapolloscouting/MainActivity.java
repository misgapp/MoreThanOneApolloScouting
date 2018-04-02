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
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    Switch picture;
    Switch safeZone;
    TextView autonumusresult;
    TextView totalresult;
    TextView autonomousCubes;
    CheckBox opponentjewel;
    CheckBox alliancejewel;
    ToggleButton corner_wall;
    public int scoreByPicture = 0;
    public int scoreBySafe = 0;
    public int scoreByJewel = 0;
    public int scoreByAutoCubes = 0;
    public int scoreByFirstCube = 0;
    public double scoreByWall = 1;
    public boolean corner = true;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        autonumusresult = (TextView) findViewById(R.id.auto_result);
        autonomousCubes = (TextView) findViewById(R.id.autoCubes);
        picture = (Switch) findViewById(R.id.switch1Vofuria);
        safeZone = (Switch) findViewById(R.id.switch2SafeZone);
        Button addBtn = (Button) findViewById(R.id.addBtn);
        Button nextpage = (Button) findViewById(R.id.next_page);
        Button plus = (Button) findViewById(R.id.plusButtonCubes);
        Button minus = (Button) findViewById(R.id.minusButtonCubes);
        opponentjewel = (CheckBox) findViewById(R.id.OpponentJewelCheckbox);
        alliancejewel = (CheckBox) findViewById(R.id.allianceJewelCheckbox);
        corner_wall = (ToggleButton) findViewById(R.id.wall_corner);
        picture.setOnCheckedChangeListener(this);
        safeZone.setOnCheckedChangeListener(this);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (scoreByAutoCubes > 0) {
                    scoreByFirstCube = 15;
                }
                int autoCubes = Integer.parseInt(autonomousCubes.getText().toString());
                double autonumusResult = (((scoreByAutoCubes - 1) * 15 * scoreByWall) + scoreByPicture + scoreBySafe + scoreByJewel + scoreByFirstCube);
                autonumusresult.setText(autonumusResult + "");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreByAutoCubes += 1;
                if (scoreByAutoCubes > 24) {
                    scoreByAutoCubes = 24;
                }
                autonomousCubes.setText(scoreByAutoCubes + "");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreByAutoCubes -= 1;
                if (scoreByAutoCubes < 0) {
                    scoreByAutoCubes = 0;
                }
                autonomousCubes.setText(scoreByAutoCubes + "");
            }
        });

        corner_wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (corner_wall.isChecked()) {
                    scoreByWall = 1.5;
                    corner = false;
                } else {
                    scoreByWall = 1;
                    corner = true;
                }
            }
        });

        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (corner == true) {
                    Intent goToNextPageCorner = new Intent(MainActivity.this, FourthActivity.class);
                    startActivity(goToNextPageCorner);
              //  } else {
              //      Intent goToNextPageWall = new Intent(MainActivity.this, ThirdActivity.class);
              //      startActivity(goToNextPageWall);
              //  }
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (picture.isChecked() && scoreByAutoCubes == 0) {
            scoreByAutoCubes = 1;
            autonomousCubes.setText(scoreByAutoCubes + "");
            scoreByPicture = 30;
        } else if (picture.isChecked()) {
            scoreByPicture = 30;
        } else {
            scoreByPicture = 0;
        }

        if (safeZone.isChecked()) {
            scoreBySafe = 10;
        } else {
            scoreBySafe = 0;
        }
    }

    public void Checks(View v) {
        if (opponentjewel.isChecked()) {
            scoreByJewel = 30;
        }
        if (alliancejewel.isChecked()) {
            scoreByJewel = -30;
        }
        if (alliancejewel.isChecked() && opponentjewel.isChecked()) {
            scoreByJewel = 0;
        }
    }
}