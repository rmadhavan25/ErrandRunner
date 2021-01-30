package com.errandrunner.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.errandrunner.hibernateutil.HibernateUtil;
import com.errandrunner.models.CookDishModel;
import com.errandrunner.models.CookModel;
import com.errandrunner.models.ErunnerModel;
import com.errandrunner.models.UserModel;



public class CookDao {

    
    public void saveCook(CookModel user) {
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
    
    public void saveDish(CookDishModel user) {
    	System.out.println("test");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	//System.out.println("test 1");
            // start a transaction
            transaction = session.beginTransaction();
            //System.out.println("test 2");
            // save the student object
            session.save(user);
           // System.out.println("test 3");
            // commit transaction
            transaction.commit();
            //System.out.println("test 4");
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
    public void updateCook(CookModel user) {
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

    public void updateDish(CookDishModel user) {
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
    public void deleteCook(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            CookModel user = session.get(CookModel.class, id);
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

    public void deleteDish(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            CookDishModel user = session.get(CookDishModel.class, id);
            if (user != null) {
                session.delete(user);
                System.out.println("food is deleted");
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
    public CookModel getCook(int id) {

        Transaction transaction = null;
        CookModel user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = session.get(CookModel.class, id);
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
    
    public CookDishModel getDishById(int id) {

        Transaction transaction = null;
        CookDishModel user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = session.get(CookDishModel.class, id);
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
	public List < CookModel > getAllCook() {

        Transaction transaction = null;
        List < CookModel > listOfUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfUser = session.createQuery("from CookModel").list();

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
    
    public CookModel getCookFromUser(int user) {

        Transaction transaction = null;
        CookModel cook = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            Query<CookModel> query = session.createNamedQuery("get_cook_by_user", CookModel.class);
            query.setParameter("userid", user);
            cook = query.getSingleResult();
           
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return cook;
    }
    
    public List<CookDishModel> getFoodsByCookId(int cookId) {
    	Transaction transaction = null;
    	List<CookDishModel> food = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            //user = session.get(ErunnerModel.class, id);
            Query<CookDishModel> query = session.createNamedQuery("get_food_by_Cook_id", CookDishModel.class);
            query.setParameter("cookid", cookId);
            food = query.getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return food;
    }
    
    
   
}