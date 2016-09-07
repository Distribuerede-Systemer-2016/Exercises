import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jesperbruun on 07/09/2016.
 */
public class Server {

  public static void main(String args[]){

    try {


      ServerSocket welcomeSocket = new ServerSocket(1337);

      while(true){

        System.out.println("Waiting for client ...");
        Socket connectionSocket = welcomeSocket.accept();

        BufferedReader inFromClient =
            new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

        DataOutputStream outToClient =
            new DataOutputStream(connectionSocket.getOutputStream());

        String clientSentence = inFromClient.readLine();
        System.out.println("Recieved: " + clientSentence);

        String capitalizedSentence = clientSentence.toUpperCase() + "\n";
        outToClient.writeBytes(capitalizedSentence);


      }


    } catch (IOException e) {
      e.printStackTrace();
    }


  }

}
