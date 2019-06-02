package net.javaguides.springmvc.dao;
import java.util.List;
import net.javaguides.springmvc.entity.Medicamento;
public interface MedicamentoDAO {
	public List<Medicamento> getMedicamentos();
	public void saveMedicamento(Medicamento medicamento);
	public void deleteMedicamento(int id);
}
