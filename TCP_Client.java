
import java.io.*;
import java.net.*;

public class TCP_Client {

    public static void main(String[] args) {
        int port = 10007;
        try{
            Socket skt = new Socket("172.31.45.9", port);
            // サーバへのデータ送信ライタ
            OutputStreamWriter oSW
                = new OutputStreamWriter(skt.getOutputStream());
            PrintWriter outS = new PrintWriter(oSW, true);

            // サーバからのデータ受信用リーダ
            InputStreamReader iSR
                = new InputStreamReader(skt.getInputStream());
            BufferedReader inS = new BufferedReader(iSR);

            if (args.length == 0) {
                outS.println("");
            }else{
                outS.println(args[0]);
            }

            String tmString = "";
            while((tmString = inS.readLine()) != null){
                System.out.println(tmString);
            }

            inS.close();
            outS.close();
            skt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
