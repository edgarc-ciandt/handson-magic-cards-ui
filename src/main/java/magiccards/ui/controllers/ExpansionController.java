package magiccards.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import magiccards.ui.entities.Expansion;
import magiccards.ui.entities.Page;
import magiccards.ui.entities.TablePage;
import magiccards.ui.proxies.ExpansionFacadeProxy;

@Controller
public class ExpansionController {

	@Autowired
	private ExpansionFacadeProxy expansionProxy;

	@RequestMapping(value = "/expansions", method = RequestMethod.GET)
	public String list() {

		return "expansions/list";
	}

	@RequestMapping(value = "/expansions/data", method = RequestMethod.GET)
	public @ResponseBody TablePage<Expansion> listPaged(@RequestParam("draw") int draw,
			@RequestParam("start") int start, @RequestParam("length") int length) {

		int pageNumber = (start / length) + 1;
		Page<Expansion> expansion = expansionProxy.getexpansions(pageNumber, length);

		TablePage<Expansion> result = new TablePage<Expansion>();
		result.setData(expansion.getContent());
		result.setRecordsTotal(expansion.getTotalElements());
		result.setRecordsFiltered(expansion.getTotalElements());
		result.setDraw(draw);
		return result;
	}

	@RequestMapping(value = "/expansions/create", method = RequestMethod.GET)
	public String create() {
		return "expansions/create";
	}

	@RequestMapping(value = "/expansions/update/{expansionId}", method = RequestMethod.GET)
	public String update(@PathVariable("expansionId") Integer expansionId, Model model) {

		Expansion expansion = expansionProxy.getExpansionById(expansionId);
		model.addAttribute("expansion", expansion);
		return "expansions/update";
	}

	@RequestMapping(value = "/expansions/create", method = RequestMethod.POST)
	public String create(Expansion expansion) {

		expansionProxy.create(expansion);

		return "redirect:/expansions";
	}

	@RequestMapping(value = "/expansions/update", method = RequestMethod.POST)
	public String update(Expansion expansion) {

		expansionProxy.update(expansion);

		return "redirect:/expansions";
	}

	@RequestMapping(value = "/expansions/delete/{expansionId}", method = RequestMethod.GET)
	public String delete(@PathVariable("expansionId") Integer expansionId) {

		expansionProxy.delete(expansionId);

		return "redirect:/expansions";
	}

}
