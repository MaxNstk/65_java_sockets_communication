package socket;

public interface Conexao {

    public void send(String command);
    public String read();
    boolean closeConnection();
}
