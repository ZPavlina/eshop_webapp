package cz.czechitas.webapp;

import java.util.*;

public interface EshopRepository {

        List<Item> findAll();

        Item getItemViaNumber(Long number);

        int getIdViaNumber(Long number);




}
