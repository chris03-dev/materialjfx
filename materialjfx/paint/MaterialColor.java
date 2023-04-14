package materialjfx.paint;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import materialjfx.controls.Depth;

public class MaterialColor extends Pane {
	Paint fill = Color.WHITE;
	CornerRadii rad = new CornerRadii(0);
	BackgroundFill bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
	Background bg = new Background(bgf);
	Depth d = new Depth(2);
	boolean hold = false;
	
	void init() {
		setPickOnBounds(false);
		setBackground(new Background(new BackgroundFill(fill, new CornerRadii(2), null)));
		setEffect(d);
	}
	public MaterialColor() {
		init();
	}
	public MaterialColor(Node...nodes) {
		super(nodes);
		init();
	}
	public MaterialColor(Paint value) {
		setFill(value);
		init();
	}
	public MaterialColor(Paint value, Node...nodes) {
		super(nodes);
		setFill(value);
		init();
	}
	
	public void setRippleHold(boolean hold) {this.hold = hold;}
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
		setEffect(d);
	}
	public void setDepth(double depth) {
		d = new Depth(depth);
		setEffect(d);
	}
	
	public boolean getRippleHold() {return hold;}
	public Paint getFill() {return fill;}
	public CornerRadii getCornerRadii() {return rad;}
	public double getDepth() {return d.getDepth();}
}
