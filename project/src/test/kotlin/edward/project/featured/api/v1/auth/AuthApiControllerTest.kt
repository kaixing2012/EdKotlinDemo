package edward.project.featured.api.v1.auth

import edward.project.shared.constants.AuthConstant

import com.fasterxml.jackson.databind.ObjectMapper

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
                val username = AuthConstant.USER_TEST_INFO.username
                val password = AuthConstant.USER_TEST_INFO.password
                val isActive = AuthConstant.USER_TEST_INFO.isActive
                val roles = AuthConstant.USER_TEST_INFO.roles
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
                        jsonPath("$.username") { value(AuthConstant.USER_TEST_INFO.username) }
                        jsonPath("$.password") { value(AuthConstant.USER_TEST_INFO.password) }
                        jsonPath("$.isActive") { value(AuthConstant.USER_TEST_INFO.isActive) }
                        jsonPath("$.roles") { value(AuthConstant.USER_TEST_INFO.roles) }
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