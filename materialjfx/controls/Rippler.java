package materialjfx.controls;

import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Paint;

public class Rippler extends Region {
	Region rippler = this;
	Pane root = new Pane();
	public Rippler(Region content) {
		Platform.runLater(new Runnable() {
			public void run() {
				root = (Pane) getScene().getRoot();
				content.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
					Bounds bounds = content.localToScene(content.getBoundsInLocal());
					
					//System.out.println("Mouse X:" + e.getSceneX());
					//System.out.println("Mouse Y:" + e.getSceneY());
					//System.out.println("Content X:" + bounds.getMinX());
					//System.out.println("Content Y:" + bounds.getMinY());
					//System.out.println("Content Y:" + bounds.getMinY());
					
					if ((e.getSceneX() > bounds.getMinX())
					&&(e.getSceneX() < bounds.getMaxX())
					&&(e.getSceneY() > bounds.getMinY())
					&&(e.getSceneY() < bounds.getMaxY()))
						new Ripple(e.getSceneX(), e.getSceneY(), content, root);
				});
			}
		});
	}
	
	public Rippler(Region content, Paint color) {
		Platform.runLater(new Runnable() {
			public void run() {
				root = (Pane) getScene().getRoot();
				content.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
					Bounds bounds = content.localToScene(content.getBoundsInLocal());
					
					if ((e.getSceneX() > bounds.getMinX())
					&&(e.getSceneX() < bounds.getMaxX())
					&&(e.getSceneY() > bounds.getMinY())
					&&(e.getSceneY() < bounds.getMaxY()))
						new Ripple(e.getSceneX(), e.getSceneY(), color, content, root);
				});
			}
		});
	}

}
