/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.distsysca;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class launches everything in ONE process so they share 
 * the ServiceRegistry memory. This makes Discovery work!
 */
public class AppLaunch {
    public static void main(String[] args) throws Exception {
        // 1. Create a thread pool to run servers in the background
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("--- Starting All Services ---");

        // 2. Start each server in its own thread
        executor.submit(() -> {
            try { ArmServer.main(new String[]{}); } catch (Exception e) { e.printStackTrace(); }
        });

        executor.submit(() -> {
            try { BraceletServer.main(new String[]{}); } catch (Exception e) { e.printStackTrace(); }
        });

        executor.submit(() -> {
            try { BeltServer.main(new String[]{}); } catch (Exception e) { e.printStackTrace(); }
        });

        // 3. Wait a moment for registration to finish
        Thread.sleep(2000);

        System.out.println("\n--- All Services Registered. Starting Client ---");

        // 4. Run the Client (It will now find the services!)
        MainClient.main(new String[]{});
    }
}
