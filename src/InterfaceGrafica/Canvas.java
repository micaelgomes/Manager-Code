/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package InterfaceGrafica;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Canvas extends JPanel{
	private static final long serialVersionUID = 1L;
	private String canvasName;
	private int width;
	private int height;
	private int x;
	private int y;
	Color color;

	public Canvas() {}
	
	public Canvas(String canvasName, int width, int height, int x, int y) {
		super();
		this.canvasName = canvasName;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		
		setBounds(this.x, this.y, this.width, this.height);
	}
	
	public String getWindowName() {
		return canvasName;
	}
	
	public void setWindowName(String canvasName) {
		this.canvasName = canvasName;
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
	
	public void noColor(){
		setBackground(null);
	}
	public void defineColor(int r, int g, int b) {
		Color color = new Color(r, g, b);
		this.color = color;
		setBackground(this.color);
	}
	
	public void addDrawImage(Draw draw){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(draw);
	}
	
	public void addDrawButton(Button button){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(button);
	}
	
	public void generateBorder(int tamanho){
		setBackground(null);
		setBorder(BorderFactory.createLineBorder(this.color, tamanho));
	}
}
