package com.epam.programsportalautomation.test;

import com.epam.programsportalautomation.database.DataBaseUtility;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class JdbcFunctionsTest {
    @Test
    public void fetchesAllCollegesFromProgramsPortal(){
        List<String> colleges = DataBaseUtility.getColumnValueWithselectAttributeQuery("name","colleges");
        for(int i=0;i< colleges.size();i++)
			System.out.println(colleges.get(i));
    }
    @Test
    public void fetchesSelectedCollegeFromProgramsPortal(){
        List<String> college = DataBaseUtility.getCoumnValueWithEqualToConditionQuery("name","colleges","name","hutafutschool");
        for(int i=0;i< college.size();i++)
            System.out.println(college.get(i));
    }
    @Test
    public void fetchesEntireTableFromProgramsPortal(){
        List<String> table = DataBaseUtility.getEntireTableWithQuery("colleges");
        for(int i=0;i< table.size();i++)
            System.out.println(table.get(i));
    }

    public static boolean  checkIfCollegeAdded() throws SQLException, IOException {
        PreparedStatement statement =  DataBaseUtility.getCountOfInsertedCollegeInDataBase();
        ResultSet results = statement.executeQuery();
        results.next();
        System.out.println(results.getInt("count(*)"));
        if(results.getInt("count(*)")>=1)
            return true;
       return false;

    }
}
