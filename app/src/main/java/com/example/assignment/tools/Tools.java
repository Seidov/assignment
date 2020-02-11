package com.example.assignment.tools;

import com.example.assignment.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Tools {

    public ArrayList<User> getUsersList() {
        Gson gson = new Gson();
        String json = "[{\"name\":\"user1@mail.com\",\"password\":\"123456\"},{\"name\":\"user2@mail.com\",\"password\":\"123456\"},{\"name\":\"user3@mail.com\",\"password\":\"123456\"}]";
        Type usersType = new TypeToken<ArrayList<User>>() {}.getType();
        ArrayList<User> users = gson.fromJson(json, usersType);

        return users;
    }
}
