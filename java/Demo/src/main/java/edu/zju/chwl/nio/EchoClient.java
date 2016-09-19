package edu.zju.chwl.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;


public class EchoClient {

	public static void main(String[] args) {
		 ByteBuffer buffer = ByteBuffer.allocate(1024);
	        SocketChannel socketChannel = null;
	        try
	        {
	            socketChannel = SocketChannel.open();
	            socketChannel.configureBlocking(false);
	            socketChannel.connect(new InetSocketAddress("localhost",9070));

	            if(socketChannel.finishConnect())
	            {
	                int i=0;
	                while(true)
	                {
	                	//客户端向服务端发送消息
	                    TimeUnit.SECONDS.sleep(1);
	                    String info = "I'm "+i+++"-th information from client";
	                    buffer.clear();
	                    buffer.put(info.getBytes());
	                    buffer.flip();
	                    while(buffer.hasRemaining()){
	                        socketChannel.write(buffer);//发送消息
	                    }
	                    
	                    //客户端从服务端接收消息
	                    TimeUnit.SECONDS.sleep(1);
	                    buffer.clear();
	                    socketChannel.read(buffer);//接收消息
	                    buffer.flip();
	                    while(buffer.hasRemaining()){
	                        System.out.print((char)buffer.get());
	                    }
	                    System.out.println();
	                }
	            }
	        }
	        catch (IOException | InterruptedException e)
	        {
	            e.printStackTrace();
	        }
	        finally{
	            try{
	                if(socketChannel!=null){
	                    socketChannel.close();
	                }
	            }catch(IOException e){
	                e.printStackTrace();
	            }
	        }
	}

}
