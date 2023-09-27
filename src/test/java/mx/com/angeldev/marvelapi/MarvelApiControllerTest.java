package mx.com.angeldev.marvelapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest()
@WebAppConfiguration
class MarvelApiControllerTest {

MockMvc mockMvc;
	
	private final static String BASE_URL = "/marvel/characters/";
	
	@Autowired
	WebApplicationContext applicationContext;
	
	@BeforeEach
	void setUp() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
		
	}
	
	@Test
	void getAll() throws Exception {
		MvcResult mvc = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		System.out.println(mvc.getResponse().getStatus());
		assertEquals(200, mvc.getResponse().getStatus());
	}
	
	@Test
	void getCharacter() throws Exception {
		MvcResult mvc = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL).queryParam("id", "1011334").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		System.out.println(mvc.getResponse().getStatus());
		assertEquals(200, mvc.getResponse().getStatus());
	}

}
