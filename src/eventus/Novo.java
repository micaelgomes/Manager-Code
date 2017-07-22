/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package eventus;

import java.awt.event.ActionEvent;

import gerenciador.*;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class Novo implements ActionListener{
	Projeto proj;
	
	@Override
	public void actionPerformed(ActionEvent e){
		try{
			System.out.println("string: " + e.getActionCommand()); 

			if(!Informacao.isInf()){
				String nome = JOptionPane.showInputDialog(null, "Nome do projeto.");
				Informacao.setNomeProjeto(nome);
				if(!nome.equals(null)){
					Informacao.getRaiz().removeAllChildren();
					Informacao.setNomeFiles(new ArrayList<String>());
					
					DefaultMutableTreeNode main1 = new DefaultMutableTreeNode("main.cpp");
					Informacao.getRaiz().add(main1);
					Informacao.getNomeFiles().add("main.cpp");
					Projeto projeto = new Projeto(nome);
					Informacao.setDirectory(projeto.getPasta().getPath());;
					Informacao.setNomeProjeto(nome);
					Informacao.getTitleBackTree().setText(nome);
					Informacao.getTitleBackTree().repaint();
					Informacao.setArrayNos(new ArrayList<DefaultMutableTreeNode>());
					Informacao.setProjeto(projeto);
					Informacao.setNomeNO("RAIZ");
					Informacao.setInf(true);	
					Informacao.setIsprojeto(true);
					Informacao.getTree().setVisible(true);
					Informacao.getTree().revalidate();
					Informacao.getContent().revalidate();
					Informacao.getContent().repaint();
					Informacao.getTree().repaint();
	
					File main = new File("projetos/" + Informacao.getNomeProjeto() + "/" + "main.cpp");
					if(!main.exists()){
						main.createNewFile();
					}
					FileWriter fw = new FileWriter(main);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("#include <stdio.h>\n#include <iostream>\n\n\n");
					bw.write("using namespace std;\n\n");
					bw.write("int main()\n{\n\tcout << \"C é melhor que java.\";\n\treturn 0;\n}");
					bw.close();
					fw.close();
					projeto.addArquivo(main);
					
					Informacao.getMain().update();
					
					Runtime.getRuntime().exec("gnome-terminal --geometry 41x14+409+197");
				}
			}else{
				JOptionPane.showMessageDialog(null,"Número máximo de projetos alcançado,\npara ter acesso a mais projetos obtenha a versão Pro. ");
			}
		}catch(Exception ev){
			System.err.println("eita!! erro : " + ev.getMessage());
		}
	}
}
