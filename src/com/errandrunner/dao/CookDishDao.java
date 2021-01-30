package com.errandrunner.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.errandrunner.hibernateutil.HibernateUtil;
import com.errandrunner.models.CookDishModel;
import com.errandrunner.models.CookModel;
import com.errandrunner.models.CookOrdersModel;

public class CookDishDao {
	 public void save(CookDishModel dish) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(dish);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Update User
	     * @param user
	     */
	    public void update(CookDishModel dish) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.update(dish);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Delete User
	     * @param id
	     */
	    public void delete(int id) {

	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();

	            // Delete a user object
	            CookDishModel dish = session.get(CookDishModel.class, id);
	            if (dish != null) {
	                session.delete(dish);
	            }

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Get User By ID
	     * @param id
	     * @return
	     */
	    public CookDishModel getById(int id) {

	        Transaction transaction = null;
	        CookDishModel dish = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            dish = session.get(CookDishModel.class, id);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return dish;
	    }

	    /**
	     * Get all Users
	     * @return
	     */
	    //@SuppressWarnings("unchecked")
	    @SuppressWarnings("unchecked")
		public List < CookDishModel > getAllDishes() {

	        Transaction transaction = null;
	        List < CookDishModel > dishList = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object

	            dishList = session.createQuery("from CookDishModel").list();

	            // commit transaction
	            transaction.commit();
	         
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return dishList;
	    }
	    
	    public List < CookDishModel > getDishFromCook(CookModel cook) {

	        Transaction transaction = null;
	        List < CookDishModel > dish = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            System.out.println("HERE IN CDM :" + cook.getId() );
//	            NativeQuery<CookDishModel> query = session.getNamedNativeQuery("get_dish_from_cook");
	            String hql = "FROM CookDishModel WHERE cookid = :cookid";
	            Query<CookDishModel> query = session.createQuery(hql);
	            System.out.println("test 1");
	            query.setParameter("cookid",cook.getId());
	            System.out.println("test 2");
	            dish = query.list();
//	            System.out.println("test 1");
//	            query.setParameter("cookid", cook.getId());
//	            System.out.println("test 2");
//	            dish = query.getResultList();
	            System.out.println("CDM OVER");

	            // commit transaction
	            transaction.commit();
	         
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.getMessage();
	        }
	        return dish;
	    }
	   
}
