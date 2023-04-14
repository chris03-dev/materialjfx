package materialjfx.controls;

import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class Depth extends DropShadow {
	double depth;
	public Depth(double depth) {
		super(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.5), 2 * depth, 0, 0, ((depth > 0) ? 1 : 0) + depth/2);
		this.depth = depth;
		if (depth < 1) this.setColor(Color.TRANSPARENT);
	}
	
	public void setDepth(double depth) {
		this.setRadius(2 * depth);
		this.setOffsetY(((depth > 0) ? 1: 0) + depth/2);
		this.depth = depth;
		if (depth < 1) this.setColor(Color.TRANSPARENT);
		else this.setColor(Color.rgb(0, 0, 0, 0.5));
	}
	
	public double getDepth() {
		return depth;
	}
}
