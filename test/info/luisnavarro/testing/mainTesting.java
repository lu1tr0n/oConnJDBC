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
package info.luisnavarro.testing;

import info.luisnavarro.jdbc.mysqlJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lu1tr0n
 */
public class mainTesting {
    public static void main(String[] args) {
        String query = "select count(*) from books";
        mysqlJDBC con = new mysqlJDBC("localhost", "3306", "biblioteca", "root", "");
        try {
            con.connectJDBC();
            ResultSet rs = con.executeJDBC(query);
            while(rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total de libros en la tabla: " + count);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mainTesting.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.closeConnJDBC();
        }        
    }
}
