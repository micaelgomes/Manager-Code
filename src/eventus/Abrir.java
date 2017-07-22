/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package eventus;

import gerenciador.Projeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.tree.DefaultMutableTreeNode;

public class Abrir implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		try{
			
			String userDir = System.getProperty("user.home");
			Informacao.setDirProj(userDir + "/eclipse-luna/ManagerC_final/projetos");
			JFileChooser jfc = new JFileChooser(userDir + "/eclipse-luna/ManagerC_final/projetos");
			
			int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					Informacao.setDirectory(selectedFile.getAbsolutePath());
				}
				
			Informacao.getRaiz().removeAllChildren();
				
			pegaNomes(Informacao.getDirectory());	
				
			
			Informacao.setNomeProjeto(Informacao.getNomeProjeto());
			Informacao.setTitleBackTree(Informacao.getNomeProjeto());
			Informacao.getTitleBackTree().setText(Informacao.getNomeProjeto());
			Informacao.getTitleBackTree().repaint();
			Informacao.setArrayNos(new ArrayList<DefaultMutableTreeNode>());
			
			Projeto projeto = new Projeto(Informacao.getNomeProjeto());
			Informacao.setProjeto(projeto);
			Informacao.setIsprojeto(true);			
			
			//DefaultMutableTreeNode bin = new DefaultMutableTreeNode("BIN");
			//DefaultMutableTreeNode wrg = new DefaultMutableTreeNode("waring");
			//DefaultMutableTreeNode main = new DefaultMutableTreeNode("main.cpp");
			//bin.add(wrg);
			//Informacao.getRaiz().add(bin);
			//Informacao.getRaiz().add(main);

			Informacao.getTree().setVisible(true);
			Informacao.getTree().revalidate();
			Informacao.getTree().repaint();
			Informacao.getContent().revalidate();
			Informacao.getContent().repaint();
			Informacao.getMain().update();
			
			Runtime.getRuntime().exec("gnome-terminal --geometry 41x14+409+197");
			
		}catch(Exception ev){
			System.err.println("Arquivo! erro : " + ev.getMessage());
		}
	}
	
	public void pegaNomes(String local){		
		String []tokens = local.split("/");
		//int num = tokens.length;
		
		String myString = new String();
		for(int i=0; i<tokens.length-1; i++){
			myString += tokens[i];
			myString += "/";
		}
		File f = new File(myString);
		if(f.isDirectory()){
			String []nomes = f.list();
			ArrayList<String> array = new ArrayList<String>();
			for(int i=0; i<nomes.length; i++){
				array.add(nomes[i]);
			}
			
			for(String str : array){
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(str);
				DefaultMutableTreeNode wrg = new DefaultMutableTreeNode("waring");
				
				if(node.toString().equals("bin")){
					node.add(wrg);
				}
				
				Informacao.getRaiz().add(node);
			}
			
			Informacao.setDirectory(myString);
			Informacao.setNomeFiles(array);			
			Informacao.setNomeProjeto(f.getName());	
		}
	}
}
