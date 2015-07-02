/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Config.WebConfig;
import static Controller.AdminController.getLstSlide;
import static Controller.AdminController.getPosts;
import static Controller.AdminController.getPostsCamNang;
import static Controller.AdminController.getPostsSuKien;
import static Controller.AdminController.getPostsTinhNang;
import DTO.Posts;
import DTO.Slide;
import Services.PostsService;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VuNguyen
 */
@Controller
public class HomeController {
     
     
    @Autowired 
    PostsService postsService;
    
    @Autowired
    WebConfig webConfig;
    
    @RequestMapping(value= "/home", method = RequestMethod.GET)
    public ModelAndView index() {
 
	ModelAndView modelAndView = new ModelAndView();
       
        modelAndView.setViewName("Home1/index");
      
               
            List<Posts> lstPostSuKien =  getPostsSuKien();
            List<Posts> lstPostCamNang =  getPostsCamNang();
            List<Posts> lstPostTinhNang =  getPostsTinhNang();
            List<Posts> lstPostTinTuc = getPosts();
            List<Slide> lstSlide = getLstSlide();
            modelAndView.addObject("lstPostTinTuc",lstPostTinTuc);
            modelAndView.addObject("lstPostSuKien",lstPostSuKien);
            modelAndView.addObject("lstPostCamNang",lstPostCamNang);
            modelAndView.addObject("lstPostTinhNang",lstPostTinhNang);
            modelAndView.addObject("lstSlide",lstSlide);
       
            modelAndView.addObject("emailSupport",webConfig.getEmailSupport() );
 
        return modelAndView;
    }
    @RequestMapping(value = "/{post_type}-list",method = RequestMethod.GET)
    public ModelAndView PostView(@PathVariable("post_type") String str){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView = new ModelAndView();
        modelAndView.setViewName("Home1/content");
        modelAndView.addObject("page","content-list.jsp");
        
       
        
        switch(str){
            case "tin-tuc":
                modelAndView.addObject("type", "Tin tức");
               str = "1";
                break;
            case "su-kien":
                modelAndView.addObject("type", "Sự kiện");
                str = "2";
                break;
            case "tinh-nang":
                modelAndView.addObject("type", "Tính năng");
                str ="3";
                break;
            case "cam-nang":
                modelAndView.addObject("type", "Cẩm nang");
                str = "4";
                break;    
            default:  
                modelAndView.addObject("type", "Tin tức");
                str = "1";
                break;
        }
        modelAndView.addObject("post_type", str);
        return modelAndView;
    }
     @RequestMapping(value = "/getpostlist",method = RequestMethod.GET )
    public @ResponseBody   ResponseEntity<String> getPostList(@ModelAttribute("index") String str,@ModelAttribute("post_type") String str1,HttpServletRequest request,HttpServletResponse response) throws Exception {   
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
         
        
        int index =  Integer.parseInt(str);

        List<Posts> postlist = postsService.getList(index, index + 9, str1);
        for(Posts p : postlist)
        {
            p.setPost_text("");
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(gson.toJson(postlist), responseHeaders, HttpStatus.CREATED);   
    }
   
    
    @RequestMapping(value = "/{post_link}-post", method = RequestMethod.GET)
    public ModelAndView Post(@PathVariable("post_link") String post_link)  {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Home1/content");
        modelAndView.addObject("page", "content-post.jsp");
        List<Slide> lstSlide = getLstSlide();
        modelAndView.addObject("lstSlide",lstSlide);
        Posts post = null;
         for(int i = 0;i < getPosts().size();i++){
             if (getPosts().get(i).getPost_link().equals(post_link)) {
                post = getPosts().get(i);
                 modelAndView.addObject("post",post);
                  modelAndView.addObject("lstpost",  postsService.getList(0, 5));
                 return modelAndView;
             }
         }
         for(int i = 0;i < getPostsSuKien().size();i++){
             if (getPostsSuKien().get(i).getPost_link().equals(post_link)) {
                post = getPostsSuKien().get(i);
                 modelAndView.addObject("post",post);
                  modelAndView.addObject("lstpost",  postsService.getList(0, 5));
                 return modelAndView;
             }
         }
         
          for(int i = 0;i < getPostsCamNang().size();i++){
             if (getPostsCamNang().get(i).getPost_link().equals(post_link)) {
                post = getPostsCamNang().get(i);
                 modelAndView.addObject("post",post);
                  modelAndView.addObject("lstpost",  postsService.getList(0, 5));
                 return modelAndView;
             }
         }
          for(int i = 0;i < getPostsTinhNang().size();i++){
             if (getPostsTinhNang().get(i).getPost_link().equals(post_link)) {
                post = getPostsTinhNang().get(i);
                 modelAndView.addObject("post",post);
                  modelAndView.addObject("lstpost",  postsService.getList(0, 5));
                 return modelAndView;
             }
         }
        
        post = postsService.getData(post_link);
        if (post == null) {
            post = new Posts();
            post.setPost_subject("error");
            post.setPost_text("Link không tồn tại");
        }
        
        modelAndView.addObject("post",post);
        modelAndView.addObject("lstpost",  postsService.getList(0, 5));
        return modelAndView;
     }
}
