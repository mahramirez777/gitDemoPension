/**
 * 
 */
package com.examen.demoPension.rest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.demoPension.dao.AutoDAO;
import com.examen.demoPension.dao.BitacoraDAO;
import com.examen.demoPension.model.Auto;
import com.examen.demoPension.model.Bitacora;

/**
 * @author Marco Antonio
 *
 */
@RestController
@RequestMapping("bitacora")
public class BitacoraRest {
	@Autowired
	BitacoraDAO bitacoraDAO;
	
	@Autowired
	AutoDAO autoDAO;
	
	@PostMapping("/alta")
	public void alta (@RequestBody Bitacora bitacora) {
		bitacora.setImporte(BigDecimal.ZERO);
		bitacora.setFechaEntrada(new Date());
		bitacora.setFechaRegistro(new Date());
		bitacora.setFechaUltModificacion(new Date());
		bitacora.getAuto().setFechaRegistro(new Date());
		bitacora.getAuto().setFechaUltModificacion(new Date());
		
		bitacoraDAO.save(bitacora);
	}
	
	@PutMapping("/modificar")
	public void modificar (@RequestBody Bitacora bitacora) {
		bitacora.setFechaUltModificacion(new Date());
		bitacora.getAuto().setFechaUltModificacion(new Date());
		
		bitacoraDAO.save(bitacora);
	}
	
	@GetMapping("/consultarTodo")
	public List <Bitacora> consultarTodo () {
		return bitacoraDAO.findAll();
	}
	
	@PutMapping("/generarPagoPorId/{id}")
	public BigDecimal generarPagoPorId  (@PathVariable ("id") Long id) {
		BigDecimal pago = BigDecimal.ZERO;
		Optional<Bitacora> oBitacora = bitacoraDAO.findById(id);
		Bitacora bitacora =  new Bitacora();
		
		if (oBitacora.isPresent()) {
			bitacora = oBitacora.get();
			
			bitacora.setEstado(2);
			bitacora.setFechaSalida(new Date());
			bitacora.setFechaUltModificacion(new Date());
			bitacora.getAuto().setFechaUltModificacion(new Date());
			
			if (bitacora.getAuto().getTipo().getCodigo().equals("AINTEMP")) { /*Autos Internos Empresa*/
				bitacora.setImporte(BigDecimal.ZERO);
			} else if (bitacora.getAuto().getTipo().getCodigo().equals("AEXTRES")) { /*Autos Externos Residentes*/
				Long diferencia = bitacora.getFechaSalida().getTime() - bitacora.getFechaEntrada().getTime();
				
				Long minutos = TimeUnit.MILLISECONDS.toMinutes(diferencia);
				
				pago = bitacora.getAuto().getTipo().getTarifa().multiply(BigDecimal.valueOf(minutos));
				
				List <Auto> autos =  autoDAO.consultarPorPlaca(bitacora.getAuto().getPlaca());
				
				if (!autos.isEmpty() && autos.size() == 10) {
					BigDecimal porcentaje = BigDecimal.ZERO;
					
					porcentaje = pago.multiply(BigDecimal.valueOf(20)).divide(new BigDecimal(100));
					
					pago = pago.subtract(porcentaje);
					
					bitacora.setImporte(pago);
				} else if (autos.isEmpty() && autos.size() == 20) {
					bitacora.setImporte(BigDecimal.ZERO);
				} else {
					bitacora.setImporte(pago);
				}
			} else if (bitacora.getAuto().getTipo().getCodigo().equals("AEXT")) { /*Autos Externos*/
				Long diferencia = bitacora.getFechaSalida().getTime() - bitacora.getFechaEntrada().getTime();
				
				Long minutos = TimeUnit.MILLISECONDS.toMinutes(diferencia);
				
				pago = bitacora.getAuto().getTipo().getTarifa().multiply(BigDecimal.valueOf(minutos));
				
				bitacora.setImporte(pago);
			}
			
			bitacoraDAO.save(bitacora);
		}
		
		return pago;
	}
}