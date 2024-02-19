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

import com.uisrael.SpiritGear.modelo.entidades.Parametros;
import com.uisrael.SpiritGear.modelo.entidades.Proveedor;
import com.uisrael.SpiritGear.servicios.IParametrosServicio;
import com.uisrael.SpiritGear.servicios.IProveedorServicio;


@Controller
public class ProveedorControlador implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IProveedorServicio varIProvedorServicio;
	
	@Autowired
	private IParametrosServicio varIParamServicio;
	
	private List<Proveedor> detProveedor = new ArrayList<>();
	private List<Parametros> detParam = new ArrayList<>();
	
	
	@GetMapping("/listarproveedor")
	public String listaProveedor(Model modelProveedor) {
		detProveedor = varIProvedorServicio.listaOrdenadaProveedor();
		modelProveedor.addAttribute("listaProveedor", detProveedor);
		return ("/spiritGear/proveedor");
	}
	
	//para enviar los objetos a HTML	
	@GetMapping("/nuevoproveedor")
	public String proveedorObj(Model modelObjProveedor) {
		Proveedor objProveedor = new Proveedor();
		modelObjProveedor.addAttribute("objProveedorNuevo", objProveedor);
		//LISTA
		detParam = varIParamServicio.listarParamNmonico("TIPODOCCLIENTE");
		modelObjProveedor.addAttribute("listaParam", detParam);
		return ("/spiritGear/nuevoproveedor");
	}
	
	//edit 
	@GetMapping("/editarproveedor/{idProveedorEdit}")
	public String editProveedor(@PathVariable(value="idProveedorEdit") int idEditProveedor, Model modelObjProveedor) {
		Proveedor objProveedor = varIProvedorServicio.buscarProveedorId(idEditProveedor);
		modelObjProveedor.addAttribute("objProveedorNuevo", objProveedor);	
		//lista de parametros		
		detParam = varIParamServicio.listarParamNmonico("TIPODOCCLIENTE");
		modelObjProveedor.addAttribute("listaParam", detParam);			
		
		return("/spiritGear/nuevoproveedor");
	}
	
	//eliminar
	@GetMapping("/eliminarproveedor/{idProveedorDel}")
	public String borrarProveedor(@PathVariable(value="idProveedorDel") int idDelProveedor) {
		Proveedor objEliminarProveedor = new Proveedor();
		objEliminarProveedor.setIDPROVEEDOR(idDelProveedor);
		varIProvedorServicio.borrarProveedorId(objEliminarProveedor);		
		return("redirect:/listarproveedor");
	}
	
	//guardar proveedor
	@PostMapping("/insertaProveedor")
	public String insertarNuevoProveedor(@ModelAttribute("objProveedorNuevo") Proveedor nuevoProveedorInsertar) {
		//nuevoProveedorInsertar.setIDPROVEEDOR(1);		
		varIProvedorServicio.insertaProveedor(nuevoProveedorInsertar);
		return("redirect:/listarproveedor");
	}

}






























