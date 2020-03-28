package com.arkdex.springinaction.disruptorqueue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamToMap {
    public static Map<Integer, Animal> convertListId(List<Animal> list) {
        Map<Integer, Animal> map = list.stream()
                .collect(Collectors.toMap(Animal::getId, animal -> animal));
        return map;
    }

    public static Map<Integer, Animal> convertListAge(List<Animal> list) {
        Map<Integer, Animal> map = list.stream()
                .collect(Collectors.toMap(Animal::getAge, animal -> animal));
        return map;
    }

    @Test
    public void testConverList(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(1,3,"cat"));
        animals.add(new Animal(2,5,"dog"));
        Map<Integer,Animal> animalIdMap = convertListId(animals);
        animalIdMap.put(1,new Animal(1,9,"pig"));
        System.out.println(animalIdMap.keySet());
        Animal animal = animalIdMap.get(1);
        System.out.println(animal.getName());
    }
}
