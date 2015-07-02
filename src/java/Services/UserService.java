/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import DTO.ChangePass;
import DTO.LoginInfo;
import DTO.RegisterInfo;
import DTO.User;
import java.util.List;

/**
 *
 * @author VuNguyen
 */
public interface UserService {

 public void insertData(RegisterInfo user);
 public List<User> getUserList();
 //public void deleteData(String id);
 public User getUser(String userName);
 //public void updateData(User user);
 
 public boolean IsExistsEmail(RegisterInfo user);
 public boolean IsExistsUserName(RegisterInfo user);
 public boolean CheckLogin(LoginInfo user);
 
 public boolean editData(User user);
 public User getUserFromEmail(String Email);
 public void editPersonInfo(User user);
  public void KichAcc(User user);
}
