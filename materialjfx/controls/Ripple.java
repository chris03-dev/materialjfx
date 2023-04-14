package materialjfx.controls;

import javafx.beans.InvalidationListener;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.util.Duration;
import materialjfx.animation.MaterialAnimationType;
import materialjfx.animation.MaterialAnimation;
import materialjfx.layout.Root;

public class Ripple extends Circle {
	Ripple rpl = this;
	
	boolean fadeReady = false;
	
	Paint color;
	Color contentFill;
	CornerRadii rad; 
	double x, y, dc, lightIndex;
	
	Region content = new Region();
	Pane room;
	Pane root;
	
	InvalidationListener l;
	
	void lightTest() {
		lightIndex = (contentFill.getRed()
			+ contentFill.getGreen()
			+ contentFill.getBlue())/3;
		
		if (lightIndex > 0.5) color = Color.rgb(0, 0, 0);
		else color = Color.rgb(255, 255, 255);
	}
	void init() {
		setOpacity(0.75 - (contentFill.getRed() + contentFill.getGreen() + contentFill.getBlue())/18);
		setFill(color);
		setMouseTransparent(true);
		root.getChildren().add(this);
		
		dc = Math.sqrt((content.getWidth() * content.getWidth()) + (content.getHeight() * content.getHeight()));
		
		MaterialAnimationType i = (MaterialAnimationType) MaterialAnimationType.SHARP_IN;
		MaterialAnimationType ir = (MaterialAnimationType) MaterialAnimationType.SHARP_OUT;
		
		MaterialAnimation a = new MaterialAnimation(radiusProperty(), 1, dc, Duration.seconds(0.5), i);
		MaterialAnimation b = new MaterialAnimation(opacityProperty(), 1, 0, Duration.seconds(0.5), ir);
		
		a.play();

		EventHandler<MouseEvent> e = new EventHandler<MouseEvent> () {
			public void handle(MouseEvent e) {
				b.play();
				b.setOnFinished(ev -> {
					try {
						if (content.getScene().getRoot() instanceof Root) {
							room.layoutYProperty().removeListener(l);
						}
					}
					catch (NullPointerException n) {}
					root.getChildren().remove(rpl);
					content.removeEventHandler(MouseEvent.MOUSE_RELEASED, this);
					rpl = null;
				});
			}
		};
		
		content.addEventHandler(MouseEvent.MOUSE_RELEASED, e);

		Bounds bounds = content.localToScene(content.getLayoutBounds());
		Rectangle rect = new Rectangle(bounds.getMinX(), bounds.getMinY(), content.getWidth(), content.getHeight());
		setClip(rect);
		
		if (content.getScene().getRoot() instanceof Root) {
			room = (((Root) (content.getScene().getRoot())).getCurrent());
			
			l = (ed -> {
				Bounds bound = content.localToScene(content.getLayoutBounds());
				rect.setX(bound.getMinX());
				rect.setY(bound.getMinY());
				rect.setWidth(content.getWidth());
				rect.setHeight(content.getHeight());
			});
			room.layoutYProperty().addListener(l);
		}
		
		
		rect.setArcWidth(2 * rad.getTopLeftHorizontalRadius());
		rect.setArcHeight(2 * rad.getTopLeftVerticalRadius());
	}
	
	public Ripple(double x, double y, Region content, Pane root) {
		super(x, y, 1);
		this.x = x;
		this.y = y;
		this.content = content;
		this.root = root;
		
		rad = content.getBackground().getFills().get(0).getRadii();
		contentFill = (Color) content.getBackground().getFills().get(0).getFill();
		
		lightTest();
		
		if ((content instanceof MaterialListButton)
		||(content instanceof MaterialRadioButton)) {
			color = Color.rgb(0, 0, 0, (content instanceof MaterialRadioButton) ? 0.5: 0.25);
		}
		
		
		init();
	}
	
	public Ripple(double x, double y, Paint value, Region content, Pane root) {
		super(x, y, 1);
		this.x = x;
		this.y = y;
		this.content = content;
		this.root = root;
		color = value;
		
		rad = content.getBackground().getFills().get(0).getRadii();
		contentFill = (Color) content.getBackground().getFills().get(0).getFill();
		
		init();
	}
}