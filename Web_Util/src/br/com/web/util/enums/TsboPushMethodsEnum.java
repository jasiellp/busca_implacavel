package br.com.web.util.enums;


/**
* <b>Autor:</b> Paulo Sato </br></br>
* 
* <b>Historico de Revisao</b> </br>
*    04/02/2016 - Paulo Sato - Primeira Versao </br></br>
*  
* <b>Objetivo:</b> Enumeradores dos Push Services</br>
*/
public enum TsboPushMethodsEnum 
{
	fnd_roteador(1,"PushRoteador"),
	cmm_session(2,"br.com.original.pushs.session.PushSession"),
	sgl_envio(3,"br.com.original.sgl.pushservice.PushSglEnvio"),
	sgl_retorno(4,"br.com.original.sgl.pushservice.PushSglRetorno"),
	sgl_confirmacao(5,"br.com.original.sgl.pushservice.PushConfirmacao"),
	bds_taxa(6,"br.com.original.bds.push.PushConsultaTaxasVG"),
	cc_movimentacao(7,"br.com.original.contacorrente.push.PushMovCCTubo"),
	atualiza_carteira(8,"br.com.original.sgl.pushservice.PushSglAtualizaCarteira"),
	sgl_cesta(9,"br.com.original.sgl.pushservice.PushSglCestasOnline"),
	consulta_cliente(10,"br.com.original.consultacliente.push.PushConsultaCliente"),
	ged_minutaria(11,"br.com.original.itfnotasnegociacao.push.PushGED"),
	consulta_conta_corrente(12,"br.com.original.cadastrocontacorrente.push.PushConsultaContaCorrente"),
	xrm_alerta(13,"br.com.original.xrmalerta.push.PushProcessNotification"),
	volume_global(14, "br.com.original.volumeglobal.push.PushVolumeGlobal");

	
	private int id;
	private String descricao;
	
	TsboPushMethodsEnum(int id, String descricao)
	{
		this.id = id;
		this.descricao = descricao;
	}
	
	
	public static TsboPushMethodsEnum fromInt(int paramInt)
	{
		TsboPushMethodsEnum[] arrayOfBcoPushMethodsEnum = (TsboPushMethodsEnum[]) TsboPushMethodsEnum.class.getEnumConstants();

		int i = paramInt - arrayOfBcoPushMethodsEnum[0].id;
		
		if ((i < arrayOfBcoPushMethodsEnum.length) && (i >= 0) && (arrayOfBcoPushMethodsEnum[i].id == paramInt))
		{
			return arrayOfBcoPushMethodsEnum[i];
		}
		
		for (TsboPushMethodsEnum localBcoPushMethodsEnum : arrayOfBcoPushMethodsEnum)
		{
			if (localBcoPushMethodsEnum.id == paramInt)
			{
				return localBcoPushMethodsEnum;
			}
		}
		
		throw new IllegalArgumentException("No enum " + TsboPushMethodsEnum.class + " with value " + paramInt);
	}
	
	
	/**
	 * Retorna o Id do Push
	 * @return
	 */
	public int getValor()
	{
		return id;
	}
	
	/**
	 * Seta valor do ID
	 * @param valor
	 */
	public void setValor(int valor)
	{
		this.id = valor;
	}
	
	/**
	 * Obtem a descricao do Push
	 * @return
	 */
	public String getDescricao()
	{
		return descricao;
	}
	
	/**
	 * Seta a Descricao do Push
	 * @param descricao
	 */
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
	
	/*mov_conta_corrente_tubo("PushMovContaCorrenteTubo"),
	consulta_resgate_bloqueio_ci("PushConsultaResgateBloqueioCI"),
	consulta_enquadramento_suitability("PushConsultaEnquadramentoSuitabi"),
	consulta_termo_suitability("PushConsultaTermoSuitability"),
	consulta_api_suitability("PushConsultaAPISuitability"),
	mov_conta_corrente("PushMovContaCorrente"),
	imp_operacao_lastreada("PushImpOperacaoLastreada"),
	consulta_disp_cestas("PushConsultaDispCestas"),
	atualiza_posicao_carteira("PushAtualizaCarteiraSGL"),
	resgate_lca_sgl("PushPushResgateLCASGL"),
	consulta_cc("PushConsultaCC"),
	envio_cancelamento("PushEnvioCancelamento"),
	user_session("PushMethodUserSession"),
	cadastro_conta_corrente("PushMethodCadastroContaCorrente"),
	consulta_taxa_transfer("PushTaxaTransfer"),
	ged_notas_gerar_minuta("PushGEDNotasGerarMinuta"),
	xrm_process_notification("PushXRMProcessNotification"),
	bloq_desb_cheque_invest("PushBloqDesbChequeInvest"),
	bds_taxas("PushServiceBDSTaxas"),
	sgl_filas_envio ("pushSglFilasEnvio"),
	sgl_filas_retorno ("PushSglFilasRetorno"),
	sgl_filas_confirmacao ("PushSglFilasConfirmacao"),	
	bds_taxas_vg("PushServiceBDSTaxasVolGlobal");*/
	


}