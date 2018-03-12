package com.pawe322.webmanager.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pawe322.webmanager.beans.Pet;
import com.pawe322.webmanager.beans.UserAccount;
 
 
public class DBUtils {
 
    public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a where a.User_Name = ? and a.password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String gender = rs.getString("Gender");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender);
            return user;
        }
        return null;
    }
 
    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a where a.User_Name = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            String gender = rs.getString("Gender");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender);
            return user;
        }
        return null;
    }
 
    public static List<Pet> queryPet(Connection conn) throws SQLException {
        String sql = "Select a.id, a.name, a.type_of_animal, a.age, a.`height[cm]` from pets a ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Pet> list = new ArrayList<Pet>();
        while (rs.next()) {
        	Integer id = rs.getInt("id");
            String name = rs.getString("name");
            String typeOfAnimal = rs.getString("type_of_animal");
            Integer age = rs.getInt("age");
            Integer height = rs.getInt("height[cm]");
            Pet pet = new Pet();
            pet.setId(id);
            pet.setName(name);
            pet.setTypeOfAnimal(typeOfAnimal);
            pet.setAge(age);
            pet.setHeight(height);
            list.add(pet);
        }
        return list;
    }
 
    public static Pet findPet(Connection conn, String name) throws SQLException {
        String sql = "Select a.name, a.type_of_animal, a.age, a.`height[cm]` from pets a where name=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, name);
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            String typeOfAnimal = rs.getString("type_of_animal");
            Integer age = rs.getInt("age");
            Integer height = rs.getInt("height[cm]");
            Pet pet = new Pet(name, typeOfAnimal, age, height);
            return pet;
        }
        return null;
    }
 
    public static void updatePet(Connection conn, Pet pet) throws SQLException {
        String sql = "Update pets set type_of_animal=?, age=?, `height[cm]`=? where name=? ";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(4, pet.getName());
        pstm.setString(1, pet.getTypeOfAnimal());
        pstm.setInt(2, pet.getAge());
        pstm.setInt(3, pet.getHeight());
        pstm.executeUpdate();
    }
 
    public static void insertPet(Connection conn, Pet pet) throws SQLException {
        String sql = "Insert into pets(name,type_of_animal,age,`height[cm]`) values (?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, pet.getName());
        pstm.setString(2, pet.getTypeOfAnimal());
        pstm.setInt(3, pet.getAge());
        pstm.setInt(4, pet.getHeight());
        pstm.executeUpdate();
    }
 
    public static void deletePet(Connection conn, String name) throws SQLException {
        String sql = "Delete From pets where name=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.executeUpdate();
    }
 
}