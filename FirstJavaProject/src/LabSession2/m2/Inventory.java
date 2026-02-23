package LabSession2.m2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import LabSession2.m1.Item;

public class Inventory<T extends Item> {
    private Map<String, T> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void add(T item) throws RuntimeException {
        if(item.getQuantity() < 0){
            throw new RuntimeException("Quantity is less than equal to zero which is invalid");
        }
        if(items.containsKey(item.getId())) {
            throw new RuntimeException("Item " + item.getId() + " already exists");
        }
        items.put(item.getId(), item);
    }

    public void remove(T item) {
        items.remove(item.getId());
    }

    public T get(String id) {
        return items.get(id);
    }

    public List<T> getAll() {
        return new ArrayList<>(items.values());
    }
}
