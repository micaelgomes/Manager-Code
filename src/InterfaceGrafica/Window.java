/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package InterfaceGrafica;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	private String windowName;
	private int width;
	private int height;
	private int x;
	private int y;
	
	public Window() {}
	
	public Window(String windowName, int width, int height, int x, int y) {
		super();
		this.windowName = windowName;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		
		setTitle(this.windowName);
		setBounds(this.x, this.y, this.width, this.height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getWindowName() {
		return windowName;
	}
	public void setWindowName(String windowName) {
		this.windowName = windowName;
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
	
	public void clearAll(){
		getContentPane().removeAll();
	}
	
	public void onWindow(){
		setVisible(true);
	}
	
	public void offWindow(){
		setVisible(false);
	}
	
	//DIALOG BOX
	public void generateBox(Window window, String boxName, String mensage, String image) {
		JOptionPane.showMessageDialog(window, mensage, boxName,  JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image));
	}
	
	//GRID
	public void noGrid() {
		setLayout(null);
	}
	
	public void gridLayout(Canvas right, Canvas left, Canvas center, Canvas top, Canvas bottom){
		add(right, BorderLayout.EAST);
		add(left, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(top, BorderLayout.NORTH);
		add(bottom, BorderLayout.EAST);
	}
	
	public void gridLayout(Draw right, Draw left, Draw center, Draw top, Draw bottom){
		add(right, BorderLayout.EAST);
		add(left, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(top, BorderLayout.NORTH);
		add(bottom, BorderLayout.EAST);
	}
	public void update(){
		SwingUtilities.updateComponentTreeUI(this);
	}
	//BUTTON
	public void addButton(Button button) {
		add(button);
	}
	
	//LABEL
	public void addDraw(Draw mensage) {
		add(mensage);
	}

	//PANEL
	public void addCanvas(Canvas canvas) {
		add(canvas);
	}

	public void setIconProgram(String directory) throws IOException {
		setIconImage(ImageIO.read(new File(directory)));
	}

	public void getEstou() {
		System.out.println("estou na main *-*");
	}
}
