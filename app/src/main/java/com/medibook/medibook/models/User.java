package com.medibook.medibook.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kevin on 6/18/2016.
 */

public class User {
    private String first_name, last_name, gender, address, birthday, email, password, healthcard;
    private Integer id;

    public User(String first_name, String last_name, Integer id, String gender, String address, String birthday, String email, String password, String healthcard){
        this.first_name = first_name;
        this.last_name = last_name;
        this.id = id;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.healthcard = healthcard;
    }

    public String getName(){
        return this.first_name + " " + this.last_name;
    }

    public String getGender(){
        switch(this.gender){
            case "M":
                return "Male";
            case "F":
                return "Female";
            default:
                return "Unknown";
        }
    }

    public String getAddress(){
        return this.address;
    }

    public String getBirthday(){
        return this.birthday;
    }

    public String getEmail(){
        return this.email;
    }

    public String getHealthcard(){
        return this.healthcard;
    }

    public String toJson(){
        JSONObject user = new JSONObject();
        try{
            user.put("F_NAME", this.first_name);
            user.put("L_NAME", this.last_name);
            user.put("ADDRESS", this.address);
            user.put("BIRTHDAY", this.birthday);
            user.put("EMAIL", this.email);
            user.put("PASSWORD", this.password);
            user.put("GENDER", this.gender);
            user.put("HEALTHCARD_NUM", this.healthcard);
        } catch (JSONException e){
            e.printStackTrace();
        }

        return user.toString();

    }

}
