/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package gerenciador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Pasta{
	private String nome;
	private File pasta;
	private ArrayList<Arquivo> arquivos;
	private int numArquivos = 0;
	private Arvore tree;
	//Construtores
	public Pasta(){
		arquivos = new ArrayList<Arquivo>();
		tree = new Arvore();
	}
	public Pasta(String caminho){
		tree = new Arvore();
		this.pasta = new File(caminho);
		if(!this.pasta.exists()){
			pasta.mkdir();
		}
		this.nome = pasta.getName();
		this.arquivos = new ArrayList<Arquivo>();
	}
	public Pasta(String caminho, ArrayList<Arquivo> arquivos){
		tree = new Arvore();
		this.pasta = new File(caminho);
		if(!pasta.exists()){
			pasta.mkdir();
		}
		this.nome = pasta.getName();
		this.arquivos = arquivos;
	}
	public Pasta(File pai, String caminho){
		tree = new Arvore();
		this.pasta = new File(pai, caminho);
		if(!this.pasta.exists()){
			pasta.mkdir();
		}
		this.nome = pasta.getName();
		this.arquivos = new ArrayList<Arquivo>();
	}
	//Fim Construtores
	//Metodos
	
	public Arvore getTree() {
		return tree;
	}
	public void setTree(Arvore tree) {
		this.tree = tree;
	}
	public String getNome() {
		return nome;
	}
	public File getPasta() {
		return pasta;
	}
	public void setPasta(File pasta) {
		this.pasta = pasta;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumArquivos() {
		return numArquivos;
	}
	public void setNumArquivos(int numArquivos) {
		this.numArquivos = numArquivos;
	}
	public ArrayList<Arquivo> getArquivos() {
		return arquivos;
	}
	public void setArquivos(ArrayList<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}
	public boolean addArquivo(Arquivo arquivo){
		if(this.arquivos.add(arquivo)){
			(this.numArquivos)++;
			return true;	
		}
		return false;
	}
	public boolean removeArquivo(String nome){
		for(Arquivo arq : arquivos){
			if(arq.getNome().equals(nome)){
				this.arquivos.remove(arq);
				return true;
			}
		}
		return false;
	}
	public Arquivo buscaArquivo(String nome){
		for(Arquivo arq : arquivos){
			if(arq.getNome().equals(nome)){
				return arq;
			}
		}
		return null;
	}
	public boolean abrirArquivo(String nome){
		for(Arquivo arq : arquivos){
			if(arq.getNome().equals(nome)){
				try {
					Runtime.getRuntime().exec("subl "+this.pasta.getPath()+File.separator+nome);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}
	public boolean exists(){
		return this.pasta.exists();
	}
	public void varrer(){
		String[] arqs;
		if(pasta.exists()){
			if(pasta.isDirectory()){
				arqs = pasta.list();
				for(String nome : arqs){
					if(this.nome.equals("src")){
						Codigo c = new Codigo(this, nome);
						addArquivo(c);
					}else if(this.nome.equals("header")){
						Header h = new Header(this, nome);
						addArquivo(h);
					}else if(this.nome.equals("log")){
						Log l = new Log(this, nome);
						addArquivo(l);
					}else{
						/*
						 * IMPLEMENTAR A VARREDURA NO BIN 
						 * 
						 */
						System.out.println("PEGANDO OS .O DA PASTA BIN!");
					}
				}
			}
		}
	}
	public String[] listar(){
		if(this.pasta.isDirectory()){
			return pasta.list();
		}
		return null;
	}
	public ArrayList<No> gerarArvore(){
		this.tree.gerarArvore(this);
		return this.tree.getNos();		
	}
}
