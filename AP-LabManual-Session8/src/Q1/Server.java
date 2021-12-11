package Q1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Server class represents a server in network
 */
public class Server {

    /**
     * Read data from client
     */
    public void run() {
        String data = "";
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket = serverSocket.accept();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String input = "", output = "";
            while (!input.equals("over")) {
                input = inputStream.readUTF();
                System.out.println(input);
                data += input;
                output = br.readLine();
                outputStream.writeUTF(output);
                outputStream.flush();
            }
            outputStream.writeUTF(data);
            outputStream.flush();
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
