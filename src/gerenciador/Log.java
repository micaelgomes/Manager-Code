/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package gerenciador;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Log extends Arquivo{
	private FileWriter fw;
	private BufferedWriter bw;
	
	//Construtores
	public Log(){}
	public Log(Pasta pasta, String caminho){
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
		if(!super.data.exists()){
			try{
				super.data.createNewFile();
				//Montar as informações iniciais
				return true;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
}
