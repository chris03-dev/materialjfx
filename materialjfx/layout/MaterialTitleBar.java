package materialjfx.layout;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import materialjfx.controls.Depth;
import materialjfx.paint.MaterialColorPalette;

public class MaterialTitleBar extends HBox {
	Paint fill = MaterialColorPalette.BLUE;
	CornerRadii rad = new CornerRadii(0);
	BackgroundFill bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
	Background bg = new Background(bgf);
	
	Depth d = new Depth(4);
	MaterialTitleBar bar = this;
	
	void init() {
		setPickOnBounds(false);
		setPrefHeight(40);
		setAlignment(Pos.CENTER_LEFT);
		setPadding(new Insets(5, 10, 5, 10));
		setBackground(bg);		
		setEffect(new Depth(4));
		
		Platform.runLater(new Runnable() {
			public void run() {
				//Bounds bounds = bar.localToScene(bar.getLayoutBounds());
				/*
				System.out.println(bounds.getMinX());
				System.out.println(bounds.getMinY());
				System.out.println(bounds.getMaxX());
				System.out.println(bounds.getMaxY());*/
			}
		});
	}
	
	public MaterialTitleBar() {
		init();
	}
	
	public MaterialTitleBar(Node...nodes) {
		super(nodes);
		init();
	}
	public void setFill(Paint value) { 
		fill = value;
		bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
		bg = new Background(bgf);
		setBackground(bg);
		setEffect(d);
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
	
	public Paint getFill() {return fill;}
	public CornerRadii getCornerRadii() {return rad;}
	public double getDepth() {return d.getDepth();}
}
