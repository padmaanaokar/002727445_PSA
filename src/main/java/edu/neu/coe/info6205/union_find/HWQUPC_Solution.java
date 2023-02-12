package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class HWQUPC_Solution {
   static int union=0;
    public static void main(String[] arg) {
        findConnections(1000, 250, 1500);
    }
    public static void findConnections(int runs, int low, int high) {
        for (int i = low; i <= high; i = i+low) {
            int totalConn = 0;
            for (int j = 0; j < runs; j++) {
                totalConn+=count(i);
            }
            System.out.println("Connection generated for (N) " + i + " sites: " + totalConn/runs);
            System.out.println("Number of Unions required for "+i+" sites are :"+union/runs);
            union=0;
        }
    }

    public static int count(int n) {
        int pairs = 0;
        UF_HWQUPC unionFind = new UF_HWQUPC(n);
        Random r = new Random();
        while(unionFind.components() > 1) {
            int p = r.nextInt(n);
            int q = r.nextInt(n);
            pairs++;
            if (!unionFind.isConnected(p, q)) {
                unionFind.connect(p, q);
                union++;
            }
        }
        return pairs;
    }
}





