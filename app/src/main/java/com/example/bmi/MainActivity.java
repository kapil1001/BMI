package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView tv_result;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et_weight);
        et2=(EditText)findViewById(R.id.et_height);
        tv_result=(TextView)findViewById(R.id.tv_result);
        btn=(Button)findViewById(R.id.button);


        btn.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if(validate()) {
                    bmi();
                }

            }
            
        });
    }

    private boolean validate()
    {
        boolean isValidated = true;
        String weight, height;
         weight = et1.getText().toString().trim();
         height = et2.getText().toString().trim();

        if(weight.isEmpty()){
            et1.setError("Weight field is empty");
            isValidated = false;
        }
        if(height.isEmpty()){
            et2.setError("height field is empty");
            isValidated = false;
        }

        return isValidated;

    }
    private void bmi(){
        float a, b, c;

        a = Float.parseFloat(et1.getText().toString());
        b = Float.parseFloat(et2.getText().toString());
        c =  a / (b * b);


        tv_result.setText("" + c);

        if (c < 18.5) {

            Toast.makeText(getApplicationContext(), "You are Underweight", Toast.LENGTH_SHORT).show();
        }
        if ((c >= 18.5) && (c <= 24.9)) {

            Toast.makeText(getApplicationContext(), "You are Healthy", Toast.LENGTH_SHORT).show();
        }
        if (c >= 24.9) {

            Toast.makeText(getApplicationContext(), "You are Overweight", Toast.LENGTH_SHORT).show();
        }
    }
}
