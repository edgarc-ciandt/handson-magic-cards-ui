package com.tcgplacecards.ui.proxies;

import com.tcgplacecards.ui.entities.Expansion;
import com.tcgplacecards.ui.entities.Page;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(url= "${rest.client.cards.url:default}/expansions", name="expansions")
public interface ExpansionsFacadeProxy {

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    Expansion getExpansionById(@PathVariable("id") String gathererId);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    Page<Expansion> getExpansions(@RequestParam(value = "page") int pageNumber, @RequestParam(value = "size") int size);

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    void create(Expansion expansion);

    @RequestMapping(value = "", method = RequestMethod.PUT)
    void update(Expansion expansion);

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") String id);
}