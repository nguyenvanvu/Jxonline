/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import DAO.PostsDAO;
import DTO.Posts;
import DTO.Slide;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author VuNguyen
 */
public class PostsServiceImpl implements PostsService {
    
    @Autowired
    PostsDAO postsdao;
    
    @Override
    public boolean insertData(Posts post) {
        try{
            postsdao.insertData(post);
            return true;
        }catch(Exception ex){
            return false;
        }
            
    }

    @Override
    public void deleteData(String post_link) {
         postsdao.deleteData(post_link);
    }

    @Override
    public void editData(Posts post) {
       postsdao.editData(post);
    }

    @Override
    public Posts getData(String post_link) {
        return postsdao.getData(post_link);
    }

    @Override
    public List<Posts> getList(int from , int to , String type) {
        return postsdao.getList(from, to, type);
    }

    @Override
    public List<Posts> getList(int from, int to) {
       return postsdao.getList(from, to);
    }

    @Override
    public List<Slide> getListSlide() {
       return postsdao.getSlide();
    }
    
}
