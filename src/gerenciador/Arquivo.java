/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package gerenciador;

import java.io.File;
import java.io.IOException;

public abstract class Arquivo implements Run{
	protected String nome;
	protected File data;
	
	//Construtores
	public Arquivo(){}
	public Arquivo(Pasta pasta, String caminho){
		this.data = new File(pasta.getPasta().getPath(), caminho);
		if(!data.exists()){
			try {
				data.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.nome = data.getName();
	}
	//Fim Construtores
	//Métodos
	public File getData() {
		return this.data;
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setData(File data) {
		this.data = data;
	}
	public boolean exists(){
		return this.data.exists();
	}
	public abstract void run();
	public abstract boolean criar();
}
