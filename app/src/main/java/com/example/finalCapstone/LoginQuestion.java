package com.example.finalCapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.progressindicator.LinearProgressIndicator;

public class LoginQuestion extends AppCompatActivity {

    private Button next;
    RadioGroup dietRadioGroup;
    RadioButton radioButton;
    RadioButton veg,vegan,ovoVeg,nonVeg,eatall;
    String diet;
    UserData data = new UserData();
    LinearProgressIndicator progressIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_question);
        Intent i1= getIntent();
        next = (Button) findViewById(R.id.dietNextButton);
        dietRadioGroup = (RadioGroup) findViewById(R.id.dietRadioGroup);

        veg = (RadioButton) findViewById(R.id.radioVegetarian);
        vegan = (RadioButton) findViewById(R.id.radioVegean);
        ovoVeg = (RadioButton) findViewById(R.id.radioOvoVegetarian);
        nonVeg = (RadioButton) findViewById(R.id.radioNonVegetarian);
        eatall = (RadioButton) findViewById(R.id.radioEverything);
        progressIndicator = findViewById(R.id.question_1_Progress);
        int max = progressIndicator.getMax();
        int fill = max/3;
        progressIndicator.setProgressCompat(fill,true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(),LoginQuestion2.class);

                // store the diet value in 'UserData' class
                diet = getDiet();
//                diet = (String) radioButton.getText();
                data.setDiet(diet);
//                Toast.makeText(LoginQuestion.this, diet, Toast.LENGTH_SHORT).show();
                i2.putExtra("UserData", data);
                startActivity(i2);
            }
        });
    }

//    public void checkButton(View view)
//    {
//        int radioId = dietRadioGroup.getCheckedRadioButtonId();
//        radioButton = (RadioButton) findViewById(radioId);
//    }
    String getDiet()
    {
        if(veg.isChecked())
            return "Vegetarian";
        else if(vegan.isChecked())
            return "Vegan";
        else if(ovoVeg.isChecked())
            return "Ovo-Vegetarian";
        else if(nonVeg.isChecked())
            return "Non-Vegetarian";
        else
            return "eat-everything";
    }
}