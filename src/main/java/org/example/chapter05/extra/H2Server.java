package org.example.chapter05.extra;

import org.h2.tools.Server;

public class H2Server {
    static void main() throws Exception {
        Server.createTcpServer("-tcpPort", "9092").start();
        Server.createWebServer("-webPort", "8082").start();
        System.out.println("H2 started");
    }
}