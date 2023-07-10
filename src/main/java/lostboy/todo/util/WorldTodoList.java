package lostboy.todo.util;

import java.util.ArrayList;

// Created as a template for the GSON data
// This class will be unused until later
public class WorldTodoList {

    public ArrayList<String> listData = new ArrayList<>();
    public String worldName;

    public WorldTodoList(String worldName, ArrayList<String> listData) {
        this.worldName = worldName;
        this.listData = listData;
    }

}
