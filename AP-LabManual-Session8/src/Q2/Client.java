package Q2;

import java.io.*;
import java.net.Socket;

/**
 * The Client class represents a client in network
 */
public class Client {

    // Data of client
    private String data;

    // Port for connection
    private int port;

    /**
     * Create a client with given port
     * @param port a port for connection
     */
    public Client(int port) {
        this.port = port;
        data = "";
    }

    /**
     * Get date of client
     *
     * @return data field
     */
    public String getData() {
        return data;
    }

    /**
     * Set a data for client
     *
     * @param data a string
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Send a data to server
     *
     * @param data a string
     */
    public void sendData(String data) {
        try {
            Socket socket = new Socket("localhost", port);
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            outputStream.writeUTF("Data sent");
            outputStream.writeUTF("over");
            outputStream.flush();

            String input = "";
            while (!input.equals("over")) {
                input = inputStream.readUTF();
            }
            this.data = input;
            inputStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
