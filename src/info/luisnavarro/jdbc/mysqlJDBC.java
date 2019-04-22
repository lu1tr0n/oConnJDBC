/*
 * Copyright (C) 2019 lu1tr0n
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package info.luisnavarro.jdbc;

/**
 * Import libreries
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lu1tr0n
 */
public class mysqlJDBC {
    
    /**
     *  To declare the variables
     */
    private String driver;
    private String dataBase;
    private String hostname;
    private String port;
    private String url;
    private String username;
    private String password;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    /**
     * Construct
     */
    public mysqlJDBC() {
        new Throwable("No Data for Connection");
    }
    /**
     * @since 07/03/2019
     * @param dataBase
     * @param hostname
     * @param port
     * @param username
     * @param password 
     */
    public mysqlJDBC( String hostname, String port, String dataBase, String username, String password) {
        this.dataBase = dataBase;
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
        this.url = "jdbc:mysql:‪//" + this.hostname + ":" + this.port + "/" + this.dataBase + "?"
                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.url = this.url.replaceAll("\\s","").trim();
    }
    
    /**
     * @return name Database
     */
    public String getDataBase() {
        return dataBase;
    }

    /**
     * Set name DB
     * @param dataBase 
     */
    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    /**
     * @return the name of Hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPort() {
        return port;
    }

    /**
     * Set port for define url
     * @param port 
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Get password for DB
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set Password
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }    
    
    /**
     * Method initialize url connection MySQL
     */
    private String getCompleteUrlConn() {
        return this.url;
    }
    
    /**
     * Connection to MySQL
     */
    public void connectJDBC() {
        try {
            this.getCompleteUrlConn();
            this.con = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (SQLException ex) {
            Logger.getLogger(mysqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Execute query for MySQL
     * @param query 
     */
    public ResultSet executeJDBC(String query) {
        try {
            this.stmt = con.createStatement();
            this.rs = stmt.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(mysqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return this.rs;
        }
    }
    
    /**
     * Close Connection to MySQL
     */
    public void closeConnJDBC() {
        try {
            this.con.close();
            this.stmt.close();
            this.rs.close();            
        } catch (SQLException ex) {
            Logger.getLogger(mysqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
