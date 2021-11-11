package com.example.application.db;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.Arrays;

import com.example.application.model.*;
import javax.persistence.*;

public class DbQueries {

    private Connection conn;

    public DbQueries(Connection conn)  {
        this.conn=conn;
    }

    //groups

    public void StGroupUpdate(Integer groupId, String[] param_names, String[] param_values)
            throws DbQueryException, SQLException {
        if(param_names.length != param_values.length)
            throw new DbQueryException("Unmatching sizes of fiels and values arrays");
        if(Arrays.asList(param_names).contains("id"))
            throw new DbQueryException("Can`t set autoincrement value");
        Statement stmt = conn.createStatement();
        String query="";
        for(int i=0; i<param_names.length; i++) {
           query+=param_names[i]+" = '"+param_values[i]+"'";
           if(i!=param_names.length - 1) query += " , ";

        }
        stmt.executeUpdate("UPDATE st_groups SET "+query+" WHERE id="+groupId+"");

    }

    public void StGroupCreate(String[] param_names, String[] param_values)
            throws DbQueryException, SQLException {
        if(param_names.length != param_values.length)
            throw new DbQueryException("Non-matching sizes of fields and values arrays");
        if(Arrays.asList(param_names).contains("id"))
            throw new DbQueryException("Can`t set autoincrement value");
        Statement stmt = conn.createStatement();
        String query="";
        for(int i=0; i<param_names.length; i++) {
            query+=param_names[i];
            if(i!=param_names.length - 1) query += " , ";
            else query+=" ) VALUES ( ";
        }

        for(int i=0; i<param_values.length; i++) {
            query+="'"+param_values[i]+"'";
            if(i!=param_values.length - 1) query += " , ";
        }

      stmt.executeUpdate("INSERT INTO st_groups ( "+query+" )");

    }

    public void StGroupDelete(Integer groupId) throws SQLException  {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM st_groups WHERE id="+groupId+"");
    }

    public ResultSet StGroupGetById(Integer groupId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM st_groups WHERE id="+groupId);
        return  rs;
    }


    //lessons

    public void LessonUpdate(Integer lessonId, String[] param_names, String[] param_values)
            throws DbQueryException, SQLException {
        if(param_names.length != param_values.length)
            throw new DbQueryException("Unmatching sizes of fiels and values arrays");
        if(Arrays.asList(param_names).contains("id"))
            throw new DbQueryException("Can`t set autoincrement value");
        Statement stmt = conn.createStatement();
        String query="";
        for(int i=0; i<param_names.length; i++) {
            query+=param_names[i]+" = '"+param_values[i]+"'";
            if(i!=param_names.length - 1) query += " , ";

        }
        stmt.executeUpdate("UPDATE Lessons SET "+query+" WHERE id="+lessonId+"");
    }

    public void LessonCreate(String[] param_names, String[] param_values)
            throws DbQueryException, SQLException {
        if(param_names.length != param_values.length)
            throw new DbQueryException("Non-matching sizes of fields and values arrays");
        if(Arrays.asList(param_names).contains("id"))
            throw new DbQueryException("Can`t set autoincrement value");
        Statement stmt = conn.createStatement();
        String query="";
        for(int i=0; i<param_names.length; i++) {
            query+=param_names[i];
            if(i!=param_names.length - 1) query += " , ";
            else query+=" ) VALUES ( ";
        }

        for(int i=0; i<param_values.length; i++) {
            query+="'"+param_values[i]+"'";
            if(i!=param_values.length - 1) query += " , ";
        }

        stmt.executeUpdate("INSERT INTO Lessons ( "+query+" )");
    }

    public void LessonDelete(Integer lessonId) throws SQLException  {
        Statement stmt = conn.createStatement();
       stmt.executeUpdate("DELETE FROM Lessons WHERE id="+lessonId+"");

    }

    public ResultSet LessonGetById(Integer lessonId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Lessons WHERE id="+lessonId);
        return  rs;
    }

    //subjects

    public void SubjectUpdate(Integer subjectId, String[] param_names, String[] param_values)
            throws DbQueryException, SQLException {
        if(param_names.length != param_values.length)
            throw new DbQueryException("Unmatching sizes of fiels and values arrays");
        if(Arrays.asList(param_names).contains("id"))
            throw new DbQueryException("Can`t set autoincrement value");
        Statement stmt = conn.createStatement();
        String query="";
        for(int i=0; i<param_names.length; i++) {
            query+=param_names[i]+" = '"+param_values[i]+"'";
            if(i!=param_names.length - 1) query += " , ";

        }
        stmt.executeUpdate("UPDATE Subjects SET "+query+" WHERE id="+subjectId+"");

    }

