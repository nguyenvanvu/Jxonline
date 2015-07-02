/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author VuNguyen
 */
public class RegisterInfo {
    
    @Size(min=6,max=18)
    @Pattern(regexp="[a-zA-Z0-9]+")
    @NotEmpty 
    private String cAccName;
    
    @Pattern(regexp="[a-zA-Z0-9]+")
    @Size(min=8,max=24)
    @NotEmpty 
    private String cPassWord;
    
    private String ConfirmcPassWord;
    
    @Email
    @NotEmpty 
    private String cEmail;
    
    private String captcha;

    /**
     * @return the cAccName
     */
    public String getcAccName() {
        return cAccName;
    }

    /**
     * @param cAccName the cAccName to set
     */
    public void setcAccName(String cAccName) {
        this.cAccName = cAccName;
    }

    /**
     * @return the cPassWord
     */
    public String getcPassWord() {
        return cPassWord;
    }

    /**
     * @param cPassWord the cPassWord to set
     */
    public void setcPassWord(String cPassWord) {
        this.cPassWord = cPassWord;
    }

    /**
     * @return the cEmail
     */
    public String getcEmail() {
        return cEmail;
    }

    /**
     * @param cEmail the cEmail to set
     */
    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
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

    /**
     * @return the ConfirmcPassWord
     */
    public String getConfirmcPassWord() {
        return ConfirmcPassWord;
    }

    /**
     * @param ConfirmcPassWord the ConfirmcPassWord to set
     */
    public void setConfirmcPassWord(String ConfirmcPassWord) {
        this.ConfirmcPassWord = ConfirmcPassWord;
    }
}
