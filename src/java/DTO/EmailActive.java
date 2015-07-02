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
public class EmailActive {
    @Size(min=6,max=18)
    @Pattern(regexp="[a-zA-Z0-9]+")
    private String username;
    
    @Pattern(regexp="[a-fA-F0-9]+")
    @Size(min=1)
    @NotEmpty 
    private String activecode;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the activecode
     */
    public String getActivecode() {
        return activecode;
    }

    /**
     * @param activecode the activecode to set
     */
    public void setActivecode(String activecode) {
        this.activecode = activecode;
    }
}
