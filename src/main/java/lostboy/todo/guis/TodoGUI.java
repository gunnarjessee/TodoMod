package lostboy.todo.guis;

import lostboy.todo.TodoListMod;
import lostboy.todo.guis.widgets.TaskWidget;
import lostboy.todo.helpers.TodoListHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.MultilineText;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ScrollableWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
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

    private ScrollableWidget scroll;
    public TodoGUI() {
        super(Text.literal("My GUI"));
        this.passEvents = false;
        this.width = 200;
        this.height = 200;
    }

    private TextFieldWidget textFieldWidget;
    private ButtonWidget submitButton;
    @Override
    protected void init() {
            textFieldWidget = new TextFieldWidget(textRenderer, 10, 10, 100, 16, Text.literal(""));
            submitButton = new ButtonWidget(10, 30, 50, 20, Text.literal("ADD"), button -> {
                TodoListHandler.getInstance().add(textFieldWidget.getText());
                textFieldWidget.setText("");
                draw();
            });
            draw();
    }
    private int pointer = 0;
    private void draw() {
        clearChildren();
        addDrawableChild(submitButton);
        addDrawableChild(textFieldWidget);
        TodoListHandler.getInstance().getList().forEach(str -> {
            int yOffset = pointer * 20;
            addDrawableChild(new TaskWidget(width - 20, 10 + yOffset, 16, 20, str));
            pointer++;
        });
        pointer = 0;
    }

    // Needs to scroll in the future
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
    }



    @Override
    public boolean shouldPause() {
        return false;
    }
}
