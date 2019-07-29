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
public class ExpansionController {

    @Autowired
    private ExpansionFacadeProxy expansionProxy;

    @RequestMapping(value="/expansion", method = RequestMethod.GET)
    public String list() {

        return "expansion/list";
    }

    @RequestMapping(value="/expansion/data", method = RequestMethod.GET)
    public @ResponseBody TablePage<Expansion> listPaged(@RequestParam("draw")int draw, @RequestParam("start")int start, @RequestParam("length")int length) {

        int pageNumber = (start/length) + 1;
        Page<Expansion> expansion = expansionProxy.getexpansion(pageNumber, length);

        TablePage<Expansion> result = new TablePage<Expansion>();
        result.setData(expansion.getContent());
        result.setRecordsTotal(expansion.getTotalElements());
        result.setRecordsFiltered(expansion.getTotalElements());
        result.setDraw(draw);
        return result;
    }

    @RequestMapping(value="/expansion/create", method = RequestMethod.GET)
    public String create() {
        return "expansion/create";
    }

    @RequestMapping(value="/expansion/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id")String id, Model model) {

        Expansion expansion = expansionProxy.getExpansionById(id);
        model.addAttribute("expansion", expansion);
        return "expansion/update";
    }

    @RequestMapping(value="/expansion/create", method = RequestMethod.POST)
    public String create(Expansion expansion) {

        expansionProxy.create(expansion);

        return "redirect:/expansion";
    }

    @RequestMapping(value="/expansion/update", method = RequestMethod.POST)
    public String update(Expansion expansion) {

        expansionProxy.update(expansion);

        return "redirect:/expansion";
    }

    @RequestMapping(value="/expansion/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id")Integer id) {

        expansionProxy.delete(id);

        return "redirect:/expansion";
    }


}
