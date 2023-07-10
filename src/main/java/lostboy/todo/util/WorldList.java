package lostboy.todo.util;

import java.lang.reflect.Array;
import java.util.ArrayList;

// This class will be used in the future
public class WorldList {

    public ArrayList<WorldTodoList> worlds = new ArrayList<WorldTodoList>();

    public WorldList(ArrayList<WorldTodoList> worlds) {
        this.worlds = worlds;
    }

    public WorldList(WorldTodoList worldData) {
        worlds.add(worldData);
    }

}
