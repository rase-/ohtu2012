package statistics.matcher;

import statistics.Player;

public class And implements Matcher {

    protected Matcher[] matchers;

    public And(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                return false;
            }
        }

        return true;
    }
}
