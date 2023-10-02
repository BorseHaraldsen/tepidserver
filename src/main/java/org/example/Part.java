package org.example;

import java.util.ArrayList;
import java.util.List;

public class Part {

    public static ArrayList<String> parts = new ArrayList<>();

    public static List<String> getParts() {
        return parts;
    }

    public static void addParts (String part) {
        parts.add(part);
    }

}
