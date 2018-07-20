package com.mrathena.java.util.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.stream.IntStream;

import com.mrathena.java.util.concurrent.tool.ExecutorKit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AtomicMarkableReferenceDemo {

	/*为了解决ABA问题，伟大的java为我们提供了AtomicMarkableReference和AtomicStampedReference类
	AtomicMarkableReference是利用boolean标记的形式记录了是否做了标记这个状态，这样的话就不会存在ABA问题了*/

	public static void main(String[] args) {
		AtomicMarkableReference<Integer> atomicMarkableReference = new AtomicMarkableReference<>(0, true);
		log.info("{}, {}", atomicMarkableReference.getReference(), atomicMarkableReference.isMarked());

		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10).forEach(i -> {
			// compareAndSet(期望的值, 新值, 期望的标记, 新的标记), 期望的值和期望的标记都相同, 才会更新
			Runnable task = () -> System.out.println(atomicMarkableReference.compareAndSet(0, 0, true, false));
			executor.submit(task);
		});
		ExecutorKit.stop(executor);

		log.info("{}, {}", atomicMarkableReference.getReference(), atomicMarkableReference.isMarked());

	}

}
