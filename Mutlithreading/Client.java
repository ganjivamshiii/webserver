import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    
    public Runnable getRunnable() {
        return () -> {
            int port = 8010;
            try (Socket socket = new Socket(InetAddress.getByName("localhost"), port);
                 PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                
                toSocket.println("Hello from Client " + socket.getLocalSocketAddress());
                String response = fromSocket.readLine();
                System.out.println("Response from Server: " + response);
                
            } catch (IOException e) {
                System.err.println("Client Error: " + e.getMessage());
            }
        };
    }

    public static void main(String[] args) {
        int numClients = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(10); // 10 threads for handling 100 requests

        Client client = new Client();
        for (int i = 0; i < numClients; i++) {
            executorService.execute(client.getRunnable());
        }

        executorService.shutdown(); // Graceful shutdown after all tasks are submitted
    }
}
