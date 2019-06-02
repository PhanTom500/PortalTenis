package net.javaguides.springmvc.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="boleta")
public class Boleta implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_Boleta")
	private int codBoleta;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fec_Boleta")
	private Date fechaBoleta;
	
	@Column(name="subTotal_Boleta")
	private double subTotalBoleta;
	
	@Column(name="igv_Boleta")
	private double igvBoleta;
	
	@Column(name="total_Boleta")
	private double totalBoleta;
	
	@ManyToOne
	@JoinColumn(name="cod_Usuario")
	private Usuario usuario;
	
	public Boleta() {
		usuario = new Usuario();
	}

	public int getCodBoleta() {
		return codBoleta;
	}

	public void setCodBoleta(int codBoleta) {
		this.codBoleta = codBoleta;
	}

	public Date getFechaBoleta() {
		return fechaBoleta;
	}

	public void setFechaBoleta(Date fechaBoleta) {
		this.fechaBoleta = fechaBoleta;
	}

	public double getSubTotalBoleta() {
		return subTotalBoleta;
	}

	public void setSubTotalBoleta(double subTotalBoleta) {
		this.subTotalBoleta = subTotalBoleta;
	}

	public double getIgvBoleta() {
		return igvBoleta;
	}

	public void setIgvBoleta(double igvBoleta) {
		this.igvBoleta = igvBoleta;
	}

	public double getTotalBoleta() {
		return totalBoleta;
	}

	public void setTotalBoleta(double totalBoleta) {
		this.totalBoleta = totalBoleta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	


}
