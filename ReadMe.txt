Camel Router WAR Project
========================

This project includes a sample route as as a WAR.
You can build the WAR by running

    mvn package

You can then run the project by dropping the WAR into your 
favorite web container or just run

    mvn jetty:run

to start up and deploy to Jetty. (have to add jetty maven plugin for this)


Important note regarding camel-restlet and org.restlet.jee.ext.spring

camel-restlet v2.13.2 depends on org.restlet.jee.ext.spring v2.1.7. 
So upgrading org.restlet.jee.ext.spring to newer version breaks the application. 
