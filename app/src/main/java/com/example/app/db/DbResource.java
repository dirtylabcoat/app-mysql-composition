package com.example.app.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("db")
public class DbResource {

    public static final Logger LOGGER = LoggerFactory.getLogger(DbResource.class.getName());

    @PersistenceContext(unitName = "MyDataSourcePU")
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkDb() {
        Query query = em.createNativeQuery("SELECT * FROM tbl;", Tbl.class);
        List<Tbl> rows = query.getResultList();
        int count = rows.size();
        LOGGER.debug("count: {}", count);
        JsonObjectBuilder job = Json.createObjectBuilder().add("count", count);
        JsonArrayBuilder jab = Json.createArrayBuilder();
        rows.forEach(r -> jab.add(Json.createObjectBuilder()
                .add("id", r.getId())
                .add("msg", r.getMsg())
                .build()));
        job.add("rows", jab.build());
        return Response.ok(job.build()).build();
    }

}
