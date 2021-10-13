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

    public ResultSet StGroupUpdate(Integer groupId, String[] param_names, String[] param_values)
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
        ResultSet rs = stmt.executeQuery("UPDATE st_groups SET "+query+" WHERE id="+groupId+" RETURNING *");
        return  rs;
    }

    public ResultSet StGroupCreate(String[] param_names, String[] param_values)
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
            query+=param_values[i];
            if(i!=param_values.length - 1) query += " , ";
        }

        ResultSet rs = stmt.executeQuery("INSERT INTO st_groups ( "+query+" ) RETURNING *");
        return  rs;
    }

    public ResultSet StGroupDelete(Integer groupId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("DELETE FROM st_groups WHERE id="+groupId+" RETURNING *");
        return  rs;
    }

    public ResultSet StGroupGetById(Integer groupId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM st_groups WHERE id="+groupId);
        return  rs;
    }


    //lessons

    public ResultSet LessonUpdate(Integer lessonId, String[] param_names, String[] param_values)
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
        ResultSet rs = stmt.executeQuery("UPDATE Lessons SET "+query+" WHERE id="+lessonId+" RETURNING *");
        return  rs;
    }

    public ResultSet LessonCreate(String[] param_names, String[] param_values)
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
            query+=param_values[i];
            if(i!=param_values.length - 1) query += " , ";
        }

        ResultSet rs = stmt.executeQuery("INSERT INTO Lessons ( "+query+" ) RETURNING *");
        return  rs;
    }

    public ResultSet LessonDelete(Integer lessonId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("DELETE FROM Lessons WHERE id="+lessonId+" RETURNING *");
        return  rs;
    }

    public ResultSet LessonGetById(Integer lessonId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Lessons WHERE id="+lessonId);
        return  rs;
    }

    //subjects

    public ResultSet SubjectUpdate(Integer subjectId, String[] param_names, String[] param_values)
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
        ResultSet rs = stmt.executeQuery("UPDATE Subjects SET "+query+" WHERE id="+subjectId+" RETURNING *");
        return  rs;
    }

    public ResultSet SubjectCreate(String[] param_names, String[] param_values)
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
            query+=param_values[i];
            if(i!=param_values.length - 1) query += " , ";
        }

        ResultSet rs = stmt.executeQuery("INSERT INTO Subjects ( "+query+" ) RETURNING *");
        return  rs;
    }

    public ResultSet SubjectDelete(Integer subjectId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("DELETE FROM Subjects WHERE id="+subjectId+" RETURNING *");
        return  rs;
    }

    public ResultSet SubjectGetById(Integer subjectId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Subjects WHERE id="+subjectId);
        return  rs;
    }

    //students

    public ResultSet StudentUpdate(Integer studentId, String[] param_names, String[] param_values)
            throws DbQueryException, SQLException {
        if(param_names.length != param_values.length)
            throw new DbQueryException("Unmatching sizes of fiels and values arrays");
        Statement stmt = conn.createStatement();
        String query="";
        for(int i=0; i<param_names.length; i++) {
            query+=param_names[i]+" = '"+param_values[i]+"'";
            if(i!=param_names.length - 1) query += " , ";

        }
        ResultSet rs = stmt.executeQuery("UPDATE Students SET "+query+" WHERE id="+studentId+" RETURNING *");
        return  rs;
    }

    public ResultSet StudentCreate(String[] param_names, String[] param_values)
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
            query+=param_values[i];
            if(i!=param_values.length - 1) query += " , ";
        }

        ResultSet rs = stmt.executeQuery("INSERT INTO Students ( "+query+" ) RETURNING *");
        return  rs;
    }

    public ResultSet StudentDelete(Integer studentId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("DELETE FROM Students WHERE id="+studentId+" RETURNING *");
        return  rs;
    }

    public ResultSet StudentGetById(Integer studentId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Students WHERE id="+studentId);
        return  rs;
    }

    //teachers

    public ResultSet TeacherUpdate(Integer teacherId, String[] param_names, String[] param_values)
            throws DbQueryException, SQLException {
        if(param_names.length != param_values.length)
            throw new DbQueryException("Unmatching sizes of fiels and values arrays");
        Statement stmt = conn.createStatement();
        String query="";
        for(int i=0; i<param_names.length; i++) {
            query+=param_names[i]+" = '"+param_values[i]+"'";
            if(i!=param_names.length - 1) query += " , ";

        }
        ResultSet rs = stmt.executeQuery("UPDATE Teachers SET "+query+" WHERE id="+teacherId+" RETURNING *");
        return  rs;
    }

    public ResultSet TeacherCreate(String[] param_names, String[] param_values)
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
            query+=param_values[i];
            if(i!=param_values.length - 1) query += " , ";
        }

        ResultSet rs = stmt.executeQuery("INSERT INTO Teachers ( "+query+" ) RETURNING *");
        return  rs;
    }

    public ResultSet TeacherDelete(Integer teacherId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("DELETE FROM Teachers WHERE id="+teacherId+" RETURNING *");
        return  rs;
    }

    public ResultSet TeacherGetById(Integer teacherId) throws SQLException  {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Teachers WHERE id="+teacherId);
        return  rs;
    }


}
