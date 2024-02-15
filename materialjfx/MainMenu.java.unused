package pack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;

import javafx.animation.Interpolator;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import materialjfx.controls.*;
import materialjfx.layout.*;
import materialjfx.layout.HFill;

public class MainMenu extends Application {
	public static void main(String[] args) {launch(args);}
	public void init(Stage st) {
		//Stage
		st.setMinWidth(480);
		st.setMinHeight(360);
		
		//Font
		Font.loadFont(getClass().getResourceAsStream("fonts/Roboto-Regular.ttf"), 16);
    	Font.loadFont(getClass().getResourceAsStream("fonts/Roboto-Medium.ttf"), 16);
    	Font.loadFont(getClass().getResourceAsStream("fonts/Roboto-Bold.ttf"), 16);
    	
    	st.setTitle("PSHS-WVC E-LEARNING MANAGEMENT TOOL");
		//st.setOpacity(0.9);
	}
	private Image resample(Image input, int scaleFactor) {
	    final int W = (int) input.getWidth();
	    final int H = (int) input.getHeight();
	    final int S = scaleFactor;
	    
	    WritableImage output = new WritableImage(
	      W * S,
	      H * S
	    );
	    
	    PixelReader reader = input.getPixelReader();
	    PixelWriter writer = output.getPixelWriter();
	    
	    for (int y = 0; y < H; y++) {
	      for (int x = 0; x < W; x++) {
	        final int argb = reader.getArgb(x, y);
	        for (int dy = 0; dy < S; dy++) {
	          for (int dx = 0; dx < S; dx++) {
	            writer.setArgb(x * S + dx, y * S + dy, argb);
	          }
	        }
	      }
	    }
	    
	    return output;
	  }

