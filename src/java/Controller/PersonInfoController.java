/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;


import DTO.PersonInfo;
import DTO.User;
import Services.UserService;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VuNguyen
 */
@Controller
@RequestMapping(value = "/tai-khoan")
public class PersonInfoController {
   
    @Autowired  
    UserService userService; 
     
    @RequestMapping(value = "/sua-thong-tin", method = RequestMethod.POST)
    public ModelAndView editInfo(@Valid @ModelAttribute("personinfo") PersonInfo personInfo, BindingResult result,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");
        modelAndView.addObject("page", "content-account.jsp");
        modelAndView.addObject("cAccName",session.getAttribute("cAccName"));
         User user = userService.getUser((String) session.getAttribute("cAccName"));
        if (result.hasErrors()) {   
            modelAndView.addObject("user",user);
            return modelAndView;
        }
      
        modelAndView.addObject("personinfo", new PersonInfo());
        user.setCSex(personInfo.getCSex());
        user.setdBirthDay(personInfo.getdBirthDay());
        user.setcPhone(personInfo.getcPhone());
        user.setcRealName(personInfo.getcRealName());
        userService.editPersonInfo(user);
        user = userService.getUser((String) session.getAttribute("cAccName"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        modelAndView.addObject("birthday", sdf.format(user.getdBirthDay()));
        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
