package br.com.web.util.enums;

/**
* <b>Autor:</b> Paulo Sato </br></br>
* 
* <b>Historico de Revisao</b> </br>
*    04/02/2016 - Paulo Sato - Primeira Versao </br></br>
*  
* <b>Objetivo:</b> Enumeradores de codigos de retorno dos servicos</br>
*/
public enum TsboRetornoServicoEnum
{
	sucesso			           (1, "Sucesso"),
	cliente_invalido           (2, "Cliente Invalido"),
	usuario_invalido           (3, "Usuario Invalido"),
	canal_invalido	           (4, "Canal Invalido"),
	cc_invalida		           (5, "Conta Corrente Invalida"),
	politica_invalida          (6, "Politica Invalida"),
	valor_invalido	           (7, "Valor Invalido"),
	prazo_invalido	           (8, "Prazo Invalido"),
	data_invalida	           (9, "Data Invalida"),
	parametro_invalido         (10, "Parametro Invalido"),
	id_operacao_inexistente    (11, "Id Operacao Inexistente"),
	tipo_cancelamento_invalido (12, "Tipo Cancelamento Invalido"),
	valor_indisponivel_em_cc   (13, "Valor Indisponivel em Conta Corrente"),
    id_aplicacao_invalido      (14, "Id Aplicacao Invalido"),
	sem_dados_de_retorno       (15, "Sem Dados de Retorno"),
	resg_valor_invalido        (16, "Valor Invalido para Resgate"),
	resg_ja_efetuado_dia       (17, "Resgate ja Efetuado no Dia"),
	reg_sim_futura	           (18, "Simulacao Futura de Resgate nao permitida"),
	resg_operacao_sem_liquidez (19, "Resgate de Operacao Sem Liquidez"),
	periodo_invalido           (20, "Periodo de Data Invalido"),
	id_agendamento_invalido    (21, "Id Agendamento Invalido"),
	resg_falha_pagamento       (22, "Resgate - Falha no Pagamento"),
	agencia_inexistente        (23, "Agencia Inexistente"),
	usuario_nao_vinculado_cc   (24, "Usuario Nao Vinculado a Conta Corrente Informada"),
	operacao_invalida          (25, "Operacao Invalida"),
	falha_integracao_sgl       (26, "Falha Integracao SGL"),
	falha_integracao_cc        (27, "Falha Integracao Conta Corrente"),
	tipo_consulta_extrato_mov_invalido    (28, "Tipo Consulta Extrato Movimentacao Invalido"),
	politica_invalida_para_agendamento    (29, "Politica Invalida para Agendamento"),
	falha_consulta_cesta_lca              (30, "Falha Consulta de Cestas LCA"),
	cesta_lca_sem_saldo                   (31, "Cesta LCA Sem Saldo"),
	erro_ao_obter_taxa_rentabilidade      (32, "Erro ao Obter Taxa de Rentabilidade"),
	falha_ao_obter_taxa_transfer          (33, "Erro ao Obter Taxa Transfer"),
	falha_ao_obter_instrucao_de_pagamento (34, "Erro ao Obter Instrucao de Pagamento"),
	prazo_minimo_invalido_cmn_4410        (35, "Prazo Minimo Invalido CMN4410"),
	erro_no_calculo_de_impostos           (36, "Erro ao Obter Calcuco de Impostos"),
	falha_ao_avisar_sistema_garantia      (37, "Falha ao Desvincular Cheque Investidor"),
	falha_ao_avisar_sistema_garantia_e_cancelamento (38, "Falha 37 e Falha ao Cancelar Conta Corrente"),
	politica_fora_da_data_hora_de_negociacao        (39, "Politica Fora da Data/Hora de Negociacao"),
	falha_integracao_bds                  (40, "Falha Integracao BDS"),
	produto_invalido                      (41, "Produto Invalido"),
	operacao_fora_periodo_liquidez        (42, "Operacao Fora do Periodo de Liquidez"),
	politicas_duplicadas                  (43, "Mais de uma politica existente para o produto"),
	falha_tpm							  (44, "Falha ao inicializar TPM"),
	cliente_existente					  (45, "Cliente ja cadastrado"),
	timeout_conta_corrente				  (46, "timeout conta corrente"),
	resgate_pendente				  	  (47, "Existe resgate pendente para esta operacao"),
	falha_volume_global					  (48, "Falha Volume Global"),
	problemas_tecnico                     (99, "Erro Tecnico");
	
	private int id;
	private String descricao;
	
	TsboRetornoServicoEnum(int id, String descricao)
	{
		this.id = id;
		this.descricao = descricao;
	}
	
	
	public static TsboRetornoServicoEnum fromInt(int paramInt)
	{
		TsboRetornoServicoEnum[] arrayOfBcoRetornoServicoEnum = (TsboRetornoServicoEnum[]) TsboRetornoServicoEnum.class.getEnumConstants();

		int i = paramInt - arrayOfBcoRetornoServicoEnum[0].id;
		if ((i < arrayOfBcoRetornoServicoEnum.length) && (i >= 0) && (arrayOfBcoRetornoServicoEnum[i].id == paramInt))
		{
			return arrayOfBcoRetornoServicoEnum[i];
		}
		for (TsboRetornoServicoEnum localBcoRetornoServicoEnum : arrayOfBcoRetornoServicoEnum)
			if (localBcoRetornoServicoEnum.id == paramInt)
				return localBcoRetornoServicoEnum;
		throw new IllegalArgumentException("No enum " + TsboRetornoServicoEnum.class + " with value " + paramInt);
	}
	
	
	public int getValor()
	{
		return id;
	}
	
	public void setValor(int valor)
	{
		this.id = valor;
	}
	
	public String getDescricao()
	{
		return descricao;
	}
	
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
}
