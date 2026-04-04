/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.distsysca;

/**
 *
 * @author Nardy
 */
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;

/**
 * This class handles service registration and discovery using jmDNS.
 * Servers call register() to announce themselves on the network.
 * The GUI calls discover() to find running services.
 */
public class ServiceRegistry {

    // this is the service type we use for all our gRPC services
    // it's like a "channel" that all our services broadcast on
    private static final String SERVICE_TYPE = "_grpc._tcp.local.";

    /**
     * Register a service so other devices can find it on the network.
     * Each server calls this when it starts up.
     */
    public static void register(String serviceName, int port) {
        try {
            // create a jmDNS instance on this machine's address
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // build the service info - this is what gets broadcast
            ServiceInfo serviceInfo = ServiceInfo.create(
                SERVICE_TYPE,    // the type (like a category)
                serviceName,     // the name (like "BeltService")
                port,            // the port the server is running on
                "gRPC service"   // just a description
            );

            // register it - now other devices can find this service
            jmdns.registerService(serviceInfo);
            System.out.println("[jmDNS] Registered: " + serviceName + " on port " + port);

        } catch (IOException e) {
            System.err.println("[jmDNS] Failed to register " + serviceName + ": " + e.getMessage());
        }
    }

    /**
     * Discover a service by name. Waits up to 5 seconds to find it.
     * The GUI calls this to find where each server is running.
     */
    public static ServiceInfo discover(String serviceName) {
        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // look for the service - wait up to 5 seconds
            ServiceInfo serviceInfo = jmdns.getServiceInfo(SERVICE_TYPE, serviceName, 5000);

            if (serviceInfo != null) {
                System.out.println("[jmDNS] Found: " + serviceName
                    + " at " + serviceInfo.getHostAddresses()[0]
                    + ":" + serviceInfo.getPort());
            } else {
                System.out.println("[jmDNS] Could not find: " + serviceName);
            }

            return serviceInfo;

        } catch (IOException e) {
            System.err.println("[jmDNS] Discovery error: " + e.getMessage());
            return null;
        }
    }
}
