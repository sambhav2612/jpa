/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao;

import javax.persistence.EntityManagerFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class EntityFactorySingleton {

    private static final Log log = LogFactory.getLog(EntityFactorySingleton.class);
    private final static String className = EntityFactorySingleton.class.getSimpleName();
    private EntityManagerFactory emFactory = null;
    
    private static final EntityFactorySingleton INSTANCE = new EntityFactorySingleton();
    
    private EntityFactorySingleton() {
        log.debug("--> ************ Initialisation de " + className + " ************");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emFactory;
    }
    
    public static EntityFactorySingleton getInstance() {
        return EntityFactorySingleton.INSTANCE;
    }
}
