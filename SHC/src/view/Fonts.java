package view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.FileInputStream;
import java.io.IOException;

public class Fonts {
public static void installFonts() throws FontFormatException, IOException{
	GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
	e.registerFont(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("art/Basset RR Four.ttf")));
}
}
