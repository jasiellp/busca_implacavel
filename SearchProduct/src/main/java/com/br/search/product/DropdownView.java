package com.br.search.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.br.search.product.util.Arquivo;
import com.br.search.product.util.MarcaVeiculo;
import com.br.search.product.util.ModeloAnoVeiculo;
import com.br.search.product.util.ModeloVeiculo;

@ManagedBean
@ViewScoped
public class DropdownView implements Serializable
{
	private static final long serialVersionUID = -5217446585419927326L;
	
	
	private Map<String, ArrayList<MarcaVeiculo>> data = new HashMap<String, ArrayList<MarcaVeiculo>>();
	private Map<String, ArrayList<ModeloVeiculo>> data_modelo = new HashMap<String, ArrayList<ModeloVeiculo>>();
	private Map<String, ArrayList<ModeloAnoVeiculo>> modelo_ano = new HashMap<String, ArrayList<ModeloAnoVeiculo>>();

	private String tipo;

	private String marca;

	private String modelo;

	private String ano_de;

	private ArrayList<String> marcas;

	private ArrayList<String> modelos;

	private ArrayList<String> anos_de;

	private ArrayList<String> tipos;
	private boolean vizivel;
	private String labelAno;
	private String labelMarca;
	private String labelModelo;
	private String labelPreco;
	private String labelCombustivel;
	private String sId;
	private String sIdModelo;

	 

	@SuppressWarnings("restriction")
	@PostConstruct
	public void init()
	{
		tipos = new ArrayList<String>();
		marcas = new ArrayList<String>();
		modelos = new ArrayList<String>();
		anos_de = new ArrayList<String>();

		tipos.add("Carro");
		tipos.add("Moto");
		tipos.add("Caminhao");

		if (data.get("Carro") == null)
		{
			data.put("Carro", Arquivo.getMarcaCarros());
		}
		if (data.get("Moto") == null)
		{
			data.put("Moto", Arquivo.getMarcaMotos());
		}
		if (data.get("Caminhao") == null)
		{
			data.put("Caminhao", Arquivo.getMarcaCaminhoes());
		}
	}

	public Map<String, ArrayList<MarcaVeiculo>> getData()
	{
		return data;
	}

	public String getMarca()
	{
		return marca;
	}

	public void setMarca(String marca)
	{
		this.marca = marca;
	}

