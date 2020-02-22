package hu.frt.tipmix.match;

import hu.frt.tipmix.match.dao.MatchesDao;
import hu.frt.tipmix.match.model.Match;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MatchServiceTest {
    private MatchService matchService;
    private FakeMatchesDao fakeMatchesDao;

    @Before
    public void init(){
        fakeMatchesDao = new FakeMatchesDao();
        matchService = new MatchService(fakeMatchesDao);
    }

    @Test
    public void getMatchesForTipMixResulIsNotNullTest(){
        assertNotNull(matchService.getMatchesForTipMix());
    }

    @Test
    public void getMatchesForTipMixHsResultTest(){
        Match match = new Match();
        match.teamA = "TeamA";
        fakeMatchesDao.setMatches(Arrays.asList(match));

        List<Match> matches = matchService.getMatchesForTipMix();
        assertTrue(matches.contains(match));
    }

    @Test
    public void recordMatchTest(){
        Match match = new Match();
        match.teamA = "TeamA";
        match.teamB = "TeamB";
        match.matchDateTime = LocalDateTime.of(2020,02,02,18,10);
        match.championCup = "Festő kupa";

        Match match2 = new Match();
        match2.teamA = "TeamA";
        match2.teamB = "TeamB";
        match2.matchDateTime = LocalDateTime.of(2020,02,02,18,10);
        match2.championCup = "Festő kupa";

        matchService.recordMatch(match);
        assertTrue(matchService.getMatchesForTipMix().contains(match2));
    }

    private class FakeMatchesDao implements MatchesDao {
        private List<Match> matches = new ArrayList<>();

        public void setMatches(List<Match> matches) {
            this.matches = matches;
        }

        @Override
        public List<Match> getMatchesForTipMix() {
            return matches;
        }

        @Override
        public void save(Match match) {
            matches.add(match);
        }
    }
}
