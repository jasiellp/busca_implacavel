package com.br.search.product.tabela;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "documentService")
@ApplicationScoped
public class DocumentService
{

	public TreeNode createDocuments()
	{/*
		TreeNode root = new DefaultTreeNode(new CotacaoVeiculo("Prisma", "Carro", "Chevolet", "Gasolina","20000","2010"), null);

		TreeNode prisma = new DefaultTreeNode(new CotacaoVeiculo("Prisma", "Carro", "Chevolet", "Gasolina","20000","2010"), root);
		TreeNode corsa  = new DefaultTreeNode(new CotacaoVeiculo("Corsa",  "Carro", "Chevolet", "Gasolina","20000","2010"), root);
		TreeNode vectra = new DefaultTreeNode(new CotacaoVeiculo("Vectra", "Carro", "Chevolet", "Gasolina","20000","2010"), root);

		TreeNode work = new DefaultTreeNode(new CotacaoVeiculo("Prisma", "Carro", "Chevolet", "Gasolina","20000","2010"), prisma);
		TreeNode primefaces = new DefaultTreeNode(new CotacaoVeiculo("Prisma", "Carro", "Chevolet", "Gasolina","20000","2010"), prisma);
*/
		/*// Documents
		TreeNode expenses = new DefaultTreeNode("document", new CotacaoVeiculo("Expenses.doc", "30 KB", "Word Document"), work );
		TreeNode resume = new DefaultTreeNode("document", new CotacaoVeiculo("Resume.doc", "10 KB", "Word Document"), work);
		TreeNode refdoc = new DefaultTreeNode("document", new CotacaoVeiculo("RefDoc.pages", "40 KB", "Pages Document"), primefaces);

		// Pictures
		TreeNode barca = new DefaultTreeNode("picture", new CotacaoVeiculo("barcelona.jpg", "30 KB", "JPEG Image"), corsa);
		TreeNode primelogo = new DefaultTreeNode("picture", new CotacaoVeiculo("logo.jpg", "45 KB", "JPEG Image"), corsa);
		TreeNode optimus = new DefaultTreeNode("picture", new CotacaoVeiculo("optimusprime.png", "96 KB", "PNG Image"), corsa);

		// Movies
		TreeNode pacino = new DefaultTreeNode(new CotacaoVeiculo("Al Pacino", "-", "Folder"), vectra);
		TreeNode deniro = new DefaultTreeNode(new CotacaoVeiculo("Robert De Niro", "-", "Folder"), vectra);

		TreeNode scarface = new DefaultTreeNode("mp3", new CotacaoVeiculo("Scarface", "15 GB", "Movie File"), pacino);
		TreeNode carlitosWay = new DefaultTreeNode("mp3", new CotacaoVeiculo("Carlitos' Way", "24 GB", "Movie File"), pacino);

		TreeNode goodfellas = new DefaultTreeNode("mp3", new CotacaoVeiculo("Goodfellas", "23 GB", "Movie File"), deniro);
		TreeNode untouchables = new DefaultTreeNode("mp3", new CotacaoVeiculo("Untouchables", "17 GB", "Movie File"), deniro);*/

		return new DefaultTreeNode(new CotacaoVeiculo("Prisma", "Carro", "Chevolet", "Gasolina","20000","2010"), null);
	}



}