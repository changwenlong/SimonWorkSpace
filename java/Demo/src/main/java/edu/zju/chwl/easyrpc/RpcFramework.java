package edu.zju.chwl.easyrpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * RPC的简易实现，主要用到socket编程和动态代理
 * @author chwl
 * @Date 2015年7月25日 下午3:00:12
 */

public class RpcFramework {
	/**
	 * 暴露服务
	 * @param service 服务实现
	 * @param port 服务端口
	 * @throws IOException
	 */
	public static void export(final Object service, int port) throws IOException {
		ServerSocket ss = new ServerSocket(port);
		ExecutorService executor = Executors.newFixedThreadPool(100);
		while (true) {
			final Socket s = ss.accept();
			System.out.println("connect!!!");
			executor.execute(new Runnable() {
				@Override
				public void run() {
					ObjectInputStream ois;
					try {
						ois = new ObjectInputStream(s.getInputStream());
						ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
						String methodName = ois.readUTF();
						System.out.println(methodName);
						Class<?>[] parameterTypes;
						try {
							//读取客户端传过来的方法名，参数类型和参数，并生成对象发送给客户端
							parameterTypes = (Class<?>[]) ois.readObject();
							Object[] args = (Object[]) ois.readObject();
							Method method;
							try {
								method = service.getClass().getMethod(
										methodName, parameterTypes);
								Object result = method.invoke(service, args);
								oos.writeObject(result);
							} catch (Exception e) {
								oos.writeObject(e);
							} 
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}finally{
						try {
							s.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
	}
	
	/**
	 * 在客户端实现
	 * 引用服务：供客户端调用生成服务
	 * @param interfaceClass 服务接口泛型
	 * @param host 服务器主机名
	 * @param port 服务端口
	 * @return 远程服务
	 */
	@SuppressWarnings("unchecked")
	public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) {
		return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] {interfaceClass}, new InvocationHandler(){
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
				Socket s=new Socket(host, port);
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				//将方法名，参数类型和参数，发送给给服务端，并接受服务端生成的对象
				oos.writeUTF(method.getName());
				oos.writeObject(method.getParameterTypes());
				oos.writeObject(args);
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());//阻塞操作
				Object result= ois.readObject();
				s.close();
				if(result instanceof Throwable){
					throw (Throwable)result;
				}
				return result;				
			}			
		});
	} 

}

