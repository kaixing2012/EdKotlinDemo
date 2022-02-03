package edward.project.featured.api.v1.auth

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
internal class AuthControllerTest @Autowired constructor(
    var mockMvc: MockMvc
) {
    @Test
    fun `register`() {
        //given

    }
}