package com.uisrael.SpiritGear.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.SpiritGear.modelo.entidades.Usuario;
import com.uisrael.SpiritGear.modelo.repositorio.IUsuarioRepositorio;
import com.uisrael.SpiritGear.servicios.IUsuarioServicio;

import jakarta.transaction.Transactional;

@Service
@Component
public class UsuarioServicioImpl  implements IUsuarioServicio{

	@Autowired
	private IUsuarioRepositorio varUsuarioRepositorio;
	
	
	@Override
	@Transactional
	public void insertarUsuario(Usuario nuevoUsuario) {
		// TODO Auto-generated method stub	
		try {
			varUsuarioRepositorio.save(nuevoUsuario);	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}
	}

	//@Override
	//public List<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		//return varUsuarioRepositorio.findAll();
	//}

	@Override
	public List<Usuario> listaOrdenadaUsuario() {
		// TODO Auto-generated method stub
		return varUsuarioRepositorio.listaOrdenadaUsuario();
	}

	@Override
	public List<Usuario> listarUsuarioApellido(String iapellido) {
		// TODO Auto-generated method stub
		return varUsuarioRepositorio.listarUsuarioApellido(iapellido);
	}

	@Override
	public Usuario buscarUsuarioId(int iIdUsuarioBuscar) {
		// TODO Auto-generated method stub
		return varUsuarioRepositorio.buscarUsuarioId(iIdUsuarioBuscar);
	}

	@Override
	public void actualizarUsuario(Usuario nuevoUsuario) {
		// TODO Auto-generated method stub
		Usuario existeUsuario;
		
		try {
			existeUsuario = varUsuarioRepositorio.buscarUsuarioId(nuevoUsuario.getIDUSUARIO());
			if (existeUsuario!= null) {
				existeUsuario.setFkTaller(null);//ojooooooo
				existeUsuario.setNMONICOUSUARIO(nuevoUsuario.getNMONICOUSUARIO());
				existeUsuario.setNOMBRES(nuevoUsuario.getNOMBRES());
				existeUsuario.setAPELLIDOS(nuevoUsuario.getAPELLIDOS());
				existeUsuario.setCODPERFIL(nuevoUsuario.getCODPERFIL());
				existeUsuario.setCLAVEUSR(nuevoUsuario.getCLAVEUSR());
			}
			varUsuarioRepositorio.save(existeUsuario);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}

	@Override
	public int borrarUsuarioId(Usuario objBorraUsuario) {
		try {
			varUsuarioRepositorio.delete(objBorraUsuario);
			return 1;
		} catch (Exception e) {
			System.out.println("Error al eliminar registro " + e.getMessage());
			return 0;
		}
	}

}
