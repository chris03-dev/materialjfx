package materialjfx.layout;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import materialjfx.animation.MaterialAnimationType;
import materialjfx.animation.MaterialAnimation;

public class Root extends Pane {
	Root root = this;
	Pane pane = new Pane();
	ArrayList<Room> rooms;
	Room current;
	
	Room splashPane = new Room();
	StackPane splashArea = new StackPane();
	Node splash;
	Rectangle shade;
	
	boolean tRunning = false;
	
	public static class RootTransition {
		public static final RootTransition 
			NONE = null,
			FADE = new RootTransition(),
			FADE_UP = new RootTransition(),
			FADE_DOWN = new RootTransition(),
			SLIDE_UP = new RootTransition(),
			SLIDE_DOWN = new RootTransition();

		public RootTransition() {}
	}
	
	void init() {
		Platform.runLater(new Runnable() {
			public void run() {
				if (splash != null) {
					root.getChildren().add(splashPane);
					splashPane.getChildren().add(splashArea);
					splashArea.getChildren().add(splash);
				}
				
				addEventHandler(Event.ANY, e -> {
					ArrayList<Room> rooms = new ArrayList<Room>();
					for (Node node : root.getChildrenUnmodifiable()) {
						if (node instanceof Room) {
							rooms.add((Room) node);
						}
					}
					if (current == null) current = rooms.get(rooms.size() - 1);
					if (splash != null) current = splashPane;
				});
				
				setPrefSize(getScene().getWidth(), getScene().getHeight());
				getScene().widthProperty().addListener(e -> setPrefWidth(getScene().getWidth()));
				getScene().heightProperty().addListener(e -> setPrefHeight(getScene().getHeight()));
				
				
			}
		});
	}
	public Root() {
		init();
	}
	public Root(Room...rooms) {
		super(rooms);
		init();
	}
	public Root(Node splash, Room...rooms) {
		super(rooms);
		this.splash = splash;
		init();
	}
	
	public void setRoom(Room room, RootTransition transition) {
		if (!tRunning) {
			tRunning = true;
			room.setCache(true);
			room.setCacheHint(CacheHint.SPEED);
			
			System.out.println("Current: " + current);
			
			MaterialAnimationType i = (MaterialAnimationType) MaterialAnimationType.SHARP_IN;
			MaterialAnimationType ir = (MaterialAnimationType) MaterialAnimationType.SHARP_OUT;
			
			if (transition == RootTransition.NONE) {
				room.toFront();
				tRunning = false;
			}
			
			if (transition == RootTransition.FADE) {
				MaterialAnimation a = new MaterialAnimation(room.opacityProperty(), 0, 1, Duration.seconds(0.25), i);
				a.setOnFinished(e -> {System.out.println("DONE");});
				
				room.relocate(0, 0);
				room.setOpacity(0);
				room.toFront();
				
				a.play();
				a.setOnFinished(e -> tRunning = false);
			}
			if (transition == RootTransition.FADE_UP) {
				MaterialAnimation a = new MaterialAnimation(room.layoutYProperty(), 50, 0, Duration.seconds(2), i);
				MaterialAnimation b = new MaterialAnimation(room.opacityProperty(), 0, 1, Duration.seconds(1), i);
				
				room.setOpacity(0);
				room.toFront();
				room.relocate(0, 50);
				
				a.play();
				b.play();
				
				a.setOnFinished(ec -> {
					tRunning = false;
				});
			}
			
			if (transition == RootTransition.FADE_DOWN) {
				room.toFront();
				MaterialAnimation a = new MaterialAnimation(current.layoutYProperty(), 0, 50, Duration.seconds(0.2), ir);
				MaterialAnimation b = new MaterialAnimation(room.opacityProperty(), 0, 1, Duration.seconds(0.2), ir);
				
				current.relocate(0, 0);
				room.setOpacity(0);
				room.relocate(0, 0);
				
				a.play();
				b.play();
				
				a.setOnFinished(ec -> {
					tRunning = false;
				});
			}
			
			if (transition == RootTransition.SLIDE_UP) {
				shade = new Rectangle(0, 0, 
						1.3 * getScene().getWidth(), 
						1.3 * getScene().getHeight());
				Rectangle clip = (Rectangle) room.getClip();
				
				shade.setCache(true);
				shade.setCacheHint(CacheHint.SPEED);
				shade.setFill(Color.BLACK);
				shade.setOpacity(0);
				shade.setMouseTransparent(true);
				getChildren().add(shade);
				
				clip.relocate(0, getScene().getHeight());
				
				MaterialAnimation a = new MaterialAnimation(room.layoutYProperty(), 25, 0, Duration.seconds(0.5), i);
				MaterialAnimation b = new MaterialAnimation(current.layoutYProperty(), 0, -10, Duration.seconds(0.5), i);
				MaterialAnimation c = new MaterialAnimation(
					clip.layoutYProperty(), 
					getScene().getHeight(), 
					0, Duration.seconds(0.25), i
				);
				MaterialAnimation e = new MaterialAnimation(
					shade.opacityProperty(), 
					0,
					0.5, Duration.seconds(0.25), i
				);
				
				room.toFront();
				room.relocate(0, 25);
				
				a.play();
				b.play();
				c.play();
				e.play();
				
				a.setOnFinished(ec -> {
					tRunning = false;
					root.getChildren().remove(shade);
					shade = null;
				});
			}
			
			if (transition == RootTransition.SLIDE_DOWN) {
				room.toFront();
				shade = new Rectangle(0, 0, 
					getScene().getWidth(), 
					0);
				Rectangle clip = (Rectangle) room.getClip();
				
				shade.setCache(true);
				shade.setCacheHint(CacheHint.SPEED);
				shade.setFill(Color.BLACK);
				shade.setOpacity(0.5);
				shade.setMouseTransparent(true);
				getChildren().add(shade);
				
				clip.setHeight(0);
				
				MaterialAnimation a = new MaterialAnimation(current.layoutYProperty(), 0, 50, Duration.seconds(0.25), i);
				MaterialAnimation b = new MaterialAnimation(room.layoutYProperty(), -10, 0, Duration.seconds(0.5), i);
				MaterialAnimation c = new MaterialAnimation(clip.heightProperty(), 0, getScene().getHeight(), Duration.seconds(0.25), i);
				MaterialAnimation d = new MaterialAnimation(shade.heightProperty(), 0, getScene().getHeight(), Duration.seconds(0.25), i);
				MaterialAnimation e = new MaterialAnimation(shade.opacityProperty(), 0.5, 0, Duration.seconds(0.5), i);
				
				current.relocate(0, 0);
				room.relocate(0, -10);
				
				a.play();
				b.play();
				c.play();
				d.play();
				e.play();
				
				e.setOnFinished(ec -> {
					tRunning = false;
					root.getChildren().remove(shade);
					shade = null;
				});
			}
			
			System.out.println("Number:" + this.getChildren().size());
			//room.setCache(false);
			//room.setCacheHint(CacheHint.DEFAULT);
			
			//System.gc();
			current = room;
		}
	}
	
	public Room getCurrent() {
		return current;
	}
}
