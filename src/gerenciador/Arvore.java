/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package gerenciador;

import java.util.ArrayList;

public class Arvore {
	private ArrayList<No> nos;
	private int size;
	//Construtores
	public Arvore(){
		nos = new ArrayList<No>();
		size = 0;
	}
	public Arvore(ArrayList<No> tree){
		nos = tree;
		size = tree.size();
	}
	//Fim Construtores
	
	public ArrayList<No> getNos() {
		return nos;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setNos(ArrayList<No> nos) {
		this.nos = nos;
	}
	public boolean removeNo(String nome){
		for(No no : nos){
			if(no.getNome().equals(nome)){
				nos.remove(no);
				return true;
			}
		}
		return false;
	}
	public void addNo(No no){
		this.nos.add(no);
		this.size++;
	}
	public void gerarArvore(Pasta pasta){
		if(pasta.getPasta().isDirectory()){
			pasta.varrer();
			String[] nomes = pasta.listar();
			this.addNo(new No(pasta.getNome(), true));
			for(String nome : nomes){
				this.addNo(new No(pasta.getNome(), nome, false));
				this.size++;
			}
		}
	}
}
