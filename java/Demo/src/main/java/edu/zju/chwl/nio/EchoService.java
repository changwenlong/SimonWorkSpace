package edu.zju.chwl.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class EchoService {
	
	private static final int BUF_SIZE=1024;
    private static final int PORT = 9070;
    private static final int TIMEOUT = 3000;

    public static void main(String[] args)
    {
        selector();
    }

    public static void handleAccept(SelectionKey key) throws IOException{
        ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        sc.register(key.selector(), SelectionKey.OP_READ,ByteBuffer.allocateDirect(BUF_SIZE));
    }

    public static void handleRead(SelectionKey key) throws IOException{
        SocketChannel sc = (SocketChannel)key.channel();
        ByteBuffer buf = (ByteBuffer)key.attachment();
        long bytesRead = sc.read(buf);
        while(bytesRead>0){
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char)buf.get());
            }
            System.out.println();
            buf.clear();
            bytesRead = sc.read(buf);
        }
        key.interestOps(key.interestOps()|SelectionKey.OP_WRITE);
        //sc.register(key.selector(), key.interestOps()|SelectionKey.OP_WRITE,buf);
        if(bytesRead == -1){
            sc.close();
        }
    }

    public static int i = 0;
    public static void handleWrite(SelectionKey key) throws IOException{
        ByteBuffer buf = (ByteBuffer)key.attachment();
        SocketChannel sc = (SocketChannel) key.channel();
        String info = "I'm "+i+++"-th information from server";
        buf.clear();
        buf.put(info.getBytes());
        buf.flip();
        while(buf.hasRemaining()){
            sc.write(buf);
        }
        buf.clear();
        key.interestOps(key.interestOps()&~SelectionKey.OP_WRITE);
        //sc.register(key.selector(), key.interestOps()&~SelectionKey.OP_WRITE,buf);
    }

    public static void selector() {
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try{
            selector = Selector.open();//打开Selector
            ssc= ServerSocketChannel.open();//打开ServerSocketChannel
            ssc.socket().bind(new InetSocketAddress(PORT));//Socket绑定端口
            ssc.configureBlocking(false);//非阻塞
            ssc.register(selector, SelectionKey.OP_ACCEPT);//向Selector注册Channel,注册连接事件

            while(true){
                if(selector.select(TIMEOUT) == 0){
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while(iter.hasNext()){
                    SelectionKey key = iter.next();
                    if(key.isAcceptable()){
                        handleAccept(key);
                    }
                    if(key.isReadable()){
                        handleRead(key);
                    }
                    if(key.isWritable() && key.isValid()){
                        handleWrite(key);
                    }
                    if(key.isConnectable()){
                        System.out.println("isConnectable = true");
                    }
                    iter.remove();
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(selector!=null){
                    selector.close();
                }
                if(ssc!=null){
                    ssc.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
