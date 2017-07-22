/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package eventus;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class Tree implements TreeSelectionListener{
	public void valueChanged(TreeSelectionEvent e) {
		Informacao.setNOadd(new DefaultMutableTreeNode(e.getPath().getLastPathComponent()));
		//Informacao.setNomeNoAnt((String)e.getOldLeadSelectionPath().getLastPathComponent());
		Informacao.setNomeNO(Informacao.getNOadd().toString());
		System.out.println(Informacao.getNomeNO());
//		try {			
//			
//			Runtime.getRuntime().exec("subl " + Informacao.getDirectory());
//		
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		
	}
	
	public void addArvore(DefaultMutableTreeNode root, String nome){
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nome);
		root.add(newNode);
	}
}