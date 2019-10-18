package com.company;

import java.io.FileInputStream;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;

public class TreeSetBenchmark extends Benchmark {
    private TreeSet<Pair> treeSet = new TreeSet<>();

    public void fill(FileInputStream inputStream) {
        Scanner sc = new Scanner(inputStream, "UTF-8");
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.length() < 3)
                continue;
            updateOrAdd(word);
        }
    }

    private void updateOrAdd(String word) {
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            Pair p = (Pair)iterator.next();
            if (p.word.equals(word))
            {
                iterator.remove();
                p.countRepetition += 1;
                treeSet.add(p);
                return;
            }
        }
        treeSet.add(new Pair(word, 1));
    }

    public void searchByPrefix(String prefix, boolean print) {
        if (prefix.length() < 3)
        {
            System.out.println("Введите минимум 3 буквы");
            return;
        }
        ArrayList<Pair> sortedResult = new ArrayList<>();

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            Pair p = (Pair)iterator.next();
            if (p.word.startsWith(prefix))
                sortedResult.add(p);
        }

        sortedResult.sort(new SortPair());
        if (print)
        {
            for (Pair p: sortedResult)
                System.out.println(p);
        }
    }
}