	public void start(Stage st) {
		init(st);
		
		//Images
    	Image imgAdd = new Image(getClass().getResourceAsStream("outline_add_black_18dp.png"));
    	ImageView imgvAdd = new ImageView(resample(imgAdd, 6));
    	imgvAdd.setFitWidth(18);
    	imgvAdd.setFitHeight(18);
		
		//Panes
    	Root root = new Root();
    	Scene sc = new Scene(root, 720, 480);
    	st.setScene(sc);
    	
    	Room mainmenu = new Room();
    	ScrollPane sPane = new ScrollPane();
    	sPane.setHbarPolicy(ScrollBarPolicy.NEVER);
    	Pane mPane = new Pane();
    	
    	AppBar title = new AppBar(new Title("Main Menu", Color.WHITE));
    	TextField txf = new TextField();
    	MaterialButton Auto = new MaterialButton("Auto Update");
    	MaterialButton newLF = new MaterialButton("New Log File");
    	MaterialButton newDF = new MaterialButton("New Define File");
    	MaterialButton newCMD = new MaterialButton("Utilize Command Prompt");
    	
    	txf.setOnAction(e -> {
    		Runtime rtx = Runtime.getRuntime();
    		String com = txf.getText();
    		try {
				rtx.exec(com);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	});
    	
    	Auto.setOnAction(e -> {
    		Runtime rt = Runtime.getRuntime();
    		try {
    			rt.exec("IF NOT EXIST C:\\Users\\NUL ECHO C:\\FOLDER here.");
    		}
    		catch (Exception xe) {}
    		
    		File f1 = new File("C:/ELS/testthisthing.txt");
    		File f2 = new File("C:/ELS/titledefinitions.txt");
    		
    		String lns1 = OffLoader.readFromFile(f1);
    		String lns2 = OffLoader.readFromFile(f2);
    		String[] lnsarr1 = lns1.split("\n|:");
    		String[] lnsarr2 = lns2.split("\n|:");
    		
    		Label lx1 = new Label("NAMES AND PASSWORDS\n");
    		Label lx2 = new Label("NAMES AND PASSWORDS\n");
    		lx2.relocate(400, 0);
    		mPane.getChildren().add(lx1);
    		mPane.getChildren().add(lx2);
    		for (int i = 0; i < lnsarr1.length; i++) {
    			if (i % 2 == 0) 
    				lx1.setText(lx1.getText() + "Name: " + lnsarr1[i] + "			");
    			else lx1.setText(lx1.getText() + "Pass: " + lnsarr1[i] + "			\n");
    		}
    		
    		/*
    		//Pull names
			//0 for name
			//1 for password
    		for (int i = 0; i < lnsarr1.length; i += 2) {
    		} 
    		 */
    		for (int i = 0; i < lnsarr2.length; i++) {
    			if (i % 3 == 0) 
    				lx2.setText(lx2.getText() + "Define: " + lnsarr2[i] + "			");
    			else if (i % 3 == 1) 
    				lx2.setText(lx2.getText() + "Description: " + lnsarr2[i] + "			");
    			else lx2.setText(lx2.getText() + "Image: " + lnsarr2[i] + "			\n");
    		}
    	});
    	
    	newLF.setOnAction(e -> {
    		FileChooser fileC = new FileChooser();
    		File f = fileC.showOpenDialog(st);
    		System.out.println(f);
    		
    		String lns = OffLoader.readFromFile(f);
    		String[] lnsarr = lns.split("\n|:");
    		
    		Label lx = new Label("NAMES AND PASSWORDS\n");
    		mPane.getChildren().add(lx);
    		for (int i = 0; i < lnsarr.length; i++) {
    			if (i % 2 == 0) 
    				lx.setText(lx.getText() + "Name: " + lnsarr[i] + "			");
    			else lx.setText(lx.getText() + "Pass: " + lnsarr[i] + "			\n");
    		}
    		
    		try {
    			System.out.println(Files.readAllLines(Paths.get(f.getPath())));
    			System.out.println(lns);
    		}
    		catch (IOException e1) {}
    	});
    	
    	
    	newDF.setOnAction(e -> {
    		FileChooser fileC = new FileChooser();
    		File f = fileC.showOpenDialog(st);
    		
    		String lns = OffLoader.readFromFile(f);
    		String[] lnsarr = lns.split("\n|:");
    		
    		Label lx = new Label("DEFINITIONS AND DESCRIPTIONS\n");
    		lx.relocate(400, 0);
    		
    		mPane.getChildren().add(lx);
    		for (int i = 0; i < lnsarr.length; i++) {
    			if (i % 3 == 0) 
    				lx.setText(lx.getText() + "Define: " + lnsarr[i] + "			");
    			else if (i % 3 == 1) 
    				lx.setText(lx.getText() + "Description: " + lnsarr[i] + "			");
    			else lx.setText(lx.getText() + "Image: " + lnsarr[i] + "			\n");
    		}
    		
    		try {
    			System.out.println(Files.readAllLines(Paths.get(f.getPath())));
    			System.out.println(lns);
    			//mPane.getChildren().add(new Label(lns));
    		}
    		catch (IOException e1) {}
    	});
    	
    	newCMD.setOnAction(e -> {
	    	Runtime rt = Runtime.getRuntime();
	        try {
	        	//rt.exec("cmd /C start cd \"C:/Users/Aspire ES14/Google Drive/Personal/Programming\"");
	        	//rt.exec("cmd /C java -jar \"C:/Users/Aspire ES14/Google Drive/Personal/Programming/Java/materialjfx-0.1.1demo.jar\"");
	        	//rt.exec("cmd /C start java -jar \"C:/Users/Aspire ES14/Google Drive/Personal/Programming/Java/materialjfx-0.1.1demo.jar\"");
	        	rt.exec("cmd /K start java -jar \"C:/Users/Aspire ES14/Google Drive/Personal/Programming/Java/materialjfx-0.1.1demo.jar\"; start cd c:");
	        	//rt.exec("cmd /K start cd \"C:/Users\"");
	        	//rt.exec("cmd /k java -jar materialjfx-0.1.1demo.jar");
	        } catch (IOException ex) {ex.printStackTrace();}
	    });
    	
    	title.getChildren().addAll(new HFill(-1), Auto, newLF, newDF, newCMD);
    	mainmenu.setBottom(txf);
    	sPane.setContent(mPane);
    	root.getChildren().addAll(mainmenu);
    	
    	mainmenu.setTop(title);
    	mainmenu.setCenter(sPane);
    	
		st.show();
	}
}
