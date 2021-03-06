package org.game;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("/")
public class GameResource {
    private static final Logger LOG = Logger.getLogger(GameResource.class.getName());

    @GET
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @POST
    @Path("conversions/ctok/{celsius}")
    @Produces(MediaType.TEXT_PLAIN)
    public float Celsius_to_Kelvin(@PathParam("celsius") String celsius) {
        LOG.info("Hitting the Celsius_to_Kelvin Request..." + celsius);
        try {
            float f = Float.parseFloat(celsius);
            return (float) (f + 273.15);
        } catch (NumberFormatException ex) {
            LOG.info("Eneter value is not valid");
            return 0;
        }
    }
    @POST
    @Path("conversions/ktoc/{kelvin}")
    @Produces(MediaType.TEXT_PLAIN)
    public float Kelvin_to_Celsius(@PathParam("kelvin") String kelvin) {
        LOG.info("Hitting the Kelvin_to_Celsius Request..." + kelvin);
        try {
            float f = Float.parseFloat(kelvin);
            return (float) (f - 273.15);
        } catch (NumberFormatException ex) {
            LOG.info("Eneter value is not valid");
            return 0;
        }


    }
    @POST
    @Path("conversions/mtok/{miles}")
    @Produces(MediaType.TEXT_PLAIN)
    public double  Miles_to_Kilometeres(@PathParam("miles") String miles) {
        LOG.info("Hitting the Miles_to_Kilometeres Request..." + miles);
        try {
            double f = Double.parseDouble(miles);
            return (double) (f * 1.6);
        } catch (NumberFormatException ex) {
            LOG.info("Eneter value is not valid");
            return 0;
        }
    }

    @POST
    @Path("conversions/ktom/{kilometeres}")
    @Produces(MediaType.TEXT_PLAIN)
    public double  Kilometeres_to_Miles(@PathParam("kilometeres") String kilometeres) {
        LOG.info("Hitting the Kilometeres_to_Miles Request..." + kilometeres);
        try {
            double f = Double.parseDouble(kilometeres);
            return (double) ( 0.621 * f);
        } catch (NumberFormatException ex) {
            LOG.info("Eneter value is not valid");
            return 0;
        }
    }

}