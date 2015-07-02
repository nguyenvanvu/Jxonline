/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.RegisterInfo;
import DTO.User;
import static Function.Function.md5;
import JDBC.UserRowMapper;
import java.util.ArrayList;  
import java.util.List;  
import javax.sql.DataSource;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author VuNguyen
 */
public class UserDAOImpl implements UserDAO {

 @Autowired
 DataSource dataSource;
 
 @Autowired
 DataSource dataSourceMysql;

 @Override
 public List<User> getUserList() {
  List userList = new ArrayList();

  String sql = "select * from Account_Info";

  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  userList = jdbcTemplate.query(sql, new UserRowMapper());
  return userList;
 }

 @Override
 public User getUser(String cAccName) {
  String sql = "select * from user where username = ?";
  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
  List<User> userList = jdbcTemplate.query(sql,new Object[]{cAccName}, new UserRowMapper());
     if (userList.isEmpty()) {
         return null;
     }
  return userList.get(0);
 }

 @Override
 public void insertData(RegisterInfo user){
    String sql = "INSERT INTO Account_Info(cAccName,cPassWord,cSecPassWord,iClientID,nExtPoint,nExtPoint1,nExtPoint2,nExtPoint3,nExtPoint4,nExtPoint5,nExtPoint6,nExtPoint7,bParentalControl,bisBanned,bisUseOTP,iOTPSessionLifeTime,iServiceFlag)"
           
    + "VALUES (?, ?, ?,0,1,1,1,1,1,1,1,1,'false','false','false',1,0)";
    
    String sql1 = "Insert into Account_Habitus(cAccName,dEndDate)"
            + "values(?,'10/10/2020 10:10:10 AM')";

    String MySql = "Insert into user(username,password1,password2,email,createdatetime) "
            +  "values(?,?,?,?,?)";
    
    
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
    
    //Mssql
    jdbcTemplate.update(  
    sql,  
    new Object[] { user.getcAccName(), md5(user.getcPassWord()),  
     md5(user.getcPassWord())});
    
    jdbcTemplate.update(
    sql1,
    new Object[]{user.getcAccName()});
    
    //Mysql
    jdbcTemplate.setDataSource(dataSourceMysql);
    jdbcTemplate.update(
            MySql,
            new Object[] {user.getcAccName(),md5(user.getcPassWord()),md5(user.getcPassWord()),user.getcEmail(),new java.util.Date()});
    }
   
 
    @Override
    public boolean IsExistsEmail(String Email){
        
        String sql = "select * from user where email = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List<User> userList  =  jdbcTemplate.query(sql,new Object[]{Email}, new UserRowMapper());
        return !userList.isEmpty();
    }
    @Override
    public boolean IsExistsUserName(String userName){
       String sql = "select * from user where username = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List<User> userList = (List<User>) jdbcTemplate.query(sql,new Object[]{userName}, new UserRowMapper());
        return !userList.isEmpty();
     }

    @Override
    public void ChangePass(String cAccName, DTO.ChangePass changePass) {
         String sql = "update Account_Info set cPassWord = ? where cAccName = ? and cSecPassWord = ?";
          JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
    
        //Mssql
        jdbcTemplate.update(  
        sql,  
        new Object[] { md5(changePass.getcNewPassWord()), cAccName,  
         md5( changePass.getcSecPassWord())});
        
        String sql1 = "update user set passsword1 = ? where username = ? and password2 = ?";
        
        jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        jdbcTemplate.update(sql1,  new Object[]{md5(changePass.getcNewPassWord()), cAccName,  
         md5( changePass.getcSecPassWord())} );
        
    }

    @Override
    public void editData(User user) {
        String sql = "update Account_Info set cPassWord = ?,cSecPassWord = ? where cAccName = ? ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
  
        //Mssql
        jdbcTemplate.update(  
        sql,  
        new Object[] { user.getcPassWord(),   
         user.getcSecPassWord(),user.getcAccName()});  
        
        String sql1 = "update user set password1 = ? , password2 = ? where username = ? ";
        //Mysql
        jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        jdbcTemplate.update(sql1,  new Object[]{user.getcPassWord(), user.getcSecPassWord(),user.getcAccName()});
        
        
    }

    @Override
    public User getUserFromEmail(String Email) {
        String sql = "select * from user where email = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List<User> userList = jdbcTemplate.query(sql,new Object[]{Email}, new UserRowMapper());
        if (userList.isEmpty()) {
            return null;
        }
        return userList.get(0);
        
    }

    @Override
    public void editPersonInfo(User user) {
        String sql1 = "update user set fullname = ? , sex = ?, birthday = ? , phone = ? where username = ? ";
        //Mysql
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        jdbcTemplate.update(sql1,  new Object[]{user.getcRealName(), user.getCSex(),user.getdBirthDay(),user.getcPhone(),user.getcAccName()});
    }
      @Override
    public void KickAcc(User user) {
        String sql = "update Account_Info set iClientID = 0 where  cAccName = ?";
       
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(  
        sql,  
        new Object[] {user.getcAccName()});  
        
    }
    
 
}


