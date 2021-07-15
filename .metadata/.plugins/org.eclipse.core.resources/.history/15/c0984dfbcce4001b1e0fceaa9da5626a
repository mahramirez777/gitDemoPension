/**
 * 
 */
package com.examen.demoPension.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.demoPension.dao.TipoDAO;
import com.examen.demoPension.model.Tipo;

/**
 * @author Marco Antonio
 *
 */
@RestController
@RequestMapping("tipo")
public class TipoRest {
	@Autowired
	TipoDAO tipoDAO;
	
	@PostMapping("/alta")
	public void alta (@RequestBody Tipo tipo) {
		tipo.setFechaRegistro(new Date());
		tipo.setFechaUltModificacion(new Date());
		
		tipoDAO.save(tipo);
	}
	
	@PutMapping("/modificar")
	public void modificar (@RequestBody Tipo tipo) {
		tipo.setFechaUltModificacion(new Date());
		
		tipoDAO.save(tipo);
	}
	
	@GetMapping("/consultarTodo")
	public List <Tipo> consultarTodo () {
		return tipoDAO.findAll();
	}
}
