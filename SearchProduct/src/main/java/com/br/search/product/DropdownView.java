package com.br.search.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.br.search.product.dao.CotacaoVeiculoDao;
import com.br.search.product.tabela.SelectionView;
import com.br.search.product.util.Arquivo;
import com.br.search.product.util.MarcaVeiculo;
import com.br.search.product.util.ModeloAnoVeiculo;
import com.br.search.product.util.ModeloVeiculo;
import com.br.search.product.util.Sessao;
import com.br.search.product.util.WebLog;

@ManagedBean
@SessionScoped
public class DropdownView implements Serializable
{
	private static final long serialVersionUID = -5217446585419927326L;

	private Map<String, ArrayList<MarcaVeiculo>> data = new HashMap<String, ArrayList<MarcaVeiculo>>();
	private Map<String, ArrayList<ModeloVeiculo>> data_modelo = new HashMap<String, ArrayList<ModeloVeiculo>>();
	private Map<String, ArrayList<ModeloAnoVeiculo>> modelo_ano = new HashMap<String, ArrayList<ModeloAnoVeiculo>>();

	private Double valor_de  = new Double(0);
	private Double valor_ate = new Double(0);
	private double number3 = 10000.0d;
	private String tipo;
	private String marca;
	private String modelo;
	private String ano_de;
	private String ano_ate;

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

	
	private String pattern;
	private Date selectedDate = new Date();
	private boolean popup;
	
 	private SelectionView cotacao = new SelectionView();
 			
 	 
	
	@PostConstruct
	public void init()
	{
		try
		{
			WebLog.NovoLog("Aplicacao", Sessao.retrieveSessionId());

			valor_de  = 0d;
			valor_ate = 0d;

			tipos = new ArrayList<String>();
			marcas = new ArrayList<String>();
			modelos = new ArrayList<String>();
			anos_de = new ArrayList<String>();

			tipos.add("Carro");
			tipos.add("Moto");
			tipos.add("Caminhao");

			if (data.get("Carro") == null)
			{
				data.put("Carro", CotacaoVeiculoDao.getMarcaCarros());
			}
			if (data.get("Moto") == null)
			{
				data.put("Moto", CotacaoVeiculoDao.getMarcaMotos());
			}
			if (data.get("Caminhao") == null)
			{
				data.put("Caminhao", CotacaoVeiculoDao.getMarcaCaminhoes());
			}
		 	 
		     this.popup = true;
		     this.pattern = "DD MM, YYYY";
		     
		     number3 =  (double) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("number3");
		     selectedDate =(Date) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("selectedDate");
		     System.out.println("JASIEL LINDO "+number3);
		     
		}
		catch (Exception e)
		{
			try
			{
				WebLog.logErro(e);
			} catch (Exception e1)
			{

			}
		}
	}

	public Double getValorAte()
	{
		return valor_ate;
	}

	public void setValorAte(Double input1)
	{
		this.valor_ate = input1;
	}

	public Double getValorDe()
	{
		return valor_de;
	}

