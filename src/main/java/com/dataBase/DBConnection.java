package com.dataBase;

import java.sql.Connection;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.sql.*;
import java.io.*;

public class DBConnection{
	private static CSVReader csvReader;
	private static BufferedReader lineReader; 
	public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/country_data?allowPublicKeyRetrieval=true&useSSL=false";
        String username = "root";
        String password = "root";
 
        String csvFilePath = "E:\\state_level.csv";
        Connection connection = null;
 
        try {
 
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
 
            String sql = "INSERT INTO statedata (state, confirmed, active, recovered, death) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
 
            lineReader = new BufferedReader(new FileReader(csvFilePath));
            String[] lineText ;
            FileReader filereader = new FileReader(csvFilePath); 
			csvReader =new CSVReaderBuilder(filereader).withSkipLines(1).build(); 
 
            lineReader.readLine(); // skip header line
 
            while ((lineText = csvReader.readNext()) != null) {
                String[] data = lineText;
               
                String state = data[0];
                String confirmed = data[1];
                String active = data[2];
                String recovered = data[3];
                String death = data[4];
                
                statement.setString(1, state);
                statement.setString(2, confirmed);
                statement.setString(3, active);
                statement.setString(4, recovered);
                statement.setString(5, death);
 
//                statement.addBatch();
// 
//                if (count % batchSize == 0) {
//                    statement.executeBatch();
//                }
//            }
// 
                statement.execute();
           lineReader.close();
 
            // execute the remaining queries
         //   statement.executeBatch();
 
            connection.commit();
           //connection.close();
 
        }
            }catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
 
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
 
    }
}