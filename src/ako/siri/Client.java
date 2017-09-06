package ako.siri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.run();
    }
    
    private void run() throws IOException {
        String message = "Baby";
        Socket socket = new Socket("192.168.33.18", 9001);
        BufferedReader in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(message);
        System.out.println(message);
        System.out.println(in.readLine());
    }
}
