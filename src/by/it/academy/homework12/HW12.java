package by.it.academy.homework12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HW12 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        getAndPrintSquareOfNumbers();
    }

    public static void getAndPrintSquareOfNumbers() throws ExecutionException, InterruptedException {
        List<Integer> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(7);
        listOfNumbers.add(8);
        listOfNumbers.add(5);
        listOfNumbers.add(2);

        List<CompletableFuture<Integer>> squareOfNumbersFutureList = new ArrayList<>();

        for (int i = 0; i< listOfNumbers.size(); i++) {
            int number = listOfNumbers.get(i);
            CompletableFuture<Integer> squareOfNumbersFuture = CompletableFuture.supplyAsync(() -> number*number);
            squareOfNumbersFutureList.add(squareOfNumbersFuture);
        }

        List<Integer> squareNumbers = new ArrayList<>();

        for (CompletableFuture<Integer> future:squareOfNumbersFutureList){
            squareNumbers.add(future.get());
        }
        System.out.println("Result square of numbers " + squareNumbers);
    }
}
