package materialjfx.layout;

import javafx.scene.layout.*;

public class MaterialXFill extends Pane {
	public MaterialXFill(int space) {
		if (space < 0) HBox.setHgrow(this, Priority.SOMETIMES);
		else this.setPrefWidth(space);
	}
}
