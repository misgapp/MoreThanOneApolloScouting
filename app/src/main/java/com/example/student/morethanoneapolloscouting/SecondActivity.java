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

public class SecondActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Switch cypher_corner;
    TextView teleopresult_corner;
    TextView teleOpCubes_corner;
    TextView lines_corner;
    TextView columns_corner;
    Button calculate_corner;
    Button previouspage_corner;
    Button plusCubes_corner;
    Button minusCubes_corner;
    Button plusLines_corner;
    Button minusLines_corner;
    Button plusColumns_corner;
    Button minusColumns_corner;
    Button nextpage_corner;
    int cubes = 0;
    int teleOpLines = 0;
    int teleOpColumns = 0;
    int scoreByCypher = 0;
    private static final String Ascore = "autonumos_score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // the problem requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final MainActivity activity_one = new MainActivity();

        teleopresult_corner = (TextView) findViewById(R.id.teleop_resultCorner);
        teleOpCubes_corner = (TextView) findViewById(R.id.teleOpCubesNumCorner);
        lines_corner = (TextView) findViewById(R.id.linesNumTextViewCorner);
        columns_corner = (TextView) findViewById(R.id.columnsTextViewCorner);
        cypher_corner = (Switch) findViewById(R.id.cypherSwitchCorner);
        calculate_corner = (Button) findViewById(R.id.calculateTeleopCorner);
        previouspage_corner = (Button) findViewById(R.id.previous_pageCorner);
        plusCubes_corner = (Button) findViewById(R.id.plusButtonCorner);
        minusCubes_corner = (Button) findViewById(R.id.minusButtonCubesCorner);
        plusLines_corner = (Button) findViewById(R.id.plusButtonCubesCorner);
        minusLines_corner = (Button) findViewById(R.id.minusButtonLinesCubesCorner);
        plusColumns_corner = (Button) findViewById(R.id.plusButtonColumnsCubesCorner);
        minusColumns_corner = (Button) findViewById(R.id.minusButtonColumnsCorner);
        nextpage_corner = (Button) findViewById(R.id.next_pageCorner);

        cypher_corner.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        calculate_corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int teleOpResult = (teleOpLines * 10) + (cubes * 2) + (teleOpColumns * 20) + scoreByCypher;
                teleopresult_corner.setText(teleOpResult + "");
            }
        });

        plusCubes_corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cubes += 1;
                if (cubes > 12) {
                    cubes = 12;
                }
                teleOpCubes_corner.setText(cubes + "");
            }
        });

        minusCubes_corner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                cubes -= 1;
                if (cubes < 0) {
                    cubes = 0;
                }
                teleOpCubes_corner.setText(cubes + "");
            }
        });

        plusLines_corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teleOpLines += 1;
                if (teleOpLines > 4) {
                    teleOpLines = 4;
                }
                lines_corner.setText(teleOpLines + "");
            }
        });

        minusLines_corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teleOpLines -= 1;
                if (teleOpLines < 0) {
                    teleOpLines = 0;
                }
                lines_corner.setText(teleOpLines + "");
            }
        });

        plusColumns_corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teleOpColumns += 1;
                if (teleOpColumns > 3) {
                    teleOpColumns = 3;
                }
                columns_corner.setText(teleOpColumns + "");
            }
        });

        minusColumns_corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teleOpColumns -= 1;
                if (teleOpColumns < 0) {
                    teleOpColumns = 0;
                }
                columns_corner.setText(teleOpColumns + "");
            }
        });

        nextpage_corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activity_one.corner == true) {
                    Intent goToNextPageCorenr = new Intent(SecondActivity.this, ThirdActivity.class);
                    startActivity(goToNextPageCorenr);
                } else {
                    Intent goToNextPageWall = new Intent(SecondActivity.this, FourthActivity.class);
                    startActivity(goToNextPageWall);
                }
            }
        });

        previouspage_corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activity_one.corner == true) {
                    Intent goToPreviousPage = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(goToPreviousPage);
                } else {
                   Intent goToPreviousPage = new Intent(SecondActivity.this, ThirdActivity.class);
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (cypher_corner.isChecked()) {
            scoreByCypher = 30;
        } else {
            scoreByCypher = 0;
        }
    }
}