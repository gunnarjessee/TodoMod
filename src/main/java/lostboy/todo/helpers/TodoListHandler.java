package lostboy.todo.helpers;

import java.util.ArrayList;
import java.util.List;

public class TodoListHandler {

    private List<String> list;

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

    public List<String> getList() {
        return list;
    }

    public void remove(int position) {
        list.remove(position);
    }

}
