/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package eventus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class Plus implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {	
		if(Informacao.isIsprojeto()){
			if(!Informacao.getNomeNO().equals("BIN"))
			{
				String nome = JOptionPane.showInputDialog(null, "Informe o nome:");
				
				
				File arq = new File("projetos/" + Informacao.getNomeProjeto() +"/" + nome);
				if(arq.exists()){
					System.out.println("arquivo existe!!");
					Informacao.getProjeto().addArquivo(arq);
				}else{
					try {
						arq.createNewFile();
						Informacao.getNomeFiles().add(nome);
						DefaultMutableTreeNode novonode = new DefaultMutableTreeNode(nome);
						Informacao.getArrayNos().add(novonode);
						Informacao.getNomes().add(nome);
						Informacao.getRaiz().add(novonode);
						
						JTree arvore =  new JTree(Informacao.getRaiz());
						arvore.setVisible(true);
						
						Informacao.getContent().add(arvore);
						Informacao.setTree(arvore);
						Informacao.getTree().repaint();
						Informacao.getContent().revalidate();
						Informacao.getContent().repaint();
						Informacao.getMain().update();
						
					} catch (IOException e1){
						e1.printStackTrace();
					}
				}
				
				//System.out.println("o bot plus funciona : " + x9.NomeNO + "criado");
			}else{
				JOptionPane.showMessageDialog(null,"Diretório inválido.","erro!",JOptionPane.WARNING_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null,"Você deve primeiro criar um projeto.\nSiga as instruções em README.txt","erro!",JOptionPane.WARNING_MESSAGE);
		}
	}
}
