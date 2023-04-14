package materialjfx;

import java.util.function.Consumer;
import javafx.application.Application;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import materialjfx.animation.MaterialAnimationType;
import materialjfx.animation.MaterialAnimation;
import materialjfx.controls.*;
import materialjfx.layout.*;
import materialjfx.layout.Root.RootTransition;
import materialjfx.paint.MaterialColorPalette;
import materialjfx.paint.MaterialColor;

public class TestBed extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage st) throws Exception {
		//Images
		Image img = new Image(getClass().getResourceAsStream("Icon.png"));
		Image img2 = new Image(getClass().getResourceAsStream("icons/outline_add_black_18dp.png"));
		ImageView img2V = new ImageView(img2);
		st.getIcons().add(img);
		
		//Fonts
		Font.loadFont(getClass().getResourceAsStream("fonts/Roboto-Regular.ttf"), 16);
    	Font.loadFont(getClass().getResourceAsStream("fonts/Roboto-Medium.ttf"), 16);
    	Font.loadFont(getClass().getResourceAsStream("fonts/Roboto-Bold.ttf"), 16);
		
    	//Rooms
		Room room1 = new Room();
		Room room2 = new Room();
		Room room3 = new Room();
		
		//Platform
		Root root = new Root(room1, room2, room3);
		Scene sc = new Scene(root, 720, 480, Color.RED);
		root.setRoom(room1, RootTransition.NONE);
		MaterialTitleBar hb1 = new MaterialTitleBar(new Title("Room 1", img2V, Color.WHITE), new MaterialXFill(-1));
		MaterialTitleBar hb2 = new MaterialTitleBar(new Title("Room 2", Color.WHITE), new MaterialXFill(-1));
		MaterialTitleBar hb3 = new MaterialTitleBar(new Title("Room 3", Color.WHITE), new MaterialXFill(-1));
		
		// Buttons
		MaterialButton mb12 = new MaterialButton("Room 2");
		MaterialButton mb13 = new MaterialButton("Room 3");
		
		MaterialButton mb21 = new MaterialButton("Room 1");
		MaterialButton mb23 = new MaterialButton("Room 3");
		
		MaterialButton mb31 = new MaterialButton("Room 1");
		MaterialButton mb32 = new MaterialButton("Room 2");
		
		mb12.setOnAction(e -> {root.setRoom(room2, RootTransition.SLIDE_UP);});
		mb13.setOnAction(e -> {root.setRoom(room3, RootTransition.SLIDE_UP);});
		
		mb21.setOnAction(e -> {root.setRoom(room1, RootTransition.SLIDE_DOWN);});
		mb23.setOnAction(e -> {root.setRoom(room3, RootTransition.SLIDE_UP);});
		
		mb31.setOnAction(e -> {root.setRoom(room1, RootTransition.SLIDE_DOWN);});
		mb32.setOnAction(e -> {root.setRoom(room2, RootTransition.SLIDE_DOWN);});
		
		hb1.getChildren().addAll(new MaterialButton("Room 1"), mb12, mb13);
		hb2.getChildren().addAll(mb21, new MaterialButton("Room 2"), mb23);
		hb3.getChildren().addAll(mb31, mb32, new MaterialButton("Room 3"));
		
		MaterialColor p1 = new MaterialColor(Color.WHITE);
		MaterialColor p2 = new MaterialColor(Color.GREEN);
		MaterialColor p3 = new MaterialColor(Color.RED);
		
		ToggleGroup tg = new ToggleGroup();
		
		MaterialRadioButton x = new MaterialRadioButton("Hello\nHi");
		MaterialRadioButton y = new MaterialRadioButton("Alpha");
		MaterialRadioButton z = new MaterialRadioButton("Beta");
		MaterialRadioButton a = new MaterialRadioButton("Delta");
		MaterialRadioButton b = new MaterialRadioButton("Theta");
		MaterialRadioButton c = new MaterialRadioButton("Gamma");
		
		tg.getToggles().addAll(x, y, z, a, b, c);
		
		/*x.setOnAction(e -> System.out.println(tg.getSelectedToggle()));
		y.setOnAction(e -> System.out.println(tg.getSelectedToggle()));
		z.setOnAction(e -> System.out.println(tg.getSelectedToggle()));
		//x.setText("EDITED");*/
		
		x.setTextFill(MaterialColorPalette.col(Color.BLUE, 900));
		
		VBox vb1 = new VBox(new Button("Default button"), x, y, z, a, b, c);
		VBox vb2 = new VBox(new MaterialRadioButton("1"), new MaterialRadioButton("2"), new MaterialRadioButton("3"));
		VBox vb3 = new VBox(new MaterialRadioButton("1"), new MaterialRadioButton("2"), new MaterialRadioButton("3"));
		
