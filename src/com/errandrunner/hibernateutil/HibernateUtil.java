package com.errandrunner.hibernateutil;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.errandrunner.models.CookDishModel;
import com.errandrunner.models.CookModel;
//import com.errandrunner.models.CookDishModel;
//import com.errandrunner.models.CookModel;
import com.errandrunner.models.ErunnerModel;
import com.errandrunner.models.UserDeliveryRequestModel;
import com.errandrunner.models.UserModel;
import com.errandrunner.models.UserServiceRequestModel;

public class HibernateUtil {
 private static SessionFactory sessionFactory;

 public static SessionFactory getSessionFactory() {
  if (sessionFactory == null) {
   try {
    Configuration configuration = new Configuration();

    // Hibernate settings equivalent to hibernate.cfg.xml's properties
    Properties settings = new Properties();
    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/errand_runner?useSSL=false");
    settings.put(Environment.USER, "root");
    settings.put(Environment.PASS, "sudha10");
    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
    settings.put(Environment.STORAGE_ENGINE,"innodb");

    settings.put(Environment.SHOW_SQL, "true");

    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

    settings.put(Environment.HBM2DDL_AUTO, "update");

    configuration.setProperties(settings);
    configuration.addAnnotatedClass(UserModel.class);
    configuration.addAnnotatedClass(CookModel.class);
    configuration.addAnnotatedClass(ErunnerModel.class);
    configuration.addAnnotatedClass(UserServiceRequestModel.class);
    configuration.addAnnotatedClass(UserDeliveryRequestModel.class);
    configuration.addAnnotatedClass(CookDishModel.class);
    
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
      .applySettings(configuration.getProperties()).build();
    System.out.println("Hibernate Java Config serviceRegistry created");
    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    return sessionFactory;

   } catch (Exception e) {
	  System.out.print("here");
    e.printStackTrace();
   }
  }
  return sessionFactory;
 }
}