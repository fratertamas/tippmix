package hu.frt.tipmix.bet;

import hu.frt.tipmix.bet.dao.BetDao;
import hu.frt.tipmix.bet.model.Bet;
import hu.frt.tipmix.bet.model.BetModel;
import hu.frt.tipmix.match.model.Match;

public class BetService {


    private final BetDao betDao;

    public BetService(BetDao betDao) {
        this.betDao = betDao;
    }

    public void makeBet(BetModel betModel) {
        betDao.save(betModel);
    }
}
