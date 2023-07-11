package lostboy.todo.guis;

import lostboy.todo.TodoListMod;
import lostboy.todo.guis.widgets.StringWidget;
import lostboy.todo.helpers.JsonHelper;
import lostboy.todo.helpers.TodoListHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.MultilineText;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ScrollableWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.MutableText;
import net.minecraft.text.ScoreTextContent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.http.client.utils.Idn;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class TodoGUI extends Screen {

    private ScrollableWidget scroll;
    public TodoGUI() {
        super(Text.literal("My GUI"));
        this.width = 200;
        this.height = 200;
    }

    private TextFieldWidget textFieldWidget;
    private ButtonWidget submitButton;
    @Override
    protected void init() {
            textFieldWidget = new TextFieldWidget(textRenderer, 10, 10, 100, 16, Text.literal(""));
            submitButton = new ButtonWidget.Builder(Text.literal("ADD"), button -> {
                TodoListHandler.getInstance().add(textFieldWidget.getText());
                JsonHelper.getInstance().saveData();
                textFieldWidget.setText("");
                draw();
            }).dimensions(10, 30, 50, 20).build();
            draw();

    }
    private int pointer = 0;
    private void draw() {
        clearChildren();
        addDrawable(new StringWidget(width/2 - 20, 10, "TODO List (WIP)", 0xFFFFFF, textRenderer));
        addDrawableChild(submitButton);
        addDrawableChild(textFieldWidget);

        TodoListHandler.getInstance().getList().forEach(str -> {
            int yOffset = (pointer * 22) + 10;
            addDrawable(new StringWidget(200, 14 + yOffset, str, textRenderer));

            addDrawableChild(new ButtonWidget.Builder(Text.literal("X"),button -> {
                TodoListHandler.getInstance().remove(str);
                JsonHelper.getInstance().saveData();
                draw();
            }).dimensions(180, 10 + yOffset, 16, 20).build());

            pointer++;
        });
        pointer = 0;
    }



    @Override
    public boolean shouldPause() {
        return false;
    }
}
