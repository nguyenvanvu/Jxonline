/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Config.WebConfig;
import DTO.ChangePass;
import DTO.PersonInfo;
import DTO.ResetPass;
import DTO.User;
import static Function.Function.md5;
import Services.UserService;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
public class PasswordController {
    
    @Autowired  
    UserService userService; 
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    WebConfig webConfig;
    
    @RequestMapping(value = "/quen-mat-khau", method = RequestMethod.GET)    
    public ModelAndView quenmatkhau(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");
        modelAndView.addObject("page", "content-quenmatkhau.jsp");
      
        return modelAndView;
    }
    
    @RequestMapping(value = "/gui-mail", method = RequestMethod.POST)    
    public ModelAndView sendmail(@ModelAttribute("email") String email,@ModelAttribute("captcha") String captcha,HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        String str = "";
         if (!captcha.equals(session.getAttribute("captcha")) ) {
            str = "<ul class='flashes'>"
                + "<li class='success'>Mã xác nhận không hợp lệ</li>"
                +   "</ul>";
            modelAndView.setViewName("account");
            modelAndView.addObject("page", "content-quenmatkhau.jsp");
            modelAndView.addObject("thongtin",str);
            return modelAndView;
        }
        
        User user = userService.getUserFromEmail(email);
       
         if (user == null) {
            str = "<ul class='flashes'>"
                + "<li class='success'>Email không tồn tại</li>"
                +   "</ul>";
            modelAndView.setViewName("account");
            modelAndView.addObject("page", "content-quenmatkhau.jsp");
            modelAndView.addObject("thongtin",str);
            return modelAndView;
         }
         
        MimeMessage message = mailSender.createMimeMessage();
                try{
                        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

                        helper.setFrom("admin@volamkyhiep.com","Võ Lâm Kỳ Hiệp");

                        helper.setTo(email);
                        helper.setSubject("Kích hoạt  email");
                        
                       
                        helper.setText(
                                "Bạn vừa thực hiện việc lấy lại mật khẩu cho tài khoản("+   webConfig.getHost() +  ")<br>"
                                
                                + "<br><a href = \""+  webConfig.getHost() + "/tai-khoan/lay-mat-khau.htm?atc="+  md5(user.getcAccName()) + md5(user.getcSecPassWord())+ "&acc=" + user.getcAccName() +"\">Xác nhận</a>"
                                ,true);
                }catch (MessagingException e) {
                    throw new MailParseException(e);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            modelAndView.setViewName("account");    
            modelAndView.addObject("page", "content-quenmatkhau.jsp");
             
            try{
                mailSender.send(message);
               
               
                str = "<ul class='flashes'>"
                + "<li class='success'>Đã gửi email</li>"
                +   "</ul>";
              
            }  catch(Exception ex)
            {
                 str = "<ul class='flashes'>"
                + "<li class='success'>Gửi không thành  công</li>"
                +   "</ul>";
            }
            modelAndView.addObject("thongtin",str);
            return modelAndView;   
        
    }
    
    @RequestMapping(value = "/lay-mat-khau", method = RequestMethod.GET)
    public ModelAndView laymatkhau(@ModelAttribute("atc") String atc,@ModelAttribute("acc") String acc,HttpSession session)  {
        ModelAndView modelAndView = new ModelAndView();   
        User user = userService.getUser(acc);
           if (user==null) {
              modelAndView.addObject("error", "không hợp lệ");
              modelAndView.setViewName("Error/error");
              return modelAndView;
         }
        if(atc.equals(md5(user.getcAccName()) + md5(user.getcSecPassWord()))){
                modelAndView.setViewName("account");
                modelAndView.addObject("resetpass", new ResetPass());
                modelAndView.addObject("page", "content-laymatkhau.jsp");
                session.setAttribute("cAccName", user.getcAccName());
                session.setAttribute("resetpass", "yes");
                return modelAndView;
         }
        modelAndView.addObject("error", "không hợp lệ");
        modelAndView.setViewName("Error/error");
        return modelAndView;
           
    } 
    
     
    @RequestMapping(value = "/lay-mat-khau", method = RequestMethod.POST)
    public ModelAndView laymatkhaupost(@Valid @ModelAttribute("resetpass") ResetPass  resetpass, BindingResult result,HttpServletRequest request, HttpServletResponse response,
                                        HttpSession session)  {
        ModelAndView modelAndView = new ModelAndView();  
        if (!resetpass.getCaptcha().equals(session.getAttribute("captcha"))   ) {
             modelAndView.addObject("page", "content-laymatkhau.jsp");
             modelAndView.setViewName("account");
             return modelAndView;
        }
        if (!resetpass.getPassword().equals(resetpass.getPassword_confirm())) {
             modelAndView.addObject("page", "content-laymatkhau.jsp");
             modelAndView.setViewName("account");
             return modelAndView;
        }
        if (result.hasErrors()) {
            modelAndView.setViewName("account"); 
            modelAndView.addObject("page", "content-laymatkhau.jsp");
            return modelAndView;
        }
        if (session.getAttribute("resetpass") == null) {
            modelAndView.setViewName("account"); 
            modelAndView.addObject("page", "content-laymatkhau.jsp");
            return modelAndView;
        }
        User user = userService.getUser((String) session.getAttribute("cAccName"));
        if (resetpass.getType().equals("1")) {
            user.setcPassWord(md5(resetpass.getPassword()));
            userService.editData(user);
        }
        else{
            user.setcSecPassWord(md5(resetpass.getPassword()));
             if (user.getcSecPassWord().equals(user.getcPassWord())) {
                modelAndView.addObject("errorTrungMatKhau", "Mật khẩu 2 không được trùng với mật khẩu 1");
                modelAndView.setViewName("account"); 
                modelAndView.addObject("page", "content-laymatkhau.jsp");
                return modelAndView;
             }
   
            userService.editData(user);
        }
       /// modelAndView.addObject("page", "content-account.jsp");
        //modelAndView.addObject("user", user);
        modelAndView.setViewName("redirect:accountinfo.htm");
        return modelAndView;   
    }
    @RequestMapping(value = "/doi-mat-khau", method = RequestMethod.GET)    
    public ModelAndView ChangePass(@ModelAttribute("type") String  type, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");
        modelAndView.addObject("cAccName", session.getAttribute("cAccName"));
        modelAndView.addObject("type", type);
        modelAndView.addObject("page", "content-changepass.jsp");
        ChangePass changePass = new ChangePass();
        modelAndView.addObject("changepass",changePass);
        return modelAndView;
    }
    @RequestMapping(value = "/doi-mat-khau", method = RequestMethod.POST)    
    public ModelAndView ChangePassPost(@Valid @ModelAttribute("changepass")  ChangePass changePass, BindingResult result,HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
         if (result.hasErrors()) {
             
             modelAndView.setViewName("account");
             modelAndView.addObject("page", "content-changepass.jsp");
             modelAndView.addObject("cAccName", session.getAttribute("cAccName"));
             return modelAndView;
         }
        boolean checkvalue = true;
         if (!changePass.getcNewPassWord().equals(changePass.getConfirmcNewPassWord())) {
               modelAndView.addObject("errorConfirmcPassWord","Mật khẩu không khớp");
               modelAndView.setViewName("account");
               checkvalue = false;
               
             
         }
         String captcha = (String)session.getAttribute("captcha");
         if (!captcha.equals(changePass.getCaptcha())) {
                modelAndView.addObject("errorCapcha","Mã kiểm tra không hợp lệ");
                modelAndView.setViewName("account");
                checkvalue = false;
               
         }
         User user = userService.getUser((String) session.getAttribute("cAccName"));
         if (!user.getcSecPassWord().equals(md5(changePass.getcSecPassWord()))) {
                modelAndView.addObject("errorPass2","Mật khẩu cấp 2 không hợp lệ");
                modelAndView.setViewName("account");
               checkvalue = false;
               
         }
          if (changePass.getType().equals("2") && user.getcPassWord().equals(md5(changePass.getcNewPassWord()))) {
                modelAndView.addObject("errorPass2","Mật khẩu cấp 2 không được trùng với mật khẩu 1");
                modelAndView.setViewName("account");
               checkvalue = false;
               
         }
         if (!checkvalue) {
                modelAndView.setViewName("account");
                modelAndView.addObject("page", "content-changepass.jsp");
                modelAndView.addObject("cAccName", session.getAttribute("cAccName"));
                return modelAndView;
         }
         if (changePass.getType().equals("1")) {
              user.setcPassWord(md5(changePass.getcNewPassWord()));
        }else{
             if (user.getEmailactive() != 1) {
                 String str = "<ul class='flashes'>"
                + "<li class='success'>Bạn chưa kích hoạt email.</li>"
                +  "</ul>";
                modelAndView.addObject("thanhcong",str);
                modelAndView.addObject("user",user); 
                modelAndView.setViewName("account");
                modelAndView.addObject("page", "content-account.jsp");
                 modelAndView.addObject("personinfo", new PersonInfo());
                modelAndView.addObject("cAccName", session.getAttribute("cAccName"));
                return modelAndView;
             }
              user.setcSecPassWord(md5(changePass.getcNewPassWord()));
         }
       
         
         if (userService.editData(user)) {
             String str = "<ul class='flashes'>"
                + "<li class='success'>Bạn đã thay đổi mật khẩu thành công.</li>"
                +  "</ul>";
              modelAndView.addObject("thanhcong",str);
         }
       
        modelAndView.addObject("user",user); 
        modelAndView.setViewName("account");
        modelAndView.addObject("page", "content-account.jsp");
        modelAndView.addObject("cAccName", session.getAttribute("cAccName"));
         modelAndView.addObject("personinfo", new PersonInfo());
        return modelAndView;
    }
    
    
}
