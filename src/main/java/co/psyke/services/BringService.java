package co.psyke.services;

import co.psyke.repositories.BringRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BringService {
    
    @Inject
    BringRepository bringRepository; 

    public String getBringService () {
        return bringRepository.bringString();
    }
}
