package com.mrathena.java.util.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicIntegerDemo {

	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger();
		System.out.println(atomicInteger.get());
		atomicInteger.set(1);
		System.out.println(atomicInteger.get());

		System.out.println(atomicInteger.getAndSet(2));
		System.out.println(atomicInteger.get());

		// 内部维护的值与期望值(第一个参数)相同,才会设定新值(第二个参数)
		atomicInteger.compareAndSet(3, 3);
		System.out.println(atomicInteger.get());
		atomicInteger.compareAndSet(2, 3);
		System.out.println(atomicInteger.get());

		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger.get());

		System.out.println(atomicInteger.getAndDecrement());
		System.out.println(atomicInteger.get());

		System.out.println(atomicInteger.getAndAdd(10));
		System.out.println(atomicInteger.get());

		System.out.println(atomicInteger.incrementAndGet());
		System.out.println(atomicInteger.get());

		System.out.println(atomicInteger.decrementAndGet());
		System.out.println(atomicInteger.get());

		System.out.println(atomicInteger.addAndGet(10));
		System.out.println(atomicInteger.get());

		// getAndUpdate/updateAndGet 可以接受一元lambda表达式
		AtomicInteger atomicInt = new AtomicInteger(0);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000).forEach(i -> {
//			Runnable task = () -> atomicInt.updateAndGet(n -> n + 2);
			Runnable task = () -> atomicInt.getAndUpdate(n -> n + 2);
			executor.submit(task);
		});
		stop(executor);
		System.out.println(atomicInt.get());// => 2000

		// Accumulate 累加
		// getAndAccumulate/accumulateAndGet 可以接受二元lambda表达式
		// 可以使用这种方法并行计算累加0~1000的值
		AtomicInteger atomicInt2 = new AtomicInteger(0);
		ExecutorService executor2 = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000).forEach(i -> {
//			Runnable task = () -> atomicInt2.accumulateAndGet(i, (n, m) -> n + m);
			Runnable task = () -> atomicInt2.getAndAccumulate(i, (n, m) -> n + m);
			executor2.submit(task);
		});
		stop(executor2);
		System.out.println(atomicInt2.get());// => 499500

	}

	public static void stop(ExecutorService executor) {
		try {
			executor.shutdown();
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("termination interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("killing non-finished tasks");
			}
			executor.shutdownNow();
		}
	}

}
