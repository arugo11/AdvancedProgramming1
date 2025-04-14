
import java.io.*;
import java.net.*;

public class TCP_Http {

    public static void main(String[] args){
        // サーバ名
        String ServerName = "www.example.com";

        // ポート番号
        int portNo = 80;

        InetAddress sAdr;
        StringBuffer sBuff = new StringBuffer();

        try{
            // ホスト名からIPアドレスに変換
            sAdr = InetAddress.getByName(ServerName);

            // Socketの作成
            Socket skt = new Socket(sAdr, portNo);

            // サーバへのデータ送信用ライタ
            BufferedWriter outS
                = new BufferedWriter(
                    new OutputStreamWriter(skt.getOutputStream()));

            // サーバからのデータ受信用リーダ
            BufferedReader inS
                = new BufferedReader(
                    new InputStreamReader(skt.getInputStream()));

            // Getリクエストの送信
            String[] msg = {"GET /index.html HTTP/1.0\r\n", "\r\n"};

            for(int i = 0; i < msg.length; i++){
                outS.write(msg[i]);
            }
            outS.flush();

            String tmpString;
            while((tmpString = inS.readLine()) != null){
                sBuff.append(tmpString + "\n");
            }
            System.out.println(sBuff.toString());
            outS.close();
            inS.close();
            skt.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
    }catch(IOException e){
            e.printStackTrace();
        }
    }
}