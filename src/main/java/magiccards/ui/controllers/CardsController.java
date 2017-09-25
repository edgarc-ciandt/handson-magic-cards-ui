package magiccards.ui.controllers;

import magiccards.ui.entities.Card;
import magiccards.ui.entities.Page;
import magiccards.ui.entities.TablePage;
import magiccards.ui.proxies.CardsFacadeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CardsController {

    @Autowired
    private CardsFacadeProxy cardsProxy;

    @RequestMapping(value="/cards", method = RequestMethod.GET)
    public String list() {

        return "cards/list";
    }

    @RequestMapping(value="/cards/data", method = RequestMethod.GET)
    public @ResponseBody TablePage<Card> listPaged(@RequestParam("draw")int draw, @RequestParam("start")int start,@RequestParam("length")int length) {

        int pageNumber = (start/length) + 1;
        Page<Card> cards = cardsProxy.getcards(pageNumber, length);

        TablePage<Card> result = new TablePage<Card>();
        result.setData(cards.getContent());
        result.setRecordsTotal(cards.getTotalElements());
        result.setRecordsFiltered(cards.getTotalElements());
        result.setDraw(draw);
        return result;
    }

    @RequestMapping(value="/cards/create", method = RequestMethod.GET)
    public String create() {
        return "cards/create";
    }

    @RequestMapping(value="/cards/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id")String id, Model model) {

        Card card = cardsProxy.getCardById(id);
        model.addAttribute("card", card);
        return "cards/update";
    }

    @RequestMapping(value="/cards/create", method = RequestMethod.POST)
    public String create(Card card) {

        cardsProxy.create(card);

        return "redirect:/cards";
    }

    @RequestMapping(value="/cards/update", method = RequestMethod.POST)
    public String update(Card card) {

        cardsProxy.update(card);

        return "redirect:/cards";
    }

    @RequestMapping(value="/cards/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id")String id) {

        cardsProxy.delete(id);

        return "redirect:/cards";
    }


}
