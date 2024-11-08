package Async.CompletableFutureExample;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureExample {
    
    public static String getItemName(Item item)
    {
        delay();
        System.out.println("Thread name : "+ Thread.currentThread().getName());
        System.out.println(item.getName());
        return item.getName();
    }

    public static void delay()
    {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void runWithoutCompletableFutures()
    {
        long start = System.currentTimeMillis();

		System.out.println("Running runWithoutCompletableFutures() method");

		var result = Stream.of(
            new Item(1, "description 1"),
            new Item(2, "description 2"),
            new Item(3, "description 3"))
        .map(CompletableFutureExample::getItemName)
        .collect(Collectors.toList());
		
		
		long end = System.currentTimeMillis();

		System.out.printf("Time needed to complete runWithoutCompletableFutures() :  %s ms%n" , end - start);
		System.out.println(result);
    }

    /**
     * runWithCompletableFutures method executes using completablefuture
     */
    public static void runWithCompletableFutures()
    {
        long start = System.currentTimeMillis();
        
		System.out.println("Running runWithCompletableFutures() method");

		var result = Stream.of(
            new Item(1, "description 1"),
            new Item(2, "description 2"),
            new Item(3, "description 3"))
        .map(item -> CompletableFuture.supplyAsync(() -> CompletableFutureExample.getItemName(item)))
        .collect(Collectors.toList());
		
		long end = System.currentTimeMillis();

		System.out.printf("Time needed to complete runWithCompletableFutures() :  %s ms%n" , end - start);
		System.out.println(result);
    }

    public static void main(String[] args)
    {
        runWithoutCompletableFutures();
        runWithCompletableFutures();
    }

}
