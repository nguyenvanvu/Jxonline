/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.ChangePass;
import DTO.RegisterInfo;
import DTO.User;
import java.util.List;

/**
 *
 * @author VuNguyen
 */
public interface UserDAO {
    public void insertData(RegisterInfo user);
    public List<User> getUserList();
    //public void updateData(User user);
    //public void deleteData(String id);
    public User getUser(String cAccName); 
    public boolean IsExistsEmail(String Email);
    public boolean IsExistsUserName(String userName);
    public void ChangePass(String cAccName, ChangePass changePass);
    public void editData(User user);
    public User getUserFromEmail(String Email);
    public void editPersonInfo(User user);
    public void KickAcc(User user);
}
