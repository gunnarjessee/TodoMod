package lostboy.todo;

import lostboy.todo.events.PlayerJoinGameEvent;
import lostboy.todo.helpers.JsonHelper;
import lostboy.todo.helpers.KeyBindHelper;
import lostboy.todo.helpers.TodoListHandler;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TodoListMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "todolist";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		KeyBindHelper.InitKeyBindings();
		PlayerJoinGameEvent.initialize();
		TodoListHandler.getInstance().initialize();
		JsonHelper.getInstance().initialize();
		// loads json data when game starts, this will be moved to a world by world basis in the future
		JsonHelper.getInstance().loadData();
		LOGGER.info("Hello Fabric world!");
	}

}