package com.arkdex.springinaction.collectionmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamToMap {
    public static Map<Integer, Animal> convertList(List<Animal> list) {
        Map<Integer, Animal> map = list.stream()
                .collect(Collectors.toMap(Animal::getId, animal -> animal));
        return map;
    }

    @Test
    public void testConverList(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(1,"cat"));
        animals.add(new Animal(2,"dog"));
        Map<Integer,Animal> animalMap = convertList(animals);
        System.out.println(animalMap.keySet());
    }
}
