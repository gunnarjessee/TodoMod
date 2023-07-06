package lostboy.todo.guis;

import lostboy.todo.guis.widgets.TaskWidget;
import lostboy.todo.helpers.TodoListHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ScrollableWidget;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.ScoreTextContent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.http.client.utils.Idn;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

@Environment(EnvType.CLIENT)
public class TodoGUI extends Screen {

    private Text msg;
    private ButtonWidget buttonWidget;
    private ScrollableWidget scroll;
    public TodoGUI() {
        super(Text.literal("My GUI"));
        this.passEvents = false;
        this.width = 200;
        this.height = 200;

    }

    @Override
    protected void init() {

    }

    private int pointer = 0;

    // Needs to scroll in the future
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
        TodoListHandler.getInstance().getList().forEach(str -> {
            int yOffset = pointer * 22;
            TaskWidget widget = new TaskWidget((width / 2) + 10, 10 + yOffset, 20, 20, str);
            widget.render(matrices, mouseX, mouseY, delta);
            textRenderer.draw(matrices, Text.literal(str), (width / 2) - 60, 10 + yOffset, 0x00BBFF);
            pointer++;
        });
        pointer = 0;
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
