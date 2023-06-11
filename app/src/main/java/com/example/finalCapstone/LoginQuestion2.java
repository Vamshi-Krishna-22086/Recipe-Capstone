package com.example.finalCapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

public class LoginQuestion2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list, selectedAllergens;

    SearchView searchAllergens;

    private Button next,prev;

    UserData data;

    ArrayList<String> allergensList, userAllergenList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_question2);
        next = (Button) findViewById(R.id.anext);

        prev = (Button) findViewById(R.id.aprev);

        // getting the UserData object from previous activity

        data = (UserData) getIntent().getSerializableExtra("UserData");



        list = (ListView) findViewById(R.id.allergensList);

        selectedAllergens = (ListView) findViewById(R.id.selectedAllergens);

        searchAllergens = (SearchView) findViewById(R.id.searchAllergens);



        // adding allergens to the ArrayList

        userAllergenList = new ArrayList<String>();

        allergensList = new ArrayList<String>();

        allergensList.add("Milk");

        allergensList.add("Eggs");

        allergensList.add("Peanuts");

        allergensList.add("Wheat");

        allergensList.add("Soybeans");

        allergensList.add("Sesame");

        allergensList.add("Shrimp");

        allergensList.add("Wheat");

        allergensList.add("Almonds");

        allergensList.add("Celery");

        allergensList.add("Mustard");

        allergensList.add("Apricot");

        allergensList.add("Fish");

        allergensList.add("Crustacean Shellfish");

        allergensList.add("Tree nuts");

        allergensList.add("Cereals containing gultens");

        allergensList.add("Cabbage");

        allergensList.add("Zucchini");

        allergensList.add("Cauliflower");

        allergensList.add("Chickpea");



        // defining adapters for the list views

        ArrayAdapter listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,allergensList);

        ArrayAdapter userListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,userAllergenList);



        // on entering some text in search view

        searchAllergens.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override

            public boolean onQueryTextSubmit(String s) {

                return false;

            }



            @Override

            public boolean onQueryTextChange(String s) {

                // this will filter the items according to the search text

                listAdapter.getFilter().filter(s);

                if(!s.isEmpty()) {

                    list.setAdapter(listAdapter);

                }

                return false;

            }

        });



        // when clicken on any item

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedItem = (String) adapterView.getItemAtPosition(i);

                if(! userAllergenList.contains(selectedItem))

                {

                    userAllergenList.add(selectedItem);

                    Toast.makeText(LoginQuestion2.this, selectedItem+" added", Toast.LENGTH_SHORT).show();

                }

                else

                {

                    Toast.makeText(LoginQuestion2.this, selectedItem+" already added", Toast.LENGTH_SHORT).show();

                }

                selectedAllergens.setAdapter(userListAdapter);

            }

        });



        next.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),LoginQuestion3.class);

                data.setAllergens(userAllergenList);

                i.putExtra("UserData", data);

                startActivity(i);

            }

        });



        prev.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent p = new Intent(getApplicationContext(),LoginQuestion.class);

                startActivity(p);

            }

        });


//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.ingredients, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

}