		vb1.setPrefWidth(200);
		vb2.setPrefWidth(200);
		vb3.setPrefWidth(200);
		room1.setLeft(vb1);
		room2.setLeft(vb2);
		room3.setLeft(vb3);
		
		room1.setCenter(p1);
		room2.setCenter(p2);
		room3.setCenter(p3);
		
		Rectangle r1 = new Rectangle(  0, 0, 100, 100);
		Rectangle r2 = new Rectangle( 50, 0, 100, 100);
		Rectangle r3 = new Rectangle(100, 0, 100, 100);
		Rectangle r4 = new Rectangle(150, 0, 100, 100);
		Rectangle r5 = new Rectangle(200, 0, 100, 100);
		Rectangle r6 = new Rectangle(250, 0, 100, 100);
		Rectangle r7 = new Rectangle(300, 0, 100, 100);
		Rectangle r8 = new Rectangle(350, 0, 100, 100);
		Rectangle r9 = new Rectangle(400, 0, 100, 100);
		Rectangle r0 = new Rectangle(450, 0, 100, 100);
		
		Line ln = new Line(0, 0, 250, 125);
		
		r1.setStroke(Color.BLACK);
		r2.setStroke(Color.BLACK);
		r3.setStroke(Color.BLACK);
		r4.setStroke(Color.BLACK);
		r5.setStroke(Color.BLACK);
		r6.setStroke(Color.BLACK);
		r7.setStroke(Color.BLACK);
		r8.setStroke(Color.BLACK);
		r9.setStroke(Color.BLACK);
		r0.setStroke(Color.BLACK);
		
		r1.setFill(MaterialColorPalette.col(Color.BLUE, 900));
		r2.setFill(MaterialColorPalette.col(Color.BLUE, 800));
		r3.setFill(MaterialColorPalette.col(Color.BLUE, 700));
		r4.setFill(MaterialColorPalette.col(Color.BLUE, 600));
		r5.setFill(MaterialColorPalette.col(Color.BLUE, 500));
		r6.setFill(MaterialColorPalette.col(Color.BLUE, 400));
		r7.setFill(MaterialColorPalette.col(Color.BLUE, 300));
		r8.setFill(MaterialColorPalette.col(Color.BLUE, 200));
		r9.setFill(MaterialColorPalette.col(Color.BLUE, 100));
		r0.setFill(MaterialColorPalette.col(Color.BLUE, 50));
		p1.getChildren().addAll(r1, r2, r3, r4, r5, r6, r7,r8, r9, r0, ln);
		
		MaterialButton px = new MaterialButton("Play!");
		px.setFill(Color.WHITE);
		px.setTextFill(Color.BLUE);
		
		Circle cc1 = new Circle(100, 100, 10);
		Circle cc2 = new Circle(100, 100, 10);
		Circle ccp = new Circle(225, 225, 10);
		Circle ccx = new Circle(500, 500, 10);
		
		cc1.setCache(true);
		cc1.setCacheHint(CacheHint.SPEED);
		cc1.layoutYProperty().addListener(e -> p1.getChildren().add(new Circle(cc1.getLayoutX(), cc1.getLayoutY(), 0.5)));
		cc2.layoutYProperty().addListener(e -> p1.getChildren().add(new Circle(cc1.getLayoutX(), cc2.getLayoutY(), 0.5)));
		
		MaterialAnimation cc1xa = new MaterialAnimation(cc1.layoutXProperty(), 0, 250, Duration.millis(2000), 2);
		MaterialAnimation cc1ya = new MaterialAnimation(cc1.layoutYProperty(), 0, 125, Duration.millis(2000), 2, MaterialAnimationType.SHARP_IN);
		MaterialAnimation cc2xa = new MaterialAnimation(cc2.layoutXProperty(), 0, 250, Duration.millis(2000), 2);
		MaterialAnimation cc2ya = new MaterialAnimation(cc2.layoutYProperty(), 0, 125, Duration.millis(2000), 2, MaterialAnimationType.SHARP_OUT);
		
		cc1xa.setAutoReverse(true);
		cc1ya.setAutoReverse(true);
		cc2xa.setAutoReverse(true);
		cc2ya.setAutoReverse(true);
		
		px.relocate(0, 250);
		px.setOnAction(e -> {
			cc1.setLayoutY(0);
			//cc1ya.setCycleCount(cc1ya.getCycleCount());
			cc1xa.play();
			cc1ya.play();
			cc2xa.play();
			cc2ya.play();
			/*
			cc1xa.playFromStart();
			cc1ya.playFromStart();
			cc2xa.playFromStart();
			cc2ya.playFromStart();*/
		});
		p1.getChildren().addAll(px, cc1, cc2, ccp, ccx);
		
		room1.setTop(hb1);
		room2.setTop(hb2);
		room3.setTop(hb3);
		
		st.setScene(sc);
		st.show();
	}
}
