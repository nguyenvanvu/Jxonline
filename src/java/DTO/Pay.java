/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import javax.validation.constraints.Pattern;

/**
 *
 * @author vunguyen
 */
public class Pay {
    @Pattern(regexp="[0-9]+")
    private String MaThe;
    
    private String SoThe;
    
    @Pattern(regexp="[0-2]+")
    private int LoaiThe;
    
    private String captcha;

    /**
     * @return the MaThe
     */
    public String getMaThe() {
        return MaThe;
    }

    /**
     * @param MaThe the MaThe to set
     */
    public void setMaThe(String MaThe) {
        this.MaThe = MaThe;
    }

    /**
     * @return the SoThe
     */
    public String getSoThe() {
        return SoThe;
    }

    /**
     * @param SoThe the SoThe to set
     */
    public void setSoThe(String SoThe) {
        this.SoThe = SoThe;
    }

    /**
     * @return the LoaiThe
     */
    public int getLoaiThe() {
        return LoaiThe;
    }

    /**
     * @param LoaiThe the LoaiThe to set
     */
    public void setLoaiThe(int LoaiThe) {
        this.LoaiThe = LoaiThe;
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
