/**
 * 
 */
package com.examen.demoPension.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.examen.demoPension.model.Auto;

/**
 * @author Marco Antonio
 *
 */
public interface AutoDAO extends JpaRepository<Auto, Long> {
    @Query(nativeQuery = true, value = " SELECT * FROM auto WHERE placa = ?1")
	List <Auto> consultarPorPlaca (String placa);
}
