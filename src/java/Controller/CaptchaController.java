package Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/captcha")
//@SessionAttributes("captcha")
public class CaptchaController
{
   

    @RequestMapping(value = {"/image"} , method = RequestMethod.GET)
    public ModelAndView captcha(HttpServletResponse response,HttpSession session) throws IOException {
        
       
        // Set to expire far in the past.
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
         
        // return a jpeg
        response.setContentType("image/jpeg");

        // create the text for the image
        BufferedImage image = new BufferedImage(120,30, BufferedImage.TYPE_INT_RGB); 
        Graphics2D graphics2D = image.createGraphics();
     
        Random r = new Random();
        String token = Long.toString(Math.abs(r.nextLong()), 36);
        String ch = token.substring(0,5);
        Color c = new Color(0.6662f, 0.4569f, 0.3232f);
        GradientPaint gp = new GradientPaint(30, 30, c, 15, 25, Color.white, true);
        graphics2D.setPaint(gp);
        Font font=new Font("Verdana", Font.CENTER_BASELINE , 26);
        graphics2D.setFont(font);
        graphics2D.drawString(ch,2,20);
        graphics2D.dispose();
    
        ModelAndView modelAndView = new ModelAndView();
        session.setAttribute("captcha", ch);
        
            
        OutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
        outputStream.close();
        
        return null;
    }

    
}