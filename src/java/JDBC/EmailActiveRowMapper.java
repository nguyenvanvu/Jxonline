/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBC;

import DTO.EmailActive;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VuNguyen
 */
public class EmailActiveRowMapper  implements RowMapper<EmailActive>{
    @Override
    public EmailActive mapRow(ResultSet resultSet, int line) throws SQLException {
     EmailActiveExtractor emailActiveExtractor = new EmailActiveExtractor();
     return emailActiveExtractor.extractData(resultSet);
    }
}
