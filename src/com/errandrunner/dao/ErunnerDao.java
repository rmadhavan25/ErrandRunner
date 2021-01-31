 package com.errandrunner.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.errandrunner.hibernateutil.HibernateUtil;
import com.errandrunner.models.CookModel;
import com.errandrunner.models.ErunnerModel;
import com.errandrunner.models.UserDeliveryRequestModel;
import com.errandrunner.models.UserModel;
import com.errandrunner.models.UserServiceRequestModel;

public class ErunnerDao {
	
	 public void save(ErunnerModel user) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(user);
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
	    public void update(ErunnerModel user) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.update(user);
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
	            ErunnerModel user = session.get(ErunnerModel.class, id);
	            if (user != null) {
	                session.delete(user);
	                System.out.println("user is deleted");
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
	    public ErunnerModel get(int id) {

	        Transaction transaction = null;
	        ErunnerModel user = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            user = session.get(ErunnerModel.class, id);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return user;
	    }
	    
	    public ErunnerModel getByMainUserId(int id) {

	        Transaction transaction = null;
	        ErunnerModel user = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            //user = session.get(ErunnerModel.class, id);
	            Query<ErunnerModel> query = session.createNamedQuery("get_erunner_id", ErunnerModel.class);
	            query.setParameter("userid", id);
	            user = query.getResultList().stream().findFirst().orElse(null);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return user;
	    }

	    
	    
	    /**
	     * Get all Users
	     * @return
	     */
	    //@SuppressWarnings("unchecked")
	    @SuppressWarnings("unchecked")
		public List < ErunnerModel > getAllErunner() {

	        Transaction transaction = null;
	        List < ErunnerModel > listOfUser = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object

	            listOfUser = session.createQuery("from ErunnerModel").list();

	            // commit transaction
	            transaction.commit();
	         
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfUser;
	    }
	    
	    @SuppressWarnings("unchecked")
		public List < UserServiceRequestModel > getAllServices() {

	        Transaction transaction = null;
	        List < UserServiceRequestModel > listOfServices = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object

	            listOfServices = session.createQuery("from UserServiceRequestModel").list();

	            // commit transaction
	            transaction.commit();
	         
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfServices;
	    }
	    
	    @SuppressWarnings({ "unchecked", "deprecation" })
		public List < UserDeliveryRequestModel > getAllDeliveries() {

	        Transaction transaction = null;
	        List < UserDeliveryRequestModel > listOfDeliveries = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	        	//System.out.println("test1-dao");
	            transaction = session.beginTransaction();
	            // get an user object
	            //System.out.println("test2-dao");
	            //listOfDeliveries = session.createQuery("from UserDeliveryRequestModel").getResultList();
	            //listOfDeliveries = loadAllData(UserDeliveryRequestModel.class,session);
	            Query<UserDeliveryRequestModel> query = session.createNamedQuery("get_all_deliveries", UserDeliveryRequestModel.class);
//	            user = query.getResultList().stream().findFirst().orElse(null);
	            listOfDeliveries = query.getResultList();
	            //System.out.println("test3-dao");
	            // commit transaction
	            transaction.commit();
	         
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfDeliveries;
	    }
	    
	    public UserServiceRequestModel getAService(int id) {
	    	Transaction transaction = null;
	    	UserServiceRequestModel service = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            service = session.get(UserServiceRequestModel.class, id);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return service;
	    }
	    
	    public UserDeliveryRequestModel getADelivery(int id) {
	    	Transaction transaction = null;
	    	UserDeliveryRequestModel delivery = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            delivery = session.get(UserDeliveryRequestModel.class, id);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return delivery;
	    }
}
