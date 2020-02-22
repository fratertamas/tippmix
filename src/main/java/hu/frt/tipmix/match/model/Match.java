package hu.frt.tipmix.match.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Match {
    public String teamA;
    public String teamB;
    public LocalDateTime matchDateTime;
    public String championCup;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(teamA, match.teamA) &&
                Objects.equals(teamB, match.teamB) &&
                Objects.equals(matchDateTime, match.matchDateTime) &&
                Objects.equals(championCup, match.championCup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamA, teamB, matchDateTime, championCup);
    }
}
