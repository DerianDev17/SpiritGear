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
@Table(name="TLRM01")
public class Taller implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static final long serialVer
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IDTALLER;
	
	private String NMONICOTALLER;
	private int ESTATUS;
	private String CALLEPRINCIPAL;
	private String CALLESEGUNDARIA;
	private String NUMEROUBICA;
	private String DESCRIPTALLER;
	
	//un taller tienere varios usuarios
	//relacion onetoMany
	@OneToMany(mappedBy = "fkTaller", fetch = FetchType.LAZY)
	private List<Usuario> listaUsuario = new ArrayList<>();
	
}





