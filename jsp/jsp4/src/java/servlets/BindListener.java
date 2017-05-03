/*
 * BindListener.java
 *
 * Created on 28 septembrie 2007, 18:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package servlets;

import javax.servlet.http.*;

/**
 *
 * @author neo_qs7
 */
public class BindListener implements HttpSessionBindingListener,HttpSessionListener, HttpSessionActivationListener {
        
    protected int numSessions = 0;
    /** Creates a new instance of BindListener */
    public BindListener() {
    }
    
    public void valueBound(HttpSessionBindingEvent evt){
        numSessions++;        
    }
    
    public void valueUnbound(HttpSessionBindingEvent evt){
        numSessions--;
    }
    
    public int getNumSessions(){
        return numSessions;
    }
    
    public void sessionCreated(HttpSessionEvent evt){
               
    }
    
    public void sessionDestroyed(HttpSessionEvent evt){
        
    }
    
    
    public void sessionDidActivate(HttpSessionEvent evt){
        
    }
    
    public void sessionWillPassivate(HttpSessionEvent evt){
        
    }
}
