/**
 * 
 */
package com.app.ecclesiamainframe.util;

//import java.util.HashMap;
//import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.app.ecclesiamainframe.entity.AreaReports;
import com.app.ecclesiamainframe.entity.Areas;
import com.app.ecclesiamainframe.entity.CellReports;
import com.app.ecclesiamainframe.entity.Cells;
import com.app.ecclesiamainframe.entity.DcaCourses;
import com.app.ecclesiamainframe.entity.DcaLevels;
import com.app.ecclesiamainframe.entity.DcaStudents;
import com.app.ecclesiamainframe.entity.Members;
import com.app.ecclesiamainframe.entity.Users;

/**
 * @author Harry
 *
 */

import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.cfg.Environment;
//import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
   private static StandardServiceRegistry registry;
   private static SessionFactory sessionFactory;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory == null) {
         try {
        	 
        	 // Create the SessionFactory from hibernate.cfg.xml
         	Configuration configuration = new Configuration();
         	configuration.configure("hibernate.cfg.xml");
         	System.out.println("Hibernate Configuration loaded");
        	 
        	 // Create StandardServiceRegistry
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            
//            registryBuilder.applySettings(settings);
            registryBuilder.applySettings(configuration.getProperties());
            registry = registryBuilder.build();
         	
         	//apply configuration property settings to StandardServiceRegistryBuilder
        	////ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	////System.out.println("Hibernate serviceRegistry created");
        	
        	////SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            
            // Create MetadataSources
            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(Members.class);
            sources.addAnnotatedClass(Users.class);
            sources.addAnnotatedClass(DcaStudents.class);
            sources.addAnnotatedClass(AreaReports.class);
            sources.addAnnotatedClass(Areas.class);
            sources.addAnnotatedClass(Cells.class);
            sources.addAnnotatedClass(CellReports.class);
            sources.addAnnotatedClass(DcaCourses.class);
            sources.addAnnotatedClass(DcaLevels.class);
//            
//            // Create Metadata
            Metadata metadata = sources.getMetadataBuilder().build();
            
            // Create SessionFactory
            sessionFactory = metadata.getSessionFactoryBuilder().build();
         } catch (Exception e) {
            if (registry != null) {
               StandardServiceRegistryBuilder.destroy(registry);
            }
            e.printStackTrace();
         }
      }
      return sessionFactory;
   }
   
 //Utility method to return SessionFactory
   public static void shutdown() {
      if (registry != null) {
         StandardServiceRegistryBuilder.destroy(registry);
      }
   }
}
