package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static String[] paths = { "./texts/text11(4729).txt", "./texts/text10(10351).txt", "./texts/text9(20065).txt",
            "./texts/text8(30927).txt", "./texts/text7(41402).txt", "./texts/text6(59935).txt",
            "./texts/text5(50514).txt", "./texts/text4(69803).txt", "./texts/text3(80018).txt",
            "./texts/text2(90430).txt", "./texts/text1(109497).txt" };


    public static void main(String[] args) {
        ArrayListBenchmark benchmark = new ArrayListBenchmark();
        System.out.println(benchmark.doBenchmarkFill(paths[0]));
    }

}
