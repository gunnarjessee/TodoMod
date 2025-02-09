package lostboy.todo.guis;

import lostboy.todo.guis.widgets.StringWidget;
import lostboy.todo.helpers.JsonHelper;
import lostboy.todo.helpers.TodoListHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;


@Environment(EnvType.CLIENT)
public class TodoGUI extends Screen {

    public TodoGUI() {
        super(Text.of("My GUI"));
        this.passEvents = false;
        this.width = 200;
        this.height = 200;
    }

    private TextFieldWidget textFieldWidget;
    private ButtonWidget submitButton;
    @Override
    protected void init() {
        textFieldWidget = new TextFieldWidget(textRenderer, 10, 10, 100, 16, Text.of(""));
        submitButton = new ButtonWidget(10, 30, 50, 20, Text.of("ADD"), button -> {
            TodoListHandler.getInstance().add(textFieldWidget.getText());
            JsonHelper.getInstance().saveData();
            textFieldWidget.setText("");
            draw();
        });
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
            addDrawableChild(new ButtonWidget(200 - 20, 10 + yOffset, 16, 20, Text.of("X"), button -> {
                TodoListHandler.getInstance().remove(str);
                JsonHelper.getInstance().saveData();
                draw();
            }));
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
