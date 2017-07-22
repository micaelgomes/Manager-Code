/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package InterfaceGrafica;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Draw extends JLabel{
	private static final long serialVersionUID = 1L;
	private String mensage;
	private int width;
	private int height;
	private int x;
	private int y;
	private Color color;
	private Font font;
	
	public Draw(){}
	
	public Draw(ImageIcon image, int width, int height, int x, int y){
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;

		setBounds(this.x, this.y, this.width, this.height);
		setIcon(image);
	}
	
	public Draw(String mensage, int width, int height, int x, int y) {
		super();
		this.mensage = mensage;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		
		setBounds(this.x, this.y, this.width, this.height);
		setForeground(Color.white);
		setFont(new Font("Arial", Font.BOLD, 14));
		setText(this.mensage);
	}

	public String getMensage() {
		return mensage;
	}
	
	public void setMensage(String mensage) {
		this.mensage = mensage;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public void changeColor(int r, int g, int b){
		Color color = new Color(r, g, b);
		this.color = color;
		setForeground(this.color);
	}
	
	public void defineFont(String font, int form, int tamanho){
		if(form == 1){
			Font newFont = new Font(font, Font.PLAIN, tamanho);
			setFont(newFont);
			this.font = newFont;
		}
		if(form == 2){
			Font newFont = new Font(font, Font.BOLD, tamanho);
			setFont(newFont);
			this.font = newFont;
		}
		if(form == 3){
			Font newFont = new Font(font, Font.ITALIC, tamanho);
			setFont(newFont);
			this.font = newFont;
		}
	}
}
