package jvd.ir.motionlayout_playground2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.motion.widget.MotionLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Boolean isMotionLayoutWorking = false;
    private int step = 1;

    private Button btnNext;
    private MotionLayout motionLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        motionLayout = findViewById(R.id.constraintLayout);
        btnNext = findViewById(R.id.btn_next);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isMotionLayoutWorking){
                    switch (step){
                        case 1:
                            motionLayout.setTransition(R.id.tran_trip_second);
                            motionLayout.transitionToEnd();
                            break;
                        case 2:
                            motionLayout.setTransition(R.id.tran_trip_third);
                            motionLayout.transitionToEnd();
                            break;
                        case 3:
                            motionLayout.setTransition(R.id.tran_trip_fourth);
                            motionLayout.transitionToEnd();
                            break;
                        case 4:
                            motionLayout.setTransition(R.id.tran_trip_fifth);
                            motionLayout.transitionToEnd();
                        default:
                            Toast.makeText(MainActivity.this, "Finished Steps\n Recreating activity..", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        motionLayout.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {
                isMotionLayoutWorking = true;
                step++;
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {
                isMotionLayoutWorking = false;
                if (step==5){
                    startActivity(new Intent(MainActivity.this,MainActivity.class));
                    MainActivity.this.finish();
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {

            }
        });
    }
}