/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcel.web.mavenjsfcdi;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marcel
 */
@Named
@RequestScoped
public class ChannelBean {
    
    private final static String EVENTCHANNEL = "/CHANNEL"; 
    
    public String getEventchannel() {
       return EVENTCHANNEL + getSessionId();
    }
    
    private String getSessionId() {
        HttpSession sessionObj = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if( sessionObj != null ) {
            return sessionObj.getId();
        }
        return null;
    }
}
