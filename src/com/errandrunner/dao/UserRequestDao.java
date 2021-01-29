package com.errandrunner.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.errandrunner.hibernateutil.HibernateUtil;
import com.errandrunner.models.UserDeliveryRequestModel;
import com.errandrunner.models.UserModel;
import com.errandrunner.models.UserServiceRequestModel;



public class UserRequestDao  {

    /**
     * Save User
     * @param user
     */
    public void saveService(UserServiceRequestModel service) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(service);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void saveDelivery(UserDeliveryRequestModel delivery) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(delivery);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
	public List<UserServiceRequestModel> getUserServices(String phone) {

        Transaction transaction = null;
        List<UserServiceRequestModel> user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            //user = session.get(UserServiceRequestModel.class, id);
            Query<UserServiceRequestModel> query = session.createNamedQuery("get_user_services", UserServiceRequestModel.class);
            query.setParameter("phno", phone);
            user = query.getResultList();
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
    
    public List<UserDeliveryRequestModel> getUserDeliveries(String phone) {

        Transaction transaction = null;
        List<UserDeliveryRequestModel> user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            //user = session.get(UserDeliveryRequestModel.class, id);
            Query<UserDeliveryRequestModel> query = session.createNamedQuery("get_user_deliveries", UserDeliveryRequestModel.class);
            query.setParameter("phno", phone);
            user = query.getResultList();
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
    
    public void updateService(UserServiceRequestModel user) {
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
    
    public void updateDelivery(UserDeliveryRequestModel user) {
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

}
