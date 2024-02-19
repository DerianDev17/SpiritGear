package com.uisrael.SpiritGear.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.SpiritGear.modelo.entidades.Taller;
import com.uisrael.SpiritGear.servicios.ITallerServicio;

@Controller
public class TallerControlador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ITallerServicio varITallerServicio;
	private List<Taller> detTaller = new ArrayList<>();
	
	@GetMapping("/listartalleres")
	public String listarTalleres(Model modeloTaller) {
		detTaller = varITallerServicio.listaOrdenadaTaller();
		modeloTaller.addAttribute("listatalleres", detTaller);
		return "spiritGear/Taller";
	}
	
	//enviar objeto TALLER
	@GetMapping("/nuevotaller")
	public String insNuevoTaller(Model modelObjTaller) {
		Taller objNuevoTaller = new Taller();
		objNuevoTaller.setESTATUS(1);
		modelObjTaller.addAttribute("objTallerNuevo", objNuevoTaller);
		return("/spiritGear/nuevotaller");
	}	
	
	//EDITAR TALLER
	@GetMapping("/editarTaller/{idTallerEditar}")
	public String objEditarTaller(@PathVariable(value="idTallerEditar") int idTallerEditar, Model objModelTallerEdit) {
		Taller objTallerExiste = new Taller();
		if (idTallerEditar>0) {
			objTallerExiste = varITallerServicio.buscarTallerId(idTallerEditar);
		}else {
			return("redirect:/listartalleres");
		}
		objModelTallerEdit.addAttribute("objTallerNuevo", objTallerExiste);		
		return("/spiritGear/nuevotaller");
	}
	
	//eliminar 
	@GetMapping("/eliminarTaller/{idTallerDel}")
	public String eliminarObjTaller (@PathVariable(value="idTallerDel") int idTallerEliminar) {
		Taller objTallerDel = new Taller();
		objTallerDel.setIDTALLER(idTallerEliminar);
		varITallerServicio.actualizaEstatusTaller(objTallerDel);
		return ("redirect:/listartalleres");
	}	
	
	//insertar Taller
	@PostMapping("/insertarTaller")
	public String insertarTallerNuevo(@ModelAttribute("objTallerNuevo") Taller nuevoTallerObj) {	
		System.out.println("ESTATUS received: " + nuevoTallerObj.getESTATUS());
		if (nuevoTallerObj!= null && nuevoTallerObj.getIDTALLER() > 0) {			
			varITallerServicio.actualizarTaller(nuevoTallerObj);
		}else {
			nuevoTallerObj.setIDTALLER(1);
			//nuevoTallerObj.setESTATUS(1);
			varITallerServicio.insertarTaller(nuevoTallerObj);	
		}				
		return ("redirect:/listartalleres");
	}	

}