    public void SubjectCreate(String[] param_names, String[] param_values)
            throws DbQueryException, SQLException {
        if(param_names.length != param_values.length)
            throw new DbQueryException("Non-matching sizes of fields and values arrays");
        if(Arrays.asList(param_names).contains("id"))
            throw new DbQueryException("Can`t set autoincrement value");
        Statement stmt = conn.createStatement();
        String query="";
        for(int i=0; i<param_names.length; i++) {
            query+=param_names[i];
            if(i!=param_names.length - 1) query += " , ";
            else query+=" ) VALUES ( ";
        }

        for(int i=0; i<param_values.length; i++) {
            query+="'"+param_values[i]+"'";
            if(i!=param_values.length - 1) query += " , ";
        }

        stmt.executeUpdate("INSERT INTO Subjects ( "+query+" )");
    }

    public void SubjectDelete(Integer subjectId) throws SQLException  {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM Subjects WHERE id="+subjectId+"");
    }

    public ResultSet SubjectGetById(Integer subjectId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Subjects WHERE id="+subjectId);
        return  rs;
    }

    //students

    public void StudentUpdate(Integer studentId, String[] param_names, String[] param_values)
            throws DbQueryException, SQLException {
        if(param_names.length != param_values.length)
            throw new DbQueryException("Unmatching sizes of fiels and values arrays");
        Statement stmt = conn.createStatement();
        String query="";
        for(int i=0; i<param_names.length; i++) {
            query+=param_names[i]+" = '"+param_values[i]+"'";
            if(i!=param_names.length - 1) query += " , ";

        }
       stmt.executeUpdate("UPDATE Students SET "+query+" WHERE id="+studentId+"");
    }

    public void StudentCreate(String[] param_names, String[] param_values)
            throws DbQueryException, SQLException {
        if(param_names.length != param_values.length)
            throw new DbQueryException("Non-matching sizes of fields and values arrays");
        Statement stmt = conn.createStatement();
        String query="";
        for(int i=0; i<param_names.length; i++) {
            query+=param_names[i];
            if(i!=param_names.length - 1) query += " , ";
            else query+=" ) VALUES ( ";
        }

        for(int i=0; i<param_values.length; i++) {
            query+="'"+param_values[i]+"'";
            if(i!=param_values.length - 1) query += " , ";
        }

        stmt.executeUpdate("INSERT INTO Students ( "+query+" )");

    }

    public void StudentDelete(Integer studentId) throws SQLException  {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM Students WHERE id="+studentId+"");
    }

    public ResultSet StudentGetById(Integer studentId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Students WHERE id="+studentId);
        return  rs;
    }

    //teachers

    public void TeacherUpdate(Integer teacherId, String[] param_names, String[] param_values)
            throws DbQueryException, SQLException {
        if(param_names.length != param_values.length)
            throw new DbQueryException("Unmatching sizes of fiels and values arrays");
        Statement stmt = conn.createStatement();
        String query="";
        for(int i=0; i<param_names.length; i++) {
            query+=param_names[i]+" = '"+param_values[i]+"'";
            if(i!=param_names.length - 1) query += " , ";

        }
        stmt.executeUpdate("UPDATE Teachers SET "+query+" WHERE id="+teacherId+"");

    }

    public void TeacherCreate(String[] param_names, String[] param_values)
            throws DbQueryException, SQLException {
        if(param_names.length != param_values.length)
            throw new DbQueryException("Non-matching sizes of fields and values arrays");
        Statement stmt = conn.createStatement();
        String query="";
        for(int i=0; i<param_names.length; i++) {
            query+=param_names[i];
            if(i!=param_names.length - 1) query += " , ";
            else query+=" ) VALUES ( ";
        }

        for(int i=0; i<param_values.length; i++) {
            query+="'"+param_values[i]+"'";
            if(i!=param_values.length - 1) query += " , ";
        }

        stmt.executeUpdate("INSERT INTO Teachers ( "+query+" )");
    }

    public void TeacherDelete(Integer teacherId) throws SQLException  {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM Teachers WHERE id="+teacherId+"");
    }

    public ResultSet TeacherGetById(Integer teacherId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Teachers WHERE id="+teacherId);
        return  rs;
    }


}
