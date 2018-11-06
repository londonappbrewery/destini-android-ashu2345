package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView story;
    private Button topbutton;
    private Button downbutton;
    private int sceneID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        story = (TextView) findViewById(R.id.storyTextView);
        topbutton = (Button) findViewById(R.id.buttonTop);
        downbutton = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        topbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(sceneID == 1)
                {
                    story.setText(R.string.T3_Story);
                    topbutton.setText(R.string.T3_Ans1);
                    downbutton.setText(R.string.T3_Ans2);
                    sceneID = 3;
                }
                else if(sceneID == 2)
                {
                    story.setText(R.string.T3_Story);
                    topbutton.setText(R.string.T3_Ans1);
                    downbutton.setText(R.string.T3_Ans2);
                    sceneID = 3;
                }
                else if(sceneID == 3)
                {
                    story.setText(R.string.T6_End);
                    topbutton.setVisibility(View.GONE);
                    downbutton.setVisibility(View.GONE);
                    sceneID = 6;
                }

                if(sceneID == 6)
                {
                    endApp();
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        downbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sceneID == 1)
                {
                    story.setText(R.string.T2_Story);
                    topbutton.setText(R.string.T2_Ans1);
                    downbutton.setText(R.string.T2_Ans2);
                    sceneID = 2;
                }
                else if(sceneID == 2)
                {
                    story.setText(R.string.T4_End);
                    topbutton.setVisibility(View.GONE);
                    downbutton.setVisibility(View.GONE);
                    sceneID = 4;
                }
                else if(sceneID == 3)
                {
                    story.setText(R.string.T5_End);
                    topbutton.setVisibility(View.GONE);
                    downbutton.setVisibility(View.GONE);
                    sceneID = 5;
                }

                if(sceneID == 4 || sceneID == 5)
                {
                    endApp();
                }
            }
        });
    }
    private void endApp()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
        alert.setTitle("Story completed!");
        alert.setMessage("Your story is concluded");
        alert.setCancelable(false);
        alert.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onCreate(null);
            }
        });
        alert.setNegativeButton("Exit application", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
    }
}
