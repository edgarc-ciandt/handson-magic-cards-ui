package magiccards.ui.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import magiccards.ui.entities.Expansion;
import magiccards.ui.entities.Page;
import magiccards.ui.proxies.ExpansionFacadeProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ExpansionsController.class)
public class ExpansionsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ExpansionFacadeProxy expansionProxy;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void shouldReturnListView() throws Exception {
        mockMvc.perform(get("/expansions"))
                .andExpect(status().isOk())
                .andExpect(view().name("expansions/list"));
    }

    @Test
    public void shouldReturnTheTableData() throws Exception {
        when(expansionProxy.getPage(0 , 10))
                .thenReturn(
                        Page.<Expansion>builder()
                                .content(Collections.EMPTY_LIST)
                                .numberOfElements(0)
                        .build()
                );

        mockMvc.perform(get("/expansions/data")
                .param("draw", "0")
                .param("start", "0")
                .param("length", "10"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("data").isArray())
                .andExpect(jsonPath("recordsTotal").value(0))
                .andExpect(jsonPath("recordsFiltered").value(0))
                .andExpect(jsonPath("draw").value(0));
        verify(expansionProxy).getPage(0 , 10);
    }

    @Test
    public void shouldReturnCreatePage() throws Exception {
        mockMvc.perform(get("/expansions/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("expansions/create"));
    }

    @Test
    public void shouldCallCreateAndRedirect() throws Exception {
        ArgumentCaptor<Expansion> captor = ArgumentCaptor.forClass(Expansion.class);

        mockMvc.perform(post("/expansions/create")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("expansionId", "1")
                .param("name", "TestName")
                .param("expansionCategoryId", "1")
                .param("launchDate", "2018-08-01"))
                .andExpect(view().name("redirect:/expansions"));
        verify(expansionProxy).create(captor.capture());
        Expansion value = captor.getValue();
        assertThat(value).isNotNull();
        assertThat(value.getExpansionId()).isEqualTo(1);
        assertThat(value.getName()).isEqualTo("TestName");
        assertThat(value.getPortugueseName()).isNull();
        assertThat(value.getLinkName()).isNull();
        assertThat(value.getLaunchDate()).hasDayOfMonth(1);
        assertThat(value.getLaunchDate()).hasMonth(8);
        assertThat(value.getLaunchDate()).hasYear(2018);
        assertThat(value.getExpansionCategoryId()).isEqualTo(1);
        assertThat(value.isPromo()).isFalse();
        assertThat(value.isLegal()).isFalse();
    }

    @Test
    public void shouldReturnTheUpdatePageWithTheLoadedExpansion() throws Exception {
        int id = 1;
        Expansion expansion = new Expansion();
        when(expansionProxy.getEntityById(id)).thenReturn(expansion);

        mockMvc.perform(get("/expansions/update/" + id))
                .andExpect(status().isOk())
                .andExpect(view().name("expansions/update"))
                .andExpect(model().attribute("entity", expansion));
    }

    @Test
    public void shouldUpdateTheExpansionAndRedirect() throws Exception {
        ArgumentCaptor<Expansion> captor = ArgumentCaptor.forClass(Expansion.class);

        mockMvc.perform(post("/expansions/update")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("expansionId", "1")
                .param("name", "TestName")
                .param("expansionCategoryId", "1")
                .param("launchDate", "2018-08-01"))
                .andExpect(view().name("redirect:/expansions"));
        verify(expansionProxy).update(captor.capture());
        Expansion value = captor.getValue();
        assertThat(value).isNotNull();
        assertThat(value.getExpansionId()).isEqualTo(1);
        assertThat(value.getName()).isEqualTo("TestName");
        assertThat(value.getPortugueseName()).isNull();
        assertThat(value.getLinkName()).isNull();
        assertThat(value.getLaunchDate()).hasDayOfMonth(1);
        assertThat(value.getLaunchDate()).hasMonth(8);
        assertThat(value.getLaunchDate()).hasYear(2018);
        assertThat(value.getExpansionCategoryId()).isEqualTo(1);
        assertThat(value.isPromo()).isFalse();
        assertThat(value.isLegal()).isFalse();
    }

    @Test
    public void shouldDeleteAndRedirectToListPage() throws Exception {
        int id = 1;

        mockMvc.perform(get("/expansions/delete/" + id))
                .andExpect(view().name("redirect:/expansions"));
        verify(expansionProxy).delete(id);
    }

}
