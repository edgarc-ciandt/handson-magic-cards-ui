package magiccards.ui.controllers;

import magiccards.ui.entities.Expansion;
import magiccards.ui.entities.Page;
import magiccards.ui.entities.TablePage;
import magiccards.ui.proxies.ExpansionsFacadeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExpansionsController {

    @Autowired
    private ExpansionsFacadeProxy expansionsProxy;

    @RequestMapping(value="/expansions", method = RequestMethod.GET)
    public String list() {

        return "expansions/list";
    }

    @RequestMapping(value="/expansions/data", method = RequestMethod.GET)
    public @ResponseBody TablePage<Expansion> listPaged(@RequestParam("draw")int draw, @RequestParam("start")int start, @RequestParam("length")int length) {

        int pageNumber = (start/length) + 1;
        Page<Expansion> expansions = expansionsProxy.getexpansion(pageNumber, length);

        TablePage<Expansion> result = new TablePage<>();
        result.setData(expansions.getContent());
        result.setRecordsTotal(expansions.getTotalElements());
        result.setRecordsFiltered(expansions.getTotalElements());
        result.setDraw(draw);
        return result;
    }

    @RequestMapping(value="/expansions/create", method = RequestMethod.GET)
    public String create() {
        return "expansions/create";
    }

    @RequestMapping(value="/expansions/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id")Integer id, Model model) {

        Expansion expansion = expansionsProxy.getExpansionById(id);
        model.addAttribute("expansion", expansion);
        return "expansions/update";
    }

    @RequestMapping(value="/expansions/create", method = RequestMethod.POST)
    public String create(Expansion expansion) {

        expansionsProxy.create(expansion);

        return "redirect:/expansions";
    }

    @RequestMapping(value="/expansions/update", method = RequestMethod.POST)
    public String update(Expansion expansion) {

        expansionsProxy.update(expansion);

        return "redirect:/expansions";
    }

    @RequestMapping(value="/expansions/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id")Integer id) {

        expansionsProxy.delete(id);

        return "redirect:/expansions";
    }


}
