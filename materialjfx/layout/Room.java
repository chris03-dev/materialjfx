package materialjfx.layout;

import javafx.scene.shape.Rectangle;
import materialjfx.controls.Depth;
import javafx.application.Platform;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;

public class Room extends BorderPane {
	Room room = this;
	Rectangle rect;
	
	public Room() {
		room.setBackground(new Background(new BackgroundFill(Paint.valueOf("#EEE"), null, null)));
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					rect = new Rectangle(0, 0, getScene().getWidth(), getScene().getHeight());
					//rect.setFill(Color.rgb(255, 255, 255, 1));
					setEffect(new Depth(4));
					
					setPrefSize(getScene().getWidth(), getScene().getHeight());
					getScene().widthProperty().addListener(e -> {
						setPrefWidth(getScene().getWidth());
						rect.setWidth(room.getPrefWidth());
					});
					getScene().heightProperty().addListener(e -> {
						setPrefHeight(getScene().getHeight());
						rect.setHeight(room.getPrefHeight());
					});
					room.setClip(rect);
				}
				catch (NullPointerException e) {}
			}
		});
	}
}
