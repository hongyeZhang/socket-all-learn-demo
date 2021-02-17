import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author ZHQ
 * @date 2021/2/17
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8080);
        BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String input = clientInput.readLine();
        while (!input.equals("exit")) {
            writer.println(input);
            writer.flush();
            System.out.println("服务端的响应为:" + bufferedReader.readLine());
            input = clientInput.readLine();
        }

        writer.close();
        bufferedReader.close();
        socket.close();


    }
}
