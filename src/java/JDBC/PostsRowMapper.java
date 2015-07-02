/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBC;

import DTO.Posts;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VuNguyen
 */
public class PostsRowMapper implements RowMapper<Posts> {
    @Override
    public Posts mapRow(ResultSet resultSet, int line) throws SQLException {
        PostsExtractor postExtractor = new PostsExtractor();
        return postExtractor.extractData(resultSet);
    }
}
