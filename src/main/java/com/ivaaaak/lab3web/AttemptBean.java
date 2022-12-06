package com.ivaaaak.lab3web;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Data
@Entity
@SessionScoped
@Named
@Table(name = "attempts")
public class AttemptBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    int id;
    @Column(name = "x")
    double x;
    @Column(name = "y")
    double y;
    @Column(name = "r")
    double r;
    @Column(name = "hit")
    boolean hit;

    public void setPoint(PointBean point) {
        x = point.getX();
        y = point.getY();
        r = point.getR();
        hit = point.isHit();
    }

    public PointBean getPoint() {
        var point = new PointBean();
        point.setX(x);
        point.setY(y);
        point.setR(r);
        point.setHit(hit);
        return point;
    }

}
