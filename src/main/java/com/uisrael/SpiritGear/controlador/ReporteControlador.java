package com.uisrael.SpiritGear.controlador;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReporteControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GetMapping("/reportes")
	public String reporte() {
		return("/spiritGear/reportes");
	}

}
