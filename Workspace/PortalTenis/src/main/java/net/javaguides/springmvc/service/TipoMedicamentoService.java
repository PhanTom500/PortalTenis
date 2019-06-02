package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.TipoMedicamento;

public interface TipoMedicamentoService {
	public List<TipoMedicamento> listTipoMedicamentos(int codLab);
}
