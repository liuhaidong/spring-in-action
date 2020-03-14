package com.arkdex.springinaction.collectionmap;

import java.util.*;

public class NavigableMapMain {
    private NavigableMap<Integer, String> mapHttpStatus = new TreeMap<>();

    private void reverseKeyOrder() {


        Set<Integer> ascendingKeys = mapHttpStatus.keySet();

        System.out.println("Ascending Keys: " + ascendingKeys);

        Set<Integer> descendingKeys = mapHttpStatus.descendingKeySet();

        System.out.println("Descending Keys: " + descendingKeys);

    }

    private void initMap() {
        mapHttpStatus.put(100, "Continue");
        mapHttpStatus.put(200, "OK");

        mapHttpStatus.put(400, "Bad Request");
        mapHttpStatus.put(401, "Unauthorized");

        mapHttpStatus.put(500, "Internal Server Error");
        mapHttpStatus.put(501, "Not Implemented");
    }

    private void reverseMap() {
        NavigableMap<Integer, String> descendingMap = mapHttpStatus.descendingMap();

        printMap(descendingMap);
    }

    private void printMap(Map<Integer, String> ma) {
        for (Integer key : ma.keySet()) {
            System.out.println(key + " => " + ma.get(key));
        }
    }

    private void headMap() {
        NavigableMap original = new TreeMap();
        original.put(1, "1");
        original.put(2, "2");
        original.put(3, "3");

        System.out.println("this headmap1 will contain 1 and 2");
        SortedMap headmap1 = original.headMap(3);
        printMap(headmap1);

        System.out.println("this headmap2 will contain 1, 2, and 3 because \"inclusive\"=true");
        NavigableMap headmap2 = original.headMap(3, true);

        printMap(headmap2);
    }

    private void tailMap(){
        SortedMap tailMap = mapHttpStatus.tailMap(400);
        System.out.println("this tailMap will contain >= 400");
        printMap(tailMap);
    }

    private void ceilingEntry(){
        Map.Entry ceilingEntry = mapHttpStatus.ceilingEntry(390);
        System.out.println(ceilingEntry.toString());
    }
    public static void main(String[] args) {
        NavigableMapMain navigableMapMain = new NavigableMapMain();
        navigableMapMain.initMap();
        navigableMapMain.reverseKeyOrder();
        navigableMapMain.reverseMap();
        navigableMapMain.headMap();
        navigableMapMain.tailMap();
        navigableMapMain.ceilingEntry();
    }
}
