/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBC;


import DTO.Slide;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author VuNguyen
 */
public class SlideExtractor implements ResultSetExtractor<Slide>{
     public Slide extractData(ResultSet resultSet) throws SQLException,DataAccessException {  
        Slide slide = new Slide();
        slide.setSlide_link(resultSet.getString("slide_link"));
        slide.setSlide_img(resultSet.getString("slide_img"));
        return slide;
    }
}
