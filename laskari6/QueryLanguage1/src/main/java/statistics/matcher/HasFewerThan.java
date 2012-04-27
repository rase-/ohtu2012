/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

/**
 *
 * @author tonykovanen
 */
public class HasFewerThan extends HasAtLeast {
    
    public HasFewerThan(int value, String category) {
        super(value, category);
    }
    
    @Override
    public boolean matches(Player p) {
        try {                                    
            Method method = p.getClass().getMethod(fieldName);
            int playersValue = (Integer)method.invoke(p);
            return playersValue < value;
            
        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field "+fieldName.substring(3, fieldName.length()).toLowerCase());
        }    
    }
    
}
