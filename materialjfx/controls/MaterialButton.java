package materialjfx.controls;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class MaterialButton extends Button {
	Paint fill = Color.rgb(0, 0, 255);
	CornerRadii rad = new CornerRadii(2);
	BackgroundFill bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
	Background bg = new Background(bgf);
	Depth d = new Depth(2);
	
	Pane root = new Pane();
	Button bt = this;
	
	boolean hold = false;
	double x, y, mX, mY;
	int xx = 0;
	
	void init() {
		setPickOnBounds(false);
		
		HBox.setMargin(this, new Insets(0, 2.5, 0, 2.5));
		VBox.setMargin(this, new Insets(2.5, 0, 2.5, 0));
		setFont(new Font("Roboto Bold", 13));
		setBackground(bg);
		setEffect(d);
		
		this.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
			mX = e.getSceneX();
			mY = e.getSceneY();
		});
		
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Failed to create ripple handler (" + bt.getProperties() + ")");
					root = (Pane) getScene().getRoot();
					root.getChildren().add(new Rippler(bt, bt.getTextFill()));
				}
				catch (Exception e) {
					System.out.println("Failed to create ripple handler (" + bt.getId() + ")");
				}
			}
		});
	}
	public MaterialButton() {
		setTextFill(Color.WHITE);
		init();
	}
	public MaterialButton(String text) {
		super(text);
		setTextFill(Color.WHITE);
		init();
	}
	
	public MaterialButton(String text, Node graphic) {
		super(text, graphic);
		setTextFill(Color.WHITE);
		init();
	}
	
	public MaterialButton(String text, Paint value) {
		super(text);
		fill = value;
		bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
		bg = new Background(bgf);
		setTextFill(Color.WHITE);
		init();
	}
	
	public MaterialButton(String text, Node graphic, Paint value) {
		super(text, graphic);
		fill = value;
		bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
		bg = new Background(bgf);
		setTextFill(Color.WHITE);
		init();
	}
	
	public MaterialButton(String text, double depth) {
		super(text);
		setTextFill(Color.WHITE);
		d = new Depth(depth);
		init();
	}
	
	public MaterialButton(String text, Node graphic, double depth) {
		super(text, graphic);
		setTextFill(Color.WHITE);
		d = new Depth(depth);
		init();
	}
	
	public MaterialButton(String text, Paint value, double depth) {
		super(text);
		fill = value;
		bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
		bg = new Background(bgf);
		setTextFill(Color.WHITE);
		d = new Depth(depth);
		init();
	}
	
	public MaterialButton(String text, Node graphic, Paint value, double depth) {
		super(text, graphic);
		fill = value;
		bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
		bg = new Background(bgf);
		setTextFill(Color.WHITE);
		d = new Depth(depth);
		init();
	}
	
	public MaterialButton(String text, Paint value, Paint textFill) {
		super(text);
		fill = value;
		bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
		bg = new Background(bgf);
		setTextFill(textFill);
		init();
	}
	
	public MaterialButton(String text, Node graphic, Paint value, Paint textFill) {
		super(text, graphic);
		fill = value;
		bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
		bg = new Background(bgf);
		setTextFill(textFill);
		init();
	}
	
	public MaterialButton(String text, Paint value, Paint textFill, double depth) {
		super(text);
		fill = value;
		bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
		bg = new Background(bgf);
		d = new Depth(depth);
		setTextFill(textFill);
		init();
	}
	
	public MaterialButton(String text, Node graphic, Paint value, Paint textFill, double depth) {
		super(text, graphic);
		fill = value;
		bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
		bg = new Background(bgf);
		d = new Depth(depth);
		setTextFill(textFill);
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
	public void setDepth(double depth) {
		d = new Depth(depth);
		setEffect(d);
	}
	
	public boolean      getRippleHold() {return hold;}
	public Paint              getFill() {return fill;}
	public CornerRadii getCornerRadii() {return rad;}
	public double            getDepth() {return d.getDepth();}
}