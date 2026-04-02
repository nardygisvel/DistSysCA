/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.distsysca;


import java.util.HashMap;
import java.util.Map;

/**
 * A simple Naming Service simulation.
 * Services register their address here, and the Client looks them up.
 */
public class ServiceRegistry {
    private static final Map<String, String> registry = new HashMap<>();
//  private static final Map<String, String> registry = new ConcurrentHashMap<>();
    public static void register(String serviceName, String address) {
        registry.put(serviceName, address);
        System.out.println("Naming Service: " + serviceName + " registered at " + address);
    }

    public static String lookup(String serviceName) {
        return registry.get(serviceName);
    }
}
