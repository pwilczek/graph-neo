package name.wilu.neo;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = PersistenceContext.class)
@EnableNeo4jRepositories(basePackageClasses = PersistenceContext.class)
public class PersistenceContext extends Neo4jConfiguration {

    @Override public SessionFactory getSessionFactory() {
        return new SessionFactory(PersistenceContext.class.getPackage().getName());
    }
}
