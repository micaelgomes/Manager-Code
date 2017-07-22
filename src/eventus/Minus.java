/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package eventus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTree;

public class Minus implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!Informacao.isIsprojeto()){
			JOptionPane.showMessageDialog(null,"Você não tem o que deletar!\nSiga o tutorial em README.txt","erro!",JOptionPane.WARNING_MESSAGE);
		}else{
			
			for(int i=0; i < Informacao.getNomes().size() ; i++){
				if(Informacao.getNomes().get(i).equals(Informacao.getNomeNO())){
					try {
						Runtime.getRuntime().exec("rm projetos/"+Informacao.getNomeProjeto() +"/"+ Informacao.getNomeNO());
					}catch(IOException e1) {
						e1.printStackTrace();
					}
					
					Informacao.getRaiz().remove(Informacao.getArrayNos().get(i));
				}
			}
			JTree arvore =  new JTree(Informacao.getRaiz());
			arvore.setVisible(true);
			
			
			Informacao.getContent().remove(Informacao.getTree());
			Informacao.getContent().add(arvore);
			Informacao.getContent().revalidate();
			Informacao.getContent().repaint();
			Informacao.getMain().update();
		}
	}
}
