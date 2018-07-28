package magiccards.ui.proxies;

import magiccards.ui.entities.Expansion;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(url= "${rest.client.cards.url:default}/expansions", name="expansions")
public interface ExpansionFacadeProxy extends CrudMapping<Expansion, Integer>{

}