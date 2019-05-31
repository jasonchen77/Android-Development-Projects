package com.example.basicwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Button button1;
    TextView button1tv;
    CheckBox checkBox;
    TextView checkBoxtv;
    Switch swithch1;
    TextView switchtv;
    RadioButton rb1, rb2, rb3;
    TextView radiotv;
    SeekBar seekBar;
    TextView seekBartv;
    EditText editText;
    TextView editTexttv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button1tv = (TextView) findViewById(R.id.textViewButton1);
        checkBox = (CheckBox) findViewById(R.id.checkBox1);
        checkBoxtv = (TextView) findViewById(R.id.textViewCheckBox);
        swithch1 = (Switch) findViewById(R.id.switch1);
        switchtv = (TextView) findViewById(R.id.textViewSwitch);
        radiotv = (TextView) findViewById(R.id.textViewRadio);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked()){
                    checkBoxtv.setText("Checked");
                }
                else {
                    checkBoxtv.setText("Unchecked");
                }
            }
        });

        if (swithch1 != null){
            swithch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    switchtv.setText(isChecked ? "This switch is: on" : "This switch is: off");
                }
            });
        }

        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        if (rb1 != null){
            rb1.setOnCheckedChangeListener(this);
        }
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        if (rb2 != null){
            rb2.setOnCheckedChangeListener(this);
        }
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        if (rb3 != null){
            rb3.setOnCheckedChangeListener(this);
        }

        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        seekBartv = (TextView) findViewById(R.id.textViewSeekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBartv.setText(String.valueOf(progress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        editText = (EditText) findViewById(R.id.editText1);
        editTexttv = (TextView) findViewById(R.id.textViewEditText);

    }

    public void button1Pressed(View view){
        button1tv.setText("Button 1 is pressed");
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.radioButton1:
                if (isChecked) {
                    radiotv.setText("Radio 1 is Selected");
                }
                break;
            case R.id.radioButton2:
                if (isChecked) {
                    radiotv.setText("Radio 2 is Selected");
                }
                break;
            case R.id.radioButton3:
                if (isChecked) {
                    radiotv.setText("Radio 3 is Selected");
                }
                break;
        }

    }

    public void buttonUpdatePressed (View view){
        editTexttv.setText(editText.getText());
    }
}
