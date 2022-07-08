package cz.czechitas.webapp;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    private EshopRepository repository;

    public HlavniController(EshopRepository repository) {
        this.repository = repository;
    }

//
//    @RequestMapping("/")
//    public ModelAndView showIndex() {
//        return new ModelAndView("redirect:/eshop/");
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showEshop() {
        ModelAndView dataHolder = new ModelAndView("eshop");
        List<Item> items = repository.findAll();
        dataHolder.addObject("ListOfItem", items);
        return dataHolder;

    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView showCart() {
        ModelAndView dataHolder = new ModelAndView("cart");
        return  dataHolder;
    }

    //show detail of item

    @RequestMapping(value = "/detail/{number}", method = RequestMethod.GET)
    public ModelAndView showDetail(@PathVariable("number") Long number) {
        ModelAndView dataholder = new ModelAndView("detail");
        dataholder.addObject("ListOfItem", repository.getItemViaNumber(number));
        return dataholder;
    }

//    @RequestMapping (value = "/detail/", method = RequestMethod.GET)
//    public ModelAndView backToEshop() {
//        return new ModelAndView("eshop");
//    }








}
