package com.uisrael.SpiritGear.dto;

import lombok.Data;

@Data
public class ConsultaDisponibilidadDTO {
	private int DSP_SECUENCIAL;
	private String DSP_HORA;
	private String DSP_DIA1;
	private String DSP_DIA2;
	private String DSP_DIA3;
	private String DSP_DIA4;
	private String DSP_DIA5;
	
	
	public ConsultaDisponibilidadDTO (int iSecuencia, String iHora,
								String iDia1,String iDia2,String iDia3,String iDia4,String iDia5) {
		this.DSP_SECUENCIAL = iSecuencia;
		this.DSP_HORA = iHora;
		this.DSP_DIA1 = iDia1;
		this.DSP_DIA2 = iDia2;
		this.DSP_DIA3 = iDia3;
		this.DSP_DIA4 = iDia4;
		this.DSP_DIA5 = iDia5;		
	}
}
