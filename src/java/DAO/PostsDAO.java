/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.Posts;
import DTO.Slide;
import java.util.List;

/**
 *
 * @author VuNguyen
 */
public interface PostsDAO {
    public void insertData(Posts post);
    public void deleteData(String post_link);
    public void editData(Posts post);
    public Posts getData(String post_link);
    public List<Posts> getList(int from, int to, String type);
    public List<Posts> getList(int from, int to);
    public List<Slide> getSlide();
}
