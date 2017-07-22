/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package gerenciador;

import java.io.File;
import java.util.ArrayList;
import eventus.*;

public class Projeto {
	
	private File pasta;
	private String nome;
	private ArrayList<File> arquivos;
	private ArrayList<String> nomes;
	
	public Projeto(String nome){
		this.arquivos = new ArrayList<File>();
		this.nomes = new ArrayList<String>();
		Informacao.setArquivos(this.arquivos);;
		Informacao.setNomes(this.nomes);
		this.pasta = new File("projetos/" + nome);
		this.setNome(nome);
		Informacao.setNomeProjeto(nome);
		File bin = new File(pasta,"bin");
		if(!pasta.exists()){
			pasta.mkdir();
			if(!bin.exists()){
				bin.mkdir();
			}else{
				System.out.println("bin ja existe!!!!!!!!!!");
			}
			
		}else{
			System.out.println("pasta do programa ja existe!!!!!!!!!!");
		}

	}
	
	public ArrayList<File> getArquivos(){
		return this.arquivos;
	}

	public void addArquivo(File f){
		this.arquivos.add(f);
	}
	
	
	public boolean deleteFile(File arq, String dele){
		for(File aux : this.arquivos){
			if(aux.getName().equals(dele)){
				aux.delete();
				return true;
			}
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public File getPasta() {
		return pasta;
	}

	public void setPasta(File pasta) {
		this.pasta = pasta;
	}
	
	
}
