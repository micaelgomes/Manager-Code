/**
 * 
 * @Authors Dayvson Wilkson, Mateus Barros e Micael Gomes.
 * Copyright 2017, todos os direitos reservados.
 *  
 */

package eventus;

import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import InterfaceGrafica.*;
import gerenciador.*;


public class Informacao {
	private static Projeto projeto;
	private static Window main;
	private static boolean isprojeto;	
	private static JScrollPane content;
	private static JTree tree;
	private static Button run;
	private static Draw titleBackTree;
	private static Canvas backName;
	private static int numDotC;
	private static int numDotH;
	private static boolean isMain;
	private static JRadioButton is;
	private static JRadioButton not;
	private static ArrayList<File> arquivos;
	private static ArrayList<DefaultMutableTreeNode> arrayNos;
	private static ArrayList<String> nomes;
	private static DefaultMutableTreeNode raiz;
	private static DefaultMutableTreeNode NOadd;
	private static String nomeProjeto;
	private static String NomeNO;
	private static String directory;
	private static ImageIcon image;
	private static boolean inf = false;
	private static ArrayList<String> nomeFiles;
	private static ArrayList<DefaultMutableTreeNode> ArrayNomeFiles;
	private static String nomeNoAnt;
	private static String dirProj;

	public static String getDirProj() {
		return dirProj;
	}

	public static void setDirProj(String dirProj) {
		Informacao.dirProj = dirProj;
	}

	public static Projeto getProjeto() {
		return projeto;
	}

	public static void setProjeto(Projeto projeto) {
		Informacao.projeto = projeto;
	}

	public static Window getMain() {
		return main;
	}

	public static void setMain(Window main) {
		Informacao.main = main;
	}

	public static boolean isIsprojeto() {
		return isprojeto;
	}

	public static void setIsprojeto(boolean isprojeto) {
		Informacao.isprojeto = isprojeto;
	}

	public static JScrollPane getContent() {
		return content;
	}

	public static void setContent(JScrollPane content) {
		Informacao.content = content;
	}

	public static JTree getTree() {
		return tree;
	}

	public static void setTree(JTree tree) {
		Informacao.tree = tree;
	}

	public static Button getRun() {
		return run;
	}

	public static void setRun(Button run) {
		Informacao.run = run;
	}

	public static Draw getTitleBackTree() {
		return titleBackTree;
	}

	public static void setTitleBackTree(Draw titleBackTree) {
		Informacao.titleBackTree = titleBackTree;
	}

	public static void setTitleBackTree(String string) {
		Informacao.titleBackTree.setName(string);
	}
	
	public static Canvas getBackName() {
		return backName;
	}

	public static void setBackName(Canvas backName) {
		Informacao.backName = backName;
	}

	public static int getNumDotC() {
		return numDotC;
	}

	public static void setNumDotC(int numDotC) {
		Informacao.numDotC = numDotC;
	}

	public static int getNumDotH() {
		return numDotH;
	}

	public static void setNumDotH(int numDotH) {
		Informacao.numDotH = numDotH;
	}

	public static boolean isMain() {
		return isMain;
	}

	public static void setMain(boolean isMain) {
		Informacao.isMain = isMain;
	}

	public static JRadioButton getIs() {
		return is;
	}

	public static void setIs(JRadioButton is) {
		Informacao.is = is;
	}

	public static JRadioButton getNot() {
		return not;
	}

	public static void setNot(JRadioButton not) {
		Informacao.not = not;
	}

	public static ArrayList<File> getArquivos() {
		return arquivos;
	}

	public static void setArquivos(ArrayList<File> arquivos) {
		Informacao.arquivos = arquivos;
	}

	public static ArrayList<DefaultMutableTreeNode> getArrayNos() {
		return arrayNos;
	}

	public static void setArrayNos(ArrayList<DefaultMutableTreeNode> arrayNos) {
		Informacao.arrayNos = arrayNos;
	}

	public static ArrayList<String> getNomes() {
		return nomes;
	}

	public static void setNomes(ArrayList<String> nomes) {
		Informacao.nomes = nomes;
	}

	public static DefaultMutableTreeNode getRaiz() {
		return raiz;
	}

	public static void setRaiz(DefaultMutableTreeNode raiz) {
		Informacao.raiz = raiz;
	}

	public static DefaultMutableTreeNode getNOadd() {
		return NOadd;
	}

	public static void setNOadd(DefaultMutableTreeNode nOadd) {
		NOadd = nOadd;
	}

	public static String getNomeProjeto() {
		return nomeProjeto;
	}

	public static void setNomeProjeto(String nomeProjeto) {
		Informacao.nomeProjeto = nomeProjeto;
	}

	public static String getNomeNO() {
		return NomeNO;
	}

	public static void setNomeNO(String nomeNO) {
		NomeNO = nomeNO;
	}

	public static String getDirectory() {
		return directory;
	}

	public static void setDirectory(String directory) {
		Informacao.directory = directory;
	}

	public static ImageIcon getImage() {
		return image;
	}

	public static void setImage(ImageIcon image) {
		Informacao.image = image;
	}

	public static boolean isInf() {
		return inf;
	}

	public static void setInf(boolean inf) {
		Informacao.inf = inf;
	}

	public static ArrayList<String> getNomeFiles() {
		return nomeFiles;
	}

	public static void setNomeFiles(ArrayList<String> nomeFiles) {
		Informacao.nomeFiles = nomeFiles;
	}

	public static ArrayList<DefaultMutableTreeNode> getArrayNomeFiles() {
		return ArrayNomeFiles;
	}

	public static void setArrayNomeFiles(ArrayList<DefaultMutableTreeNode> arrayNos2) {
		ArrayNomeFiles = arrayNos2;
	}

	public static String getNomeNoAnt() {
		return nomeNoAnt;
	}

	public static void setNomeNoAnt(String nomeNoAnt) {
		Informacao.nomeNoAnt = nomeNoAnt;
	}
}
