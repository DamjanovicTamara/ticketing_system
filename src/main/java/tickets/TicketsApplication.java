package tickets;

import io.dropwizard.Application;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.http.client.HttpClient;
import tickets.domain.Player;
import tickets.domain.Ticket;
import tickets.repository.TicketDAO;
import tickets.resource.TicketsResource;


public class TicketsApplication extends Application<TicketsConfiguration> {

    public static void main(String[] args) throws Exception {

        new TicketsApplication().run(args);
    }

    @Override
    public void run(TicketsConfiguration ticketsConfiguration, Environment environment) throws Exception {
        final TicketDAO ticketDAO
                = new TicketDAO(hibernateBundle.getSessionFactory());

        environment.jersey().register(new TicketsResource(ticketDAO));
        final HttpClient httpClient = new HttpClientBuilder(environment).using(ticketsConfiguration.getHttpClientConfiguration())
                .build(getName());
        environment.jersey().register(new TicketsResource(httpClient));
        environment.jersey().register(new JsonProcessingExceptionMapper(true));
    }


    /**
     * Hibernate bundle.
     */
    private final HibernateBundle<TicketsConfiguration> hibernateBundle
            = new HibernateBundle<TicketsConfiguration>(
            Ticket.class, Player.class
    ) {

        @Override
        public DataSourceFactory getDataSourceFactory(
                TicketsConfiguration configuration
        ) {
            return configuration.getDataSourceFactory();
        }

    };

    @Override
    public void initialize(
            final Bootstrap<TicketsConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

}
