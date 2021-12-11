package Q2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Handler implements Runnable {

    // Connection socket of handler
    private Socket socket;

    /**
     * Create a new Handler with given socket
     *
     * @param socket a connection socket
     */
    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        new Client(socket.getPort()).sendData("Client sent data");
    }
}
