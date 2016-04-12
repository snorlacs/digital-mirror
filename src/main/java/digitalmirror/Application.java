package digitalmirror;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;

@SpringBootApplication
@EnableNeo4jRepositories
public class Application extends Neo4jConfiguration{

    public Application(){
        setBasePackage("digitalmirror");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("target/digitalmirror.db");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
