package com.company;

public class Pair implements Comparable
{
    public Integer countRepetition;
    public String word;

    public Pair(String newWord, Integer newNumberRepetition) {
        countRepetition = newNumberRepetition;
        word = newWord;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            String word = (String) obj;
            return this.word.equals(word);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public String toString() {
        return word + " = " + countRepetition.toString();
    }

    @Override
    public int compareTo(Object o) {
        Pair p = (Pair)o;
        if (this.countRepetition == p.countRepetition)
            return this.word.compareTo(p.word);
        return p.countRepetition - this.countRepetition;
    }
}