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
@Table(name="detalleboleta")
public class DetalleBoleta implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_detalleBoleta")
	private int codDetalleBoleta;
	
	@ManyToOne
	@JoinColumn(name="cod_Boleta")
	private Boleta boleta;
	
	@Column(name="cantidad_Boleta")
	private int cantidadBoleta;
	
	@ManyToOne
	@JoinColumn(name="cod_Producto")
	private Producto producto;
	
	public DetalleBoleta() {
		producto = new Producto();
	}

	public int getCodDetalleBoleta() {
		return codDetalleBoleta;
	}

	public void setCodDetalleBoleta(int codDetalleBoleta) {
		this.codDetalleBoleta = codDetalleBoleta;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public int getCantidadBoleta() {
		return cantidadBoleta;
	}

	public void setCantidadBoleta(int cantidadBoleta) {
		this.cantidadBoleta = cantidadBoleta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	

}
