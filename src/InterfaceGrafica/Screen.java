/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package InterfaceGrafica;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class Screen extends JWindow{
	private static final long serialVersionUID = 1L;
	private String mensage;
	private int time;
	private int width;
	private int height;
	private int x;
	private int y;
	private Color color;
	
	public Screen(){}
	
	public Screen(int time){
		super();
		this.time = time;
		
	}
	
	public Screen(String mensage, int time, int width, int height, int x, int y){
		super();
		this.mensage = mensage;
		this.time = time;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		setBounds(this.x, this.y, this.width, this.height);
		setVisible(true);
	}
	
	public String getMensage() {
		return mensage;
	}
	
	public void setMensage(String screenName) {
		this.mensage = screenName;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
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
	
	public void defineColor(int r, int g, int b){
		Color color = new Color(r, g, b);
		this.color = color;
		setBackground(this.color);
	}

	public void addDraw(Draw draw){
		add(draw);
	}
	
	private void splashScren(){
		JPanel content = (JPanel) getContentPane();
		content.setBackground(getColor());
		
		try{ 
			Thread.sleep(this.time); 
		}catch(Exception e){
			
		}
		
        setVisible(false);
	}
	
	 public void execute() {        
		 splashScren();
		 dispose();     
	 }
}
