package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.dao.LaboratorioDAO;
import net.javaguides.springmvc.entity.Laboratorio;
@Service
public class LaboratorioServiceImpl implements LaboratorioService{

	@Autowired
	private LaboratorioDAO laboratorioDAO;
	
	@Override
	public List<Laboratorio> getLaboratorios() {
		return laboratorioDAO.getLaboratorios();
	}
}
