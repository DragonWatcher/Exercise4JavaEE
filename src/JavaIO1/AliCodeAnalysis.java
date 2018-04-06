package JavaIO1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AliCodeAnalysis {

	public static void main(String[] args) {/*
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
				.setNameFormat("demo-pool-%d").build();
		ExecutorService pool = new ThreadPoolExecutor(5, 200,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

		pool.execute(()-> System.out.println(Thread.currentThread().getName()));
		pool.shutdown();//gracefully shutdown   
	*/}

}
