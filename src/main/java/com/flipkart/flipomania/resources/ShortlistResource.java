package com.flipkart.flipomania.resources;

import com.flipkart.flipomania.representations.ShortListed;
import com.flipkart.flipomania.services.Selector;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by :- Shiv Pratap Singh Parmar
 * Created on :- 6/6/15.
 */

@Singleton
@Path("/create_shortlist")
@Produces(MediaType.APPLICATION_JSON)
public class ShortlistResource {

    private Selector selector;

    @Inject
    public ShortlistResource(Selector selector){
        this.selector = selector;
    }

    @POST
    @Path("/")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,List<String>> executeTheAlgorithm(ShortListed shortlist) throws IOException {
        System.out.println(shortlist.toString());
        Map<String,List<String> > outputData = selector.execute(shortlist);
        return outputData;
    }
}
