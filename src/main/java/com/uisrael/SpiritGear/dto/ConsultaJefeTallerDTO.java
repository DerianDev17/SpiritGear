package com.uisrael.SpiritGear.dto;




import java.util.Date;

import lombok.Data;

@Data
public class ConsultaJefeTallerDTO {
	private int CNJTLL_IDTALLER;
	private String CNJTLL_DESCRIPTALLER;	
	private int CNJTLL_IDUSUARIO;
	private String CNJTLL_NMONICOUSUARIO;
	private int CNJTLL_IDORDEN;
	private String CNJTLL_ESTATUS;
	private Date CNJTLL_FECHAINGRESO;
	private Date CNJTLL_FECHACIERRE;
	private int CNJTLL_DIAS;
	

	// public ConsultaJefeTallerDTO() {}
	
	public ConsultaJefeTallerDTO(int iIdTaller, String iDescripTaller, int iIdUsuario,
								String iNmonico, int iIdOrden, String iEstatus, 
									Date iFechaIngreso, Date iFechaCierre, int iDiasT) {
		this.CNJTLL_IDTALLER = iIdTaller;
		this.CNJTLL_DESCRIPTALLER = iDescripTaller;
		this.CNJTLL_IDUSUARIO = iIdUsuario;
		this.CNJTLL_NMONICOUSUARIO = iNmonico;
		this.CNJTLL_IDORDEN = iIdOrden;
		this.CNJTLL_ESTATUS = iEstatus;
		this.CNJTLL_FECHAINGRESO = iFechaIngreso;
		this.CNJTLL_FECHACIERRE = iFechaCierre;
		this.CNJTLL_DIAS = iDiasT;
		}
}
