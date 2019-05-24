package cn.jcorn.thrift;

import cn.jcorn.thrift.client.HelloClient;
import cn.jcorn.thrift.server.HelloServer;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

public class Application {
    public static void main(String[] args) {
        new Thread(() -> {
            HelloServer server = new HelloServer(9000);
            try {
                server.startServer();
            } catch (TTransportException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            HelloClient client = new HelloClient("127.0.0.1", 9000, 3000);
            try {
                client.startClient("周哥");
            } catch (TException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