	public void setValorDe(Double input1)
	{
		this.valor_de = input1;
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
		try
		{
			if ((marca != null) && (!marca.equals("")))
			{
				if ((tipo != null) && (!tipo.equals("")))
				{

					if (tipo.equalsIgnoreCase("Carro"))
					{
						ArrayList<MarcaVeiculo> aVeiculo = data.get(tipo);

						String sId = null;

						for (MarcaVeiculo mveiculo : aVeiculo)
						{
							if (mveiculo.getNomeMarca().equalsIgnoreCase(marca))
							{
								sId = mveiculo.getIdMarca();
								break;
							}
						}

						ArrayList<ModeloVeiculo> aModelo = CotacaoVeiculoDao.getModeloCarro(sId);

						data_modelo.put(marca, aModelo);
						 
						for (ModeloVeiculo MVeiculo : aModelo)
						{ 
							modelos.add(MVeiculo.getNomeModelo());
						}
					}

					if (tipo.equalsIgnoreCase("Moto"))
					{
						ArrayList<MarcaVeiculo> aVeiculo = data.get(tipo);

						String sId = null;

						for (MarcaVeiculo marca_ : aVeiculo)
						{

							if (marca_.getNomeMarca().equalsIgnoreCase(marca))
							{
								sId = marca_.getIdMarca();
								break;
							}
						}

						ArrayList<ModeloVeiculo> aModelo = CotacaoVeiculoDao.getModeloMoto(sId);

						data_modelo.put(marca, aModelo);
						modelos.clear();
						modelos = new ArrayList<String>();
						for (ModeloVeiculo MVeiculo : aModelo)
						{
							modelos.add(MVeiculo.getNomeModelo());
						}
					}
					if (tipo.equalsIgnoreCase("Caminhao"))
					{
						ArrayList<MarcaVeiculo> aVeiculo = data.get(tipo);

						String sId = null;

						for (MarcaVeiculo marca_ : aVeiculo)
						{

							if (marca_.getNomeMarca().equalsIgnoreCase(marca))
							{
								sId = marca_.getIdMarca();
								break;
							}
						}

						ArrayList<ModeloVeiculo> aModelo = CotacaoVeiculoDao.getModeloCaminhao(sId);

						modelos.clear();
						modelos = new ArrayList<String>();
						data_modelo.put(marca, aModelo);
						for (ModeloVeiculo MVeiculo : aModelo)
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
		} catch (Exception e)
		{

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
	
	public String jasiel()
	{
		
		System.out.println("----------------------Carga------------------------------");
		 
		
		 
	 
		System.out.println("------------------Fim----Carga------------------------------");
		
		
		
		return "/SearchProduct/cotacao";

	}
	public void onModeloChange()
	{
		
		
		try
		{
			if ((modelo != null) && (!modelo.equals("")))
			{

				String sId_modelo = null, sId_marca = "";

				anos_de = new ArrayList<String>();

				if ((tipo != null) && (!tipo.equals("")))
				{

					if (tipo.equalsIgnoreCase("Carro"))
					{
						ArrayList<MarcaVeiculo> aMarcas = data.get(tipo);

						loop : for (MarcaVeiculo marca_local : aMarcas)
						{
							if (marca_local.getNomeMarca().equalsIgnoreCase(marca))
							{
								sId_marca = marca_local.getIdMarca();
								break loop;
							}
						}

						ArrayList<ModeloVeiculo> aVeiculoModelo = data_modelo.get(marca);

						loop : for (ModeloVeiculo MVeiculo : aVeiculoModelo)
						{

							if (MVeiculo.getNomeModelo().equalsIgnoreCase(modelo))
							{
								sId_modelo = MVeiculo.getIdModelo();
								
								break loop;
							}
						}

						setsIdModelo(sId_modelo);
						setsId(sId_marca);
						ArrayList<ModeloAnoVeiculo> aModelo = CotacaoVeiculoDao.getModeloAno(sId_marca, sId_modelo);

						anos_de.clear();
						anos_de = new ArrayList<String>();
						modelo_ano.put(modelo, aModelo);

						for (ModeloAnoVeiculo MVeiculo : aModelo)
						{
							anos_de.add(MVeiculo.getNomeModelo());
						}
					}

					ArrayList<ModeloVeiculo> aVeiculoModelo;
					ArrayList<ModeloAnoVeiculo> aModelo;
					if (tipo.equalsIgnoreCase("Moto"))
					{
						ArrayList<MarcaVeiculo> aVeiculo = data.get(tipo);

						for (MarcaVeiculo MVeiculo : aVeiculo)
						{

							if (MVeiculo.getNomeMarca().equalsIgnoreCase(marca))
							{
								sId_marca = MVeiculo.getIdMarca();
								break;
							}
						}

						aVeiculoModelo = data_modelo.get(marca);

						for (ModeloVeiculo MVeiculo : aVeiculoModelo)
						{

							if (MVeiculo.getNomeModelo().equalsIgnoreCase(modelo))
							{
								sId_modelo = MVeiculo.getIdModelo();
								break;
							}
						}

						setsIdModelo(sId_modelo);
						setsId(sId);
						aModelo = Arquivo.getModeloAnoMoto(sId, sId_modelo);

						anos_de.clear();
						anos_de = new ArrayList<String>();
						modelo_ano.put(modelo, aModelo);
						for (ModeloAnoVeiculo MVeiculo : aModelo)
						{
							anos_de.add(MVeiculo.getNomeModelo());
						}
					}

					if (tipo.equalsIgnoreCase("Caminhao"))
					{
						ArrayList<MarcaVeiculo> aVeiculo = data.get(tipo);

						String sId = null;

						for (MarcaVeiculo MVeiculo : aVeiculo)
						{

							if (MVeiculo.getNomeMarca().equalsIgnoreCase(marca))
							{
								sId = MVeiculo.getIdMarca();
								break;
							}
						}

						aVeiculoModelo = data_modelo.get(marca);

						for (ModeloVeiculo MVeiculo : aVeiculoModelo)
						{

							if (MVeiculo.getNomeModelo().equalsIgnoreCase(modelo))
							{
								sId_modelo = MVeiculo.getIdModelo();
								break;
							}
						}

						setsIdModelo(sId_modelo);
						setsId(sId);
						aModelo = Arquivo.getModeloAnoCaminhao(sId, sId_modelo);

						anos_de.clear();
						anos_de = new ArrayList<String>();
						modelo_ano.put(modelo, aModelo);
						for (ModeloAnoVeiculo MVeiculo : aModelo)
						{
							anos_de.add(MVeiculo.getNomeModelo());
						}

					}

				}
			}
			else
			{
				anos_de = new ArrayList<String>();
			}
		}
		catch (Exception e)
		{
			 
		}
		
	}

	public void displayLocation()
	{

		if (tipo.equalsIgnoreCase("Carro"))
		{
			try
			{
				CotacaoVeiculoDao.getDetalhes( cotacao, 1, marca, modelo, ano_de, ano_ate, String.valueOf(number3), String.valueOf(number3));
			} catch (Exception e)
			{

			}
		}
		if (tipo.equalsIgnoreCase("Moto"))
		{
			try
			{
				CotacaoVeiculoDao.getDetalhes(
				        cotacao, 2, marca, modelo, ano_de, ano_ate, String.valueOf(number3), String.valueOf(number3)
				);
			} catch (Exception e)
			{

			}
		}
		if (tipo.equalsIgnoreCase("Caminhao"))
		{
			try
			{
				CotacaoVeiculoDao.getDetalhes(
				        cotacao, 3, marca, modelo, ano_de, ano_ate, String.valueOf(number3), String.valueOf(number3)
				);
			} catch (Exception e)
			{

			}
		}

		/*
		 * setVizivel(true); setLabelAno(ano_de.substring(0, 4));
		 * setLabelCombustivel(ano_de.substring(4, ano_de.length()));
		 * setLabelModelo(modelo); setLabelMarca(marca); setLabelPreco(sPreco);
		 */
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

	public String getAno_ate()
	{
		return ano_ate;
	}

	public void setAno_ate(String ano_ate)
	{
		this.ano_ate = ano_ate;
	}

	public SelectionView getCotacao()
	{
		return cotacao;
	}

	public void setCotacao(SelectionView cotacao)
	{
		this.cotacao = cotacao;
	}
	
	public boolean isPopup()
	{
		return popup;
	}

	public void setPopup(boolean popup)
	{
		this.popup = popup;
	}

	public String getPattern()
	{
		return pattern;
	}

	public void setPattern(String pattern)
	{
		this.pattern = pattern;
	}
	public Date getSelectedDate()
	{
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate)
	{
		
		
		this.selectedDate = selectedDate;
	}
	public double getNumber3()
	{
		return number3;
	}

	public void setNumber3(double number3)
	{
		this.number3 = number3;
	}

}