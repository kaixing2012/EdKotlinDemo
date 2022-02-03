package edward.project.featured.api.v1.auth

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
internal class AuthControllerTest(
    @Autowired val mockMvc: MockMvc
){

    lateinit var eD0001Service: AuthService

    @Test
    fun getEd0001MV() {

    }
}