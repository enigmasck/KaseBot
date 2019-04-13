/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kaichi
 */
public class DAO {
    
    public static final String URL = "jdbc:mysql://localhost:3306/kasebot";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "12345678";
    private Connection con;
    
    
    public DAO(){
        try{
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(SQLException sqle){
            System.out.println(sqle);
        }
    }
      
    
    public Map<String, Integer> getNumberOfCaseInDifferentStatus(String Date) throws SQLException {
        Map<String, Integer> map = new HashMap<>();
        String sql = "SELECT cases_status, count(*) FROM cases GROUP BY cases_status;";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next() == true){
            map.put(resultSet.getString(1), resultSet.getInt(2));
        }
        return map;
    }
    
    
}
