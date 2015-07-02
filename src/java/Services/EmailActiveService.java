/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import DTO.EmailActive;

/**
 *
 * @author VuNguyen
 */
public interface EmailActiveService {
    public boolean EmailActive(EmailActive emailActive);
    public boolean CheckEmailActive(EmailActive emailActive);
}
