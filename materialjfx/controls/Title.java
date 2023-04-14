package materialjfx.controls;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class Title extends Label {
	public Title() {
		setFont(new Font("Roboto Bold", 15));
	}
	public Title(String text) {
		super(text);
		setFont(new Font("Roboto Bold", 15));
	}
	public Title(String text, double x, double y) {
		super(text);
		relocate(x, y);
		setFont(new Font("Roboto Bold", 15));
	}
	public Title(String text, Node graphic) {
		super(text, graphic);
		setFont(new Font("Roboto Bold", 15));
	}
	public Title(String text, Node graphic, double x, double y) {
		super(text, graphic);
		relocate(x, y);
		setFont(new Font("Roboto Bold", 15));
	}
	public Title(String text, Paint value) {
		super(text);
		setTextFill(value);
		setFont(new Font("Roboto Bold", 15));
	}
	
	public Title(String text, Paint value, double x, double y) {
		super(text);
		setTextFill(value);
		relocate(x, y);
		setFont(new Font("Roboto Bold", 15));
	}
	public Title(String text, Node graphic, Paint value) {
		super(text, graphic);
		setTextFill(value);
		setFont(new Font("Roboto Bold", 15));
	}
	
	public Title(String text, Node graphic, Paint value, double x, double y) {
		super(text, graphic);
		setTextFill(value);
		relocate(x, y);
		setFont(new Font("Roboto Bold", 15));
	}
}