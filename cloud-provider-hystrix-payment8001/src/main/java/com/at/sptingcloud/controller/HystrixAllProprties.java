package com.at.sptingcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

public class HystrixAllProprties {
	
	//https://blog.csdn.net/tongtong_use/article/details/78611225
	@HystrixCommand(fallbackMethod = "fallbackMethod",
			groupKey="strGroupCommand",
			commandKey="strCommand",
			threadPoolKey="strThreadPool",
			commandProperties = {
				//设置隔离策略，THREAD表示线程池SEMAPHORE：信号池隔离
				@HystrixProperty(name="execution.isolation.strategy",value="THREAD"),
				//当前隔离策略选择信号池隔离的时候，用来设置信号池的大小（最大并发数）
				@HystrixProperty(name="execution.isolation.semaphore.maxConcurrentRequests",value="10"),
				//配置命令执行的超时时间
				@HystrixProperty(name="execution.isolation.thread.timeoutinMilliseconds",value="10"),
				//是否启用超时时间
				@HystrixProperty(name="execution.isolation.timeout.enabled",value="true"),
				//执行超时的时候是否中断
				@HystrixProperty(name="execution.isolation.thread.interruptOnTimeout",value="true"),
				//执行被取消的时候是否中断
				@HystrixProperty(name="execution.isolation.thread.interruptOnCancel",value="true"),
				//允许回调方法执行的最大并发数
				@HystrixProperty(name="fallback.isolation.semaphore.maxConcurrentRequests",value="10"),
				//服务降级是否启用，是否执行回调函数
				@HystrixProperty(name="fallback.enabled",value="true"),
				//是否启用断路器
				@HystrixProperty(name="circuitBreaker.enabled",value="true"),
				//该属性用来设置在滚动时间窗种，断路器熔断的最小请求数，例如，默认值为20的时候
				//如果滚动时间窗（默认10秒，通过metrics.rollingStats.timeinMilliseconds属性配置）
				//内仅收到了19个请求，即使这19个请求都失败了，断路器
				@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="20"),
				//该属性用来设置在滚动时间窗中，请求数量超过requestVolumeThreshold的情况下
				//如果错误的请求数的百分比超过50
				//就把断路器设置为“打开”状态
				@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50"),
				//该属性用来设置当前断路器打开后的休眠时间窗，休眠时间窗结束后，
				//会将断路器设置为“半开”状态，尝试熔断的请求命令，如果依然失败就将断路器继续设置为“打开”状态，
				//如果成功就设置为“关闭状态"
				@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000"),
				//断路器强制打开，优先于circuitBreaker.forceClosed属性
				@HystrixProperty(name="circuitBreaker.forceOpen",value="false"),
				//断路器强制关闭
				@HystrixProperty(name="circuitBreaker.forceClosed",value="false"),
				//滚动时间窗设置，该时间用于断路器判断健康度时需要收集信息的持续时间
				@HystrixProperty(name="metrics.rollingStats.timeinMilliseconds",value="10000"),
				//该属性用来设置滚动时间窗统计指标信息时划分“桶”的数量，断路器在收集指标信息的时候会根据
				//设置的时间窗长度拆分成多个“桶”来累计各度量值，每个“桶”记录了一段时间内的采集指标。
				//比如10秒内拆分成10个“桶”收集，所有timeinMilliseconds必须能被numBuckets整除，否则会抛异常
				//https://www.cnblogs.com/loveLands/articles/10835821.html
				@HystrixProperty(name="metrics.rollingStats.numBuckets",value="10"),
				//该属性用来设置对命令执行的延迟是否使用百分数来跟踪和计算，如果设置为false，那么所有的概要统计都将返回-1
				@HystrixProperty(name="metrics.rollingPercentile.enabled",value="false"),
				//该属性用来设置百分位统计的持续时间，单位为毫秒
				@HystrixProperty(name="metrics.rollingPercentile.timeinMilliseconds",value="60000"),
				//该属性用来设置在执行过程中每个“桶”中保留的最大执行数，如果在滚动时间窗内发生超过该设定值的执行次数
				//就从最初的位置开始重写，例如，将该值设置为100.滚动窗口为10秒，，若在10秒内一个“桶”中发生了500次执行
				//那么该“桶”中只保留最后100次执行的统计，另外，增加该值的大小将会增加内存量的消耗，并增加排序百分位数所需的计算时间
				@HystrixProperty(name="metrics.rollingPercentile.bucketSize",value="100"),
				//该属性用来设置采集影响断路器状态的健康快照（请求的成功，错误百分比）的间隔等待时间
				@HystrixProperty(name="metrics.healthSnapshot.intervalInMilliseconds",value="500"),
				//是否开启请求缓存
				@HystrixProperty(name="requestCache.enabled",value="true"),
				//HystrixCommand的执行和事件是否打印日志到HystrixReaquestlog中
				@HystrixProperty(name="requestLog.enabled",value="true"),
			},
			threadPoolProperties = {
				//该参数用来设置执行命令的线程池的核心线程数，该值也就是命令执行的最大并发量
				@HystrixProperty(name="coreSize",value="10"),
				//该参数用来设置线程池的最大队列大小。当设置为-1时，线程池将使用SynchronousQueue实现的队列
				//否则将使用LinkedBlockingQueue实现的队列
				@HystrixProperty(name="maxQueueSize",value="-1"),
				//该参数用来为队列设置拒绝的阙值，通过该参数，即使队列没有达到最大值也能拒绝请求
				//该参数主要是对LinkedBlockingQueue队列的补充，因为LinkedBlockingQueue
				//队列不能动态修改它的对象大小了
				@HystrixProperty(name="queueSizeRejectionThreshold",value="5"),
					
			}
			
			)
	public String method() {
		return "";
	}

}
