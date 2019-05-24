package cn.jcorn.thrift.client;

import cn.jcorn.thrift.api.HelloWorldService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class HelloClient {
    private String HOST;
    private int PORT;
    private int TIME_OUT;

    public HelloClient(String HOST, int PORT, int TIME_OUT) {
        this.HOST = HOST;
        this.PORT = PORT;
        this.TIME_OUT = TIME_OUT;
    }

    public void startClient(String name) throws TException {
        TTransport transport = new TSocket(HOST, PORT, TIME_OUT);
        TBinaryProtocol protocol = new TBinaryProtocol(transport);
        HelloWorldService.Client client = new HelloWorldService.Client(protocol);
        transport.open();
        String msg = client.sayHello(name);
        System.out.println(msg);
        transport.close();
    }
}
