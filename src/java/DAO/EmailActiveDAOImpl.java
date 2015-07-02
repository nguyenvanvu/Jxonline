/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.EmailActive;
import DTO.User;
import static Function.Function.md5;
import JDBC.EmailActiveRowMapper;
import JDBC.UserRowMapper;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author VuNguyen
 */
public class EmailActiveDAOImpl implements  EmailActiveDAO{
    @Autowired
    DataSource dataSourceMysql;
    
    @Override
    public boolean EmailActive( String username){
        String sql = "select * from emailactive where username = ?";
         
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List<DTO.EmailActive> emailActiveList  =  jdbcTemplate.query(sql,new Object[]{username}, new EmailActiveRowMapper());
         if(emailActiveList.isEmpty()){
            sql = "select * from user where username = ?"; 
            List<User>   userlst =  jdbcTemplate.query(sql,new Object[]{username}, new UserRowMapper());
            User user = userlst.get(0);
            
            sql = "insert into emailactive(activecode,username)"
                    + "values(?,?)";
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String activecode = formatter.format(user.getCreatedatetime());
            jdbcTemplate.update(  
            sql,  
            new Object[] { md5(username) + md5(activecode),username});
            return true;
         }
         return false;
    }
     @Override
    public boolean CheckEmailActive(String activecode){
        String sql = "select * from emailactive where activecode = ?";
         
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List<DTO.EmailActive> emailActiveList  =  jdbcTemplate.query(sql,new Object[]{activecode}, new EmailActiveRowMapper());
         if(!emailActiveList.isEmpty()){
            EmailActive emailActive = emailActiveList.get(0);
     
            sql = "update user set emailactive = ? where username =?"; 
            jdbcTemplate.update(  
            sql,  
            new Object[] { 1,emailActive.getUsername()});
            
            sql = "delete from emailactive where activecode =?";
            jdbcTemplate.update(  
            sql,  
            new Object[] { emailActive.getActivecode()});
            
            return true;
         }
         return false;
    } 
}
