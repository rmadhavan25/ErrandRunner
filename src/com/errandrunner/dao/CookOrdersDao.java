package com.errandrunner.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.errandrunner.hibernateutil.HibernateUtil;
import com.errandrunner.models.CookModel;
import com.errandrunner.models.CookOrdersModel;
import com.errandrunner.models.UserModel;

public class CookOrdersDao {
	
	public void save(CookOrdersModel order) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(order);
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
    public void update(CookOrdersModel order) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(order);
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
            CookOrdersModel order = session.get(CookOrdersModel.class, id);
            if (order != null) {
                session.delete(order);
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
    public CookOrdersModel get(int id) {

        Transaction transaction = null;
        CookOrdersModel order = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            order = session.get(CookOrdersModel.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return order;
    }

    /**
     * Get all Users
     * @return
     */
    //@SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
	public List < CookOrdersModel > getOrdersFromCook(CookModel cook) {

        Transaction transaction = null;
        List < CookOrdersModel > orders = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            System.out.println("HERE in COM");
            NativeQuery<CookOrdersModel> query = session.getNamedNativeQuery("get_orders_from_cook");
            query.setParameter("cookid", cook.getId());
            orders = (List<CookOrdersModel>)query.getResultList();
            System.out.println("COM OVER");

            // commit transaction
            transaction.commit();
         
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return orders;
    }
    
    public List < CookOrdersModel > getOrdersFromUser(UserModel user) {

        Transaction transaction = null;
        List < CookOrdersModel > orders = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            Query<CookOrdersModel> query = session.createNamedQuery("get_orders_from_user", CookOrdersModel.class);
            query.setParameter("userid", user.getId());
            orders = query.getResultList();
           

            // commit transaction
            transaction.commit();
         
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return orders;
    }
 
}
