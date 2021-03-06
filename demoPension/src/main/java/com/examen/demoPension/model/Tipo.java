/**
 * 
 */
package com.examen.demoPension.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Marco Antonio
 *
 */
@Entity
@Table(name = "tipo")
public class Tipo {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "idTipo")
	private Long idTipo;
	
	@Column(name = "codigo", length = 10)
	private String codigo;
	
	@Column(name = "descripcion", length = 30)
	private String descripcion;
	
	@Column(name = "tarifa")
	private BigDecimal tarifa;
	
	@Column(name = "fechaRegistro")
	private Date fechaRegistro;
	
	@Column(name = "fechaUltModificacion")
	private Date fechaUltModificacion;

	/**
	 * @return the idTipo
	 */
	public Long getIdTipo() {
		return idTipo;
	}

	/**
	 * @param idTipo the idTipo to set
	 */
	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the tarifa
	 */
	public BigDecimal getTarifa() {
		return tarifa;
	}

	/**
	 * @param tarifa the tarifa to set
	 */
	public void setTarifa(BigDecimal tarifa) {
		this.tarifa = tarifa;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaUltModificacion
	 */
	public Date getFechaUltModificacion() {
		return fechaUltModificacion;
	}

	/**
	 * @param fechaUltModificacion the fechaUltModificacion to set
	 */
	public void setFechaUltModificacion(Date fechaUltModificacion) {
		this.fechaUltModificacion = fechaUltModificacion;
	}

	@Override
	public String toString() {
		return "Tipo [idTipo=" + idTipo + ", codigo=" + codigo + ", descripcion=" + descripcion + ", tarifa=" + tarifa
				+ ", fechaRegistro=" + fechaRegistro + ", fechaUltModificacion=" + fechaUltModificacion + "]";
	}
}
