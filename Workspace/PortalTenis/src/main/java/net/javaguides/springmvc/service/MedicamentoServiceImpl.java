package net.javaguides.springmvc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.dao.MedicamentoDAO;
import net.javaguides.springmvc.entity.Medicamento;
@Service
public class MedicamentoServiceImpl implements MedicamentoService{

	@Autowired
	private MedicamentoDAO medicamentoDAO;
	
	@Override
	public List<Medicamento> getMedicamentos() {
		return medicamentoDAO.getMedicamentos();
	}
	@Override
	public void saveMedicamento(Medicamento medicamento) {
		medicamentoDAO.saveMedicamento(medicamento);
	}
	@Override
	public void deleteMedicamento(int id) {
		medicamentoDAO.deleteMedicamento(id);
	}
}
