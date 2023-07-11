package lostboy.todo.guis.widgets;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class StringWidget implements Drawable {

    protected Text text;
    protected int x, y;
    protected TextRenderer textRenderer;

    protected int color;

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
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawText(textRenderer, text, x, y, 0xFFFFFF, true);
    }
}
