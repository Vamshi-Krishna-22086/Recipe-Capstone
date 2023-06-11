package com.example.finalCapstone.APIClient;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalCapstone.AddedIngredients;
import com.example.finalCapstone.BuildConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientAPI {
    private static String access_token;
    public static void recipeOfDay(Activity activity, Bundle b, UpdateCallback updateCallback) {
        //String url="https://cosylab.iiitd.edu.in/api/recipeDB/recipeoftheday";
        String url = BuildConfig.RECIPE_A_DAY; // contains the URL
        RequestQueue queue = Volley.newRequestQueue(activity); // To manage network requests
        
        StringRequest request = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() { // Creates a new object. The first parameter specifies the HTTP method for a request, second is the URL while the third is used to handle the response
            @Override
            public void onResponse(String response) { // this function is called when a response is received
                try {
                    Log.d("Response",response.toString()); // to print the response received on the console
                    JSONObject a = new JSONObject(response); // to parse the response string as a JSON object
                    JSONObject respObj = (JSONObject) a;
                    Log.d("Response",respObj.toString()); // to print the JSONObject 'respObj on the console
                    Bundle b =new Bundle();
                    b.putString("0",respObj.get("recipe_title").toString()); // retrieves the value associated with the corresponding key "recipe-title" from the respObj, converts it to string and stores in the Bundle b with the key "0". 
                    b.putString("1",respObj.get("sub_region").toString());
                    b.putString("2",respObj.get("total_time").toString());
                    b.putString("3",respObj.get("servings").toString());
                    b.putString("4",respObj.get("calories").toString());
                    b.putString("5",respObj.get("processes").toString());
                    b.putString("6",respObj.getString("utensils"));
                    b.putString("7",respObj.get("img_url").toString());
                    b.putString("8",respObj.get("recipe_id").toString());
                    updateCallback.onSuccess(b); // to invoke the onSuccess method and pass the Bundle b as an argument
                } catch (Exception e) {
                    e.printStackTrace(); // helps to identify and debug issues
                }
            }

        }, new com.android.volley.Response.ErrorListener() { // to override onErrorResponse in case of an error during the network request
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(activity, "Fail to get response = " + error, Toast.LENGTH_SHORT).show(); // to let the user know that an error has occurred along with it's details
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError { // to add custom headers to requests
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer "+access_token);
                params.put("Accept-Language", "fr");
                return params;
            }
        };
        queue.add(request); // manages network requests
    }
    public static void recipeInfo(Activity activity, Bundle b, UpdateCallback updateCallback,String url2) {
        //String url="https://cosylab.iiitd.edu.in/api/recipeDB/recipeInfo/"+url2;
        String s = BuildConfig.RECIPE_INFO; // contains the URL
        String url = s+url2; // adding the recipeid to the URL
        String sr = BuildConfig.CONSUMER_SECRET;
        //String s = BuildConfig.
        Toast.makeText(activity, url2, Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(activity);  // To manage network requests
        StringRequest request = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() { // Creates a new object. The first parameter specifies the HTTP method for a request, second is the URL while the third is used to handle the response

            @Override
            public void onResponse(String response) {
                try {
                    Log.d("Response",response.toString()); // to print the response received on the console
                    JSONObject a = new JSONObject(response); // to parse the response string as a JSON object
                    JSONObject respObj = (JSONObject) a;
                    Log.d("Response",respObj.toString());  // to print the JSONObject 'respObj on the console
                    Bundle b =new Bundle();
                    b.putString("0",respObj.get("recipe_title").toString());  // retrieves the value associated with the corresponding key "recipe-title" from the respObj, converts it to string and stores in the Bundle b with the key "0". 
                    b.putString("1",respObj.get("sub_region").toString());
                    b.putString("2",respObj.get("total_time").toString());
                    b.putString("3",respObj.get("servings").toString());
                    b.putString("4",respObj.get("calories").toString());
                    b.putString("5",respObj.get("processes").toString());
                    b.putString("6",respObj.getString("utensils"));
                    b.putString("7",respObj.get("img_url").toString());
                    updateCallback.onSuccess(b);  // to invoke the onSuccess method and pass the Bundle b as an argument
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() { // to override onErrorResponse in case of an error during the network request

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(activity, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();  // to let the user know that an error has occurred along with it's details
            }
        }){

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {  // to add custom headers to requests
                Map<String, String> params = new HashMap<String, String>(); // creates a Hash map to store key value pairs
                params.put("Authorization", "Bearer "+access_token);
                params.put("Accept-Language", "fr");
                return params;
            }

        };

        queue.add(request); // manages network requests
    }


    public static void recipesByIngredient(Activity activity, Bundle b, UpdateCallback updateCallback) {
        //String url = "https://cosylab.iiitd.edu.in/api/recipeDB/searchingredientinrecipes/"+b.getString("ingredient","");
        String ing[]=new String[AddedIngredients.myarray.size()];

        // accessing the ingredients added by user
        for(int i=0;i<AddedIngredients.myarray.size();i++) // as there might be a multiple of ingrdients selected by user so adding that to an array 
        {
            ing[i]=AddedIngredients.myarray.get(i).name;
        }
        for (int va=0;va<ing.length;va++){
            //String url = "https://cosylab.iiitd.edu.in/api/recipeDB/searchingredientinrecipes/"+ing[va];
            String s = BuildConfig.RECIPE_BY_INGREDIENT; // contains the URL
            String url = s + ing[va]; // Adding a single ingredient to the URL
            RequestQueue queue = Volley.newRequestQueue(activity);
            StringRequest request = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() { // Creates a new object. The first parameter specifies the HTTP method for a request, second is the URL while the third is used to handle the response
                @Override
                public void onResponse(String response) {
                    try {
                        ArrayList<String> ids = new ArrayList<>(); // creating Array Lists
                        ArrayList<String> names = new ArrayList<>();
                        JSONArray respObj = new JSONArray(response);
                        JSONObject resp = new JSONObject(respObj.get(0).toString()); // taking the 0th from respObj and storing it as a String
                        for(int i=0;i<respObj.length();i++){
                            JSONObject r = new JSONObject(respObj.get(i).toString());
                            if(r.getString("ingredient").equals(b.getString("ingredient", ""))){
                                resp=r;
                                break;
                            }

                        }
                        Log.d("array",resp.get("recipes").toString());
                        JSONArray recipes = (JSONArray) resp.get("recipes");  // retrieves the value associated with the corresponding key "recipes" 
                        for(int i=0;i<recipes.length();i++){
                            JSONObject r = new JSONObject(recipes.get(i).toString());
                            ids.add(r.get("recipe_id").toString());
                            names.add(r.get("recipe_title").toString());
                        }
                        Bundle b =new Bundle();
                        b.putStringArrayList("recipes", ids);
                        b.putStringArrayList("names", names);
                        updateCallback.onSuccess(b);  // to invoke the onSuccess method and pass the Bundle b as an argument
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, new com.android.volley.Response.ErrorListener() { // to override onErrorResponse in case of an error during the network request

                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(activity, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();  // to let the user know that an error has occurred along with it's details
                }

            }){

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {  // to add custom headers to requests
                    Map<String, String> params = new HashMap<String, String>(); //creating a hashMap for storing key value pairs
                    params.put("Authorization", "Bearer "+access_token);
                    params.put("Accept-Language", "fr");
                    return params;
                }
            };
            queue.add(request);} // manages network requests
    }

    public static void generateAccessToken(Activity activity, APICallback callback,Bundle b,UpdateCallback updateCallback) { // for generating access token through an API call
      
        ArrayList<String> passed_params = new ArrayList<>(); //creating ArrayList
        ApplicationInfo ai = null;
        try {
            ai = activity.getPackageManager()
                    .getApplicationInfo(activity.getPackageName(), PackageManager.GET_META_DATA);
            String value = ai.metaData.getString("key"); // retrieves the metadata value at key "key"

        } catch (PackageManager.NameNotFoundException e) { //to catch any exception
            e.printStackTrace();
        }
        passed_params.add("app-ims");
        passed_params.add("password");
        String userName = BuildConfig.CONSUMER_KEY;
        String password = BuildConfig.CONSUMER_SECRET;
//        passed_params.add("gimmearecipe");
        passed_params.add(userName);
        passed_params.add(password);
        Log.i("TAG", "generateAccessToken: " + userName);
//        passed_params.add("getrecipe");
        //String url = "https://cosylab.iiitd.edu.in/api/auth/realms/bootadmin/protocol/openid-connect/token";
        String url = BuildConfig.TOKEN_GENERATOR;
        RequestQueue queue = Volley.newRequestQueue(activity); // for managing network requests
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject respObj = new JSONObject(response); // to print the response received on the console
                    access_token = respObj.getString("access_token");
                    callback.afterGenerated(activity,b,updateCallback);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {  // to override onErrorResponse in case of an error during the network request

            @Override
            public void onErrorResponse(VolleyError error) {
                
                Toast.makeText(activity, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();  // to let the user know that an error has occurred along with it's details
            }

        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parameters = new HashMap<String, String>(); // creating a hasmap to store key value pairs
                parameters.put("client_id", passed_params.get(0)); // adds a parameter with key client_id and the value from pass_params.get(0)
                parameters.put("grant_type", passed_params.get(1));
                parameters.put("username", passed_params.get(2));
                parameters.put("password", passed_params.get(3));
                return parameters;
            }
        };
        queue.add(request); // manages network requests
    }

    public static void recipeInstructions(Activity activity, Bundle b, UpdateCallback updateCallback, String url2) {
        String url="https://cosylab.iiitd.edu.in/api/instructions/"+url2;
        RequestQueue queue = Volley.newRequestQueue(activity); 
        StringRequest request = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.d("Response1",response.toString()); // to print the response received on the console
                    //Toast.makeText(activity, response.toString(), Toast.LENGTH_SHORT).show();
                    Bundle b =new Bundle();
                    b.putString("0", response.toString());  // retrieves the values from the response, converts it to string and stores in the Bundle b with the key "0". 
                    updateCallback.onSuccess(b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() { // to override onErrorResponse in case of an error during the network request
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(activity, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();  // to let the user know that an error has occurred along with it's details
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>(); // Creates a hashMap to store key value pairs
                params.put("Authorization", "Bearer "+access_token);
                params.put("Accept-Language", "fr");
                return params;
            }
        };
        queue.add(request); // manages network requests
    }



    public static interface APICallback { // interafce for handling API responses and pass on the data
        void afterGenerated(Activity activity, Bundle b,UpdateCallback updateCallback);
    }

    public static interface UpdateCallback { //interface for handling update operations
        void onSuccess(Bundle result);
    }
}


