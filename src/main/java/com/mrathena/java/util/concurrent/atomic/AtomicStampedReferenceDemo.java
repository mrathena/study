package com.mrathena.java.util.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.IntStream;

import com.mrathena.java.util.concurrent.tool.ExecutorKit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AtomicStampedReferenceDemo {

	/*
	为了解决ABA问题，伟大的java为我们提供了AtomicMarkableReference和AtomicStampedReference类
	AtomicStampedReference是利用版本戳的形式记录了每次改变以后的版本号，这样的话就不会存在ABA问题了
	
	举个通俗点的例子，你倒了一杯水放桌子上，干了点别的事，然后同事把你水喝了又给你重新倒了一杯水，你回来看水还在，拿起来就喝，
	如果你不管水中间被人喝过，只关心水还在，这就是ABA问题。如果你是一个讲卫生讲文明的小伙子，不但关心水在不在，
	还要在你离开的时候水被人动过没有，因为你是程序员，所以就想起了放了张纸在旁边，写上初始值0，别人喝水前麻烦先做个累加才能喝水。
	这就是AtomicStampedReference的解决方案。
	*/

	/*
	 *  内部:内部类Pair<V>, 其内部:T,int(版本号), 当前值/预期值,当前版本号/预期版本号都一致才会更新
	 */
	public static void main(String[] args) {
		AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(0, 0);
		log.info("{}, {}", atomicStampedReference.getReference(), atomicStampedReference.getStamp());

		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10).forEach(i -> {
			// compareAndSet(期望的值, 新值, 期望的标记, 新的标记), 期望的值和期望的标记都相同, 才会更新
			Runnable task = () -> System.out.println(atomicStampedReference.compareAndSet(0, 0, 0, 1));
			executor.submit(task);
		});
		ExecutorKit.stop(executor);

		log.info("{}, {}", atomicStampedReference.getReference(), atomicStampedReference.getStamp());
	}

}
