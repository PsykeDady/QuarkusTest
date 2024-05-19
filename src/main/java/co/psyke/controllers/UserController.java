package co.psyke.controllers;

import java.util.List;

import org.jboss.resteasy.reactive.RestPath;

import co.psyke.models.UserResponse;
import co.psyke.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;


@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public class UserController {
    @Inject
    private UserService userService;

    @POST
    public Response addUser( UserResponse u) {
        userService.addUser(u);
        return Response.ok().build();
    }


    @GET
    @Path("list")
    public List<UserResponse> listUsers () {
        return userService.listUsers();
    }


    @GET
    @Path ("{username}")
    public UserResponse getUser (@RestPath String username) {
        return userService.getUser(username);
    }

    @DELETE
    public Response deleteUser (UserResponse userResponse) {
        userService.deleteUser(userResponse);
        return Response.ok().build();
    }

    @PUT
    public Response updateUser (UserResponse userResponse) {
        userService.updateUser(userResponse);
        return Response.ok().build();
    }

}
