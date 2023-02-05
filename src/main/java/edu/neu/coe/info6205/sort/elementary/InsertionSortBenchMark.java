package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.threesum.*;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.ArrayList;
import java.util.Random;

public class InsertionSortBenchMark {
    public static void main(String[] args) {

        Random r = new Random();
        InsertionSort insertionSort = new InsertionSort();

        for (int n = 200; n <= 3200; n = n * 2) {
            //Insertion sort on Randomly Ordered Array
            ArrayList<Integer> randomArrayLst = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                randomArrayLst.add(r.nextInt(n));
            }
            Integer[] randomIntArray = randomArrayLst.toArray(new Integer[0]);
            Benchmark<Boolean> benchmarkRandomArr = new Benchmark_Timer<>(
                    "Running Insertion sort on :Randomly Ordered Array ", b -> {
                insertionSort.sort(randomIntArray.clone(), 0, randomIntArray.length);
            });
            double randomArrayResult = benchmarkRandomArr.run(true, 10);

            //Insertion sort on Ordered Array
            ArrayList<Integer> orderedArrayList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                orderedArrayList.add(i);
            }
            Integer[] orderedArr = orderedArrayList.toArray(new Integer[0]);
            Benchmark<Boolean> benchmarkOrderedArr = new Benchmark_Timer<>(
                    "Running Insertion sort on :Ordered Array ", b -> {
                insertionSort.sort(orderedArr.clone(), 0, orderedArr.length);
            });
            double orderedArrayResult = benchmarkOrderedArr.run(true, 10);

            //Insertion sort on Reverse Ordered Array
            ArrayList<Integer> reverseArrayList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                reverseArrayList.add(n - i);//reverseList[100-00]= reverseList[100],reverseList[99]
            }
            Integer[] reverseIntArray = reverseArrayList.toArray(new Integer[0]);
            Benchmark<Boolean> benchmarkReverseArr = new Benchmark_Timer<>(
                    "Running Insertion sort on :Reversely Ordered Array", b -> {
                insertionSort.sort(reverseIntArray.clone(), 0, reverseIntArray.length);
            });
            double reversedArrayResult = benchmarkReverseArr.run(true, 10);

            //Insertion sort on Partially Ordered Array
            ArrayList<Integer> partialArrayList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (j > n / 2) {
                    partialArrayList.add(r.nextInt(n));//randomly arranged
                } else {
                    partialArrayList.add(j);//ordered array
                }
            }
            Integer[] partialIntArray = partialArrayList.toArray(new Integer[0]);
            Benchmark<Boolean> benchmarkPartial = new Benchmark_Timer<>(
                    "Running Insertion sort on :Partially Ordered Array", b -> {
                insertionSort.sort(partialIntArray.clone(), 0, partialIntArray.length);
            });
            double partialArrayResult = benchmarkPartial.run(true, 10);

            System.out.println("N is : " + n);
            System.out.println("Random Array takes : " + randomArrayResult+"ms");
            System.out.println("Ordered Array takes : " + orderedArrayResult +"ms");
            System.out.println("Reversed Array takes : " + reversedArrayResult+"ms");
            System.out.println("Partial Array takes : " + partialArrayResult+"ms");
        }
    }

}
