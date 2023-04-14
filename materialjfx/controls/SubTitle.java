package materialjfx.controls;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class SubTitle extends Label {
	public SubTitle() {
		setFont(new Font("Roboto Bold", 13));
	}
	public SubTitle(String s) {
		super(s);
		setFont(new Font("Roboto Bold", 13));
	}
	public SubTitle(String s, int x, int y) {
		super(s);
		this.relocate(x, y);
		setFont(new Font("Roboto Bold", 13));
	}
}
