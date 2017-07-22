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

public class Editor implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Runtime.getRuntime().exec("subl " + Informacao.getDirectory() + "/" + Informacao.getNomeNO());
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
	}

}
