package net.javaguides.springmvc.dao;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.TipoMedicamento;
@Repository
public class TipoMedicamentoDAOImpl implements TipoMedicamentoDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly=true)
	public List<TipoMedicamento> listTipoMedicamentos(int codLab) {
		Session sesion=sessionFactory.getCurrentSession();
		List<TipoMedicamento> lista=null;
		try {
			Query query=sesion.createQuery("select tm from TipoMedicamento tm where tm.laboratorio.codLaboratorio=?1");
			query.setParameter(1, codLab);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
