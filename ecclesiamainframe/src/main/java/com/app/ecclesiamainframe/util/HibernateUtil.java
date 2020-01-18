/**
 * 
 */
package com.app.ecclesiamainframe.util;

import java.util.HashMap;
import java.util.Map;

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
import org.hibernate.cfg.Environment;


public class HibernateUtil {
   private static StandardServiceRegistry registry;
   private static SessionFactory sessionFactory;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory == null) {
         try {
        	 
        	 // Create StandardServiceRegistry
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

            //Configuration properties
//            Map<String, Object> settings = new HashMap<>();
//            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/ecclesia_mainframe_db?useSSL=false");
//            settings.put(Environment.USER, "devteam");
//            settings.put(Environment.PASS, "softmysql2019");
//            settings.put(Environment.HBM2DDL_AUTO, "validate");
//            settings.put(Environment.SHOW_SQL, true);
            
            Map<String, Object> settings = new HashMap<>();
            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://bf6ef182b3f6be:8c066a58@us-cdbr-gcp-east-01.cleardb.net:3306/gcp_cc6c46add7dbba33ef02?useSSL=false");
            settings.put(Environment.USER, "bf6ef182b3f6be");
            settings.put(Environment.PASS, "8c066a58");
            settings.put(Environment.HBM2DDL_AUTO, "validate");
            settings.put(Environment.SHOW_SQL, true);
            
            registryBuilder.applySettings(settings);
            registry = registryBuilder.build();
            
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
            
            // Create Metadata
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
