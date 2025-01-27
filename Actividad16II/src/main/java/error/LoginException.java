/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package error;

/**
 *
 * @author DAW1
 */
public class LoginException extends Exception {
    
    public LoginException(){
        super("Usuario / Password Erroneos");
    }
}
