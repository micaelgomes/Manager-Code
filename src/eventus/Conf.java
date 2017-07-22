/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package eventus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Conf implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(null,"Para ter acesso as configurações você deve \nadquirir a versão Pro °($_$)°.");
		System.out.println("o bot conf funciona");
		log("projetos/"+Informacao.getNomeProjeto()+"/relatorio_"+Informacao.getNomeProjeto() + ".txt");
	}
	
	public static void log(String local){
		File f = new File(local);
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(f, true);
			bw = new BufferedWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Date data = new Date();
		try {
			int year = data.getYear();
			int mes = data.getMonth();
			int dia = data.getDay();
			year+=1900;
			//bw.write("teste.");
			bw.write("--- "+year+"/"+mes+"/"+dia+" "+data.getHours()+":"+data.getMinutes()+":"+data.getSeconds()+" ---");
			bw.newLine();
			ArrayList<String> strings = Informacao.getNomeFiles();
			for(String s : strings){
				bw.write(s);
				bw.newLine();
			}
			
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	public static void makeFile(ArrayList<File> arquivos){
		File make = new File("makefile");
		if(!make.exists()){
			try {
				make.createNewFile();
				FileWriter fw = new FileWriter(make);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("hellomake: ");
				bw.newLine();
				bw.write("g++ -o exec ");
				for(File x : arquivos){
					bw.write(x.getPath()+ " ");
				}
				bw.close();
				fw.close();
				Runtime.getRuntime().exec("make");
				Runtime.getRuntime().exec("./exec");
				Runtime.getRuntime().exec("rm exec");
			} catch (IOException e) {
				e.printStackTrace();
				
			}
		}
	}
}

