package com.example.vibejava;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class VibeJavaApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void homePageLoads() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("home"));
	}

	@Test
	void aboutPageLoads() throws Exception {
		mockMvc.perform(get("/about"))
				.andExpect(status().isOk())
				.andExpect(view().name("about"));
	}

	@Test
	void contactPageLoads() throws Exception {
		mockMvc.perform(get("/contact"))
				.andExpect(status().isOk())
				.andExpect(view().name("contact"));
	}

	@Test
	void fibPageLoads() throws Exception {
		mockMvc.perform(get("/fib"))
				.andExpect(status().isOk())
				.andExpect(view().name("fib"));
	}

	@Test
	void fibApiReturnsValue() throws Exception {
		mockMvc.perform(get("/api/fib").param("n", "10"))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith("application/json"))
				.andExpect(jsonPath("$.n").value(10))
				.andExpect(jsonPath("$.value").value(55));
	}

	@Test
	void fibApiRejectsOutOfRangeInput() throws Exception {
		mockMvc.perform(get("/api/fib").param("n", "93"))
				.andExpect(status().isBadRequest())
				.andExpect(content().contentTypeCompatibleWith("application/json"))
				.andExpect(jsonPath("$.error").value("n must be between 0 and 92"));
	}

}
