package edu.zju.chwl.concurrent;

import static org.junit.Assert.*;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestExecutor {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		final int THREAD_COUNT=10;
		ExecutorService executor=Executors.newFixedThreadPool(THREAD_COUNT);
	}

}
