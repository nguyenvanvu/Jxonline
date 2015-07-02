/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBC;

import DTO.EmailActive;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author VuNguyen
 */
public class EmailActiveExtractor implements ResultSetExtractor<EmailActive>{
    public EmailActive  extractData(ResultSet resultSet) throws SQLException,
    DataAccessException {
  
        EmailActive emailActive = new EmailActive();
        emailActive.setActivecode(resultSet.getString("activecode"));
        emailActive.setUsername(resultSet.getString("username"));
        return emailActive;
    }
}
