package lostboy.todo.guis;

import lostboy.todo.helpers.TodoListHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

@Environment(EnvType.CLIENT)
public class TodoGUI extends Screen {
    private Text msg;
    public TodoGUI() {
        super(Text.literal("My GUI"));
        this.passEvents = false;
        this.width = 200;
        this.height = 200;

    }

    private int pointer = 0;
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        TodoListHandler.getInstance().getList().forEach(str -> {
            drawCenteredText(matrices, textRenderer, Text.literal(str), width/2, height/2 + (pointer * 10), 0xFFFFFF);
            pointer++;
        });
        pointer = 0;
    }
}
