package com.app.ecclesiamainframe.util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class MetadataExtractorIntegrator implements org.hibernate.integrator.spi.Integrator {

 public static final MetadataExtractorIntegrator INSTANCE = new MetadataExtractorIntegrator();

 private Database database;

	@Override
	public void integrate(
	        Metadata metadata,
	        SessionFactoryImplementor sessionFactory,
	        SessionFactoryServiceRegistry serviceRegistry) {
	
	    database = metadata.getDatabase();
	}
	
	@Override
	public void disintegrate(
	    SessionFactoryImplementor sessionFactory,
	    SessionFactoryServiceRegistry serviceRegistry) {
	
	}
	
	public Database getDatabase() {
	    return database;
	}
}
