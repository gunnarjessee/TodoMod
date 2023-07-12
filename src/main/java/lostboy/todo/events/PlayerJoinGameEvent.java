package lostboy.todo.events;

import lostboy.todo.TodoListMod;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.client.MinecraftClient;

public class PlayerJoinGameEvent {

    public static void initialize() {
        ClientLifecycleEvents.CLIENT_STARTED.register(event -> {
            MinecraftClient.getInstance().getName();
        });
    }

}
