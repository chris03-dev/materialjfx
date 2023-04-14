package materialjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TestBed2 extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	int gc = 0;
	
	@Override
	public void start(Stage stage) {
			Pane root = new Pane();
			Scene sc = new Scene(root, 500, 300);
		 	root.getChildren().clear();
		 	Rectangle r[] = new Rectangle[10000];
		    for (int i = 0; i < 10000; i++) {
		      r[i] = new Rectangle(i/4, i/4, 1,1);
		      root.getChildren().add(r[i]);
		      r[i].setCache(false);
		    }
		    
		    root.setOnMouseClicked(e -> {
		    	if (gc == 0) {
		    		gc = 1;
		    	}
		    	//System.gc();
		    });
		    stage.setScene(sc);
		    stage.show();

	}

}
