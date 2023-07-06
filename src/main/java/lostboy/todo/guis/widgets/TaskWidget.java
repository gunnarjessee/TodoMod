package lostboy.todo.guis.widgets;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;

/*
    Created by Gunnar Jessee/LostboyDev
    7/6/23
 */

@Environment(EnvType.CLIENT)
public class TaskWidget extends ClickableWidget {

    private int id;
    public int buttonWidth, buttonHeight, buttonX, buttonY;
    public TaskWidget(int x, int y, int width, int height, Text message, int id) {
        super(x, y, width, height, message);
        this.id = id;
        this.buttonWidth = 10;
        this.buttonHeight = 10;
        this.buttonX = x + 40;
        this.buttonY = y;
        this.initialize();
    }

    private void initialize() {

    }

    @Override
    public void appendNarrations(NarrationMessageBuilder builder) {

    }

    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        super.mouseMoved(mouseX, mouseY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        return super.mouseScrolled(mouseX, mouseY, amount);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        return super.keyReleased(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        return super.charTyped(chr, modifiers);
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
