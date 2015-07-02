/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vunguyen
 */
@Controller
@RequestMapping(value = "/tai-khoan")
public class PaymentController {
    @RequestMapping(value= "nap-the",method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");
        modelAndView.addObject("page", "content-payment.jsp");
        return modelAndView;
    }
}
