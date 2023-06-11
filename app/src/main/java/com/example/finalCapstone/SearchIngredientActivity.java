package com.example.finalCapstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchIngredientActivity extends AppCompatActivity {

    SearchView searchIngredients;
    ListView listView,selectedList;
    ArrayList list,myList;
    Button done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ingredient);

        searchIngredients = (SearchView) findViewById(R.id.searchIngredients);
        listView = (ListView) findViewById(R.id.listView);
        selectedList = (ListView) findViewById(R.id.selectedList);
        done = (Button) findViewById(R.id.done);
        myList = new ArrayList();
        list = new ArrayList();

        list.add("salt");
        list.add("onion");
        list.add("butter");
        list.add("garlic cleave");
        list.add("water");
        list.add("crab");
        list.add("chicken");
        list.add("olive oil");
        list.add("egg");
        list.add("sugar");
        list.add("tomato");
        list.add("black pepper");
        list.add("garlic");
        list.add("milk");
        list.add("pepper");
        list.add("salt pepper");
        list.add("flour");
        list.add("parsley");
        list.add("cinnamon");
        list.add("lemon juice");
        list.add("carrot");
        list.add("purpose flour");
        list.add("vegetable oil");
        list.add("cumin");
        list.add("cream");
        list.add("ginger");
        list.add("cilantro");
        list.add("parmesan cheese");
        list.add("soy sauce");
        list.add("beef");
        list.add("oregano");
        list.add("potato");
        list.add("green onion");
        list.add("brown sugar");
        list.add("oil");
        list.add("basil");
        list.add("chicken broth");
        list.add("lemon");
        list.add("lime juice");
        list.add("chicken breast");
        list.add("extra virgin olive oil");
        list.add("bake powder");
        list.add("mushroom");
        list.add("paprika");
        list.add("bay leaf");
        list.add("chili powder");
        list.add("garlic powder");
        list.add("thyme");
        list.add("celery");
        list.add("white sugar");
        list.add("red onion");
        list.add("cheddar cheese");
        list.add("cornstarch");
        list.add("nutmeg");
        list.add("cayenne pepper");
        list.add("red pepper flake");
        list.add("white wine");
        list.add("vanilla extract");
        list.add("honey");
        list.add("red bell pepper");
        list.add("tomato paste");
        list.add("coriander");
        list.add("salt black pepper");
        list.add("chicken");
        list.add("tomato sauce");
        list.add("mozzarella cheese");
        list.add("cleave");
        list.add("almond");
        list.add("bacon");
        list.add("worcestershire sauce");
        list.add("green bell pepper");
        list.add("red pepper");
        list.add("kosher salt");
        list.add("turmeric");
        list.add("cream cheese");
        list.add("rice");
        list.add("mayonnaise");
        list.add("heavy cream");
        list.add("egg yolk");
        list.add("shallot");
        list.add("bake soda");
        list.add("green pepper");
        list.add("vanilla");
        list.add("sesame oil");
        list.add("chicken stock");
        list.add("scallion");
        list.add("zucchini");
        list.add("spinach");
        list.add("salsa");
        list.add("shrimp");
        list.add("green chilies");
        list.add("canola oil");
        list.add("breadcrumb");
        list.add("sea salt");
        list.add("raisin");
        list.add("orange juice");
        list.add("red wine");
        list.add("cucumber");
        list.add("beef broth");
        list.add("jalapeno pepper");
        list.add("lime");
        list.add("black bean");
        list.add("coconut milk");
        list.add("yellow onion");
        list.add("egg white");
        list.add("curry powder");
        list.add("rosemary");
        list.add("avocado");
        list.add("feta cheese");
        list.add("flour tortilla");
        list.add("red wine vinegar");
        list.add("dijon mustard");
        list.add("black olive");
        list.add("mustard");
        list.add("coconut");
        list.add("walnut");
        list.add("mint");
        list.add("lemon zest");
        list.add("cheese");
        list.add("sesame seed");
        list.add("basil leaf");
        list.add("cumin seed");
        list.add("vinegar");
        list.add("corn");
        list.add("pork");
        list.add("fish sauce");
        list.add("allspice");
        list.add("white pepper");
        list.add("pea");
        list.add("chicken breast half");
        list.add("balsamic vinegar");
        list.add("margarine");
        list.add("monterey jack cheese");
        list.add("gingerroot");
        list.add("white vinegar");
        list.add("chive");
        list.add("onion powder");
        list.add("plain yogurt");
        list.add("ketchup");
        list.add("white onion");
        list.add("dill");
        list.add("italian season");
        list.add("orange");
        list.add("apple");
        list.add("jalapeno");
        list.add("corn tortilla");
        list.add("green bean");
        list.add("ricotta cheese");
        list.add("ham");
        list.add("cabbage");
        list.add("flat leaf parsley");
        list.add("eggplant");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
// listView.setAdapter(adapter);
        ArrayAdapter selectedAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,myList);
        // filtering items on search query
        searchIngredients.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                if(!s.isEmpty()) {
                    listView.setAdapter(adapter);
                }
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String selectedItem = (String) adapterView.getItemAtPosition(i);
                if(! AddedIngredients.myarray.contains(selectedItem)) {
                    AddedIngredients.myarray.add(new Model(R.drawable.burger,selectedItem));
                    myList.add(selectedItem);
                    Toast.makeText(SearchIngredientActivity.this, selectedItem+" added", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(SearchIngredientActivity.this, selectedItem+" already added", Toast.LENGTH_SHORT).show();
                }
                selectedList.setAdapter(selectedAdapter);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Dashboard.class);
                startActivity(i);

            }
        });
    }
}