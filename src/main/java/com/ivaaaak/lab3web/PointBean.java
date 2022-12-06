package com.ivaaaak.lab3web;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

@Data
@Named
@RequestScoped
public class PointBean implements Serializable {

    @Inject
    AttemptsManager attemptsManager;
    @Inject
    AreaChecker areaChecker;

    double x;
    double y;
    double r;
    boolean hit;

    public void submit() {
        hit = areaChecker.isHit(x, y, r);
        var newAttempt = new AttemptBean();
        newAttempt.setPoint(this);
        attemptsManager.addAttempt(newAttempt);
    }
}
