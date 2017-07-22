/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

import java.awt.Dimension;
import InterfaceGrafica.*;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import eventus.*;

public class ManagerC {
	public static void main(String[] args) throws IOException {
		Runtime.getRuntime().exec("mkdir projetos");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int mainWidth = 700;
		int mainHeight = 400;
		
		Window main = new Window("Manager Code", mainWidth, mainHeight , (screen.width-mainWidth)/2, (screen.height-mainHeight)/2);
		Informacao.setMain(main);
		
		String imageProgram = "src/image/beta.png";
		main.noGrid();
		
		telaManager(main);
		splashScreen(screen);
		
		main.setIconProgram(imageProgram);
		main.onWindow();
		
		updateScreen(main);
	}
	
	public static void screenTerms(Window window){
		String image = "src/image/icon.png";
		String mensage = "Você recebeu uma licença limitada, não transferível, não exclusiva, \nlivre de royalties e revogável para baixar, instalar, executar e utilizar \neste aplicativo em seu dispositivo. Você reconhece e concorda que a \nWebnowconcede ao usuário uma licença exclusiva para uso e desta \nforma não lhe transfere os direitos sobre o produto.";
		
		window.generateBox(window ,"Bem-vindo!", mensage, image);
	}
	
	public static void updateScreen(Window window) {
		SwingUtilities.updateComponentTreeUI(window);
	}
	
	public static void splashScreen(Dimension screen){
		int width = 500;
		int height = 300;
		Screen abertura = new Screen("Abertura", 4000 , width, height, (screen.width-width)/2, (screen.height-height)/2);
		abertura.setVisible(true);
		Draw copyright = new Draw("v0.0.6", 200, 20, abertura.getWidth()-270, abertura.getHeight()-20);
		ImageIcon image = new ImageIcon("src/image/beta.png");
		Draw icone = new Draw(image, 100, 120, (abertura.getWidth()-100)/2, (abertura.getHeight()-130)/2);
		
		ImageIcon iconeLoad = new ImageIcon("src/image/load.gif");
		Draw load = new Draw(iconeLoad, 50, 50, (abertura.getWidth()-500)/2, (abertura.getHeight()+200)/2);
		
		abertura.addDraw(load);
		abertura.addDraw(icone);
		abertura.addDraw(copyright);
		abertura.defineColor(47,79,79);
		abertura.execute();
	}
	
	public static void telaBoasVindas(Window window){
		Canvas fundo = new Canvas("fundoMain", window.getWidth(), window.getHeight(), 0, 0);	
		fundo.defineColor(47,79,79);
		ImageIcon image = new ImageIcon("src/image/beta.png");
		Informacao.setImage(image);
		
		Draw icone = new Draw(image, 100, 120, 160, 120);
		
		Draw copyright = new Draw("Copyright © 2017", 200, 20, window.getWidth()-400, window.getHeight()-57);
		
		Button botaoNovo = new Button("Novo", (window.getWidth()/2)+40, (window.getHeight()/2)-105, 100, 70);
		botaoNovo.addIcon("src/image/new1.png");
		///falta fazer as destes aqui.
		Button botaoAbrir = new Button("Abrir", (window.getWidth()/2)+40, (window.getHeight()/2)+15 , 100, 70);
		botaoAbrir.addIcon("src/image/open1.png");
		
		window.addButton(botaoAbrir);
		window.addButton(botaoNovo);
		window.addDraw(copyright);
		window.addDraw(icone);
		window.addCanvas(fundo);
	}
	
	public static void telaManager(Window window){
		//Canvas vazio = new Canvas("", 0, 0, 0, 0);
		Canvas fundo = new Canvas("fundoManager", window.getWidth(), window.getHeight(), 0, 0);	
		fundo.defineColor(47,79,79);		
		
		Canvas log = buildLog(window);
		Canvas backTree = tree(window);
		Canvas center = centerInformation(window);
		Canvas top = topMenu(window);
		Canvas footer = generateFooter(window);
		
		window.gridLayout(log, backTree, center, top, footer);
		window.addCanvas(fundo);
	}
	
