package materialjfx.controls;

import javafx.application.Platform;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import materialjfx.animation.*;
import materialjfx.layout.Root;
import materialjfx.paint.MaterialColorPalette;

public class MaterialRadioButton extends RadioButton {
	Paint fill = Color.TRANSPARENT;
	CornerRadii rad = new CornerRadii(2);
	BackgroundFill bgf = new BackgroundFill(fill, rad, Insets.EMPTY);
	Background bg = new Background(bgf);
	boolean hold = true;

	MaterialRadioButton tb = this;
	
	boolean selected = false;
	
	void init() {
		tb.getStyleClass().remove("radio-button");
		tb.getStyleClass().add("toggle-button");
		
		Group group = new Group();
		Circle frame = new Circle(12);
		frame.setFill(Color.TRANSPARENT);
		Circle solid = new Circle(8);
		solid.setFill(Color.TRANSPARENT);
		solid.setStroke(MaterialColorPalette.BLUE);
		solid.setStrokeWidth(1.5);
		Circle solid2 = new Circle(0);
		solid2.setFill(MaterialColorPalette.BLUE);
		
		group.getChildren().addAll(frame, solid, solid2);
		setGraphic(group);
		
		Platform.runLater(new Runnable() {
			public void run() {
				Region parent = (Region) getParent(); 
				setPrefWidth(parent.getWidth());
				Root root = (Root) getScene().getRoot();
				root.getChildren().add(new Rippler(tb));
				
				MaterialAnimationType i = (MaterialAnimationType) MaterialAnimationType.SHARP_IN;
				MaterialAnimation a = new MaterialAnimation(solid.strokeWidthProperty(), 1.5,   8, Duration.seconds(0.15), i);
				MaterialAnimation b = new MaterialAnimation(solid.radiusProperty(),        8,   4, Duration.seconds(0.15), i);
				MaterialAnimation c = new MaterialAnimation(solid.radiusProperty(),        7,   8, Duration.seconds(0.15), i);
				MaterialAnimation d = new MaterialAnimation(solid2.radiusProperty(),       8, 4.5, Duration.seconds(0.25), i);
				
				MaterialAnimation ar = new MaterialAnimation(solid.strokeWidthProperty(), 8, 1.5, Duration.seconds(0.15), i);
				MaterialAnimation br = new MaterialAnimation(solid.radiusProperty(),      8,   7, Duration.seconds(0.15), i);
				MaterialAnimation cr = new MaterialAnimation(solid.radiusProperty(),      4,   8, Duration.seconds(0.15), i);
				MaterialAnimation dr = new MaterialAnimation(solid2.radiusProperty(),   4.5,   8, Duration.seconds(0.25), i);
				
				ToggleGroup tg = tb.getToggleGroup();
				try {
					tg.selectedToggleProperty().addListener(e -> {
						if (a.isPlaying()) a.stop();
						if (b.isPlaying()) b.stop();
						if (c.isPlaying()) c.stop();
						if (d.isPlaying()) d.stop();
						
						/*if (ar.isPlaying()) ar.stop();
						if (br.isPlaying()) br.stop();
						if (cr.isPlaying()) cr.stop();
						if (dr.isPlaying()) dr.stop();
						//*/
						if (tg.getSelectedToggle() == tb) {
							selected = true;
							solid.setStrokeWidth(1.5);
							solid.setRadius(7);
							solid2.setRadius(0);
							
							a.play();
							b.play();
							b.setOnFinished(ec -> {
								solid.setRadius(7);
								solid.setStrokeWidth(1.5);
								solid2.setRadius(7);
								c.play();
								d.play();
							});
						}
						else {
							solid.setStrokeWidth(1.5);
							solid.setRadius(8);
							
							if (selected == true) {
								selected = false;
								System.out.println(tg.getSelectedToggle());
								solid2.setRadius(4.5);
								
								br.play();
								dr.play();
								dr.setOnFinished(xe -> {
									solid.setRadius(4);
									solid.setStrokeWidth(8);
									solid2.setRadius(0);
									
									ar.play();
									cr.play();
									/*ar.play();
									cr.play();
									
									solid.setRadius(4);
									solid.setStrokeWidth(8);
									//solid2.setRadius(0);
									*/
								});
							}
						}
					});
				}
				catch (NullPointerException e) {}
			}
		});
		
		setPrefHeight(40);
		setContentDisplay(ContentDisplay.LEFT);
		setAlignment(Pos.CENTER_LEFT);
		
		VBox.setMargin(this, new Insets(0));
		setFont(new Font("Roboto", 13));
		setEffect(null);
		setBackground(bg);
		setTextFill(Color.BLACK);
	}
	
	public MaterialRadioButton() {
		init();
	}
	
	public MaterialRadioButton(String text) {
		super(text);
		init();
	}
	public MaterialRadioButton(String text, ImageView image) {
		super(text);
				//, image);
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
	public Paint getFill()  {return fill;}
	public CornerRadii getCornerRadii() {return rad;}
}
