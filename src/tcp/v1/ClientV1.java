package tcp.v1;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

/**
 * 클라이언트가 Hello라는 문자를 서버에 전달하면 서버는 클라이언트 요청에 World를 더해서 응답한다.
 */
public class ClientV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = new Socket("localhost", PORT);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        log("소캣 연결:" + socket);

        // 서버에게 문자 보내기
        String toSend = "Hello";
        output.writeUTF(toSend);
        log("client -> server: " + toSend);

        // 서버로부터 문자 받기
        String received = input.readUTF();
        log("client <- server: " + received);

        // 자원정리
        log("연결 종료: " + socket);
        input.close();
        output.close();
        socket.close();
    }
}
