package hu.frt.tipmix.match;

import hu.frt.tipmix.match.dao.MatchesDao;
import hu.frt.tipmix.match.model.Match;

import java.util.List;

public class MatchService {

    private MatchesDao matchesDao;

    public MatchService(MatchesDao matchesDao) {
        this.matchesDao = matchesDao;
    }

    public List<Match> getMatchesForTipMix() {
        return matchesDao.getMatchesForTipMix();
    }

    public void recordMatch(Match match) {
        matchesDao.save(match);
    }
}
