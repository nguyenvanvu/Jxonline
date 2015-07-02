/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Config;

/**
 *
 * @author VuNguyen
 */
public class WebConfig {
   private String host;
   private String folderXepHang;
   private int top;
   private String emailSupport;

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the folderXepHang
     */
    public String getFolderXepHang() {
        return folderXepHang;
    }

    /**
     * @param folderXepHang the folderXepHang to set
     */
    public void setFolderXepHang(String folderXepHang) {
        this.folderXepHang = folderXepHang;
    }

    /**
     * @return the top
     */
    public int getTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * @return the emailSupport
     */
    public String getEmailSupport() {
        return emailSupport;
    }

    /**
     * @param emailSupport the emailSupport to set
     */
    public void setEmailSupport(String emailSupport) {
        this.emailSupport = emailSupport;
    }
   
}
