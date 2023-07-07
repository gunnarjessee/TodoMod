package lostboy.todo.guis.widgets;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.Element;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class StringWidget implements Drawable {

    private Text text;
    private int x, y;
    private TextRenderer textRenderer;

    private int color;

    public StringWidget(int x, int y, String str, TextRenderer renderer) {
        this.x = x;
        this.y = y;
        this.text = Text.literal(str);
        this.textRenderer = renderer;
        this.color = 0xFF0000;
    }

    public StringWidget(int x, int y, String str, int color, TextRenderer renderer) {
        this.x = x;
        this.y = y;
        this.text = Text.literal(str);
        this.textRenderer = renderer;
        this.color = color;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        textRenderer.draw(matrices, this.text, this.x, this.y, color);
    }
}
