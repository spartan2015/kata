/*
 * bean.java
 *
 * Created on 02 octombrie 2007, 11:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package classes;

/**
 *
 * @author Owner
 */

public class person implements java.io.Serializable {
    
    String firstName;
    String lastName;
    String sex;   
    
    /** Creates a new instance of bean */
    public person() {
    }
    
    public person(String firstName, String lastName, String sex){
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getSex(){
        return this.sex;
    }
    
    public void setSex(String sex){
        this.sex = sex;
    }
}
