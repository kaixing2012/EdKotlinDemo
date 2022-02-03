package edward.project.featured.api.v1.ed0001

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
internal class ED0001ControllerTest(
    @Autowired val mockMvc: MockMvc
){

    lateinit var eD0001Service: ED0001Service

    @Test
    fun getEd0001MV() {

    }
}