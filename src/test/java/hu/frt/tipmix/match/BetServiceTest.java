package hu.frt.tipmix.match;

import hu.frt.tipmix.bet.dao.BetDao;
import hu.frt.tipmix.bet.model.BetModel;
import hu.frt.tipmix.match.model.Match;
import hu.frt.tipmix.bet.BetService;
import hu.frt.tipmix.bet.model.Bet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BetServiceTest {
    @Test
    public void makeBetTest(){
        FakeBetDo betDao = new FakeBetDo();
        BetService betService = new BetService(betDao);
        Match match = new Match();

        BetModel betModel = new BetModel();
        betModel.user = "User1";
        betModel.match = match;
        betModel.bet = Bet.DRAW;
        betService.makeBet(betModel);

        assertTrue(betDao.getBets().contains(betModel));
    }

    private class FakeBetDo implements BetDao {
        private List<BetModel> bets = new ArrayList<>();
        public List<BetModel> getBets() {
            return bets;
        }

        @Override
        public void save(BetModel betModel) {
            bets.add(betModel);
        }
    }
}
