package co.psyke.repositories;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BringRepository {
    public String bringString() {
        return "Bang Bang Born";
    }
}
