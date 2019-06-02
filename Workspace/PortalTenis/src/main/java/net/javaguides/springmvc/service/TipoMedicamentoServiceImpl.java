package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springmvc.dao.TipoMedicamentoDAO;
import net.javaguides.springmvc.entity.TipoMedicamento;

@Service
public class TipoMedicamentoServiceImpl implements TipoMedicamentoService{
	@Autowired
	TipoMedicamentoDAO tipoMedicamentoDAO;
	
	@Override
	public List<TipoMedicamento> listTipoMedicamentos(int codLab) {
		return tipoMedicamentoDAO.listTipoMedicamentos(codLab);
	}

}
