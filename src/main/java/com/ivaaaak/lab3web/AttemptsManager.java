package com.ivaaaak.lab3web;

import jakarta.inject.Named;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;

@Named
@SessionScoped
public class AttemptsManager implements Serializable {

    LinkedList<AttemptBean> attempts;

    public void addAttempt(AttemptBean newAttempt) {
        attempts.add(newAttempt);
    }

    public void clearAttempts() {
        attempts.clear();
    }

    public LinkedList<AttemptBean> getAttempts() {
        return attempts;
    }
}
