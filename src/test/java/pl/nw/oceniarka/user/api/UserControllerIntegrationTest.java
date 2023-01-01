package pl.nw.oceniarka.user.api;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.nw.oceniarka.comment.repository.CommentRepository;
import pl.nw.oceniarka.post.repository.PostRepository;
import pl.nw.oceniarka.user.domain.role.Role;
import pl.nw.oceniarka.user.dto.response.UserResponse;
import pl.nw.oceniarka.user.repository.UserRepository;
import pl.nw.oceniarka.user.service.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


//@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean private PostRepository postRepository;
    @MockBean private UserRepository userRepository;
    @MockBean private CommentRepository commentRepository;
    @Autowired private WebApplicationContext webApplicationContext;

    @BeforeEach
    @Disabled
    void setUpMockMvc(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService)).build();
    }

    @Test
    void shouldCreateMockMvc(){
        assertNotNull(mockMvc);
    }

    @Test
    void showAllUsersCorrectTest() throws Exception {

        //given
        List<UserResponse> userResponseList = List.of(new UserResponse(1L, "test", "test", Role.USER, "test"));
        //when
        BDDMockito.when(userService.findAllUsers()).thenReturn(userResponseList);
        //then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].password").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].role").value("USER"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("test"));

    }

    @Test
    void createUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(" { \"email\": \"user1@gmail.com\",\"password\": \"user1\",\"role\": \"USER\",\"username\": \"user2\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void findUser() {

    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }
}