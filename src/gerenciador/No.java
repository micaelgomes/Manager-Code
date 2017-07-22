/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package gerenciador;


public class No {
	private String nome;
	private String nomePai;
	private boolean isPasta;
	//Construtores
	public No(){}
	public No(String nome, boolean isPasta){
		this.nome = nome;
		this.isPasta = isPasta;
	}
	public No(String nomePai, String nome){
		this.nome = nome;
		this.nomePai = nomePai;
	}
	public No(String nomePai, String nome, boolean isPasta){
		this.nome = nome;
		this.nomePai = nomePai;
		this.isPasta = isPasta;
	}
	//Fim Construtores
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public boolean isPasta() {
		return isPasta;
	}
	public void setPasta(boolean isPasta) {
		this.isPasta = isPasta;
	}
}
