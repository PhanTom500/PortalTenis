package net.javaguides.springmvc.dao;

import java.util.List;

import net.javaguides.springmvc.entity.TipoMedicamento;

public interface TipoMedicamentoDAO {
	public List<TipoMedicamento> listTipoMedicamentos(int codLab);
}
