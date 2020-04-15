package com.example.currencyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String[] array1 = {"Dollar", "Euro", "VND", "Yen", "Bath"};
    String[] array2 = { "VND", "Yen", "Bath", "Dollar","Euro"};
    Spinner spinner1, spinner2;
    String res1, res2;
    TextView textView1, textView2;
    Button btnCE, btnC, btnBS, btn7, btn8, btn9, btn4, btn5, btn6, btn1, btn2, btn3, btn0, btnFloat;
    boolean isSelected1, isSelected2;
    int state; // store state to calculate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        textView1 = findViewById(R.id.text_view1);
        textView2 = findViewById(R.id.text_view2);
        btn0 = findViewById(R.id.n0);
        btn1 = findViewById(R.id.n1);
        btn2 = findViewById(R.id.n2);
        btn3 = findViewById(R.id.n3);
        btn4 = findViewById(R.id.n4);
        btn5 = findViewById(R.id.n5);
        btn6 = findViewById(R.id.n6);
        btn7 = findViewById(R.id.n7);
        btn8 = findViewById(R.id.n8);
        btn9 = findViewById(R.id.n9);
        btnFloat = findViewById(R.id.float_point);
        btnCE = findViewById(R.id.CE);
        btnBS = findViewById(R.id.clear);
        isSelected1 = false;
        isSelected2 = false;

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, array1);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, array2);
        spinner1.setAdapter(arrayAdapter1);
        spinner2.setAdapter(arrayAdapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        res1 = spinner1.getSelectedItem().toString();

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                res2 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        res2 = spinner2.getSelectedItem().toString();

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnBS.setOnClickListener(this);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("");
                isSelected1 = true;
                isSelected2 = false;
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText("");
                isSelected2 = true;
                isSelected1 = false;
            }
        });


        if(res1.equals(res2)) {
            state = 1;
        } else if(res1.equals("Dollar") && res2.equals("Euro")) {
            state = 2;
        } else if(res1.equals("Dollar") && res2.equals("VND")) {
            state = 3;
        } else if(res1.equals("Dollar") && res2.equals("Yen")) {
            state = 4;
        } else if(res1.equals("Dollar") && res2.equals("Baht")) {
            state = 5;
        }

    }



    @Override
    public void onClick(View v) {


        int id = v.getId();
        if (v.getId() == btnCE.getId()) {
            textView1.setText("0");
            textView2.setText("0");
        }
        if(isSelected1) {
            if (id == btn0.getId()) {
                textView1.setText(textView1.getText() + "0");
            }

            if (id == btn1.getId()) {
                textView1.setText(textView1.getText() + "1");
            }

            if (id == btn2.getId()) {
                textView1.setText(textView1.getText() + "2");
            }

            if (id == btn3.getId()) {
                textView1.setText(textView1.getText() + "3");
            }

            if (id == btn4.getId()) {
                textView1.setText(textView1.getText() + "4");
            }

            if (id == btn5.getId()) {
                textView1.setText(textView1.getText() + "5");
            }

            if (id == btn6.getId()) {
                textView1.setText(textView1.getText() + "6");
            }

            if (id == btn7.getId()) {
                textView1.setText(textView1.getText() + "7");
            }

            if (id == btn8.getId()) {
                textView1.setText(textView1.getText() + "8");
            }

            if (id == btn9.getId()) {
                textView1.setText(textView1.getText() + "9");
            }

            if (id == btnBS.getId()) {
                if (textView1.getText().length() <= 1) {
                    textView1.setText(null);
                } else if (textView1.getText().length() > 1) {
                    String text = textView1.getText().toString();
                    textView1.setText(text.substring(0, text.length() - 1));
                }
            }

            if(id == btnFloat.getId()) {
                textView1.setText(textView1.getText() + ".");
            }

            Double temp1 = Double.parseDouble(textView1.getText().toString());

            if(state == 1) {
                textView2.setText(textView1.getText());
            } else if(state == 2) {
                temp1 *= 0.911;
                textView2.setText(temp1 + "");
            } else if(state == 3) {
                temp1 *= 23000.44;
                textView2.setText(temp1 + "");
            } else if(state == 4) {
                temp1 *= 107.08;
                textView2.setText(temp1 + "");
            } else if(state == 5) {
                temp1 *= 32.54;
                textView2.setText(temp1 + "");
            }

        } else if(isSelected2) {

            if (id == btn0.getId()) {
                textView2.setText(textView2.getText() + "0");
            }

            if (id == btn1.getId()) {
                textView2.setText(textView2.getText() + "1");
            }

            if (id == btn2.getId()) {
                textView2.setText(textView2.getText() + "2");
            }

            if (id == btn3.getId()) {
                textView2.setText(textView2.getText() + "3");
            }

            if (id == btn4.getId()) {
                textView2.setText(textView2.getText() + "4");
            }

            if (id == btn5.getId()) {
                textView2.setText(textView2.getText() + "5");
            }

            if (id == btn6.getId()) {
                textView2.setText(textView2.getText() + "6");
            }

            if (id == btn7.getId()) {
                textView2.setText(textView2.getText() + "7");
            }

            if (id == btn8.getId()) {
                textView2.setText(textView2.getText() + "8");
            }

            if (id == btn9.getId()) {
                textView2.setText(textView2.getText() + "9");
            }

            if(id == btnFloat.getId()) {
                textView2.setText(textView2.getText() + ".");
            }

            if (id == btnBS.getId()) {
                if (textView2.getText().length() <= 1) {
                    textView2.setText(null);
                } else if (textView2.getText().length() > 1) {
                    String text = textView2.getText().toString();
                    textView2.setText(text.substring(0, text.length() - 1));
                }
            }

            Double temp2 = Double.parseDouble(textView2.getText().toString());

            if(state == 1) {
                textView1.setText(textView2.getText());
            } else if(state == 2) {
                temp2 /= 0.911;
                textView1.setText(temp2 + "");
            } else if(state == 3) {
                temp2 /= 23.44;
                textView1.setText(temp2 + "");
            } else if(state == 4) {
                temp2 /= 107.08;
                textView1.setText(temp2 + "");
            } else if(state == 5) {
                temp2 /= 32.54;
                textView1.setText(temp2 + "");
            }
        }
    }

}
