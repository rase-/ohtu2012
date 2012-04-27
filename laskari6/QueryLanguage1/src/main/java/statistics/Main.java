package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstatistics.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();
        Matcher m = query.oneOf(query.playsIn("NYR")
                     .hasAtLeast(10, "goals")
                     .hasFewerThan(25, "assists").build(), query.playsIn("COL").build()).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
