/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author tonykovanen
 */
public class Or extends And {
    
    public Or(Matcher... matchers) {
        super(matchers);
    }
    
    @Override
    public boolean matches(Player p) {
        for (Matcher m : super.matchers) {
            if (m.matches(p)) {
                return true;
            }
        }
        return false;
    }
    
}
