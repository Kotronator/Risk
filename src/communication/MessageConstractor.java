/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

/**
 *
 * @author TOSHIBA
 */
public class MessageConstractor {
    
    public static final String  ADD_PLAYER="ADD_PLAYER",
                                MAKE_COLOR_AVAILABLE="MAKE_COLOR_AVAILABLE",
                                GET_MESSAGE="GET_MESSAGE";
    
    public static String messageAddToken(String message, String token)
    {
        message=message+" "+token;
        debug.Debug.println(message);
        return message;
    }
    
    public static String messageAddToken(String message, int token)
    {
        return message+=" "+token;
    }
    
    public static String createNewMessage(String token)
    {
        return new String(token);
    }
    
}
