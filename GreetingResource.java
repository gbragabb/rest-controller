package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.inject.Inject;
import io.quarkus.logging.Log;

@Path("/hello")
public class GreetingResource {

    @Inject ServiceNow service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello!";
    }
    @Path("/{nome}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloNome(@PathParam("nome") String nome) {
        return "Hello " + nome;
    }

    @Path("/{nome}/horario")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloNomeHorario(@PathParam("nome") String nome) {
        Log.info("O horário está sendo resgatado do serviço serviceNow(em low code) faz.ai");
        return "Hello " + nome + "! Agora são " + service.now() + ", não esqueça!";
    }
}
