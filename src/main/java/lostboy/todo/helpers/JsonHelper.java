package lostboy.todo.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lostboy.todo.TodoListMod;
import lostboy.todo.util.ClientList;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/*
    Gunnar Jessee
    Is a singleton object
    loads a json from a file

 */

public class JsonHelper {


    private final Path PATH = FabricLoader.getInstance().getConfigDir().getParent().resolve("tasks.json");
    private Gson gson;
    private static JsonHelper instance;

    public static JsonHelper getInstance() {
        if (instance == null) {
            instance = new JsonHelper();
            instance.initialize();
        }
        return instance;
    }

    public void initialize() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void saveData(){
        ClientList clientData = new ClientList(TodoListHandler.getInstance().getList());
        try (BufferedWriter writer = Files.newBufferedWriter(PATH)) {
            gson.toJson(clientData, writer);
        } catch (Exception e) {
            TodoListMod.LOGGER.warn("A problem has occurred while saving task data to json file.");
            throw new RuntimeException();
        }
     }

    public void loadData() {
        if (Files.exists(PATH)) {
            try (BufferedReader reader = Files.newBufferedReader(PATH)) {
                ClientList clientData = gson.fromJson(reader, ClientList.class);
                TodoListHandler.getInstance().setList(clientData.tasks);
            } catch (Exception e) {
                TodoListMod.LOGGER.warn("Tasks could not loaded from the file.");
                throw new RuntimeException(e);
            }
        }    }

}