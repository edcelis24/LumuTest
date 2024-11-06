package co.com.certification.wordcounter.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WordCount implements Comparable<WordCount> {
    private String word;
    private int count;
    public WordCount(String word) {
        this.word = word;
        this.count = 1;
    }
    public void incrementCount() {
        this.count++;
    }

    @Override
    public int compareTo(WordCount other) {
        return Integer.compare(other.count, this.count);
    }
}
