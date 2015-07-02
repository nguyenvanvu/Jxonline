/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JDBC;


import DTO.Slide;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VuNguyen
 */
public class SlideRowMapper implements RowMapper<Slide> {
    @Override
    public Slide mapRow(ResultSet resultSet, int line) throws SQLException {
        SlideExtractor slideExtractor = new SlideExtractor();
        return slideExtractor.extractData(resultSet);
 }
}
