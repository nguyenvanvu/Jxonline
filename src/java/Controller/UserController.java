/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Config.WebConfig;
import DTO.EmailActive;
import DTO.LoginInfo;
import DTO.PersonInfo;
import DTO.RegisterInfo;
import DTO.Top;
import DTO.User;
import static Function.Function.md5;
import Services.EmailActiveService;
import Services.UserService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VuNguyen
 */
@Controller
@RequestMapping(value = "/tai-khoan")
//@SessionAttributes("captcha")
public class UserController {
    @Autowired  
    UserService userService; 
    
    @Autowired 
    EmailActiveService emailActiveService;
    
    @Autowired
    WebConfig webConfig;
    
    @Autowired
    private JavaMailSender mailSender;
    
    @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
    public ModelAndView Register(@Valid RegisterInfo registerInfo, BindingResult result,HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        
        if (result.hasErrors()) {
            modelAndView.setViewName("account");
            modelAndView.addObject("page", "content-register.jsp");
            return modelAndView;
        }  else {
            boolean checkvalues = true; 
            if (!registerInfo.getConfirmcPassWord().equals(registerInfo.getcPassWord())) {
                modelAndView.addObject("errorConfirmcPassWord","Mật khẩu không khớp");
                checkvalues = false;
                
            }
            if (userService.IsExistsUserName(registerInfo)) {
                modelAndView.addObject("errorExistsUserName","Tài khoản đã tồn tại!");
                checkvalues = false;
            }
            if (userService.IsExistsEmail(registerInfo)) {
                modelAndView.addObject("errorExistsEmail","Email đã tồn tại!");
                checkvalues = false;
            }
            if (!checkvalues) {
                modelAndView.setViewName("account");
                modelAndView.addObject("page", "content-register.jsp");
                return modelAndView;
            }
            
            String captcha = (String)session.getAttribute("captcha");
            if(!captcha.equals(registerInfo.getCaptcha())){
                modelAndView.setViewName("account");
                modelAndView.addObject("page", "content-register.jsp");
                modelAndView.addObject("errorCaptcha","Mã kiểm tra không hợp lệ");
                return modelAndView;
            }
            userService.insertData(registerInfo);
            session.setAttribute("cAccName",registerInfo.getcAccName());
            modelAndView.setViewName("account");
            modelAndView.addObject("page","registerSuccessful.jsp");
            return modelAndView;
        }
    }
    
    @RequestMapping(value = "/thong-tin-tai-khoan", method = RequestMethod.GET)
    public ModelAndView AccountInfo(HttpSession session,HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
         modelAndView.setViewName("account");
         modelAndView.addObject("page", "content-account.jsp");
         modelAndView.addObject("cAccName",session.getAttribute("cAccName"));
         modelAndView.addObject("personinfo", new PersonInfo());
         User user = userService.getUser((String) session.getAttribute("cAccName"));
         if (user.getcRealName()== null) {
            user.setcRealName("");
        }
         if (user.getdBirthDay() == null) {
            user.setdBirthDay(new Date());
        }
         if (user.getcPhone() == null) {
            user.setcPhone("");
            user.setCSex(1); 
        }
       
            
        
         modelAndView.addObject("user",user);
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         modelAndView.addObject("birthday", sdf.format(user.getdBirthDay()));
       
         return modelAndView;
    }
    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
    public ModelAndView Login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");
        modelAndView.addObject("logininfo", new LoginInfo());
        modelAndView.addObject("page","content-login.jsp");
        
