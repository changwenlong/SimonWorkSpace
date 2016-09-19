package edu.zju.chwl.drools;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;


public class DroolsEngineTest {

	@Test
	public void testSale() throws IOException, InterruptedException {
		InputStream resourceAsStream = this.getClass().getResourceAsStream("sales.drl");
		String str = IOUtils.toString(resourceAsStream);
		DroolsEngine engine = new DroolsEngine(1,str);
		engine.start();
		engine.insert(new Sale(1000,1));
		Thread.sleep(1);
		engine.insert(new Sale(40,5));
		Thread.sleep(1);
		engine.insert(new Sale(40,5));
		Thread.sleep(1);
		engine.insert(new Sale(40,5));
	}
	
	@Test
	public void testLengthWindow() throws IOException, InterruptedException {
		InputStream resourceAsStream = this.getClass().getResourceAsStream("TemperatureLengthWindow.drl");
		String str = IOUtils.toString(resourceAsStream);
		DroolsEngine engine = new DroolsEngine(2,str);
		engine.start();
		engine.insert(new Temperature(60));
		Thread.sleep(1);
		engine.insert(new Temperature(50));
		Thread.sleep(1);
		engine.insert(new Temperature(12));
		Thread.sleep(1);
		engine.insert(new Temperature(64));
		Thread.sleep(1);
		engine.insert(new Temperature(78));
	}
	
	@Test
	public void testTimeWindow() throws IOException, InterruptedException {
		InputStream resourceAsStream = this.getClass().getResourceAsStream("TemperatureTimeWindow.drl");
		String str = IOUtils.toString(resourceAsStream);
		DroolsEngine engine = new DroolsEngine(2,str);
		engine.start();
		engine.insert(new Temperature(60));
		Thread.sleep(1000);
		engine.insert(new Temperature(50));
		Thread.sleep(1000);
		engine.insert(new Temperature(12));
		Thread.sleep(1000);
		engine.insert(new Temperature(64));
		Thread.sleep(1000);
		engine.insert(new Temperature(78));
		Thread.sleep(3000);
	}
	
	@Test
	public void testCpuAndMem() throws IOException, InterruptedException {
		InputStream resourceAsStream = this.getClass().getResourceAsStream("cpuAndMem.drl");
		String str = IOUtils.toString(resourceAsStream);
		DroolsEngine engine = new DroolsEngine(3,str);
		engine.start();
		engine.insert(new Cpu(98));
		engine.insert(new Mem(97));
		Thread.sleep(1000);
		engine.insert(new Cpu(97));
		engine.insert(new Mem(96));
		Thread.sleep(1000);
		engine.insert(new Cpu(96));
		engine.insert(new Mem(95));
		Thread.sleep(2001);
	}

}
