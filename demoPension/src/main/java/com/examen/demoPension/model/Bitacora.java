/**
 * 
 */
package com.examen.demoPension.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Marco Antonio
 *
 */
@Entity
@Table(name = "bitacora")
public class Bitacora {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "idBitacora")
	private Long idBitacora;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAuto", referencedColumnName = "idAuto")
	private Auto auto;
	
	@Column(name = "estado")
	private Integer estado;
	
	@Column(name = "importe")
	private BigDecimal importe;
	
	@Column(name = "fechaEntrada")
	private Date fechaEntrada;
	
	@Column(name = "fechaSalida")
	private Date fechaSalida;

	@Column(name = "fechaRegistro")
	private Date fechaRegistro;
	
	@Column(name = "fechaUltModificacion")
	private Date fechaUltModificacion;

	/**
	 * @return the idBitacora
	 */
	public Long getIdBitacora() {
		return idBitacora;
	}
	
	/**
	 * @return the auto
	 */
	public Auto getAuto() {
		return auto;
	}

	/**
	 * @param auto the auto to set
	 */
	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	/**
	 * @return the estado
	 */
	public Integer getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	/**
	 * @return the importe
	 */
	public BigDecimal getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	/**
	 * @return the fechaEntrada
	 */
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	/**
	 * @param fechaEntrada the fechaEntrada to set
	 */
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	/**
	 * @return the fechaSalida
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * @param fechaSalida the fechaSalida to set
	 */
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
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

	/**
	 * @param idBitacora the idBitacora to set
	 */
	public void setIdBitacora(Long idBitacora) {
		this.idBitacora = idBitacora;
	}

	@Override
	public String toString() {
		return "Bitacora [idBitacora=" + idBitacora + ", auto=" + auto + ", estado=" + estado + ", importe=" + importe
				+ ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", fechaRegistro=" + fechaRegistro
				+ ", fechaUltModificacion=" + fechaUltModificacion + "]";
	}
}
