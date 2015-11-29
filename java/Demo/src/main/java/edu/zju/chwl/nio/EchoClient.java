package edu.zju.chwl.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;


public class EchoClient {

	public static void main(String[] args) {
		try {
			InetSocketAddress address = new InetSocketAddress("localhost", 7);
			SocketChannel client = SocketChannel.open(address);
			ByteBuffer buffer = ByteBuffer.allocate(6);
			CharBuffer charBuffer = buffer.asCharBuffer();
			char[] inputs="aaa".toCharArray();
			charBuffer.put(inputs, 0, inputs.length);
			client.write(buffer);
			buffer.clear();
			client.read(buffer);
			buffer.flip(); // make buffer ready for read
			while (buffer.hasRemaining()) {
				System.out.print((char) buffer.get()); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
