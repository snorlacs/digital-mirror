package digitalmirror;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@Import(RepositoryRestMvcConfiguration.class)
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan(basePackages = {"digitalmirror.services"})
@Configuration
@EnableNeo4jRepositories(basePackages = "digitalmirror.repositories")
public class MyNeo4jConfiguration extends Neo4jConfiguration {

    public MyNeo4jConfiguration() {
        setBasePackage("digitalmirror.domain");
    }

    public static final String URL = System.getenv("NEO4J_URL") != null ? System.getenv("NEO4J_URL") : "http://localhost:7474/db/data/";

    @Bean
    public GraphDatabaseService graphDatabaseService() {
        return new SpringCypherRestGraphDatabase(URL,"neo4j","magicmirror");
    }

}
