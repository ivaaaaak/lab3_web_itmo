package com.ivaaaak.lab3web.model;

import com.ivaaaak.lab3web.dao.AttemptsManager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class PointService {

    @Inject
    AttemptsManager attemptsManager;
    @Inject
    AreaChecker areaChecker;
    @Inject
    AttemptsFactory attemptsFactory;

    public void checkHit( final double x, final double y, final double r) {
        final boolean hit = areaChecker.isHit(x, y, r);
        attemptsManager.addAttempt(attemptsFactory.createAttempt(x, y, r, hit));
    }

    public void clear() {
        attemptsManager.clearAttempts();
    }
}
