/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package gerenciador;


public class Codigo extends Arquivo{
	private boolean isMain;

	//Construtores
	public Codigo(){}
	public Codigo(Pasta pasta, String caminho){
		super(pasta, caminho);
		isMain = false;
	}
	public Codigo(Pasta pasta, String caminho, boolean isMain){
		super(pasta, caminho);
		this.isMain = isMain;
	}
	//Fim Construtores
	//Métodos
	public boolean isMain() {
		return isMain;
	}

	public void setIsMain(boolean isMain) {
		this.isMain = isMain;
	}
	@Override	
	public boolean criar(){
		if(!data.exists()){
			try{
				data.createNewFile();
				return true;
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		return false;
	}
	public void run(){
		System.out.println("Compilando Código!");
	}
}
