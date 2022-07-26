package com.fasttrack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class ReadFromFile {

    protected static List<Quote> readingAllQuotes(String filepath) throws IOException {
        List<Quote> result = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
        String line;
        int id = 1;
        while ((line = bufferedReader.readLine()) != null) {
            result.add(fromLine(line, id));
            id++;
        }
        return result;
    }

    protected static Quote fromLine(String line, int id) {
        String[] tokens = line.split(Pattern.quote("~"));
        return new Quote(tokens[0], tokens[1], id);
    }
}