	public static Canvas tree(Window window){
		Canvas tree = new Canvas("Tree", 130, window.getHeight()-100, 5, 35);
		tree.defineColor(47,79,79);
		
		//Canvas backTree = new Canvas("fundoTree", 130, window.getHeight()-177, 0, 30);
		//backTree.defineColor(229, 229, 229);
		
		Canvas backName = new Canvas("fundo do titulo Tree", 130, 30, 0, 0);
		backName.defineColor(32, 53, 53);
		
		Informacao.setBackName(backName);
		String imagePlus = "src/image/plus.png";
		Button plus = new Button("plus", 24, 24, 25, window.getHeight()-85);//133
		plus.addIcon(imagePlus);
		plus.addActionListener(new Plus());
		plus.setName("plus");
		//menuBarNovo
		String imageMinus = "src/image/minus.png";
		Button minus = new Button("minus", 24, 24, 85, window.getHeight()-85);//133
		minus.addIcon(imageMinus);
		minus.addActionListener(new Minus());
		plus.setName("minus");
		
		Draw titleBackTree = new Draw("Project", 130, 20, 5, 5);
		
		titleBackTree.defineFont("Sans-Serif", 3, 14);
		titleBackTree.changeColor(255,255,255);		
		Informacao.setTitleBackTree(titleBackTree); 		
		
		/*---------------------------TREE----------------------------*/		
		
		DefaultMutableTreeNode project=new DefaultMutableTreeNode("RAIZ");  
		DefaultMutableTreeNode bin=new DefaultMutableTreeNode("BIN");  
		//DefaultMutableTreeNode header=new DefaultMutableTreeNode("HEADER"); 
		//DefaultMutableTreeNode log=new DefaultMutableTreeNode("LOG");
		//DefaultMutableTreeNode src=new DefaultMutableTreeNode("SRC");
		
		project.add(bin);  
		//project.add(header);  
		//project.add(src);
		//project.add(log);
		
		
		DefaultMutableTreeNode main=new DefaultMutableTreeNode("main.ccp");  
		DefaultMutableTreeNode err=new DefaultMutableTreeNode("waring");
		//DefaultMutableTreeNode txt=new DefaultMutableTreeNode("waring");
		project.add(main);
		bin.add(err);
		//log.add(txt);     
		
		Informacao.setRaiz(project); 
		
		JTree arvore =  new JTree(project);
		arvore.setVisible(false);
		Informacao.setTree(arvore);
		JScrollPane content = new JScrollPane(arvore);		
		content.setBounds(5, 65, 130, window.getHeight()-177);
		content.setOpaque(false);
		Informacao.setContent(content);
		
		try{
			window.add(content);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("JScrolPane");
		}
		
		/*-----------------------------------------------------------*/
		
		backName.add(titleBackTree);
		//tree.add(plus); // aqui ta o problema
		tree.add(backName);
		arvore.addTreeSelectionListener(new Tree());
		window.add(plus);
		//tree.add(minus);
		window.add(minus);
		
		//tree.add(backTree);
		
		return tree; //?
	}
	
	
	public static Canvas centerInformation(Window window){
		Canvas center = new Canvas("tela de informações", 385, window.getHeight()-110, 150, 40);
		center.noColor();
		
		return center;
	}
	
	public static Canvas generateFooter(Window window){
		Canvas footer = new Canvas("linha do footer", window.getWidth(), 30, 0, window.getHeight()-60);
		footer.defineColor(47,79,79);

		Canvas line = new Canvas("linha do footer", window.getWidth(), 3, 0, 28);
		line.defineColor(32, 53, 53);
		
		Draw copyright = new Draw("© 2017 ManagerC", 130,20,(window.getWidth()-135)/2 ,0);
		copyright.changeColor(255, 255, 255);
		copyright.defineFont("Sans-Serif", 1, 12);
		
		footer.add(copyright);
		footer.add(line);
		
		return footer;
	}
	public static Canvas topMenu(Window window){
		Canvas top = new Canvas("fundoMenuBar", window.getWidth(), 30, 0, 0);
		top.defineColor(32, 53, 53);
		
		String imageNovo = "src/image/menu1.png";
		Button novo = new Button("Novo", 24, 24, 4, 3);
		novo.addIcon(imageNovo);
		novo.addActionListener(new Novo());
		novo.setName("Novo");
		//menuBar ...
		String imageAbrir = "src/image/menu2.png";
		Button abrir = new Button("Abrir", 24, 24, 34, 3);
		abrir.addIcon(imageAbrir);
		abrir.addActionListener(new Abrir());
		abrir.setName("Abrir");
		
		String imageConf = "src/image/conf.png";
		Button conf = new Button("Conf", 24, 24, window.getWidth()-30, 3);
		conf.setName("Conf");
		conf.addIcon(imageConf);
		conf.addActionListener(new Conf());
		
		String imageEditor = "src/image/editor.png";
		Button editor = new Button("editor",  24, 24, window.getWidth()-63, window.getHeight()-85);
		editor.addIcon(imageEditor);
		editor.addActionListener(new Editor());
		editor.setName("Editor");
		
		window.add(conf);
		window.add(abrir);
		window.add(novo);
		window.add(editor);
	
		return top;
	}
		
	public static Canvas buildLog(Window window){
		Canvas log = new Canvas("Tela de Log", 143, 280, 550, 40);
		log.defineColor(47,79,79);
		
		Canvas backLogName = new Canvas("Tela de Log", 143, 35, 0, 0);
		backLogName.defineColor(32 , 53, 52);

		Canvas backLog = new Canvas("Tela de Log", 143, 210, 0, 38);
		backLog.defineColor(32 , 53, 52);
		
		Draw titleLog = new Draw("Log:", 130, 20, 5, 5);
		titleLog.defineFont("Sans-Serif", 1, 18);
		titleLog.changeColor(215, 215, 0);
		
		String imageRun = "src/image/runOff.png";
		Button run = new Button("RunButton", 24, 24, window.getWidth()-115, window.getHeight()-85); //260);
		run.addIcon(imageRun);
		run.addActionListener(new Runb());
		Informacao.setRun(run);
		
		window.add(run);
		
		backLogName.add(titleLog);
		log.add(backLogName);
		log.add(backLog);
		//log.add(run);
		
		return log;
	}
}