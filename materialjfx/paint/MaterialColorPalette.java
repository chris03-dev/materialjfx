package materialjfx.paint;

import javafx.scene.paint.Color;

public class MaterialColorPalette {
	public static final Color 
	BLUE = Color.valueOf("#04f"),
	VIOLET = Color.valueOf("#6200ee");
	
	public static class Type {
		public static final Type
		PRIMARY   = new Type(),
		ALTERNATE = new Type();
	}
	
	public static Color col(Color color, int index) {
		Color c = Color.TRANSPARENT;
		
		if (color == Color.RED) {
			switch (index) {
				case  50: c = Color.valueOf("#FFEBEE"); break;
				case 100: c = Color.valueOf("#FFCDD2"); break; 
				case 200: c = Color.valueOf("#EF9A9A"); break;
				case 300: c = Color.valueOf("#E57373"); break;
				case 400: c = Color.valueOf("#EF5350"); break;
				case 500: c = Color.valueOf("#F44336"); break;
				case 600: c = Color.valueOf("#E53935"); break;
				case 700: c = Color.valueOf("#D32F2F"); break;
				case 800: c = Color.valueOf("#C62828"); break;
				case 900: c = Color.valueOf("#B71C1C"); break;
			}
		}
		if (color == Color.ORANGE) {
			switch (index) {
				case  50: c = Color.valueOf("#FFF3E0"); break;
				case 100: c = Color.valueOf("#FFE0B2"); break;
				case 200: c = Color.valueOf("#FFCC80"); break;
				case 300: c = Color.valueOf("#FFB74D"); break;
				case 400: c = Color.valueOf("#FFA726"); break;
				case 500: c = Color.valueOf("#FF9800"); break;
				case 600: c = Color.valueOf("#FB8C00"); break;
				case 700: c = Color.valueOf("#F57C00"); break;
				case 800: c = Color.valueOf("#EF6C00"); break;
				case 900: c = Color.valueOf("#E65100"); break;
			}
		}
		if (color == Color.YELLOW) {
			switch (index) {
				case  50: c = Color.valueOf("#FFFDE7"); break;
				case 100: c = Color.valueOf("#FFF9C4"); break;
				case 200: c = Color.valueOf("#FFF59D"); break;
				case 300: c = Color.valueOf("#FFF176"); break;
				case 400: c = Color.valueOf("#FFEE58"); break;
				case 500: c = Color.valueOf("#FFEB3B"); break;
				case 600: c = Color.valueOf("#FDD835"); break;
				case 700: c = Color.valueOf("#FBC02D"); break;
				case 800: c = Color.valueOf("#F9A825"); break;
				case 900: c = Color.valueOf("#F57F17"); break;
			}
		}
		if (color == Color.GREEN) {
			switch (index) {
				case 50:  c = Color.valueOf("#E8F5E9"); break;
				case 100: c = Color.valueOf("#C8E6C9"); break;
				case 200: c = Color.valueOf("#A5D6A7"); break;
				case 300: c = Color.valueOf("#81C784"); break;
				case 400: c = Color.valueOf("#66BB6A"); break;
				case 500: c = Color.valueOf("#4CAF50"); break;
				case 600: c = Color.valueOf("#43A047"); break;
				case 700: c = Color.valueOf("#388E3C"); break;
				case 800: c = Color.valueOf("#2E7D32"); break;
				case 900: c = Color.valueOf("#1B5E20"); break;
			}
		}
		if (color == Color.BLUE) {
			switch (index) {
				case  50: c = Color.valueOf("#E3F2FD"); break;
				case 100: c = Color.valueOf("#BBDEFB"); break;
				case 200: c = Color.valueOf("#90CAF9"); break;
				case 300: c = Color.valueOf("#64B5F6"); break;
				case 400: c = Color.valueOf("#42A5F5"); break;
				case 500: c = Color.valueOf("#2196F3"); break;
				case 600: c = Color.valueOf("#1E88E5"); break;
				case 700: c = Color.valueOf("#1976D2"); break;
				case 800: c = Color.valueOf("#1565C0"); break;
				case 900: c = Color.valueOf("#0D47A1"); break;
			}
		}
		if (color == Color.INDIGO) {
			switch (index) {
				case  50: c = Color.valueOf("#E8EAF6"); break;
				case 100: c = Color.valueOf("#C5CAE9"); break;
				case 200: c = Color.valueOf("#9FA8DA"); break;
				case 300: c = Color.valueOf("#7986CB"); break;
				case 400: c = Color.valueOf("#5C6BC0"); break;
				case 500: c = Color.valueOf("#3F51B5"); break;
				case 600: c = Color.valueOf("#3949AB"); break;
				case 700: c = Color.valueOf("#303F9F"); break;
				case 800: c = Color.valueOf("#283593"); break;
				case 900: c = Color.valueOf("#1A237E"); break;
			}
		}
		if ((color == Color.PURPLE)
		||  (color == Color.VIOLET)) {
			switch (index) {
				case  50: c = Color.valueOf("#F3E5F5"); break;
				case 100: c = Color.valueOf("#E1BEE7"); break;
				case 200: c = Color.valueOf("#CE93D8"); break;
				case 300: c = Color.valueOf("#BA68C8"); break;
				case 400: c = Color.valueOf("#AB47BC"); break;
				case 500: c = Color.valueOf("#9C27B0"); break;
				case 600: c = Color.valueOf("#8E24AA"); break;
				case 700: c = Color.valueOf("#7B1FA2"); break;
				case 800: c = Color.valueOf("#6A1B9A"); break;
				case 900: c = Color.valueOf("#4A148C"); break;
			}
		}
		
		System.out.println(c);
		return c;
	}
	
	public static Color col(Type t, Color color, int index) {
		Color c = Color.TRANSPARENT;
		if (t == Type.PRIMARY) {
			if (color == Color.BLUE) {
				switch (index) {
					case  50: c = Color.valueOf("#E3F2FD");
					case 100: c = Color.valueOf("#BBDEFB");
					case 200: c = Color.valueOf("#90CAF9");
					case 300: c = Color.valueOf("#64B5F6");
					case 400: c = Color.valueOf("#42A5F5");
					case 500: c = Color.valueOf("#2196F3");
					case 600: c = Color.valueOf("#1E88E5");
					case 700: c = Color.valueOf("#1976D2");
					case 800: c = Color.valueOf("#1565C0");
					case 900: c = Color.valueOf("#0D47A1");
				}
			}
		}
		System.out.println(c);
		return c;
	}
	public static Color rgb(int red, int green, int blue) {return Color.rgb(red, green, blue);}
	public static Color hsv(double hue, double saturation, double brightness) {return Color.hsb(hue, saturation, brightness);}
	public static Color valueOf(String hex) {return Color.valueOf(hex);}
}
