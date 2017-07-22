/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package gerenciador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Header extends Arquivo{
	private FileWriter fw;
	private BufferedWriter bw;
	
	//Construtores
	public Header(){}
	public Header(Pasta pasta, String caminho){
		super(pasta, caminho);
	}
	//Fim Construtores
	public FileWriter getFw() {
		return fw;
	}
	public void setFw(FileWriter fw) {
		this.fw = fw;
	}
	public BufferedWriter getBw() {
		return bw;
	}
	public void setBw(BufferedWriter bw) {
		this.bw = bw;
	}
	
	@Override
	public void run(){}
	public boolean criar(){
		try {
			this.fw = new FileWriter(this.data);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		this.bw = new BufferedWriter(this.fw);
		try {
			bw.write("#ifndef "+this.nome);
			bw.newLine();
			bw.write("#define "+this.nome);
			bw.newLine();
			bw.newLine();
			bw.write("#endif");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		try {
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
