/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VuNguyen
 */
@Controller
@RequestMapping(value = "/error")
public class ErrorController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView error(@ModelAttribute("error") String error){
        return new ModelAndView("Error/error","error",error);
    }
}
