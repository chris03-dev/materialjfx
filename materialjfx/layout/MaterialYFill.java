package materialjfx.layout;

import javafx.scene.layout.*;

public class MaterialYFill extends Pane {
	public MaterialYFill(int space) {
		if (space < 0) VBox.setVgrow(this, Priority.SOMETIMES);
		else this.setPrefHeight(space);
	}
}
