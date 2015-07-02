/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author VuNguyen
 */
public class ResetPass {
    
    @Pattern(regexp="[1-2]+")
    @Size(min=1,max=1)
    @NotEmpty 
    private String type;
    
    @Pattern(regexp="[a-zA-Z0-9]+")
    @Size(min=8,max=24)
    @NotEmpty 
    private String Password;
    
    
    private String Password_confirm;
    private String captcha;

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Password_confirm
     */
    public String getPassword_confirm() {
        return Password_confirm;
    }

    /**
     * @param Password_confirm the Password_confirm to set
     */
    public void setPassword_confirm(String Password_confirm) {
        this.Password_confirm = Password_confirm;
    }

    /**
     * @return the captcha
     */
    public String getCaptcha() {
        return captcha;
    }

    /**
     * @param captcha the captcha to set
     */
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
