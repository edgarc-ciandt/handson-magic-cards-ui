package magiccards.ui.controllers;

import magiccards.ui.entities.Expansion;
import magiccards.ui.entities.Page;
import magiccards.ui.entities.TablePage;
import magiccards.ui.proxies.ExpansionFacadeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExpansionsController {

    @Autowired
    private ExpansionFacadeProxy expansionProxy;

    @RequestMapping(value="/expansions", method = RequestMethod.GET)
    public String list() {
        return "expansions/list";
    }

    @RequestMapping(value="/expansions/data", method = RequestMethod.GET)
    public @ResponseBody TablePage<Expansion> listPaged(@RequestParam("draw")int draw, @RequestParam("start")int start,@RequestParam("length")int length) {

        int pageNumber = (start/length);
        Page<Expansion> cards = expansionProxy.getPage(pageNumber, length);

        return TablePage.<Expansion>builder()
                .data(cards.getContent())
                .recordsTotal(cards.getTotalElements())
                .recordsFiltered(cards.getTotalElements())
                .draw(draw)
                .build();
    }

    @RequestMapping(value="/expansions/create", method = RequestMethod.GET)
    public String create() {
        return "expansions/create";
    }

    @RequestMapping(value="/expansions/create", method = RequestMethod.POST)
    public String create(Expansion entity) {

        expansionProxy.create(entity);

        return "redirect:/expansions";
    }

    @RequestMapping(value="/expansions/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("entity",  expansionProxy.getEntityById(id));
        return "expansions/update";
    }

    @RequestMapping(value="/expansions/update", method = RequestMethod.POST)
    public String update(Expansion entity) {

        expansionProxy.update(entity);

        return "redirect:/expansions";
    }

    @RequestMapping(value="/expansions/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {

        expansionProxy.delete(id);

        return "redirect:/expansions";
    }


}
