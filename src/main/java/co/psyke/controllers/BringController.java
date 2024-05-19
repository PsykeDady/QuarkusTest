package co.psyke.controllers;

import co.psyke.services.BringService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/bring")
public class BringController {

    @Inject
    private BringService bringService; 

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String bring() {
        return bringService.getBringService();
    }


}
