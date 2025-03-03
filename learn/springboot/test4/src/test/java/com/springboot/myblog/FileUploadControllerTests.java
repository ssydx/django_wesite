package com.springboot.myblog;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileUploadControllerTests {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenUploadFile_thenReturnUrl() throws Exception {
        String res = mockMvc.perform(
            MockMvcRequestBuilders.multipart("/file")
                .file(
                    new MockMultipartFile("file", "test.txt",",multipart/form-data","helloupload".getBytes(StandardCharsets.UTF_8))
                )
        ).andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse().getContentAsString();
        assertThat(res).contains("file");
    }
    @Test
    public void uploadFile_AndDownLoadIt() throws Exception {
        String content = "hello upload";
        String downLoadUrl = mockMvc.perform(MockMvcRequestBuilders.multipart("/file").file(new MockMultipartFile("file", "test.txt",",multipart/form-data",content.getBytes(StandardCharsets.UTF_8)))
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        MvcResult downloadResult = mockMvc.perform(MockMvcRequestBuilders.get(downLoadUrl).contentType(MediaType.APPLICATION_OCTET_STREAM)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertThat(downloadResult.getResponse().getContentAsString()).isEqualTo(content);
    }
}
