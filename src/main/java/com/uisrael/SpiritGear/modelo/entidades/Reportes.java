package com.uisrael.SpiritGear.modelo.entidades;

import java.io.Serializable;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Reportes implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReporte;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IDORDEN")
	private CabOrden fkCabOrden;
	
	@ManyToOne
	@JoinColumn(name = "fkUsuario")
	private Usuario fkUsuario;

}