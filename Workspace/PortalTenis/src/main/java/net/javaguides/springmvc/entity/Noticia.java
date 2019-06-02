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
@Table(name="noticia")
public class Noticia implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_Noticia")
	private int codNoticia;
	
	@Column(name="titulo_Noticia")
	private String tituloNoticia;
	
	@Column(name="desc_Noticia")
	private String descNoticia;
	
	@Column
	private byte[]img_Noticia;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fec_Noticia")
	private Date fechaNoticia;
	
	@ManyToOne
	@JoinColumn(name="cod_Usuario")
	private Usuario usuario;
	
	
	public Noticia() {
		usuario=new Usuario();
	}


	public int getCodNoticia() {
		return codNoticia;
	}


	public void setCodNoticia(int codNoticia) {
		this.codNoticia = codNoticia;
	}


	public String getTituloNoticia() {
		return tituloNoticia;
	}


	public void setTituloNoticia(String tituloNoticia) {
		this.tituloNoticia = tituloNoticia;
	}


	public String getDescNoticia() {
		return descNoticia;
	}


	public void setDescNoticia(String descNoticia) {
		this.descNoticia = descNoticia;
	}


	public byte[] getImg_Noticia() {
		return img_Noticia;
	}


	public void setImg_Noticia(byte[] img_Noticia) {
		this.img_Noticia = img_Noticia;
	}


	public Date getFechaNoticia() {
		return fechaNoticia;
	}


	public void setFechaNoticia(Date fechaNoticia) {
		this.fechaNoticia = fechaNoticia;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	


}
