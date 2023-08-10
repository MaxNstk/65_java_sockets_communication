package sockets;

import java.io.InputStream;
import java.io.OutputStream;

public interface ConexaoGenerica {

    public void send(String command);

    public String read();

    boolean closeConnection();

}
