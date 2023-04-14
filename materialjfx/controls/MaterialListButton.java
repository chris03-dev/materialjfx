package materialjfx.controls;

import javafx.application.Platform;
import javafx.geometry.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;

public class MaterialListButton extends MaterialButton {
	Paint fill = Color.TRANSPARENT;
	CornerRadii rad = new CornerRadii(0);
	BackgroundFill bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
	Background bg = new Background(bgf);
	
	boolean hold = true;
	
	void init() {
		Platform.runLater(new Runnable() {
			public void run() {
				setPrefWidth(((Region) getParent()).getWidth());
			}
		});
		setPickOnBounds(false);
		setPrefHeight(40);
		setGraphicTextGap(10);
		setAlignment(Pos.CENTER_LEFT);
		VBox.setMargin(this, new Insets(0));
		
		setFont(new Font("Roboto", 13));
		setTextFill(Color.BLACK);
		
		setBackground(bg);
		setEffect(null);
		
		
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					root = (Pane) getScene().getRoot();
					root.getChildren().add(new Rippler(bt));
				}
				catch (Exception e) {}
			}
		});
	}
	public MaterialListButton(String text) {
		super(text);
		init();
	}
	public MaterialListButton(String text, ImageView image) {
		super(text, image);
		init();
	}
	
	public void setRippleHold(boolean hold) {
		this.hold = hold;
	}
	public void setFill(Paint value) { 
		fill = value;
		bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
		bg = new Background(bgf);
		setBackground(bg);
	}
	public void setCornerRadii(CornerRadii value) { 
		rad = value;
		bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
		bg = new Background(bgf);
		setBackground(bg);
	}
	
	public boolean getRippleHold() {return hold;}
	public Paint getFill() {return fill;}
	public CornerRadii getCornerRadii() {return rad;}
}
