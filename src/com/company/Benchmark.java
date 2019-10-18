package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.stream.LongStream;

public abstract class Benchmark {
    public abstract void fill(FileInputStream inputStream);
    public abstract void searchByPrefix(String prefix, boolean print);

    public long doBenchmarkFill(String path) {
        long[] results = new long[100];
        for (int i = 0; i < 100; i++)
        {
            long start = System.currentTimeMillis();
            fill(getFileInputStream(path));
            long finish = System.currentTimeMillis();
            results[i] = finish - start;
        }
        return (LongStream.of(results).sum());
    }

    private static FileInputStream getFileInputStream(String path) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException ex) {
            return null;
        }
        return inputStream;
    }

    public long doBenchmarkSearchByPrefix(String prefix)
    {
        long[] results = new long[100];
        for (int i = 0; i < 100; i++)
        {
            long start = System.currentTimeMillis();
            searchByPrefix(prefix, false);
            long finish = System.currentTimeMillis();
            results[i] = finish - start;
        }
        return (LongStream.of(results).sum());
    }
}
