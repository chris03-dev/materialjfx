package materialjfx.controls;

import javafx.animation.Interpolator;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.util.Duration;
import materialjfx.animation.MaterialAnimation;
import materialjfx.controls.Title;
import materialjfx.layout.MaterialXFill;

public class MaterialPrompt extends Region {
	Scene scene; 
	Pane root, back;
	VBox card;
	Title title;
	HBox buttonBar;
	MaterialButton yes, no, ok, cancel;
	Region content;
	MaterialPrompt buttonLayout;
	
	InvalidationListener wl, hl;
	@SuppressWarnings("rawtypes")
	EventHandler keyH;
	
	public static final MaterialPrompt
		OK = new MaterialPrompt(),
		OK_CANCEL = new MaterialPrompt(),
		YES_NO = new MaterialPrompt(),
		YES_NO_CANCEL = new MaterialPrompt(),
		CUSTOM = new MaterialPrompt();
	
	public static class PromptResult {
		public static final PromptResult 
			YES = new PromptResult(),
			NO = new PromptResult(),
			OK = new PromptResult(),
			CANCEL = new PromptResult();

		public PromptResult() {}
	}
	
	public MaterialPrompt() {}
	public MaterialPrompt(Scene scene, String titleName, Region contentNode) {
		buttonBar = new HBox();
		back = new Pane();
		card = new VBox();
		buttonLayout = MaterialPrompt.OK;
		this.scene = scene;
		
		root = (Pane) scene.getRoot();
		title = new Title(titleName);
		content = contentNode;
		
		init();
	}
	public MaterialPrompt(Scene scene, String titleName, Region contentNode, MaterialPrompt buttonLayout) {
		buttonBar = new HBox();
		back = new Pane();
		card = new VBox();
		this.buttonLayout = buttonLayout;
		this.scene = scene;
		
		root = (Pane) scene.getRoot();
		title = new Title(titleName);
		content = contentNode;
		
		init();
	}
	@SuppressWarnings("unchecked")
	void init() {
		//Node alter
		if (content instanceof Label) ((Label) content).setWrapText(true);
		
		//Card alter
		card.setPrefWidth(225);
		card.setPadding(new Insets(10, 15, 10, 15));
		content.setPadding(new Insets(5, 0, 5, 0));
		title.setAlignment(Pos.CENTER_LEFT);
		
		//Background alter
        back.setPrefWidth(root.getWidth());
        back.setPrefHeight(root.getHeight());
	    
		//Backgrounds
	    DropShadow shade = new DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.35), 20, 0, 0, 10);
	    card.setEffect(shade);
	    
		card.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), new Insets(0))));
		back.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		card.setOpacity(0);
		back.setOpacity(0);
		
		//Buttons
		yes = new MaterialButton("YES", Color.TRANSPARENT, Color.BLUE, 0);
		no = new MaterialButton("NO", Color.TRANSPARENT, Color.BLUE, 0);
		ok = new MaterialButton("OK", Color.TRANSPARENT, Color.BLUE, 0);
		cancel = new MaterialButton("CANCEL", Color.TRANSPARENT, Color.BLUE, 0);
		
		yes.setOnAction(e -> dismiss());
		no.setOnAction(e -> dismiss());
		ok.setOnAction(e -> dismiss());
		cancel.setOnAction(e -> dismiss());
		
		keyH = new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				if (e.getCode() == KeyCode.BACK_SPACE) {
					if ((buttonLayout == MaterialPrompt.YES_NO)
					||(buttonLayout == MaterialPrompt.YES_NO_CANCEL)) {
						no.fire();
						e.consume();
					}
		        }
		        if (e.getCode() == KeyCode.ENTER) {
		        	if ((buttonLayout == MaterialPrompt.YES_NO)
		        	||(buttonLayout == MaterialPrompt.YES_NO_CANCEL)) {
		        		yes.fire();
		        		e.consume();
		        	}
		        	if ((buttonLayout == MaterialPrompt.OK)
		        	||(buttonLayout == MaterialPrompt.OK_CANCEL)) {
		        		ok.fire();
		        		e.consume();
		        	}
		        }
		        if (e.getCode() == KeyCode.ESCAPE) {
		        	if ((buttonLayout == MaterialPrompt.OK_CANCEL)
		        	||(buttonLayout == MaterialPrompt.YES_NO_CANCEL)) {
			        	cancel.fire();
			        	e.consume(); 
		        	}
		        }
			}
		};
		scene.addEventHandler(KeyEvent.KEY_PRESSED, keyH);
	}
	@SuppressWarnings("unchecked")
	public void dismiss() {
		MaterialAnimation fadeCard = new MaterialAnimation(card.opacityProperty(), 1, 0, Duration.millis(150),Interpolator.LINEAR).start();
		MaterialAnimation fadeBack = new MaterialAnimation(back.opacityProperty(), 0.25, 0, Duration.millis(150),Interpolator.LINEAR).start();
		
		fadeCard.setOnFinished(e -> {
			buttonBar.getChildren().clear();
			card.getChildren().clear();
			scene.widthProperty().removeListener(wl);
			scene.heightProperty().removeListener(hl);
			scene.removeEventHandler(KeyEvent.KEY_PRESSED, keyH);
			root.getChildren().remove(card);
			
			System.gc();
		});
		fadeBack.setOnFinished(e -> root.getChildren().remove(back));
	}
	public void setTitle(String titleName) {
		title = new Title(titleName);
	}
	public void setContent(Region contentNode) {
		content = contentNode;
	}
	public void setBottomBar(Region... buttonsOrPanes) {
		buttonBar.getChildren().clear();
		buttonBar.getChildren().addAll(buttonsOrPanes);
	}
	public void setOnPressed(PromptResult button, EventHandler<ActionEvent> value) {
		if (button == PromptResult.YES) yes.setOnAction(value);
		if (button == PromptResult.NO) no.setOnAction(value);
		if (button == PromptResult.OK) ok.setOnAction(value);
		if (button == PromptResult.CANCEL) cancel.setOnAction(value);
	}
	public void show() {
		root.getChildren().addAll(back);
	    root.getChildren().add(card);
	    card.getChildren().addAll(title, content, buttonBar);
	    
	    if (buttonLayout == MaterialPrompt.OK) buttonBar.getChildren().addAll(new MaterialXFill(-1), ok);
	    if (buttonLayout == MaterialPrompt.OK_CANCEL) buttonBar.getChildren().addAll(new MaterialXFill(-1), ok, cancel);
	    if (buttonLayout == MaterialPrompt.YES_NO) buttonBar.getChildren().addAll(new MaterialXFill(-1), yes, no);
	    if (buttonLayout == MaterialPrompt.YES_NO_CANCEL) buttonBar.getChildren().addAll(new MaterialXFill(-1), yes, no, cancel);
	    
	    //Listeners
	    wl = (e -> {
        	System.out.println("Width:" + content.getHeight());
        	card.relocate((root.getWidth() - card.getPrefWidth())/2, (root.getHeight() - card.getPrefHeight())/2);
        	back.setPrefWidth(root.getWidth());
			back.setPrefHeight(root.getHeight());
        });
        scene.widthProperty().addListener(wl);
        
        hl = (e -> {
        		System.out.println("Height:" + content.getHeight());
        		card.relocate((root.getWidth() - card.getPrefWidth())/2, (root.getHeight() - card.getPrefHeight())/2);
    	    	card.setPrefHeight(card.getHeight());
    	    	back.setPrefWidth(root.getWidth());
    			back.setPrefHeight(root.getHeight());
        	}
        );
	    scene.heightProperty().addListener(hl);
	    	    
    	try {Thread.sleep(20);}
		catch(InterruptedException e) {e.printStackTrace();}
    	
	    Thread t2 = new Thread() {
	    	public void run() {
	    		card.relocate((root.getWidth() - card.getWidth())/2, (root.getHeight() - card.getHeight())/2);
	        	card.setPrefHeight(card.getHeight());
	        	
	        	new MaterialAnimation(card.opacityProperty(), 0, 1, Duration.millis(150)).start();
	        	new MaterialAnimation(back.opacityProperty(), 0, 0.25, Duration.millis(150)).start();
	    	}
    	};
    	t2.setDaemon(true);
    	Platform.runLater(t2);
	}
}