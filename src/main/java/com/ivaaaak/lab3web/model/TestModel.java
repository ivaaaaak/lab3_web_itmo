package com.ivaaaak.lab3web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public final class TestModel {
    @Id
    private Long id;

    private String data;
}
