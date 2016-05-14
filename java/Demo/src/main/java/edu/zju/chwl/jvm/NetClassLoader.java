package edu.zju.chwl.jvm;

public class NetClassLoader extends ClassLoader {

	@Override
	protected Class<?> findClass(String url) throws ClassNotFoundException {
		//父类加载器加载不了时，由次加载器加载
		byte[] classData = getDataFormNet(url);
		if(classData==null){
			throw new ClassNotFoundException();
		}else{
			return defineClass(url,classData,0,classData.length);
		}
	}

	private byte[] getDataFormNet(String url) {
		//根据url从远程网络获取Class文件的字节数组
		return null;
		
	}

	
}
