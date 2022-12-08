package com.ivaaaak.lab3web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity(name = "attempts")
@Table(name = "attempts")
public class Attempt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;
    @Column(name = "x", nullable = false)
    @Min(0) @Max(3)
    double x;
    @Column(name = "y", nullable = false)
    @Min(0) @Max(3)
    double y;
    @Column(name = "r", nullable = false)
    @Min(0) @Max(3)
    double r;
    @Column(name = "hit", nullable = false)
    boolean hit;
}
