/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author tonykovanen
 */
public class QueryBuilder {

    private Matcher matcher;
    
    public QueryBuilder() {
        
    }
    
    private QueryBuilder(Matcher matcher) {
        this.matcher = matcher;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        if (matcher != null) {
            return createAndQueryOfThisMatcherAndParameter(new HasAtLeast(value, category));
        }
        return new QueryBuilder(new HasAtLeast(value, category));
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        if (matcher != null) {
            return createAndQueryOfThisMatcherAndParameter(new HasFewerThan(value, category));
        }
        return new QueryBuilder(new HasFewerThan(value, category));
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        return new QueryBuilder(new Or(m1, m2));
    }
    
    public QueryBuilder playsIn(String team) {
        if (matcher != null) {
            return createAndQueryOfThisMatcherAndParameter(new PlaysIn(team));
        }
        
        return new QueryBuilder(new PlaysIn(team));
    }
    
    public Matcher build() {
        return this.matcher;
    }
        
    
    private QueryBuilder createAndQueryOfThisMatcherAndParameter(Matcher parameter) {
        return new QueryBuilder(new And(this.matcher, parameter));
    }
}
