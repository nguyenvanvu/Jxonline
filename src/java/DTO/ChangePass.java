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
public class ChangePass {
     
    @Pattern(regexp="[a-zA-Z0-9]+")
    @Size(min=8,max=24)
    @NotEmpty 
    private String cSecPassWord;
    
   
    
    @Pattern(regexp="[a-zA-Z0-9]+")
    @Size(min=8,max=24)
    @NotEmpty 
    private String cNewPassWord;
    
   
    private String ConfirmcNewPassWord;
    
    private String captcha;
    
    @Pattern(regexp="[1-2]+")
    @Size(min=1,max=1)
    @NotEmpty 
    private String type;

    /**
     * @return the cSecPassWord
     */
    public String getcSecPassWord() {
        return cSecPassWord;
    }

    /**
     * @param cSecPassWord the cSecPassWord to set
     */
    public void setcSecPassWord(String cSecPassWord) {
        this.cSecPassWord = cSecPassWord;
    }

    /**
     * @return the cNewPassWord
     */
    public String getcNewPassWord() {
        return cNewPassWord;
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
     * @param cNewPassWord the cNewPassWord to set
     */
    public void setcNewPassWord(String cNewPassWord) {
        this.cNewPassWord = cNewPassWord;
    }

    /**
     * @return the ConfirmcNewPassWord
     */
    public String getConfirmcNewPassWord() {
        return ConfirmcNewPassWord;
    }

    /**
     * @param ConfirmcNewPassWord the ConfirmcNewPassWord to set
     */
    public void setConfirmcNewPassWord(String ConfirmcNewPassWord) {
        this.ConfirmcNewPassWord = ConfirmcNewPassWord;
    }

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
}
