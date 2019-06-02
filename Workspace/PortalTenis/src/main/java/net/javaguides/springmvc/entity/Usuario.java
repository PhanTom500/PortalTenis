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
@Table(name="tb_medicamento")
public class Usuario implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_med")
	private int codMedicamento;
	@Column(name="nom_med")
	private String nomMedicamento;
	@Column(name="stock_med")
	private int stockMedicamento;
	@Column(name="pre_med")
	private double precioMedicamento;
	//solo fecha
	@Temporal(TemporalType.DATE)
	@Column(name="fec_ven_med")
	private Date fechaMedicamento;//java.util
	@Column
	private byte[]foto;
	//relación muchos a uno
	@ManyToOne
	//llave fk
	@JoinColumn(name="cod_lab")
	private Laboratorio laboratorio;
	@ManyToOne
	@JoinColumn(name="cod_tip_med")
	private TipoMedicamento tipoMedicamento;
	
	public Usuario() {
		laboratorio=new Laboratorio();
	}
	
	public int getCodMedicamento() {
		return codMedicamento;
	}
	public void setCodMedicamento(int codMedicamento) {
		this.codMedicamento = codMedicamento;
	}
	public String getNomMedicamento() {
		return nomMedicamento;
	}
	public void setNomMedicamento(String nomMedicamento) {
		this.nomMedicamento = nomMedicamento;
	}
	public int getStockMedicamento() {
		return stockMedicamento;
	}
	public void setStockMedicamento(int stockMedicamento) {
		this.stockMedicamento = stockMedicamento;
	}
	public double getPrecioMedicamento() {
		return precioMedicamento;
	}
	public void setPrecioMedicamento(double precioMedicamento) {
		this.precioMedicamento = precioMedicamento;
	}
	public Date getFechaMedicamento() {
		return fechaMedicamento;
	}
	public void setFechaMedicamento(Date fechaMedicamento) {
		this.fechaMedicamento = fechaMedicamento;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}

	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}


}
