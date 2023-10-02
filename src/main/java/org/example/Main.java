package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) throws Exception {

            var server = new Server(8181);

            // Server handler. Web Socket
            var resource = Resource.newClassPathResource("/webapp");
            var webApp = new WebAppContext(resource, "/");

            webApp.addServlet(new ServletHolder(new ApiServlet()), "/api/parts"); //Anyone on localhost:8181/api it will go to apiservlet.
            // webApp.addFilter(new FilterHolder(new NewFilter()), "/*", EnumSet.of(DispatcherType.REQUEST));
            server.setHandler(webApp);
            server.start();


    }
}