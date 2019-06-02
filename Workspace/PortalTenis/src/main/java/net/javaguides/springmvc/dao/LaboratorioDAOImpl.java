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

import net.javaguides.springmvc.entity.Laboratorio;
@Repository
public class LaboratorioDAOImpl implements LaboratorioDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly=true)
	public List<Laboratorio> getLaboratorios() {
		Session session = sessionFactory.getCurrentSession();
		List<Laboratorio> lista=null;
		try {
			String hql="select lab from Laboratorio lab";
			Query query=session.createQuery(hql);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	

}
