package ako.siri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SiriServer {
    private static final int PORT = 9001;
    
    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running.");
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }
    
    private static class Handler extends Thread {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    name = in.readLine();
                    if (name.equalsIgnoreCase("baby")) {
                        out.println("Panget mo");
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
