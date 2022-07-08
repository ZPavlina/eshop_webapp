package cz.czechitas.webapp;

import java.util.*;
import javax.swing.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;


@Repository
public class InMemoryRepositoryEshop  implements EshopRepository{


    private Long sequence = 1000L;
    private List<Item> ListOfItem = new ArrayList<>(Arrays.asList(
            new Item(sequence++, "Jablko", 16.90, "odrůda Grany Smith"),
            new Item(sequence++, "Rohlík", 6.90, "pekárna Hradec Králové"),
            new Item(sequence++, "Jogurt bílý", 18.90, "mlékárna Milko"),
            new Item(sequence++, "Párek krůtí", 35.90, "cena za 100g, výrábí Naše farma"),
            new Item(sequence++, "Mléko", 23.90, "mlékárna Milko"),
            new Item(sequence++, "Vejce", 4.90, "vejce z podestýlky")
    ));


    @Override
    public synchronized List<Item> findAll() {
        List<Item> copyOfListOfItem = new ArrayList<>(ListOfItem.size());
        for (Item item : ListOfItem) {
            copyOfListOfItem.add(clone(item));
        }
        return copyOfListOfItem;
    }

    public List<Item> getListOfItem() {
        return ListOfItem;
    }

    public void setListOfItem(List<Item> newValue) {
        ListOfItem = newValue;
    }

    public Item getItemViaNumber(Long number) {
        int index = getIdViaNumber(number);
        if(index == -1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        return clone(ListOfItem.get(index));
    }

    public int getIdViaNumber(Long number) {
        for (int i = 0; i < ListOfItem.size() ; i++) {
            Item item = ListOfItem.get(i);
            if (item.getNumber().equals(number)) {
                return i;
            }

        }  return -1;
    }

    private Item clone(Item originItem) {
        return new Item(
                originItem.getNumber(),
                originItem.getName(),
                originItem.getPrice(),
                originItem.getDescription());
    }
}
