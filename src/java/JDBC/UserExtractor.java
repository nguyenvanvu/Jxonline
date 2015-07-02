/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBC;

import DTO.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author VuNguyen
 */
public class UserExtractor implements ResultSetExtractor<User> {

 public User extractData(ResultSet resultSet) throws SQLException,
   DataAccessException {
  
  User user = new User();
  
  user.setcAccName(resultSet.getString("username"));
  user.setcPassWord(resultSet.getString("password1"));
  user.setcSecPassWord(resultSet.getString("password2"));
  user.setcEmail(resultSet.getString("email"));
  user.setcRealName(resultSet.getString("fullname"));
  user.setCSex(resultSet.getInt("sex"));
  user.setdBirthDay(resultSet.getDate("birthday"));
  user.setcPhone(resultSet.getString("phone"));
  user.setCreatedatetime(resultSet.getDate("createdatetime"));
  user.setEmailactive(resultSet.getInt("emailactive"));
  
  return user;
 }

}