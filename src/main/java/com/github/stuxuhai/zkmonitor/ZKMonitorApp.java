/*
 * Author: wuya
 * Create Date: 2015年11月30日 下午5:41:12
 */

package com.github.stuxuhai.zkmonitor;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.URI;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletRegistration;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.configuration.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.servlet.WebappContext;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;

import com.github.stuxuhai.zkmonitor.conf.ConfigKeys;
import com.github.stuxuhai.zkmonitor.conf.ZKMonitorConfig;
import com.github.stuxuhai.zkmonitor.domain.ZKServerInfo;
import com.google.common.collect.Queues;

public class ZKMonitorApp {

    private WebApplicationContext webApplicationContext = null;

    private static final Logger LOGGER = LogManager.getLogger();

    public HttpServer startHttpServer() throws IOException {
        String ipv4 = Inet4Address.getLocalHost().getHostAddress();
        int port = Integer.parseInt(System.getProperty("http.port", "8080"));
        URI baseUri = UriBuilder.fromUri("http://" + ipv4 + "/").port(port).build();
        ResourceConfig resourceConfig = new ResourceConfig();
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, resourceConfig);
        WebappContext context = new WebappContext("zkmonitor", "/");
        context.setInitParameter("contextConfigLocation", "context.xml");
        context.addListener(ContextLoaderListener.class.getName());

        ServletRegistration servletRegistration = context.addServlet("spring-servlet", DispatcherServlet.class);
        servletRegistration.setInitParameter("contextConfigLocation", "context.xml");
        servletRegistration.addMapping("/");

        context.deploy(httpServer);
        webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(context);

        return httpServer;
    }

    public void startMetricCollector() {
        Configuration config = ZKMonitorConfig.getConfig();
        Queue<ZKServerInfo> queue = Queues.newConcurrentLinkedQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();
        int collectRate = config.getInt(ConfigKeys.METRICS_COLLECT_RATE_SECONDS, 60);
        for (int i = 0; i < collectRate; i++) {
            executorService.submit(webApplicationContext.getBean(MetricCollector.class, queue));
        }

        MetricJob metricJob = webApplicationContext.getBean(MetricJob.class, queue);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(metricJob, 0, collectRate, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws IOException {
        LOGGER.info("Starting zkmonitor server...");
        ZKMonitorApp app = new ZKMonitorApp();
        app.startHttpServer();
        app.startMetricCollector();

        LOGGER.info("zkmonitor server started.");
    }

}
