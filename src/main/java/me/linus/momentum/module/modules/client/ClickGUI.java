package me.linus.momentum.module.modules.client;

import me.linus.momentum.gui.main.gui.GUI;
import me.linus.momentum.module.Module;
import me.linus.momentum.setting.checkbox.Checkbox;
import me.linus.momentum.setting.mode.Mode;
import me.linus.momentum.setting.slider.Slider;
import me.linus.momentum.setting.slider.SubSlider;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;

/**
 * @author bon & linustouchtips
 * @since 11/16/2020
 */

public class ClickGUI extends Module {
	public ClickGUI() {
		super("ClickGUI", Category.CLIENT, "Opens the ClickGUI");
		this.getKeybind().setKeyCode(Keyboard.KEY_COMMA);
	}

	public static Slider scrollSpeed = new Slider("Scroll Speed", 0.0D, 10.0D, 20.0D, 0);
	public static Slider speed = new Slider("Animation Speed", 0.0D, 3.5D, 5.0D, 1);

	public static Checkbox blurEffect = new Checkbox("Blur Effect", true);
	public static Checkbox blurChat = new Checkbox("Chat Blur", true);
	public static Checkbox allowOverflow = new Checkbox("Allow Overflow", true);

	public static Checkbox snapSlider = new Checkbox("Slider Snap", true);
	public static SubSlider snapSub = new SubSlider(snapSlider, "Snap Distance", 1.0D, 5.0D, 10.0D, 0);

	public static Mode theme = new Mode("Theme", "Default", "Dark");

	public static Checkbox pauseGame = new Checkbox("Pause Game", false);
	public static Checkbox indicators = new Checkbox("Indicators", false);

	public static GUI clickGui = new GUI();

	@Override
	public void setup() {
		addSetting(theme);
		addSetting(snapSlider);
		addSetting(scrollSpeed);
		addSetting(speed);
		addSetting(blurEffect);
		addSetting(blurChat);
		addSetting(allowOverflow);
		addSetting(pauseGame);
		addSetting(indicators);
	}

	@Override
	public void onEnable() {
		if (nullCheck())
			return;

		super.onEnable();
		mc.displayGuiScreen(clickGui);

		if (blurEffect.getValue())
			mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
	}

	@Override
	public void onUpdate() {
		if (nullCheck()) {
			this.disable();
		}
	}
}