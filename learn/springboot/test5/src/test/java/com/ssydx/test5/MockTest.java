package com.ssydx.test5;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ssydx.test5.dto.AuthorDto;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MockTest {
    // 测试WEB
    @Autowired
    private MockMvc mvc;
    @Test
    public void testIndex() throws Exception {
        var res = mvc.perform(MockMvcRequestBuilders.get(new URI("/"))).andReturn().getModelAndView();
        var m = res.getModel();
        m.remove("org.springframework.validation.BindingResult.author");
        assertThat(m).containsExactlyInAnyOrderEntriesOf(Map.of("name","ssydx","author", new AuthorDto().setName("十三月的雪")));
        Assertions.assertEquals(res.getViewName(), "index");
    }
    @ParameterizedTest
    @CsvSource({"张三, 12","李四, 34"})
    public void testAddAuthor(String name, Byte age) throws Exception {
        var res = mvc.perform(MockMvcRequestBuilders
            .post(new URI("/addAuthor"))
            .param("name", name)
            .param("age", age.toString()))
            .andReturn().getModelAndView();
        Assertions.assertEquals("redirect:listAuthor", res.getViewName());
    }
    @ParameterizedTest
    @ValueSource(longs = {10, 20})
    public void testDeleteAuthor(Long id) throws Exception {
        var r = mvc.perform(MockMvcRequestBuilders.delete("/listAuthor/{0}", id)).andReturn().getModelAndView();
        Assertions.assertEquals("redirect:listAuthor",r.getViewName());
    }
}
