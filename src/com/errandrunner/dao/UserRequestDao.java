package com.errandrunner.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
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
    
    public UserServiceRequestModel getUserServicesById(int id) {

        Transaction transaction = null;
        UserServiceRequestModel user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            //user = session.get(UserServiceRequestModel.class, id);
            Query<UserServiceRequestModel> query = session.createNamedQuery("get_user_services_byid", UserServiceRequestModel.class);
            query.setParameter("id", id);
            user = query.getSingleResult();
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
    
    public UserDeliveryRequestModel getUserDeliveriesById(int id) {

        Transaction transaction = null;
        UserDeliveryRequestModel user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            //user = session.get(UserServiceRequestModel.class, id);
            Query<UserDeliveryRequestModel> query = session.createNamedQuery("get_user_deliveries_byid", UserDeliveryRequestModel.class);
            query.setParameter("id", id);
            user = query.getSingleResult();
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
    
    public List<UserServiceRequestModel> getUserServicesByErunnerId(int id) {

        Transaction transaction = null;
        List<UserServiceRequestModel> user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            //user = session.get(UserServiceRequestModel.class, id);
            //System.out.println("test1");
            NativeQuery<UserServiceRequestModel> query = session.getNamedNativeQuery("get_user_services_by_erunnerid");
            query.setParameter("id", id);
            //Query<UserServiceRequestModel> query = session.createNamedQuery("get_user_services_by_erunnerid", UserServiceRequestModel.class);
            //System.out.println("ID :"+id);
            
            //query.setParameter("id",id);
            //System.out.println("test3");
            user = query.getResultList();
            //System.out.println("test4");
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
    
    public List<UserDeliveryRequestModel> getUserDeliveriesByErunnerId(int id) {

        Transaction transaction = null;
        List<UserDeliveryRequestModel> user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            //user = session.get(UserDeliveryRequestModel.class, id);
            //Query<UserDeliveryRequestModel> query = session.createNamedQuery("get_user_deliveries_by_erunnerid", UserDeliveryRequestModel.class);
            //query.setParameter("id", id);
            NativeQuery<UserDeliveryRequestModel> query = session.getNamedNativeQuery("get_user_deliveries_by_erunnerid");
            query.setParameter("id", id);
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
