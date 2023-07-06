package lostboy.todo.helpers;

import lostboy.todo.guis.TodoGUI;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import javax.swing.text.JTextComponent;

public class KeyBindHelper {

    public static void InitKeyBindings() {
        KeyBinding keyBinding;
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
           "",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                ""
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (keyBinding.isPressed()) {
                MinecraftClient.getInstance().setScreen(new TodoGUI());
            }
        });

    }

}
