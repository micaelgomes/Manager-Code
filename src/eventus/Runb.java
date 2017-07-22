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
import javax.swing.JOptionPane;

public class Runb implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nameButtoOn = "src/image/runOn.png";
		Informacao.getRun().addIcon(nameButtoOn);
		System.out.println(Informacao.getNomeProjeto());
		compilar("projetos/"+Informacao.getNomeProjeto());
		
			
		Informacao.getMain().update();
	}
	public void compilar(String local){
		File f = new File(local);
		String []strs = f.list();
		String comando = "";
		for(int i=0; i<strs.length; i++){
			if(strs[i].contains(".cpp") && !strs[i].contains("main")){
				System.out.println(strs[i]);
				comando += strs[i] + " ";
			}
		}
		try {
			Runtime.getRuntime().exec("g++ "+"projetos/"+Informacao.getNomeProjeto()+"/main.cpp "+comando+" -o projetos/"+Informacao.getNomeProjeto()+"/bin/exec");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro de compilação, reveja seu código.");
		}
}
}