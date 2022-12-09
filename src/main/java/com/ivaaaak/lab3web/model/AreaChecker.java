package com.ivaaaak.lab3web.model;

import javax.inject.Named;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

import static java.lang.Math.pow;

@Named
@ApplicationScoped
public class AreaChecker implements Serializable {

    public boolean isHit (final double x, final double y, final double r) {
        boolean hit = false;
        if (x >= 0) {
            if (y > 0) {
                hit = x <= r && y <= r;
            } else {
                hit = x <= r && y >= x/2 - r/2;
            }
        } else {
            if (y <= 0) {
                hit = x >= -r / 2 && y >= -r / 2 && pow(x, 2) + pow(y, 2) <= pow(r / 2, 2);
            }
        }
        return hit;
    }
}
