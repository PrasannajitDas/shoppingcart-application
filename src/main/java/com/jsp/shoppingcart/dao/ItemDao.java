package com.jsp.shoppingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart.dto.Item;

@Repository
public class ItemDao {
	@Autowired
	EntityManagerFactory emf;
	
	public void saveItem(Item p) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(p);
		et.commit();
	}
	
	public void updateItem(Item p) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(p);
		et.commit();
	}
	
	public void deleteItemById(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Item p=em.find(Item.class, id);
		et.begin();
		em.remove(p);
		et.commit();
	}
	
	public Item findItemById(int id) {
		EntityManager em=emf.createEntityManager();
		
		Item p=em.find(Item.class, id);
		if(p!=null) {
			return p;
		}else {
			return null;
		}
	}

}
