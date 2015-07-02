/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.Posts;
import DTO.Slide;
import JDBC.PostsRowMapper;
import JDBC.SlideRowMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author VuNguyen
 */
public class PostsDAOImpl implements PostsDAO {

    @Autowired
    DataSource dataSourceMysql;
    @Override
    public void insertData(Posts post) {
       String sql = "insert into posts(post_link,post_subject,post_text,post_time,post_type)   values(?,?,?,?,?)";
       JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql); 
       jdbcTemplate.update(sql, new Object[]{post.getPost_link(),
                                            post.getPost_subject(),
                                            post.getPost_text(),
                                            new java.util.Date(),
                                            post.getPost_type()});
    }

    @Override
    public void deleteData(String post_link) {
       String  sql = "delete from posts where post_link = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        jdbcTemplate.update(sql,new Object[]{post_link});
    }

    @Override
    public Posts getData(String post_link) {
        String sql = "select * from posts where post_link = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List<Posts> postList = jdbcTemplate.query(sql,new Object[]{post_link}, new PostsRowMapper());
        if (postList.size() != 1 ) {
            return null;
        }
        return postList.get(0);
    }

    @Override
    public void editData(Posts post) {
        String sql = "update posts set post_subject = ?, post_text = ?, post_time = ?,post_type = ? where post_link = ?";
       JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql); 
       jdbcTemplate.update(sql, new Object[]{
                                            post.getPost_subject(),
                                            post.getPost_text(),
                                            new java.util.Date(),
                                            post.getPost_type(),
                                            post.getPost_link()});
    }

    @Override
    public List<Posts> getList(int from, int to,String type) {
        String sql = "select * from posts where post_type = ?  order by post_time desc limit ?,?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List postList = jdbcTemplate.query(sql,new Object[]{type,from,to}, new PostsRowMapper());
        return postList;
    }

    @Override
    public List<Posts> getList(int from, int to) {
        String sql = "select * from posts order by post_time desc limit ?,?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List postList = jdbcTemplate.query(sql,new Object[]{from,to}, new PostsRowMapper());
        return postList;
    }

    @Override
    public List<Slide> getSlide() {
        String sql = "select * from slide  limit 0,6";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List lstSlide = jdbcTemplate.query(sql, new SlideRowMapper());
        return lstSlide;
    }
    
}
