/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author VuNguyen
 */
public interface EmailActiveDAO {
    public boolean EmailActive(String username);
    public boolean CheckEmailActive(String activecode);
}
