package net.javaguides.springmvc.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="producto")
public class Producto implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_Producto")
	private int codProducto;
	
	@Column(name="des_Producto")
	private String desProducto;
	
	@Column(name="pre_Producto")
	private double preProducto;
	
	@Column(name="stock_Producto")
	private String stockProducto;
	
	@ManyToOne
	@JoinColumn(name="cod_Categoria")
	private Categoria categoria;
	
	@Column
	private byte[]imgProducto;

	@OneToMany(mappedBy="producto")
	private List<DetalleBoleta> listaDetalleBoleta;
	
	public Producto() {
		categoria = new Categoria();
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getDesProducto() {
		return desProducto;
	}

	public void setDesProducto(String desProducto) {
		this.desProducto = desProducto;
	}

	

	public double getPreProducto() {
		return preProducto;
	}

	public void setPreProducto(double preProducto) {
		this.preProducto = preProducto;
	}

	public String getStockProducto() {
		return stockProducto;
	}

	public void setStockProducto(String stockProducto) {
		this.stockProducto = stockProducto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<DetalleBoleta> getListaDetalleBoleta() {
		return listaDetalleBoleta;
	}

	public void setListaDetalleBoleta(List<DetalleBoleta> listaDetalleBoleta) {
		this.listaDetalleBoleta = listaDetalleBoleta;
	}

	public byte[] getImgProducto() {
		return imgProducto;
	}

	public void setImgProducto(byte[] imgProducto) {
		this.imgProducto = imgProducto;
	}
	
	
	

	
	
	
	
	
}







