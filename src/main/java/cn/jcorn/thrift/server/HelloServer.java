package cn.jcorn.thrift.server;

import cn.jcorn.thrift.api.HelloWorldService;
import cn.jcorn.thrift.impl.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class HelloServer {
    private int PORT;

    public HelloServer(int PORT) {
        this.PORT = PORT;
    }

    public void startServer() throws TTransportException {
        TProcessor tProcessor = new HelloWorldService.Processor<>(new HelloServiceImpl());
        TServerSocket serverTransport = new TServerSocket(PORT);
        TServer.Args tArgs = new TSimpleServer.Args(serverTransport);
        tArgs.processor(tProcessor);
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        TSimpleServer server = new TSimpleServer(tArgs);
        server.serve();
    }
}
