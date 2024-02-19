package com.uisrael.SpiritGear.modelo.entidades;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data

@Table(name="TLRP01")
public class Parametros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IDPARAMETRO;
	
	private String NMONICOPARAMETRO;
	private String NMONICOPARAMSEC;
	private String SERIE;
	private String SECUENCIA;
	private String DESCRIPCION;
	private String VALSTRING;
	private int VALNUMERO;
	private double VALMONTO;
	
	

}
