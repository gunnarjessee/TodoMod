package lostboy.todo.helpers;

import java.util.ArrayList;
import java.util.List;

public class TodoListHandler {

    private ArrayList<String> list;

    private static TodoListHandler instance;

    public static TodoListHandler getInstance() {
        if (instance == null) {
            instance = new TodoListHandler();
        }
        return instance;
    }
    public void initialize() {

        list = new ArrayList<String>();
    }

    public void add(String str) {
        list.add(str);
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> listData) {
        this.list = listData;
    }

    public void remove(String position) {
        list.remove(position);
    }



}
