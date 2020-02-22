package hu.frt.tipmix.match.dao;

import hu.frt.tipmix.match.model.Match;

import java.util.List;

public interface MatchesDao {
    List<Match> getMatchesForTipMix();

    void save(Match match);
}
