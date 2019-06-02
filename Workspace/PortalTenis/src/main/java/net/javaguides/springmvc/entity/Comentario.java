package net.javaguides.springmvc.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="comentario")
public class Comentario implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_Comentario")
	//atributo vincula a la columna
	private int codComentario;
	
	@Column(name="des_Comentario")
	private String desComentario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fec_Comentario")
	private Date fechaComentario;
	
	@ManyToOne
	@JoinColumn(name="cod_Usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="cod_Noticia")
	private Noticia noticia;
	
	//relación uno a muchos
	@OneToMany(mappedBy="comentario")
	private List<Noticia> listaNoticia;
	
	public Comentario() {
		usuario = new Usuario();
	}	

	public int getCodComentario() {
		return codComentario;
	}

	public void setCodComentario(int codComentario) {
		this.codComentario = codComentario;
	}

	public String getDesComentario() {
		return desComentario;
	}

	public void setDesComentario(String desComentario) {
		this.desComentario = desComentario;
	}

	public Date getFechaComentario() {
		return fechaComentario;
	}

	public void setFechaComentario(Date fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public List<Noticia> getListaNoticia() {
		return listaNoticia;
	}

	public void setListaNoticia(List<Noticia> listaNoticia) {
		this.listaNoticia = listaNoticia;
	}
	
	

	
	
	
}







