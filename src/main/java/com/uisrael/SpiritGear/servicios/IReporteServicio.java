package com.uisrael.SpiritGear.servicios;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.uisrael.SpiritGear.modelo.entidades.CabOrden;

public interface IReporteServicio {

    List<CabOrden> findByFechaCierreBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

}
