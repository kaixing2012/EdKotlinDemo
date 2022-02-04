package edward.project.featured.api.v1.auth

import edward.project.featured.api.v1.auth.models.ReqRegisterJM
import edward.project.shared.constants.AuthConstant
import edward.project.shared.repositories.IUserRepo

import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.Test

import io.mockk.mockk
import io.mockk.verify
import io.mockk.every
import org.springframework.security.crypto.password.PasswordEncoder

internal class AuthApiServiceTest {
    private val passwordEncoder: PasswordEncoder = mockk()
    private val userRepo: IUserRepo = mockk()
    private val authApiService: AuthApiService = AuthApiService(userRepo, passwordEncoder)

    @Test
    fun `Register a New User`() {
        //given
        every { userRepo.save(any()) } returns AuthConstant.USER_TEST_INFO

        val registerJM = ReqRegisterJM(
            username = AuthConstant.USER_TEST_INFO.username,
            password = AuthConstant.USER_TEST_INFO.password,
        )

        //when
        val result = authApiService.register(registerJM)

        //then
        verify(exactly = 1) { userRepo.save(any()) };

        assertThat(registerJM).matches { model -> model.username == result.username}
        assertThat(registerJM).matches { model -> model.password == result.password}
    }
}