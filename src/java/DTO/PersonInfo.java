/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author VuNguyen
 */
public class PersonInfo {
    
    @Size(min=1,max=80)
    @NotEmpty 
    private String cRealName;
    
    
    private int CSex = 1;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dBirthDay;
    
    @Pattern(regexp="[0-9]+")
    @NotEmpty 
    private String cPhone;

    /**
     * @return the cRealName
     */
    public String getcRealName() {
        return cRealName;
    }

    /**
     * @param cRealName the cRealName to set
     */
    public void setcRealName(String cRealName) {
        this.cRealName = cRealName;
    }

    /**
     * @return the CSex
     */
    public int getCSex() {
        return CSex;
    }

    /**
     * @param CSex the CSex to set
     */
    public void setCSex(int CSex) {
        this.CSex = CSex;
    }

    /**
     * @return the dBirthDay
     */
    public Date getdBirthDay() {
        return dBirthDay;
    }

    /**
     * @param dBirthDay the dBirthDay to set
     */
    public void setdBirthDay(Date dBirthDay) {
        this.dBirthDay = dBirthDay;
    }

    /**
     * @return the cPhone
     */
    public String getcPhone() {
        return cPhone;
    }

    /**
     * @param cPhone the cPhone to set
     */
    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }
}
