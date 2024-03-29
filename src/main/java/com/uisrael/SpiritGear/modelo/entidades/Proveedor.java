package com.uisrael.SpiritGear.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data

@Table(name = "TLRM09")
public class Proveedor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )	
	private int IDPROVEEDOR;
	
	private String TIPOIDPRV;
	private String IDENTIFICAPRV;
	private String NOMBRECOMPLETO;
	private String NOMBRECOMERCIAL;
	private String CELULAR;
	private String EMAIL;	
	
	//un taller tienere varios usuarios
	//relacion onetoMany
	@OneToMany(mappedBy = "fkProdServicio",fetch = FetchType.LAZY)
	private List<ProductoServicio> listaProductoServicio = new ArrayList<>();
	

}
