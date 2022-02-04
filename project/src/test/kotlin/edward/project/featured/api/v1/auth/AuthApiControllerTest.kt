package edward.project.featured.api.v1.auth

import com.fasterxml.jackson.databind.ObjectMapper
import edward.project.featured.api.v1.auth.models.ReqRegisterJM
import edward.project.shared.constants.AuthConstant

import org.junit.jupiter.api.*

import org.springframework.test.web.servlet.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType


@SpringBootTest
@AutoConfigureMockMvc
internal class AuthApiControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {
    val baseUrl = "/api/v1"

    @Nested
    @DisplayName("POST /api/v1/auth/register")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class AuthPostMethod {

        private val baseAuthUrl = "$baseUrl/auth"

        @Test
        fun `GOOD REQUEST on User Registration`() {
            // given
            val newUser =  object {
                val firstName = AuthConstant.USER_TEST_INFO.firstName
                val lastName = AuthConstant.USER_TEST_INFO.lastName
                val email = AuthConstant.USER_TEST_INFO.email
                val age = AuthConstant.USER_TEST_INFO.age
            }

            // when
            val postRes = mockMvc
                .post("$baseAuthUrl/register") {
                    contentType = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(newUser)
                }

            // then
            postRes
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        jsonPath("$.firstName") { value(AuthConstant.USER_TEST_INFO.firstName) }
                        jsonPath("$.lastName") { value(AuthConstant.USER_TEST_INFO.lastName) }
                        jsonPath("$.email") { value(AuthConstant.USER_TEST_INFO.email) }
                        jsonPath("$.age") { value(AuthConstant.USER_TEST_INFO.age) }
                        jsonPath("$.isActive") { value(AuthConstant.USER_TEST_INFO.isActive) }
//                        jsonPath("$.roles") { value(AuthConstant.USER_TEST_INFO.roles) }
                    }
                }
        }

        @Test
        fun `BAD REQUEST on User Registration`() {
            // given
            val invalidUser = object {
                val firstName = "Invalid Test"
            }

            // when
            val performPost = mockMvc.post("$baseAuthUrl/register") {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(invalidUser)
            }

            // then
            performPost
                .andDo { print() }
                .andExpect { status { isBadRequest() } }
        }
    }
}