         return modelAndView;
    }
    @RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
    public ModelAndView CheckLogin(@Valid LoginInfo loginInfo, BindingResult result,HttpServletRequest request,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("account");
            modelAndView.addObject("logininfo",loginInfo);
            modelAndView.addObject("errorLogin", "Tài khoản hoặc mật khẩu không hợp lệ");
            modelAndView.addObject("page", "content-login.jsp");
            
            return modelAndView;
        }
        if (!userService.CheckLogin(loginInfo)) {
            modelAndView.setViewName("account");
            modelAndView.addObject("logininfo",loginInfo);
            modelAndView.addObject("page", "content-login.jsp");
            modelAndView.addObject("errorLogin", "Tài khoản hoặc mật khẩu không đúng");
            return modelAndView;
        }
       
        modelAndView.setViewName("redirect:/tai-khoan/thong-tin-tai-khoan.htm");
        session.setAttribute("cAccName", loginInfo.getcAccName());
        return modelAndView;
    }
   
    @RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
    public ModelAndView Logout(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/tai-khoan/dang-nhap.htm");
        session.invalidate();
        return modelAndView;
    }
     @RequestMapping(value = "/kich-acc", method = RequestMethod.GET)
     public @ResponseBody String KichAcc(HttpSession session,HttpServletRequest request) throws InterruptedException{
        Thread.sleep(1500);
        User user = userService.getUser((String) session.getAttribute("cAccName"));
        userService.KichAcc(user);
        return "ok";
     }
    @RequestMapping(value = "/kich-hoat-email", method = RequestMethod.GET)
    public @ResponseBody String EmailActive(HttpSession session,HttpServletRequest request) throws InterruptedException{
      
        
            EmailActive emailActive = new EmailActive();
            emailActive.setUsername((String) session.getAttribute("cAccName"));
            String strReturn = "";
            if (!emailActiveService.EmailActive(emailActive)) {
                Thread.sleep(3000);
                strReturn = "false";
            }
            
                MimeMessage message = mailSender.createMimeMessage();
                User user = userService.getUser((String) session.getAttribute("cAccName"));
                try{
                    
                    MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
                    
                    helper.setFrom("admin@volamkyhiep.com","Võ Lâm Kỳ Hiệp");
                    
                    helper.setTo(user.getcEmail());
                    helper.setSubject("Kích hoạt  email");
                   
                    Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                     String activecode = formatter.format(user.getCreatedatetime());
                    helper.setText(
                            "Bạn hoặc ai đó đã gửi một yêu cầu kích hoạt email cho tài khoản của bạn tại " + webConfig.getHost()
                            + "<br>Tên tài khoản: " + session.getAttribute("cAccName")
                            + "<br><a href = \""+ webConfig.getHost()+ "/tai-khoan/kiem-tra-kich-hoat.htm?atc="+  md5(user.getcAccName()) + md5(activecode)+ "\">Kích hoạt</a>"
                            ,true);
                }catch (MessagingException e) {
                    throw new MailParseException(e);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                mailSender.send(message);
               
                strReturn = "true";
               
                return strReturn;   
    }
     @RequestMapping(value = "/kiem-tra-kich-hoat", method = RequestMethod.GET)
      public ModelAndView CheckActive(@ModelAttribute("atc") String atc,HttpSession session) {
            ModelAndView modelAndView = new ModelAndView();
            EmailActive emailActive = new EmailActive();
            emailActive.setActivecode(atc);
            emailActive.setUsername((String) session.getAttribute("cAccName"));
            if (emailActiveService.CheckEmailActive(emailActive)) {
                String str = "<ul class='flashes'>"
                + "<li class='success'>Kích hoạt email thành công.</li>"
                +   "</ul>";
                   modelAndView.setViewName("account");
                   modelAndView.addObject("page", "content-account.jsp");
                   modelAndView.addObject("cAccName", session.getAttribute("cAccName"));
                   modelAndView.addObject("personinfo", new PersonInfo());
                   modelAndView.addObject("thanhcong",str);
                   User user = userService.getUser((String) session.getAttribute("cAccName"));
                   modelAndView.addObject("user",user);
                   return modelAndView;
            }
             String str = "<ul class='flashes'>"
                + "<li class='success'>Kích hoạt email không thành công.</li>"
                +   "</ul>";
                   modelAndView.setViewName("account");
                   modelAndView.addObject("page", "content-account.jsp");
                   modelAndView.addObject("cAccName", session.getAttribute("cAccName"));
                   modelAndView.addObject("personinfo", new PersonInfo());
                   modelAndView.addObject("thanhcong",str);
                   User user = userService.getUser((String) session.getAttribute("cAccName"));
                   modelAndView.addObject("user",user);
                   return modelAndView;
            
            
            
           
      }
    
    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView displayCustomerForm() {
 
	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");
        modelAndView.addObject("registerInfo", new RegisterInfo());
        modelAndView.addObject("page", "content-register.jsp");
        return modelAndView;
    }
    /*
     @RequestMapping(value = "demo", method = RequestMethod.GET)
    public ModelAndView demo() {
 
	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo");
       
        modelAndView.addObject("demo", webConfig.getFolderXepHang());
        
        String path = webConfig.getFolderXepHang(); 
        List<String> lstFileName = new ArrayList<String>();
        String files;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(); 
        
        List<Top> lstTop = new ArrayList<Top>();
        
        for (int i =  listOfFiles.length - 1; i >= 0; i--) 
        {
            if (listOfFiles.length - i > 3 ) {
                break;
            }
            if (listOfFiles[i].isFile()) 
            {
                files = listOfFiles[i].getName();
                if (files.endsWith(".txt"))
                {
                   
                   lstFileName.add(files);
                }
            }
           
        }
        Top temp = new Top();
        for (int j = 0; j < lstFileName.size(); j++) {
             Top top = new Top();
             top.setTime(lstFileName.get(j).substring(lstFileName.indexOf("_time"), lstFileName.indexOf("_name")));
             top.setName(lstFileName.get(j).substring(lstFileName.get(j).indexOf("_name") + 5, lstFileName.get(j).lastIndexOf(".txt")));
             top.setLevel(lstFileName.get(j).substring(5, lstFileName.get(j).indexOf("_time")));
             lstTop.add(top);
             
         }
         
          
         modelAndView.addObject("lstFileName",lstTop );
        return modelAndView;
    }
    */
}
