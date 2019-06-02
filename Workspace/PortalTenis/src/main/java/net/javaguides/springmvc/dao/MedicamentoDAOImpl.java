package net.javaguides.springmvc.dao;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.Medicamento;
@Repository
public class MedicamentoDAOImpl implements MedicamentoDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly=true)
	public List<Medicamento> getMedicamentos() {
		Session session = sessionFactory.getCurrentSession();
		List<Medicamento> lista=null;
		try {
			String hql="select m from Medicamento m";
			Query query=session.createQuery(hql);
			lista=query.getResultList();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	@Transactional
	public void saveMedicamento(Medicamento medicamento) {
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			currentSession.saveOrUpdate(medicamento);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	@Transactional
	public void deleteMedicamento(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Medicamento med=session.get(Medicamento.class, id);
			session.delete(med);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
