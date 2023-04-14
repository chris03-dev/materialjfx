package materialjfx.animation;

import javafx.animation.Interpolator;


public class MaterialAnimationType extends Interpolator {
	public static final Interpolator
	LINEAR = (MaterialAnimationType) new MaterialAnimationType() {
		protected double curve(double t) {
			return t;
		}
	}, 
	EASE_IN = (MaterialAnimationType) new MaterialAnimationType() {
		protected double curve(double t) {
			if (t < 0.5) 
				t = t + t/0.5;
			return t;
		}
	}, 
	EASE_OUT = (MaterialAnimationType) new MaterialAnimationType() {
		protected double curve(double t) {
			return t;
		}
	},/*
	SHARP_IN = new FrameControl() {
		protected double curve(double t) {
			//if (t == 1) 
			return (t == 1) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
		}
	},
	SHARP_OUT = new FrameControl() {
		protected double curve(double t) {
			return (t == 1) ? 1.0 : Math.pow(2, -10 * (1 - t));
		}
	},
	SHARP_IN = new FrameControl() {
		protected double curve(double t) {
			return (t <= 0.3) ?
				(10.0/3.0) * Math.pow(t, 2):
				(-10.0/7.0) * Math.pow(t - 1.0, 2.0) + 1.0;
		}
	},
	SHARP_OUT = new FrameControl() {
		protected double curve(double t) {
			return (t <= 0.7) ? 
				(10.0/7.0) * Math.pow(t, 2): 
				(-10.0/3.0) * Math.pow(t - 1.0, 2.0) + 1.0;
		}
	},*/
	SHARP_IN = new MaterialAnimationType() {
		protected double curve(double t) {
			return (t <= 0.3) ?
				(100.0/9.0) * Math.pow(t, 3):
				2.041 * Math.pow(t - 1.0, 3.0) + 1.0;
		}
	},
	SHARP_OUT = new MaterialAnimationType() {
		protected double curve(double t) {
			return (t <= 0.7) ? 
				2.041 * Math.pow(t, 3): 
				(100.0/9.0) * Math.pow(t - 1.0, 3.0) + 1.0;
		}
	},
	DISCRETE = (MaterialAnimationType) new MaterialAnimationType() {
		protected double curve(double t) {
			return (t == 1) ? 1 : 0;
		}
	};
	public MaterialAnimationType() {}

	@Override
	protected double curve(double t) {
		return t;
	}
}
