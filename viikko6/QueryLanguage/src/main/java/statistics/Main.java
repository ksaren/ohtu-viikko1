package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        
//        System.out.println("AND");
//        Matcher m = new And( new HasAtLeast(10, "goals"),
//                             new HasAtLeast(10, "assists"),
//                             new PlaysIn("PHI")
//        );
//        
//        for (Player player : stats.matches(m)) {
//            System.out.println( player );
//        }
//        
//          
//        System.out.println("OR");
//        Matcher m2 = new Or( new HasFewerThan(10, "goals"),
//                             new HasAtLeast(5, "assists"),
//                             new PlaysIn("NYR")
//        );
//        
//        for (Player player : stats.matches(m2)) {
//            System.out.println( player );
//        }
//        
//        System.out.println("NOT");
//        Matcher m3 = new Not( new HasFewerThan(10, "goals"),
//                             new HasAtLeast(5, "assists"),
//                             new PlaysIn("NYR")
//        );
//        
//        for (Player player : stats.matches(m3)) {
//            System.out.println( player );
//        }
//        
// 
    QueryBuilder query = new QueryBuilder();
// 
        System.out.println("BUILDER");
    
//    Matcher m4 = query.playsIn("NYR").hasAtLeast(20, "goals").build();
// 
//    for (Player player : stats.matches(m4)) {
//        System.out.println( player );
//   }
    
    
    Matcher m5 = query.oneOf(
                        query.playsIn("PHI")
                             .hasAtLeast(10, "goals")
                             .hasFewerThan(20, "assists").build(),
 
                        query.playsIn("EDM")
                             .hasAtLeast(60, "points").build()
                       ).build();
    
     for (Player player : stats.matches(m5)) {
        System.out.println( player );
     }
    }
}
