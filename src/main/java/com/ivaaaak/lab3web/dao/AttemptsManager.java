package com.ivaaaak.lab3web.dao;

import com.google.gson.Gson;
import com.ivaaaak.lab3web.model.Attempt;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.LinkedList;

@Named
@SessionScoped
@Transactional
public class AttemptsManager implements Serializable {

    @PersistenceContext(unitName = "db")
    private EntityManager entityManager;
    private final LinkedList<Attempt> attempts;
    private final Gson parser = new Gson();

    public AttemptsManager() {
        attempts = new LinkedList<>();
    }

    @PostConstruct
    public void init() {
        attempts.addAll(entityManager.createQuery("SELECT a FROM attempts a", Attempt.class).getResultList());
    }

    public void addAttempt(final Attempt newAttempt) {
        entityManager.persist(newAttempt);
        attempts.addFirst(newAttempt);
    }

    public void clearAttempts() {
        entityManager.createQuery("DELETE FROM attempts").executeUpdate();
        attempts.clear();
    }

    public LinkedList<Attempt> getAttempts() {
        return attempts;
    }

    public String getJsonAttempts() {
        return parser.toJson(attempts);
    }

}
