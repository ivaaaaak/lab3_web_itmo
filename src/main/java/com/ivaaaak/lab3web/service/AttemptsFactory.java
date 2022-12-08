package com.ivaaaak.lab3web.service;

import com.ivaaaak.lab3web.model.Attempt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class AttemptsFactory {

    public Attempt createAttempt(final double x,
                                 final double y,
                                 final double r,
                                 final boolean hit) {
        var newAttempt = new Attempt();
        newAttempt.setX(x);
        newAttempt.setY(y);
        newAttempt.setR(r);
        newAttempt.setHit(hit);
        return newAttempt;
    }
}
