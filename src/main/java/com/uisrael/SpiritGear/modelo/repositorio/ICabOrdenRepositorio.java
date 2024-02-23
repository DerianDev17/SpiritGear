package com.uisrael.SpiritGear.modelo.repositorio;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.uisrael.SpiritGear.modelo.entidades.CabOrden;

@Repository
@Component
public interface ICabOrdenRepositorio extends JpaRepository<CabOrden, Integer> {
	
	@Query(value = "SELECT " +
	        "tlrm01.IDTALLER, " +
	        "tlrm01.DESCRIPTALLER, " +
	        "tlrm05.IDUSUARIO, " +
	        "tlrm02.NMONICOUSUARIO, " +
	        "tlrm05.IDORDEN, " +
	        "tlrm05.ESTATUS, " +
	        "(SELECT fechaestado FROM TLRM10 WHERE TLRM10.IDORDEN = TLRM05.IDORDEN AND estatusactual = 'act') AS FechaInicial, " +
	        "(SELECT fechaestado FROM TLRM10 WHERE TLRM10.IDORDEN = TLRM05.IDORDEN AND estatusactual = 'cie') AS FechaFinal, " +
	        "CASE " +
            "WHEN (SELECT fechaestado FROM TLRM10 WHERE TLRM10.IDORDEN = TLRM05.IDORDEN AND estatusactual = 'cie') IS NOT NULL THEN " +
            "DATEDIFF(day, (SELECT fechaestado FROM TLRM10 WHERE TLRM10.IDORDEN = TLRM05.IDORDEN AND estatusactual = 'act'), (SELECT fechaestado FROM TLRM10 WHERE TLRM10.IDORDEN = TLRM05.IDORDEN AND estatusactual = 'cie')) " +
            "ELSE " +
            "DATEDIFF(day, (SELECT fechaestado FROM TLRM10 WHERE TLRM10.IDORDEN = TLRM05.IDORDEN AND estatusactual = 'act'), getdate()) " +
            "END AS dias " +	        
	        "FROM tlrm05 JOIN tlrm02 " +
	        "ON TLRM05.IDUSUARIO = TLRM02.IDUSUARIO " +
	        "JOIN tlrm01 ON TLRM02.IDTALLER = tlrm01.IDTALLER", nativeQuery = true)
    List<Object[]> reporteUsoTiempo();

    @Procedure(name = "sp_GeneraDisponibilidad")
    List<Object[]> sp_GeneraDisponibilidad();
}
