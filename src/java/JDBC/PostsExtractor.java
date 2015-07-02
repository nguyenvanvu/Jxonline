/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBC;


import DTO.Posts;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author VuNguyen
 */
public class PostsExtractor implements ResultSetExtractor<Posts>{
    public Posts extractData(ResultSet resultSet) throws SQLException,DataAccessException {  
        Posts post = new Posts();
        post.setPost_link(resultSet.getString("post_link"));
        post.setPost_text(resultSet.getString("post_text"));
        post.setPost_subject(resultSet.getString("post_subject"));
        post.setPost_type(resultSet.getString("post_type"));
        post.setPost_time(resultSet.getTimestamp("post_time"));
        
        return post;
    }
}
