package com.uisrael.SpiritGear.modelo.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.SpiritGear.modelo.entidades.CabOrden;
import com.uisrael.SpiritGear.modelo.entidades.Reportes;

@Repository
@Component
public interface IReportesRepositorio extends JpaRepository<Reportes, Integer> {
	
	@Query("SELECT c FROM CabOrden c WHERE c.FECHA_CIERRE BETWEEN :fechaInicio AND :fechaFin")
    List<CabOrden> findByFechaCierreBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

}
