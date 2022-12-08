package com.ivaaaak.lab3web.service;

import com.ivaaaak.lab3web.dao.AttemptsManager;
import com.ivaaaak.lab3web.controller.PointBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

@Named
@ApplicationScoped
public class Service {

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
