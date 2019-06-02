package net.javaguides.springmvc.service;
import java.util.List;
import net.javaguides.springmvc.entity.Medicamento;
public interface MedicamentoService {
	public List<Medicamento> getMedicamentos();
	public void saveMedicamento(Medicamento medicamento);
	public void deleteMedicamento(int id);
}
