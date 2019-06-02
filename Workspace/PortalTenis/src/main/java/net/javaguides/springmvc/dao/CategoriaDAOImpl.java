package net.javaguides.springmvc.dao;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.Categoria;
@Repository
public class CategoriaDAOImpl implements CategoriaDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=true)
	public List<Categoria> getCategorias() {
		Session session = sessionFactory.getCurrentSession();
		List<Categoria> lista=null;
		try {
			String hql="select cat from categoria cat";
			Query query=session.createQuery(hql);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	

}
