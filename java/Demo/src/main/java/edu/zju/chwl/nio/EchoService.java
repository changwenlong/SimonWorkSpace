package edu.zju.chwl.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class EchoService {

	public static void main(String[] args) {
		ServerSocketChannel serverChannel;
		Selector selector;
		try {
			// 打开Channel
			serverChannel = ServerSocketChannel.open();
			// 获取通道Socket
			ServerSocket ss = serverChannel.socket();
			ss.bind(new InetSocketAddress(7));
			serverChannel.configureBlocking(false);
			// 打开选择器
			selector = Selector.open();
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		while (true) {
			try {
				selector.select();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = readyKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				iterator.remove();
				try {
					if (key.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel) key
								.channel();
						SocketChannel client = server.accept();
						System.out
								.println("Accepted Connection from " + client);
						client.configureBlocking(false);
						SelectionKey clientKey = client.register(selector,
								SelectionKey.OP_WRITE | SelectionKey.OP_READ);
						ByteBuffer buffer = ByteBuffer.allocate(6);
						clientKey.attach(buffer);
					} else if (key.isReadable()) {
						SocketChannel client = (SocketChannel) key.channel();
						System.out.println("Read from " + client);
						ByteBuffer output = (ByteBuffer) key.attachment();						
						client.read(output);
						output.flip(); // make buffer ready for read
						while (output.hasRemaining()) {
							System.out.print((char) output.get()); 
						}
					} else if (key.isWritable()) {
						SocketChannel client = (SocketChannel) key.channel();
						System.out.println("Write from " + client);
						ByteBuffer output = (ByteBuffer) key.attachment();
						output.flip();
						while (output.hasRemaining()) {
							output.putChar(Character.toUpperCase((char) output.get()));
						}
						client.write(output);
						output.compact();					
						
					}
				} catch (IOException ex) {
					key.cancel();
					try {
						key.channel().close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

}
