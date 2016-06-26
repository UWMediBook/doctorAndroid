package com.medibook.medibook.common;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.medibook.medibook.R;
import com.medibook.medibook.models.Allergy;
import com.medibook.medibook.models.Doctor;
import com.medibook.medibook.models.Prescription;
import com.medibook.medibook.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kevin on 6/19/2016.
 */
public class API {
    private RequestQueue queue;
    private View rootView;

    public API(Context context){
        // Instantiate the RequestQueue.
        this.queue = Volley.newRequestQueue(context);
        this.rootView = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);
    }

    public void getUser(Integer id) {
        String url = "http://52.41.78.184:8000/api/main/" + id;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonUser = new JSONObject(response);
                            User user = new User(
                                    jsonUser.getString("F_NAME"),
                                    jsonUser.getString("L_NAME"),
                                    jsonUser.getInt("USER_ID"),
                                    jsonUser.getString("GENDER"),
                                    jsonUser.getString("ADDRESS"),
                                    jsonUser.getString("BIRTHDAY"),
                                    jsonUser.getString("EMAIL"),
                                    jsonUser.getString("PASSWORD"),
                                    jsonUser.getString("HEALTHCARD_NUM")
                            );
                            TextView userName = (TextView) rootView.findViewById(R.id.user_name);
                            TextView userGender = (TextView) rootView.findViewById(R.id.user_gender);
                            TextView userBirthday = (TextView) rootView.findViewById(R.id.user_birthday);
                            TextView userHealthcard = (TextView) rootView.findViewById(R.id.user_healthcard);
                            userName.setText("Name: " + user.getName());
                            userGender.setText("Gender: " + user.getGender());
                            userBirthday.setText("Birthday: " + user.getBirthday());
                            userHealthcard.setText("Healthcard Number: " + user.getHealthcard());

                        } catch(JSONException j){
                            Log.e("JSON Conversion", "Failed to convert JSON to User");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Get User API", "That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        this.queue.add(stringRequest);
    }


    public void getAllergiesByUser(Integer user_id) {
        String url = "http://52.41.78.184:8000/api/allergies/?user_id=" + user_id;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            //TODO: complete the assignment
                            JSONArray jsonAllergies = new JSONArray(response);
                            Allergy allergy = new Allergy(1, "", 1);

                        } catch(JSONException j){
                            Log.e("JSON Conversion", "Failed to convert allergy to JSON");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Get Allergy API", "That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        this.queue.add(stringRequest);
    }

    public void getDoctor(Integer doctor_id) {
        String url = "http://52.41.78.184:8000/api/primarydoctor/" + doctor_id;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            //TODO: complete this
                            JSONObject jsonDoctor = new JSONObject(response);
                            Doctor doctor = new Doctor();

                        } catch(JSONException j){
                            Log.e("JSON Conversion", "Failed to convert allergy to JSON");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Get Allergy API", "That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        this.queue.add(stringRequest);
    }

    public void getPrescriptionsByUser(Integer user_id) {
        String url = "http://52.41.78.184:8000/api/prescriptions/?user_id=" + user_id;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            //TODO: complete this
                            JSONArray jsonPrescriptions = new JSONArray(response);
                            Prescription prescription = new Prescription();

                        } catch(JSONException j){
                            Log.e("JSON Conversion", "Failed to convert allergy to JSON");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Get Allergy API", "That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        this.queue.add(stringRequest);
    }

}
