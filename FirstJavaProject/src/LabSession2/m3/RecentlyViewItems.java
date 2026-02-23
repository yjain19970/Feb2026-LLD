package LabSession2.m3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import LabSession2.m1.Item;

public class RecentlyViewItems {
    private List<Item> items;
    private Integer MAX_SIZE = 10;

    public RecentlyViewItems() {
        items = new LinkedList<>();
    }

    public void addRecentlyViewedItem(Item item) {
        // remove the item if it is already present so that it can be moved at the front
        items.remove(item);

        items.addFirst(item);
        if(items.size() > MAX_SIZE) {
            // Supported by LinkedList to delete from LAST.
            items.removeLast();
            // remove form the last and remove from the front.
            items.removeFirst();
        }
    }

    public List<Item> getRecentlyViewedItems() {
        return new ArrayList<>(items); // max size always be 10
    }
}
