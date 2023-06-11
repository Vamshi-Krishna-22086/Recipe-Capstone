package com.example.finalCapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class LoginQuestion3 extends AppCompatActivity {
    UserData data;
    ArrayList<String> userPreferredCuisineList;
    Chip uk, us, spanishAndPortuguese, italian, thai, mexican, allCuisines,southEastAsian,southAmerican,scandinavian,
            restAfrica,northernAfrica,middleEastern,korean,japanese,irish,indianSubcontinent,greek,french,easternEuropean,
            deutschland,chineseAndMongolian,centralAmerican,caribbean,belgian,australian,canadian;
    Button cnext, cprev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_question3);
        // Buttons
        cprev = findViewById(R.id.cprev);
        cnext = findViewById(R.id.cnext);
        // Asia chip group
        chineseAndMongolian = findViewById(R.id.chip_chinese);
        indianSubcontinent = findViewById(R.id.chip_india);
        japanese = findViewById(R.id.chip_japan);
        korean = findViewById(R.id.chip_korea);
        middleEastern = findViewById(R.id.chip_middle_east);
        southEastAsian = findViewById(R.id.chip_south_east_asia);
        thai = findViewById(R.id.chip_thai);

        // Europe chip group
        belgian = findViewById(R.id.chip_belgian);
        deutschland = findViewById(R.id.chip_deutschland);
        easternEuropean = findViewById(R.id.chip_east_europe);
        french = findViewById(R.id.chip_french);
        greek = findViewById(R.id.chip_greek);
        irish = findViewById(R.id.chip_irish);
        italian = findViewById(R.id.chip_italy);
        scandinavian = findViewById(R.id.chip_scandinavia);
        spanishAndPortuguese = findViewById(R.id.chip_span_portugal);
        uk = findViewById(R.id.chip_uk);

        // North America chip group
        canadian = findViewById(R.id.chip_canada);
        caribbean = findViewById(R.id.chip_caribbean);
        centralAmerican = findViewById(R.id.chip_central_america);
        mexican = findViewById(R.id.chip_mexico);
        us = findViewById(R.id.chip_us);

        //Africa chip group
        northernAfrica = findViewById(R.id.chip_north_africa);
        restAfrica = findViewById(R.id.chip_rest_africa);

        // Australia chip group
        australian = findViewById(R.id.chip_australia);

        //South America chip group
        southAmerican = findViewById(R.id.chip_south_america);

        // Initializing the arrayList
        userPreferredCuisineList = new ArrayList<>();

        // TODO : The names added to the 'userPreferredCuisineList' have to be make in sync with that of APIs.
        // For now I have added meaning full names.


        // Asia onClickListeners
        // chinese and mongolian
        chineseAndMongolian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chineseAndMongolian.isChecked())
                {
                    //String s = "Chinese and Mongolian";
                    userPreferredCuisineList.add("Chinese and Mongolian");
                }
                else {
                    userPreferredCuisineList.remove("Chinese and Mongolian");
                }
            }
        });

        // indian subcontinent
        indianSubcontinent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indianSubcontinent.isChecked())
                {
                    userPreferredCuisineList.add("Indian Subcontinent");
                }
                else {
                    userPreferredCuisineList.remove("Indian Subcontinent");
                }
            }
        });

        // Japanese
        japanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(japanese.isChecked())
                {
                    userPreferredCuisineList.add("Japanese");
                }
                else {
                    userPreferredCuisineList.remove("Japanese");
                }
            }
        });

        // Korean
        korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(korean.isChecked())
                {
                    userPreferredCuisineList.add("Korean");
                }
                else {
                    userPreferredCuisineList.remove("Korean");
                }
            }
        });

        // Middle East
        middleEastern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(middleEastern.isChecked())
                {
                    userPreferredCuisineList.add("Middle East");
                }
                else {
                    userPreferredCuisineList.remove("Middle East");
                }
            }
        });

        // South East Asia
        southEastAsian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(southEastAsian.isChecked())
                {
                    userPreferredCuisineList.add("South East Asia");
                }
                else {
                    userPreferredCuisineList.remove("South East Asia");
                }
            }
        });

        // Thai
        thai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(thai.isChecked())
                {
                    userPreferredCuisineList.add("Thai");
                }
                else {
                    userPreferredCuisineList.remove("Thai");
                }
            }
        });

        // Europe onClickListeners
        // Belgian
        belgian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(belgian.isChecked())
                {
                    userPreferredCuisineList.add("Belgian");
                }
                else {
                    userPreferredCuisineList.remove("Belgian");
                }
            }
        });

        // Deutschland
        deutschland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(deutschland.isChecked())
                {
                    userPreferredCuisineList.add("Deutschland");
                }
                else {
                    userPreferredCuisineList.remove("Deutschland");
                }
            }
        });

        // East Europe
        easternEuropean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(easternEuropean.isChecked())
                {
                    userPreferredCuisineList.add("East Europe");
                }
                else {
                    userPreferredCuisineList.remove("East Europe");
                }
            }
        });

        // French
        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(french.isChecked())
                {
                    userPreferredCuisineList.add("Frech");
                }
                else {
                    userPreferredCuisineList.remove("French");
                }
            }
        });

        // Greek
        greek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(greek.isChecked())
                {
                    userPreferredCuisineList.add("Greek");
                }
                else {
                    userPreferredCuisineList.remove("Greek");
                }
            }
        });

        // Irish
        irish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(irish.isChecked())
                {
                    userPreferredCuisineList.add("Irish");
                }
                else {
                    userPreferredCuisineList.remove("Irish");
                }
            }
        });

        // Italian
        italian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(italian.isChecked())
                {
                    userPreferredCuisineList.add("Italian");
                }
                else {
                    userPreferredCuisineList.remove("Italian");
                }
            }
        });

        // Scandinavian
        scandinavian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(scandinavian.isChecked())
                {
                    userPreferredCuisineList.add("Scandinavia");
                }
                else {
                    userPreferredCuisineList.remove("Scandinavia");
                }
            }
        });

        // Spanish And Portuguese
        spanishAndPortuguese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spanishAndPortuguese.isChecked())
                {
                    userPreferredCuisineList.add("Spanish and Portuguese");
                }
                else {
                    userPreferredCuisineList.remove("Spanish and Portuguese");
                }
            }
        });

        // UK
        uk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uk.isChecked())
                {
                    userPreferredCuisineList.add("UK");
                }
                else {
                    userPreferredCuisineList.remove("UK");
                }
            }
        });

        // North America onClickListeners
        // Canadian
        canadian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(canadian.isChecked())
                {
                    userPreferredCuisineList.add("Canadian");
                }
                else {
                    userPreferredCuisineList.remove("Canadian");
                }
            }
        });

        // Caribbean
        caribbean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(caribbean.isChecked())
                {
                    userPreferredCuisineList.add("Caribbean");
                }
                else {
                    userPreferredCuisineList.remove("Caribbean");
                }
            }
        });

        // Central America
        centralAmerican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(centralAmerican.isChecked())
                {
                    userPreferredCuisineList.add("Central America");
                }
                else {
                    userPreferredCuisineList.remove("Central America");
                }
            }
        });

        // Mexican
        mexican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mexican.isChecked())
                {
                    userPreferredCuisineList.add("Mexican");
                }
                else {
                    userPreferredCuisineList.remove("Mexican");
                }
            }
        });

        // US
        us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(us.isChecked())
                {
                    userPreferredCuisineList.add("US");
                }
                else {
                    userPreferredCuisineList.remove("US");
                }
            }
        });

        // Africa onClickListeners
        // North Africa
        northernAfrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(northernAfrica.isChecked())
                {
                    userPreferredCuisineList.add("North Africa");
                }
                else {
                    userPreferredCuisineList.remove("North Africa");
                }
            }
        });

        // Australia onClickListeners
        // Australian
        australian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(australian.isChecked())
                {
                    userPreferredCuisineList.add("Australian");
                }
                else {
                    userPreferredCuisineList.remove("Australian");
                }
            }
        });

        // South America onClickListeners
        // South American
        southAmerican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(southAmerican.isChecked())
                {
                    userPreferredCuisineList.add("South American");
                }
                else {
                    userPreferredCuisineList.remove("South American");
                }
            }
        });


        // on clicking the next button

        cnext.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Log.i("Cuisines list", "onClick: " + userPreferredCuisineList);

                Intent n = new Intent(getApplicationContext(), Dashboard.class);

                data.setCuisines(userPreferredCuisineList);

                startActivity(n);

            }

        });


        // on clicking the prev button

        cprev.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent p = new Intent(getApplicationContext(), LoginQuestion2.class);

                startActivity(p);

            }

        });

    }
//    public void onChecked(View view)
//    {
//        Toast.makeText(this, "Item Selected", Toast.LENGTH_SHORT).show();
//        Button b=findViewById(R.id.cnext);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(),Dashboard.class);
//                startActivity(i);
//
//            }
//        });
//    }
//}
}