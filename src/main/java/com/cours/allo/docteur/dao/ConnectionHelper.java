/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.EntityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.graalvm.compiler.replacements.Log;

/**
 *
 * @author ElHadji
 */
public class ConnectionHelper {

    private static final Log log = LogFactory.getLog(ConnectionHelper.class);

    public static void closeSqlResources(EntityManager em) {
    }

    public static void closeSqlResources(Connection connection) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection("localhost:3306");
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * from Adresse");
        } catch (SQLException e) {
            System.err.println("exception occured!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("exception occured!");
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    System.err.println("exception occured!");
                } finally {
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        System.err.println("exception occured!");
                    }
                }
            }
        }
    }
}
