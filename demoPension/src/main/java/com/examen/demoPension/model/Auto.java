/**
 * 
 */
package com.examen.demoPension.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Marco Antonio
 *
 */
@Entity
@Table(name = "auto")
public class Auto {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "idAuto")
	private Long idAuto;
	
	@OneToOne(mappedBy = "auto")
	private Bitacora Bitacora;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipo")
	private Tipo tipo;
	
	@Column(name = "placa", length = 10)
	private String placa;
	
	@Column(name = "observacion", length = 100)
	private String observacion;
	
	@Column(name = "fechaRegistro")
	private Date fechaRegistro;
	
	@Column(name = "fechaUltModificacion")
	private Date fechaUltModificacion;

	/**
	 * @return the idAuto
	 */
	public Long getIdAuto() {
		return idAuto;
	}

	/**
	 * @param idAuto the idAuto to set
	 */
	public void setIdAuto(Long idAuto) {
		this.idAuto = idAuto;
	}

	/**
	 * @return the bitacora
	 */
	public Bitacora getBitacora() {
		return Bitacora;
	}

	/**
	 * @param bitacora the bitacora to set
	 */
	public void setBitacora(Bitacora bitacora) {
		Bitacora = bitacora;
	}
	
	/**
	 * @return the tipo
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
		return "Auto [idAuto=" + idAuto + ", Bitacora=" + Bitacora + ", tipo=" + tipo + ", placa=" + placa
				+ ", observacion=" + observacion + ", fechaRegistro=" + fechaRegistro + ", fechaUltModificacion="
				+ fechaUltModificacion + "]";
	}
}
