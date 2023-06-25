package com.example.finalCapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.finalCapstone.APIClient.ClientAPI;

import java.util.ArrayList;

public class RecipieListActivity extends AppCompatActivity {
    TextView data;
    TextView data2;
    String url;
    ListView lv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipie_list);
        //data=findViewById(R.id.text_view);
        //data2=findViewById(R.id.textView2);
        lv=findViewById(R.id.resultlist);
//        ClientAPI.APICallback api2Callback = new ClientAPI.APICallback() {
//            @Override
//            public void afterGenerated(Activity activity, Bundle b, ClientAPI.UpdateCallback updateCallback) {
//                //ClientAPI.recipeInfo(activity,b,updateCallback,"None");
//            }
//        };

        ClientAPI.APICallback api1Callback = new ClientAPI.APICallback() {
            @Override
            public void afterGenerated(Activity activity, Bundle b, ClientAPI.UpdateCallback updateCallback) {
                //ClientAPI.recipeInfo(activity,b,updateCallback);
                ClientAPI.recipesByIngredient(activity,b,updateCallback);
            }
        };

        //String s1="";
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        ArrayList<String> s1_id = new ArrayList<>();
        ArrayList<String> s2_id = new ArrayList<>();
        //String s2="";
        ClientAPI.UpdateCallback updateCallback = new ClientAPI.UpdateCallback() {

            @Override
            public void onSuccess(Bundle result) {
                String s="";
                ArrayList<String> names = new ArrayList<String>();
                ArrayList<String> recipe_id = new ArrayList<String>();
                names = result.getStringArrayList("names");
                recipe_id = result.getStringArrayList("recipes");
                Log.i("names", "first: "+ names+" "+recipe_id);
                //String s[] = new String[100];
                //s=s + names.get(i);
                s1.addAll(names);
                s1_id.addAll(recipe_id);
                if(s2.size() == 0)
                {
                    s2.addAll(names);
                    s2_id.addAll(recipe_id);
                }
                else
                {
                    Log.i("names", "before: "+ names.get(1)+" "+s2.size()+" "+s1.size());
                    s2.retainAll(s1);
                    s2_id.retainAll(s1_id);
                    Log.i("names", "after: "+ names.get(1)+" "+s2.size()+" "+s1.size());
                }
                s1.clear();
                s1_id.clear();
// Set<String> set1 = new HashSet<String>(Arrays.asList(s));
// String[] r1 = set1.toArray(new String[set1.size()]);
                String temp="";
                for( int j =0;j<s2.size();j++)
                    temp=temp+s2.get(j)+"%";

                  String[] arr=temp.split("%");

                //Log.i("tarun", String.valueOf(s2_id.size()));
                  Intent suggestion = new Intent(getApplicationContext(),RecipeSuggestionActivity.class);
                  suggestion.putStringArrayListExtra("recipe_ids",s2_id);
                  startActivity(suggestion);

//                for(int i=0;i<arr.length;i++)
//                {
//                    Log.d("Varun",arr[i]);
//                }
//                ArrayAdapter<String> adapter= new ArrayAdapter<String>(RecipieListActivity.this, android.R.layout.simple_dropdown_item_1line ,arr);
//                lv.setAdapter(adapter);
//                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                        //Toast.makeText(RecipieListActivity.this,String.valueOf(id), Toast.LENGTH_SHORT).show();
//                        Intent i= new Intent(RecipieListActivity.this,RecipeDetailActivity.class);
//                        i.putExtra("id",s2_id.get(position));
//                        startActivity(i);
//
//
//                    }
//                });

                //data.setText(temp);
                Log.i("names", "final: ***"+names.get(1)+" "+s2.size()+" "+s1.size());
            }
        };
//        ClientAPI.UpdateCallback update2Callback = new ClientAPI.UpdateCallback() {
//            @Override
//            public void onSuccess(Bundle result) {
//                String ss="";
//// String x=result.getString("recipe_title");
//                //ss=ss+"recipe title: "+result.getString("0")+"\nsubregion: "+result.getString("1");
//                ss=ss+"recipe title: "+result.getString("0")+"\nsubregion: "+result.getString("1")+"\ntotal time: "+result.getString("2")+"\nservings:"+result.getString("3")+"\ncalories:"+result.getString("4")+"\nprocesses:"+result.getString("5")+"\nutensils:"+result.getString("6");
//                data2.setText(ss);
//                Log.i("recipeinfo", "before: "+ss);
//            }
//        };
        Bundle b =new Bundle();
        Bundle bt =new Bundle();
        ClientAPI.generateAccessToken(this, api1Callback,bt,updateCallback);
//        ClientAPI.generateAccessToken(this, api2Callback,b, update2Callback);
//
        //url="https://worldtimeapi.org/api/timezone/Asia/Kolkata";
// url="https://cosylab.iiitd.edu.in/api/recipeDB/recipeInfo/2610";
// JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
// @Override
// public void onResponse(JSONObject response) {
// String datetime= null;
// try {
// datetime = response.getString("prep_time");
// //String date=datetime.split("T")[0];
// data.setText(datetime);
// } catch (JSONException e) {
// throw new RuntimeException(e);
// }
// }
// }, new Response.ErrorListener() {
// @Override
// public void onErrorResponse(VolleyError error) {
//
// }
// });
// Volley.newRequestQueue(this).add(request);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}