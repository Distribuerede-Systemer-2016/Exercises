import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by jesperbruun on 07/09/2016.
 */
public class Client {

  public static void main(String args[]){

    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

    try {
      Socket clientSocket = new Socket("localhost", 1337);

      DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

      BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

      System.out.println("\nClient Input:");
      String sentence = inFromUser.readLine();

      outToServer.writeBytes(sentence);

      String modifiedSentence = inFromServer.readLine();
      System.out.println("FROM SERVER:" + modifiedSentence);
      clientSocket.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
