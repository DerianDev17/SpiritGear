package com.uisrael.SpiritGear.modelo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.SpiritGear.modelo.entidades.Usuario;


@Repository
@Component
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {
	
	@Query("Select u from Usuario u where u.APELLIDOS like %?1%")
	public List<Usuario> listarUsuarioApellido(String iapellido);
	
	@Query("Select u from Usuario u order by u.IDUSUARIO")
	public List<Usuario> listaOrdenadaUsuario();
	
	@Query("Select u from Usuario u where u.IDUSUARIO = ?1")
	public Usuario buscarUsuarioId(int iIdUsuarioBuscar);
	
	
}
