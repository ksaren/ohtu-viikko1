/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Not;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author kaisa
 */
public class QueryBuilder {


    Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new All();
        
    }
    
    QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    
  
    
    QueryBuilder not(Matcher matcher) {
        this.matcher = new And(this.matcher,new Not(matcher));
        return this;
    }

    QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(this.matcher,new HasAtLeast(value, category));
        return this;
    }
    
    QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(this.matcher,new HasFewerThan(value, category));
        return this;
    }
    
    QueryBuilder playsIn(String team) {
        this.matcher = new And(this.matcher,new PlaysIn(team));
        return this;
    }

    public Matcher build() {
        Matcher temp = this.matcher;
        this.matcher = new All();
        return temp;
    }
   
}