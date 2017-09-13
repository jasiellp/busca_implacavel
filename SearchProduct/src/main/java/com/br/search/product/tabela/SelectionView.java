package com.br.search.product.tabela;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.TreeNode;

@ManagedBean(name = "ttSelectionView")
@ViewScoped
public class SelectionView implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8478733404040479791L;
	
	
	private TreeNode root1; 

	private TreeNode selectedNode; 

	@ManagedProperty("#{documentService}")
	private DocumentService service;

	@PostConstruct
	public void init()
	{
		root1 = service.createDocuments(); 
	}

	public TreeNode getRoot1()
	{
		return root1;
	}
	public void setRoot1(TreeNode root1)
	{
		this.root1 = root1;
	}

 
	public TreeNode getSelectedNode()
	{
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode)
	{
		this.selectedNode = selectedNode;
	}

	 

	public void setService(DocumentService service)
	{
		this.service = service;
	}

	public void displaySelectedSingle()
	{
		if (selectedNode != null)
		{
			FacesMessage message = new FacesMessage(
			        FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString()
			);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	 
}