	public String getModelo()
	{
		return modelo;
	}

	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}

	public String getAno_de()
	{
		return ano_de;
	}

	public void setAno_de(String ano_de)
	{
		this.ano_de = ano_de;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public ArrayList<String> getTipos()
	{
		return tipos;
	}

	public void setTipos(ArrayList<String> tipos)
	{
		this.tipos = tipos;
	}

	public ArrayList<String> getMarcas()
	{
		return marcas;
	}

	public ArrayList<String> getModelos()
	{
		return modelos;
	}

	public ArrayList<String> getAnos_de()
	{
		return anos_de;
	}

	public void setAnos_de(ArrayList<String> anos_de)
	{
		this.anos_de = anos_de;
	}

	public Map<String, ArrayList<ModeloVeiculo>> getData_modelo()
	{
		return data_modelo;
	}

	public void setData_modelo(Map<String, ArrayList<ModeloVeiculo>> data_modelo)
	{
		this.data_modelo = data_modelo;
	}

	public String getLabelAno()
	{
		return labelAno;
	}

	public void setLabelAno(String labelAno)
	{
		this.labelAno = labelAno;
	}

	public String getLabelMarca()
	{
		return labelMarca;
	}

	public void setLabelMarca(String labelMarca)
	{
		this.labelMarca = labelMarca;
	}

	public String getLabelModelo()
	{
		return labelModelo;
	}

	public void setLabelModelo(String labelModelo)
	{
		this.labelModelo = labelModelo;
	}

	public String getLabelPreco()
	{
		return labelPreco;
	}

	public void setLabelPreco(String labelPreco)
	{
		this.labelPreco = labelPreco;
	}

	public String getLabelCombustivel()
	{
		return labelCombustivel;
	}

	public void setLabelCombustivel(String labelCombustivel)
	{
		this.labelCombustivel = labelCombustivel;
	}

	public static long getSerialversionuid()
	{
		return -5217446585419927326L;
	}

	public void setData(Map<String, ArrayList<MarcaVeiculo>> data)
	{
		this.data = data;
	}

	public void setMarcas(ArrayList<String> marcas)
	{
		this.marcas = marcas;
	}

	public void setModelos(ArrayList<String> modelos)
	{
		this.modelos = modelos;
	}

	public boolean isVizivel()
	{
		return vizivel;
	}

	public void setVizivel(boolean vizivel)
	{
		this.vizivel = vizivel;
	}

	public void onMarcaChange()
	{
		 
		if ((marca != null) && (!marca.equals("")))
		{
			if ((tipo != null) && (!tipo.equals("")))
			{
				 
				 
				if (tipo.equalsIgnoreCase("Carro"))
				{
					ArrayList<MarcaVeiculo> aVeiculo =   data.get(tipo);

					String sId = null;

					for (MarcaVeiculo mveiculo :aVeiculo)
					{
					 

						if (mveiculo.getNomeMarca().equalsIgnoreCase(marca))
						{
							sId = mveiculo.getIdMarca();
							break;
						}
					}

					ArrayList<ModeloVeiculo>	aModelo = Arquivo.getModeloCarro(sId);

					data_modelo.put(marca, aModelo);

					for (ModeloVeiculo MVeiculo :  aModelo)
					{
						modelos.add(MVeiculo.getNomeModelo());
					}
				}
				

				
				if (tipo.equalsIgnoreCase("Moto"))
				{
					ArrayList<MarcaVeiculo> aVeiculo =  data.get(tipo);

					String sId = null;

					for (MarcaVeiculo marca_ :aVeiculo)
					{
						 

						if (marca_.getNomeMarca().equalsIgnoreCase(marca))
						{
							sId = marca_.getIdMarca();
							break;
						}
					}

					ArrayList<ModeloVeiculo> aModelo = Arquivo.getModeloMoto(sId);

					data_modelo.put(marca, aModelo);
					
					for (ModeloVeiculo MVeiculo :  aModelo)
					{
						modelos.add(MVeiculo.getNomeModelo());
					}
				}
				if (tipo.equalsIgnoreCase("Caminhao"))
				{
					ArrayList<MarcaVeiculo> aVeiculo = data.get(tipo);

					String sId = null;

					for (MarcaVeiculo marca_:aVeiculo)
					{
					

						if (marca_.getNomeMarca().equalsIgnoreCase(marca))
						{
							sId = marca_.getIdMarca();
							break;
						}
					}

					ArrayList<ModeloVeiculo> aModelo = Arquivo.getModeloCaminhao(sId);

					modelos.clear();
					modelos = new ArrayList<String>();
					data_modelo.put(marca, aModelo);
					for (ModeloVeiculo MVeiculo :  aModelo)
					{
						modelos.add(MVeiculo.getNomeModelo());
					}

				}
			}
		}
		else
		{
			modelos = new ArrayList<String>();
		}
	}

	private void clean()
	{
		setVizivel(false);
		marcas.clear();
		marcas = new ArrayList<String>();
		modelos.clear();
		modelos = new ArrayList<String>();

		anos_de.clear();
		anos_de = new ArrayList<String>();

		setLabelAno("");
		setLabelCombustivel("");
		setLabelModelo("");
		setLabelMarca("");
	}

	public void onTipoChange()
	{
		clean();

		if ((tipo != null) && (!tipo.equals("")))
		{
			ArrayList<MarcaVeiculo> aVeiculo = data.get(tipo);

			for (MarcaVeiculo MVeiculo : aVeiculo)
			{
				marcas.add(MVeiculo.getNomeMarca());
			}

		}
		else
		{
			modelos = new ArrayList<String>();

			marcas.clear();
			marcas = new ArrayList<String>();
			modelos.clear();
			modelos = new ArrayList<String>();

			anos_de.clear();
			anos_de = new ArrayList<String>();
		}
	}

	public void onModeloChange()
	{ 
		if ((modelo != null) && (!modelo.equals("")))
		{
			
			String sTipoVeiculo = null,sId_="";

			anos_de = new ArrayList<String>();

			if ((tipo != null) && (!tipo.equals("")))
			{ 
				 
				if (tipo.equalsIgnoreCase("Carro"))
				{
					 ArrayList<MarcaVeiculo> aVeiculo_ = data.get(tipo);

				 

					loop : for (MarcaVeiculo mv_ : aVeiculo_)
					{
						 if(mv_.getNomeMarca().equalsIgnoreCase(marca))
						 {
							 sId_ = mv_.getIdMarca();	
							 break;
						 }
					}

					ArrayList<ModeloVeiculo>	aVeiculoModelo =   data_modelo.get(marca);

					

					for (ModeloVeiculo MVeiculo: aVeiculoModelo)
					{
						 

						if (MVeiculo.getNomeModelo().equalsIgnoreCase(modelo))
						{
							sTipoVeiculo = MVeiculo.getIdModelo();
							break;
						}
					}

					setsIdModelo(sTipoVeiculo);
					setsId(sId_);
					ArrayList<ModeloAnoVeiculo> aModelo = Arquivo.getModeloAnoCarro(sId, sTipoVeiculo);

					anos_de.clear();
					anos_de = new ArrayList<String>();
					modelo_ano.put(modelo, aModelo);

					for (ModeloAnoVeiculo MVeiculo :   aModelo)
					{
						anos_de.add(MVeiculo.getNomeModelo());
					}
				}
				 
				ArrayList<ModeloVeiculo> aVeiculoModelo;
				ArrayList<ModeloAnoVeiculo> aModelo;
				if (tipo.equalsIgnoreCase("Moto"))
				{
					ArrayList<MarcaVeiculo> aVeiculo =   data.get(tipo);

					 

					for (MarcaVeiculo MVeiculo:  aVeiculo)
					{
 

						if (MVeiculo.getNomeMarca().equalsIgnoreCase(marca))
						{
							sId_ = MVeiculo.getIdMarca();
							break;
						}
					}

					aVeiculoModelo =   data_modelo.get(marca);

					 

					for (ModeloVeiculo MVeiculo: aVeiculoModelo)
					{
						

						if (MVeiculo.getNomeModelo().equalsIgnoreCase(modelo))
						{
							sTipoVeiculo = MVeiculo.getIdModelo();
							break;
						}
					}

					setsIdModelo(sTipoVeiculo);
					setsId(sId);
					aModelo = Arquivo.getModeloAnoMoto(sId, sTipoVeiculo);

					anos_de.clear();
					anos_de = new ArrayList<String>();
					modelo_ano.put(modelo, aModelo);
					for (ModeloAnoVeiculo MVeiculo :  aModelo)
					{
						anos_de.add(MVeiculo.getNomeModelo());
					}
				}

				if (tipo.equalsIgnoreCase("Caminhao"))
				{
					ArrayList<MarcaVeiculo> aVeiculo =  data.get(tipo);

					String sId = null;

					for (MarcaVeiculo MVeiculo :aVeiculo)
					{
						 
						if (MVeiculo.getNomeMarca().equalsIgnoreCase(marca))
						{
							sId = MVeiculo.getIdMarca();
							break;
						}
					}

					  aVeiculoModelo =  data_modelo.get(marca);
 

					for ( ModeloVeiculo MVeiculo: aVeiculoModelo)
					{
						 
						if (MVeiculo.getNomeModelo().equalsIgnoreCase(modelo))
						{
							sTipoVeiculo = MVeiculo.getIdModelo();
							break;
						}
					}

					setsIdModelo(sTipoVeiculo);
					setsId(sId);
					  aModelo = Arquivo.getModeloAnoCaminhao(sId, sTipoVeiculo);

					anos_de.clear();
					anos_de = new ArrayList<String>();
					modelo_ano.put(modelo, aModelo);
					for (ModeloAnoVeiculo MVeiculo :   aModelo)
					{
						anos_de.add(MVeiculo.getNomeModelo());
					}

				}

			}
		} else
		{
			anos_de = new ArrayList<String>();
		}
	}

	public void displayLocation()
	{
		ArrayList<ModeloAnoVeiculo> aVeiculoModelo = (ArrayList) modelo_ano.get(modelo);

		String sAnoCode = null;

		for (ModeloAnoVeiculo MVeiculo : aVeiculoModelo)
		{
			if (MVeiculo.getNomeModelo().equalsIgnoreCase(ano_de))
			{
				sAnoCode = MVeiculo.getIdModelo();
				break;
			}
		}

		String sPreco = null;

		if (tipo.equalsIgnoreCase("Carro"))
		{
			sPreco = Arquivo.getDetalheCarro(getsId(), getsIdModelo(), sAnoCode);
		}
		if (tipo.equalsIgnoreCase("Moto"))
		{
			sPreco = Arquivo.getDetalheMoto(getsId(), getsIdModelo(), sAnoCode);
		}
		if (tipo.equalsIgnoreCase("Caminhao"))
		{
			sPreco = Arquivo.getDetalheCaminhao(getsId(), getsIdModelo(), sAnoCode);
		}

		setVizivel(true);
		setLabelAno(ano_de.substring(0, 4));
		setLabelCombustivel(ano_de.substring(4, ano_de.length()));
		setLabelModelo(modelo);
		setLabelMarca(marca);
		setLabelPreco(sPreco);
	}

	public String getsId()
	{
		return sId;
	}

	public void setsId(String sId)
	{
		this.sId = sId;
	}

	public String getsIdModelo()
	{
		return sIdModelo;
	}

	public void setsIdModelo(String sIdModelo)
	{
		this.sIdModelo = sIdModelo;
	}
}