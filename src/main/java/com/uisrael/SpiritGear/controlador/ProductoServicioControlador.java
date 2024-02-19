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
import com.uisrael.SpiritGear.modelo.entidades.ProductoServicio;
import com.uisrael.SpiritGear.modelo.entidades.Proveedor;
import com.uisrael.SpiritGear.servicios.IParametrosServicio;
import com.uisrael.SpiritGear.servicios.IProductoServicioServicio;
import com.uisrael.SpiritGear.servicios.IProveedorServicio;

@Controller
public class ProductoServicioControlador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IProveedorServicio varIProveedorSrv;
	
	@Autowired
	private IProductoServicioServicio varIProductoSrv;
	
	@Autowired
	private IParametrosServicio varIParametrosSrv;
	
	private List<ProductoServicio> detProductoServicio = new ArrayList<>();
	private List<Proveedor> detProveedor = new ArrayList<>();
	private List<Parametros> detParam = new ArrayList<>();

	@GetMapping("/listarProdServicio")
	public String listarProductoServicio(Model modelProdSrv) {
		detProductoServicio = varIProductoSrv.listaProductoServicio();
		modelProdSrv.addAttribute("listaProdServ", detProductoServicio);
		return ("/spiritGear/proveedor");
	}
	
	@GetMapping("/listardetPrdSrvxProveedor/{idProveedor}")
	public String listarDetPrdSrvXProv(@PathVariable(value="idProveedor") int idProvSel, Model modelProdServicio) {
		detProductoServicio = varIProductoSrv.listaxIdProveedorPrdSrv(idProvSel);
		modelProdServicio.addAttribute("listaProdServ", detProductoServicio);
		//proveedor
		//20240128 Proveedor objProveedor = new Proveedor();
		//20240128 objProveedor = varIProveedorSrv.buscarProveedorId(idProvSel);
		modelProdServicio.addAttribute("idProveedorSel", idProvSel);
		//listar
		detParam = varIParametrosSrv.listarParamNmonico("VHTRABAJOSERVICIO");
		modelProdServicio.addAttribute("listaParam",detParam);		
		return("/spiritGear/productoservicio");
	}
	
	@GetMapping("/nuevoprodserv/{idProveedor}")
	public String insertaNuevoProduServi(@PathVariable(value="idProveedor") int idProvSel,Model modelObjProdServicio) {
		ProductoServicio objProdServ = new ProductoServicio();
		modelObjProdServicio.addAttribute("objProdSrvNuevo", objProdServ);
		//lista proveedor
		//20240128 Proveedor objProveedorSel = new Proveedor();
		//20240128 objProveedorSel = varIProveedorSrv.buscarProveedorId(idProvSel);
		//20240128 int idProveedor = objProvServ.getFkProdServicio().getIDPROVEEDOR();
		
		detProveedor = varIProveedorSrv.listaIdProveedor(idProvSel);
		detParam = varIParametrosSrv.listarParamNmonico("VHTRABAJOSERVICIO");
		
		modelObjProdServicio.addAttribute("idProveedorSel", idProvSel);
		modelObjProdServicio.addAttribute("listaProveedor", detProveedor);
		modelObjProdServicio.addAttribute("listaParam", detParam);
		
		detParam = varIParametrosSrv.listarParamNmonico("BNDSINO");
		modelObjProdServicio.addAttribute("listaParamS", detParam);
		
		return ("/spiritGear/nuevoproductoservicio");
	}
	
	@GetMapping("/ingresarproductoservicio/{idEditProveedor}")
	public String ingresarBaseProdServ(@PathVariable(value="idEditProveedor") int idProv, Model modelObjProdServ) {
		ProductoServicio objProdServEdit = new ProductoServicio();
		Proveedor objBaseProveedor = new Proveedor();
		
		objBaseProveedor.setIDPROVEEDOR(idProv);
		objProdServEdit.setFkProdServicio(objBaseProveedor);
	
		modelObjProdServ.addAttribute("objProdSrvNuevo", objProdServEdit);
		detProveedor = varIProveedorSrv.listaOrdenadaProveedor();
		detParam = varIParametrosSrv.listarParamNmonico("VHTRABAJOSERVICIO");
		
		modelObjProdServ.addAttribute("listaProveedor", detProveedor);
		modelObjProdServ.addAttribute("listaParam", detParam);
		return ("/spiritGear/nuevoproductoservicio");
	}
	
	// editar producto servicio
	@GetMapping("/editarProdServicio/{idEditProdServ}")
	public String editarProductoSrv (@PathVariable(value="idEditProdServ") int idPrvSrvEdit, Model modelObjProdServ) {
		ProductoServicio objEditProdServicio = new ProductoServicio() ;
		objEditProdServicio = varIProductoSrv.buscarProdServicioId(idPrvSrvEdit);
		modelObjProdServ.addAttribute("objProdSrvNuevo", objEditProdServicio);
		//listas
		//detProveedor = varIProveedorSrv.listaOrdenadaProveedor();
		int idProveedor = objEditProdServicio.getFkProdServicio().getIDPROVEEDOR();
		detProveedor = varIProveedorSrv.listaIdProveedor(idProveedor);
		detParam = varIParametrosSrv.listarParamNmonico("VHTRABAJOSERVICIO");
		
		modelObjProdServ.addAttribute("listaProveedor", detProveedor);
		modelObjProdServ.addAttribute("listaParam", detParam);
		
		detParam = varIParametrosSrv.listarParamNmonico("BNDSINO");
		modelObjProdServ.addAttribute("listaParamS", detParam);	
		
		//20240128 Proveedor objProveedorSel = new Proveedor();
		//20240128 objProveedorSel = varIProveedorSrv.buscarProveedorId(idProveedor);
		modelObjProdServ.addAttribute("idProveedorSel", idProveedor);
		
		return ("/spiritGear/nuevoproductoservicio");
	}
	
	@GetMapping("/eliminarproductosrv/{idProdServDel}")
	public String borrarProveedor(@PathVariable(value="idProdServDel") int idDelPrdSrv) {	
		ProductoServicio objPrdSrv = new ProductoServicio();
		objPrdSrv = varIProductoSrv.buscarProdServicioId(idDelPrdSrv);
		
		int idProveedor = objPrdSrv.getFkProdServicio().getIDPROVEEDOR();		
		objPrdSrv.setIDSERVICIO(idDelPrdSrv);		
		varIProductoSrv.borrarProdServId(objPrdSrv);
		
		return("redirect:/listardetPrdSrvxProveedor/"+idProveedor);
	}
	
	@PostMapping("/insertaProductoServicio")
	public String insertarNuevoProductoSrv(@ModelAttribute("objDetMovimiento") ProductoServicio nuevoProdSrvObj) {
		//nuevoProdSrvObj.setIDSERVICIO(1);
		int idProveedor = nuevoProdSrvObj.getFkProdServicio().getIDPROVEEDOR();
		varIProductoSrv.insertaProductoServicio(nuevoProdSrvObj);				
		return("redirect:/listardetPrdSrvxProveedor/"+idProveedor);
	}
	
}
