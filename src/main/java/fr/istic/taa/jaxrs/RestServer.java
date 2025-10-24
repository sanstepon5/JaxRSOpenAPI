package fr.istic.taa.jaxrs;

import fr.istic.taa.jaxrs.dao.generic.TeacherDAO;
import fr.istic.taa.jaxrs.domain.Teacher;
import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import java.util.logging.Logger;

/**
 * RESTfull microservice, based on JAX-RS and JBoss Undertow
 *
 */
public class RestServer {
    private static final Logger logger = Logger.getLogger(RestServer.class.getName());
    public static void main( String[] args ) {
        TeacherDAO teacherDAO = new TeacherDAO();
        teacherDAO.save(new Teacher("John", "Rest"));
        UndertowJaxrsServer ut = new UndertowJaxrsServer();
        TestApplication ta = new TestApplication();
        ut.deploy(ta);
        ut.start(
                Undertow.builder()
                        .addHttpListener(8080, "localhost")
        );
        logger.info("JAX-RS based micro-service running!");
    }
}
