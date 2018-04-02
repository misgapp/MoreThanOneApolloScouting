package com.example.student.morethanoneapolloscouting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Switch cypher_wall;
    TextView teleopresult_wall;
    TextView teleOpCubes_wall;
    TextView lines_wall;
    TextView columns_wall;
    int cubes = 0;
    int teleOpLines = 0;
    int teleOpColumns = 0;
    int scoreByCypher = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        // the problem requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final MainActivity activity_one = new MainActivity();

        teleopresult_wall = (TextView) findViewById(R.id.teleop_resultWall);
        teleOpCubes_wall = (TextView) findViewById(R.id.teleOpCubesNumWall);
        lines_wall = (TextView) findViewById(R.id.linesNumTextViewWall);
        columns_wall = (TextView) findViewById(R.id.columnsNumTextviewWall);
        cypher_wall = (Switch) findViewById(R.id.cypherSwitchWall);
        Button calculate_wall = (Button) findViewById(R.id.calculateTeleopWall);
        Button previouspage_wall = (Button) findViewById(R.id.previous_pageWall);
        Button plusCubes_wall = (Button) findViewById(R.id.plusButtonCubes);
        Button minusCubes_wall = (Button) findViewById(R.id.minusButtonCubesWall);
        Button plusLines_wall = (Button) findViewById(R.id.plusButtonLinesWall);
        Button minusLines_wall = (Button) findViewById(R.id.minusButtonLinesWall);
        Button plusColumns_wall = (Button) findViewById(R.id.plusButtonColumnsWall);
        Button minusColumns_wall = (Button) findViewById(R.id.minusButtonColumnsWall);
        Button nextpage_wall = (Button) findViewById(R.id.next_pageWall);

        cypher_wall.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);

        calculate_wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double teleOpResult = ((teleOpLines * 10) + (cubes * 2) + (teleOpColumns * 20) + scoreByCypher) * 1.25;
                teleopresult_wall.setText(teleOpResult + "");
            }
        });


        plusCubes_wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cubes += 1;
                if (cubes > 24) {
                    cubes = 24;
                }
                teleOpCubes_wall.setText(cubes + "");
            }
        });

        minusCubes_wall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                cubes -= 1;
                if (cubes < 0) {
                    cubes = 0;
                }
                teleOpCubes_wall.setText(cubes + "");
            }
        });

        plusLines_wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teleOpLines += 1;
                if (teleOpLines > 8) {
                    teleOpLines = 8;
                }
                lines_wall.setText(teleOpLines + "");
            }
        });

        minusLines_wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teleOpLines -= 1;
                if (teleOpLines < 0) {
                    teleOpLines = 0;
                }
                lines_wall.setText(teleOpLines + "");
            }
        });

        plusColumns_wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teleOpColumns += 1;
                if (teleOpColumns > 6) {
                    teleOpColumns = 6;
                }
                columns_wall.setText(teleOpColumns + "");
            }
        });

        minusColumns_wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teleOpColumns -= 1;
                if (teleOpColumns < 0) {
                    teleOpColumns = 0;
                }
                columns_wall.setText(teleOpColumns + "");
            }
        });

        nextpage_wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activity_one.corner == true) {
                    Intent goToNextPageCorner = new Intent(ThirdActivity.this, SecondActivity.class);
                    startActivity(goToNextPageCorner);
                }else {
                    Intent goToNextPageWall = new Intent(ThirdActivity.this, FourthActivity.class);
                    startActivity(goToNextPageWall);
                }
            }
        });

        previouspage_wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activity_one.corner == true) {
                    Intent goToPreviousPage = new Intent(ThirdActivity.this, MainActivity.class);
                    startActivity(goToPreviousPage);
                } else {
                    Intent goToPreviousPage = new Intent(ThirdActivity.this, SecondActivity.class);
                    startActivity(goToPreviousPage);
                }
            }
        });
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (cypher_wall.isChecked()) {
            scoreByCypher = 30;
        } else {
            scoreByCypher = 0;
        }
    }
}


