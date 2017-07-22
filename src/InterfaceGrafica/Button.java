/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package InterfaceGrafica;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton {
	private static final long serialVersionUID = 1L;
	private String nameButton;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Button(){}
	
	public Button(String nameButton, int width, int height, int x, int y) {
		super();
		this.nameButton = nameButton;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		setText(this.nameButton);
		this.setName(this.nameButton); // faltava isto!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		setBounds(this.x, this.y, this.width, this.height);
		setBorderPainted(false);
		setBackground(null);
		setOpaque(false);
		setContentAreaFilled(false);
		System.out.println("nome segundo a func: " + this.getName());
	}

	public String getNameButton() {
		return nameButton;
	}
	public void setNameButton(String nameButton) {
		this.nameButton = nameButton;
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

	public void addIcon(String directory) {
		setText(null);
		setIcon(null);
		ImageIcon icon = new ImageIcon(directory);
		setIcon(icon);
	}
}
