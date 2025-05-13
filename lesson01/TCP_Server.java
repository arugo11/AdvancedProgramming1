
import java.io.*;
import java.net.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TCP_Server {
    public static void main(String[] args) {
        int port = 10007;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            //? ソケットプログラミングにおいて明示的にflgを記述する必要がある？
            boolean flg = true;
            while (flg == true) {
                Socket skt = serverSocket.accept();

                InputStreamReader iSR
                    = new InputStreamReader(skt.getInputStream());
                BufferedReader inS = new BufferedReader(iSR);

                OutputStreamWriter oSW
                    = new OutputStreamWriter(skt.getOutputStream());
                PrintWriter outS = new PrintWriter(oSW, true);

                String inMsg = inS.readLine();

                LocalDateTime nowDateTime = LocalDateTime.now();
                DateTimeFormatter java8Format = 
                    DateTimeFormatter.ofPattern("MM/dd HH:mm:ss");
                String outMsg = nowDateTime.format(java8Format) + "(" + inMsg + ")";
                System.out.println(outMsg);
                outS.println(outMsg);

                inS.close();
                outS.close();
                skt.close();
            }
            serverSocket.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
