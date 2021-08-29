package tickets;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import tickets.resource.TicketsResource;
import tickets.service.PlayerService;
import tickets.service.TicketsService;
import ticketsmapper.PlayerMapper;
import ticketsmapper.TicketMapper;


public class TicketsApplication extends Application<TicketsConfiguration> {

    public static void main(String[] args) throws Exception {

        new TicketsApplication().run(args);
    }

    @Override
    public void run(TicketsConfiguration ticketsConfiguration, Environment environment) throws Exception {

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, ticketsConfiguration.getDataSourceFactory(), "postgresql");
        final TicketsService ticketsService = jdbi.onDemand(TicketsService.class);
        environment.jersey().register(new TicketsResource(ticketsService));

        final PlayerService playerService = jdbi.onDemand(PlayerService.class);
        environment.jersey().register(new TicketsResource(playerService));
        jdbi.registerMapper(new TicketMapper());
        jdbi.registerMapper(new PlayerMapper());

        environment.jersey().register(new JsonProcessingExceptionMapper(true));
    }



    @Override
    public void initialize(
            final Bootstrap<TicketsConfiguration> bootstrap) {

    }

}
