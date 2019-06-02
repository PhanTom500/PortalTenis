package net.javaguides.springmvc.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="tb_laboratorio")
public class Laboratorio implements Serializable{
	//clave pk
	@Id
	//auto_increment
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//Columna (campo)
	@Column(name="cod_lab")
	//atributo vincula a la columna
	private int codLaboratorio;
	@Column(name="des_lab")
	private String desLaboratorio;
	//relación uno a muchos
	@OneToMany(mappedBy="laboratorio")
	private List<Medicamento> listaMedicamento;
	//
	@OneToMany(mappedBy="laboratorio")
	private List<TipoMedicamento> listaTipoMedicamento;
	
	public int getCodLaboratorio() {
		return codLaboratorio;
	}
	public void setCodLaboratorio(int codLaboratorio) {
		this.codLaboratorio = codLaboratorio;
	}
	public String getDesLaboratorio() {
		return desLaboratorio;
	}
	public void setDesLaboratorio(String desLaboratorio) {
		this.desLaboratorio = desLaboratorio;
	}
	public List<Medicamento> getListaMedicamento() {
		return listaMedicamento;
	}
	public void setListaMedicamento(List<Medicamento> listaMedicamento) {
		this.listaMedicamento = listaMedicamento;
	}
	public List<TipoMedicamento> getListaTipoMedicamento() {
		return listaTipoMedicamento;
	}
	public void setListaTipoMedicamento(List<TipoMedicamento> listaTipoMedicamento) {
		this.listaTipoMedicamento = listaTipoMedicamento;
	}
	
}







