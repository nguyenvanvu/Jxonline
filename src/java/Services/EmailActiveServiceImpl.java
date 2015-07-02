/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import DAO.EmailActiveDAO;
import DTO.EmailActive;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author VuNguyen
 */
public class EmailActiveServiceImpl  implements EmailActiveService  {
    @Autowired
    EmailActiveDAO emailActiveDao;
    
    @Override
    public boolean EmailActive(EmailActive emailActive){
       return emailActiveDao.EmailActive( emailActive.getUsername());
    }
     @Override
    public boolean CheckEmailActive(EmailActive emailActive){
       return emailActiveDao.CheckEmailActive( emailActive.getActivecode());
    }
}
