package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/workintech")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>(){{
        put(1, new Animal(1, "Cat"));
    }};

    @GetMapping("/animal")
    public Collection<Animal> getAnimals() {

        return animals.values();
    }

    @PostMapping("/animal")
    public void addAnimal(@RequestBody Animal animal) {

        if (!animals.containsKey(animal.getId()))
            animals.put(animal.getId(), animal);
    }

    @GetMapping("/animal/{id}")
    public Animal getAnimal(@PathVariable("id") Integer id) {

        return animals.get(id);
    }

    @PutMapping("/animal/{id}")
    public void updateAnimal(@PathVariable("id") Integer id, @RequestBody Animal animal) {

        animals.put(id, animal);
    }

    @DeleteMapping("/animal/{id}")
    public void deleteAnimal(@PathVariable("id") Integer id) {

        animals.remove(id);
    }
}
