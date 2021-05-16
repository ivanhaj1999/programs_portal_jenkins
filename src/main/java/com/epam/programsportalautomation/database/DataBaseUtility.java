package com.epam.programsportalautomation.database;
import com.epam.programsportalautomation.constants.JDBCconstants;
import com.epam.programsportalautomation.dataproviders.ExcelDataProvider;
import com.epam.programsportalautomation.framework.logs.LogUtilityFunctions;
import com.epam.programsportalautomation.pojo.College;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.sql.*;
import java.util.*;

import static com.epam.programsportalautomation.constants.JDBCconstants.*;
import static com.epam.programsportalautomation.framework.ExcelResusableFunctions.getCollegeInfoFromExcelSheet;

public class DataBaseUtility {

    private static FileInputStream file;
    private static Properties jdbcUserConfig;

    private DataBaseUtility(){}
    public static void setUp(){
        try {
            file=new FileInputStream(new File(JDBCconstants.CONFIGPATH));
            jdbcUserConfig = new Properties();
            jdbcUserConfig.load(file);
        }catch (IOException exception){
            LogUtilityFunctions.logInfoError("IO Exception while reading the file "+exception.getStackTrace());
        }
    }
    public static Connection getDataBaseConnection(){
            setUp();
        String username = jdbcUserConfig.getProperty("jdbc_username");
        String password = jdbcUserConfig.getProperty("jdbc_password");
        String schema = jdbcUserConfig.getProperty("schema");
        String hostlink = jdbcUserConfig.getProperty("host_link");
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(hostlink+schema,username,password);
            } catch (SQLException e) {
                LogUtilityFunctions.logInfoError("SQL Exception for Connection object"+e.getStackTrace());
            }
            return connection;
        }
        public static ResultSet queryStringTaker(String query) {
            ResultSet resultSet = null;
            setUp();
            String driverclass = jdbcUserConfig.getProperty("jdbc_driver_class");
            try {
                Class.forName(driverclass);
                Connection connection = getDataBaseConnection();
                Statement statement = connection.createStatement();
                 resultSet = statement.executeQuery(query);
            } catch (Exception e) {
                LogUtilityFunctions.logInfoError("Class not found exception for JDBC driver class "+e.getStackTrace());
            }
            return resultSet;
        }
        public static List<String> getCoumnValueWithEqualToConditionQuery(String columnlabel,String tablename,String extractbylabel,String value){
            List<String> listofColumnValues = new ArrayList<>();
            try {
            ResultSet resultSet = querySelectingAttributeWithEqualCondition(columnlabel,tablename,extractbylabel,value);
            while (resultSet.next())
                listofColumnValues.add(resultSet.getString(columnlabel));
            }catch (Exception e){
            e.printStackTrace();
    }
            return listofColumnValues;
        }
        public static List<String> getColumnValueWithselectAttributeQuery(String attribute,String tablename) {
            List<String> listofColumnValues = new ArrayList<>();
            try {
                ResultSet resultSet = querySelectingAttribute(attribute,tablename);
                while (resultSet.next())
                    listofColumnValues.add(resultSet.getString(attribute));
            }catch (Exception e){
                e.printStackTrace();
            }

            return listofColumnValues;
        }
        public static List<String> getEntireTableWithQuery(String tablename) {
            List<String> listofColumnValues = new ArrayList<>();
            try {
                ResultSet resultSet = queryReturningEntireTable(tablename);
                while (resultSet.next())
                    listofColumnValues.add(resultSet.getString(ID_INDEX)+" "+resultSet.getString(NAME_INDEX)+" "+
                            resultSet.getString(CITY_INDEX)+" "+resultSet.getString(GROUP_INDEX)+" "+resultSet.getString(PTO_NAME_INDEX)+" "+
                            resultSet.getString(PTO_EMAIL_INDEX));
            }catch (Exception e){
                e.printStackTrace();
            }
            return listofColumnValues;
        }

        public static PreparedStatement getCountOfInsertedCollegeInDataBase() throws IOException {
            PreparedStatement preparedStatement = null;
            College college = getCollegeInfoFromExcelSheet();

            try {
                preparedStatement = getDataBaseConnection().prepareStatement("select count(*) from colleges where name=? and city=? and colleges.group=? and pto_name=? and pto_email=?");
                preparedStatement.setString(1, college.getCollegeName());
                preparedStatement.setString(3, college.getCollegeCity());
                preparedStatement.setString(2, college.getCollegeGroup());
                preparedStatement.setString(4, college.getCollegePtoName());
                preparedStatement.setString(5, college.getCollegePtoEmail());

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return preparedStatement;
        }
        public static  ResultSet queryReturningEntireTable(String tablename){
            return queryStringTaker("select * from "+ tablename);
        }
        public static  ResultSet querySelectingAttribute(String attribute,String tablename){
            return queryStringTaker("select "+ attribute +" from "+ tablename);
        }
        public static  ResultSet querySelectingAttributeWithEqualCondition(String attribute1,String tablename,String attribute2,String value) {
            return queryStringTaker("select "+ attribute1 +" from "+ tablename+" where "+attribute2+" = "+"\""+value+"\"");
        }
}
