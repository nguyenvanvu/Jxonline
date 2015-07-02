/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import DAO.UserDAO;
import DTO.ChangePass;
import DTO.LoginInfo;
import DTO.RegisterInfo;
import DTO.User;
import static Function.Function.md5;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author VuNguyen
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userdao;



    @Override
    public List<User> getUserList() {
        return userdao.getUserList();
    }

 

    @Override
    public User getUser(String userName) {
    return userdao.getUser(userName);
    }
 
    @Override
    public void insertData(RegisterInfo user){
      userdao.insertData(user);
    }
  
    @Override
    public boolean IsExistsEmail(RegisterInfo user){
        return userdao.IsExistsEmail(user.getcEmail());
    }
  
    @Override
    public boolean IsExistsUserName(RegisterInfo user){
        return userdao.IsExistsUserName(user.getcAccName());
    }
    @Override
    public boolean CheckLogin(LoginInfo user){
        try{
            User userDB = userdao.getUser(user.getcAccName());
            if (userDB.getcPassWord().equals(md5(user.getcPassWord())) ) {
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }

  

    @Override
    public boolean editData(User user) {
        
            userdao.editData(user);
            return true;
        
        
    }

    @Override
    public User getUserFromEmail(String Email) {
       return userdao.getUserFromEmail(Email);
    }

    @Override
    public void editPersonInfo(User user) {
         userdao.editPersonInfo(user);
    }
    @Override
    public void KichAcc(User user) {
        userdao.KickAcc(user);
    }
   
            
}
