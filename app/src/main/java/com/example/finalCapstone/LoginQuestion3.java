package com.example.finalCapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginQuestion3 extends AppCompatActivity {
    UserData data;
    ArrayList<String> userCuisineList;
    CheckBox uk, us, spanishAndPortuguese, italian, thai, mexican, allCuisines,southEastAsian,southAmerican,scandinavian,
            restAfrica,northernAfrica,middleEastern,korean,japanese,irish,indianSubcontinent,greek,french,easternEuropean,
            deutschland,chineseAndMongolian,centralAmerican,caribbean,belgian,australian;
    Button cnext, cprev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_question3);
        // getting the 'UserData' class object from previous activity
        data = (UserData) getIntent().getSerializableExtra("UserData");
        uk = (CheckBox) findViewById(R.id.uk);
        us = (CheckBox) findViewById(R.id.us);
        spanishAndPortuguese = (CheckBox) findViewById(R.id.spanishAndPortuguese);
        italian = (CheckBox) findViewById(R.id.italian);
        thai = (CheckBox) findViewById(R.id.thai);
        mexican = (CheckBox) findViewById(R.id.mexican);
        allCuisines = (CheckBox) findViewById(R.id.all);
        southEastAsian = (CheckBox) findViewById(R.id.southEastAsian);
        southAmerican = (CheckBox) findViewById(R.id.southAmerican);
        scandinavian = (CheckBox) findViewById(R.id.scandinavian);
        restAfrica = (CheckBox) findViewById(R.id.restAfrica);
        northernAfrica = (CheckBox) findViewById(R.id.northernAfrica);
        middleEastern = (CheckBox) findViewById(R.id.middleEastern);
        korean = (CheckBox) findViewById(R.id.korean);
        japanese = (CheckBox) findViewById(R.id.japanese);
        irish = (CheckBox) findViewById(R.id.irish);

        indianSubcontinent = (CheckBox) findViewById(R.id.indianSubcontinent);
        greek = (CheckBox) findViewById(R.id.greek);
        french = (CheckBox) findViewById(R.id.french);
        easternEuropean = (CheckBox) findViewById(R.id.easternEuropean);
        deutschland = (CheckBox) findViewById(R.id.deutschland);
        chineseAndMongolian = (CheckBox) findViewById(R.id.chineseAndMongolian);
        centralAmerican = (CheckBox) findViewById(R.id.centralAmerican);
        caribbean = (CheckBox) findViewById(R.id.caribbean);
        belgian = (CheckBox) findViewById(R.id.belgian);
        australian = (CheckBox) findViewById(R.id.australian);

        allCuisines.setChecked(true);
        cnext = (Button) findViewById(R.id.cnext);
        cprev = (Button) findViewById(R.id.cprev);

        userCuisineList = new ArrayList<>();
        uk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (uk.isChecked()) {
                    userCuisineList.add("uk");
                    Toast.makeText(LoginQuestion3.this, "UK added", Toast.LENGTH_SHORT).show();
                } else {
                    userCuisineList.remove("uk");

                    Toast.makeText(LoginQuestion3.this, "UK removed", Toast.LENGTH_SHORT).show();

                }

            }

        });

        us.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if (us.isChecked()) {

                    userCuisineList.add("us");

                } else {

                    userCuisineList.remove("us");

                }

            }

        });


        spanishAndPortuguese.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if (spanishAndPortuguese.isChecked()) {

                    userCuisineList.add("spanish and Portuguese");

                } else {

                    userCuisineList.remove("spanish and Portuguese");

                }

            }

        });


        italian.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if (italian.isChecked()) {

                    userCuisineList.add("italian");

                } else {

                    userCuisineList.remove("italian");

                }

            }

        });

        thai.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if (thai.isChecked()) {

                    userCuisineList.add("thai");

                } else {

                    userCuisineList.remove("thai");

                }

            }

        });


        mexican.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if (mexican.isChecked()) {

                    userCuisineList.add("mexican");

                } else {

                    userCuisineList.remove("mexican");

                }

            }

        });

        allCuisines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allCuisines.isChecked()) {
                    userCuisineList.add("all cuisines");
                } else {
                    userCuisineList.remove("all cuisines");
                }
            }
        });

        southEastAsian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (southEastAsian.isChecked()) {
                    userCuisineList.add("southEast Asian");
                } else {
                    userCuisineList.remove("southEast Asian");
                }
            }
        });
        southAmerican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (southAmerican.isChecked()) {
                    userCuisineList.add("South American");
                } else {
                    userCuisineList.remove("South American");
                }
            }
        });
        scandinavian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (scandinavian.isChecked()) {
                    userCuisineList.add("scandinavian");
                } else {
                    userCuisineList.remove("scandinavian");
                }
            }
        });

        restAfrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (restAfrica.isChecked()) {
                    userCuisineList.add("rest Africa");
                } else {
                    userCuisineList.remove("rest Africa");
                }
            }
        });
        northernAfrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (northernAfrica.isChecked()) {
                    userCuisineList.add("northern Africa");
                } else {
                    userCuisineList.remove("northern Africa");
                }
            }
        });
        middleEastern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (scandinavian.isChecked()) {
                    userCuisineList.add("middle Eastern");
                } else {
                    userCuisineList.remove("middle Eastern");
                }
            }
        });
        korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (korean.isChecked()) {
                    userCuisineList.add("korean");
                } else {
                    userCuisineList.remove("korean");
                }
            }
        });
        japanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (japanese.isChecked()) {
                    userCuisineList.add("japanese");
                } else {
                    userCuisineList.remove("japanese");
                }
            }
        });
        irish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (irish.isChecked()) {
                    userCuisineList.add("irish");
                } else {
                    userCuisineList.remove("irish");
                }
            }
        });

        indianSubcontinent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indianSubcontinent.isChecked()) {
                    userCuisineList.add("indian Subcontinent");
                } else {
                    userCuisineList.remove("indian Subcontinent");
                }
            }
        });
        greek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (greek.isChecked()) {
                    userCuisineList.add("greek");
                } else {
                    userCuisineList.remove("greek");
                }
            }
        });
        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (french.isChecked()) {
                    userCuisineList.add("french");
                } else {
                    userCuisineList.remove("french");
                }
            }
        });
        easternEuropean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (easternEuropean.isChecked()) {
                    userCuisineList.add("eastern European");
                } else {
                    userCuisineList.remove("eastern European");
                }
            }
        });

        deutschland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (deutschland.isChecked()) {
                    userCuisineList.add("deutschland");
                } else {
                    userCuisineList.remove("deutschland");
                }
            }
        });
        chineseAndMongolian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chineseAndMongolian.isChecked()) {
                    userCuisineList.add("chinese And Mongolian");
                } else {
                    userCuisineList.remove("chinese And Mongolian");
                }
            }
        });
        centralAmerican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (centralAmerican.isChecked()) {
                    userCuisineList.add("central American");
                } else {
                    userCuisineList.remove("central American");
                }
            }
        });
        caribbean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (caribbean.isChecked()) {
                    userCuisineList.add("caribbean");
                } else {
                    userCuisineList.remove("caribbean");
                }
            }
        });
        belgian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (belgian.isChecked()) {
                    userCuisineList.add("belgian");
                } else {
                    userCuisineList.remove("belgian");
                }
            }
        });

        australian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (australian.isChecked()) {
                    userCuisineList.add("australian");
                } else {
                    userCuisineList.remove("australian");
                }
            }
        });


        // on clicking the next button

        cnext.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Log.i("Cuisines list", "onClick: " + userCuisineList);

                Intent n = new Intent(getApplicationContext(), Dashboard.class);

                data.setCuisines(userCuisineList);

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