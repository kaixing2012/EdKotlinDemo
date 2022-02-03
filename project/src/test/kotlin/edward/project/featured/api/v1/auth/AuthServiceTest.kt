package edward.project.featured.api.v1.auth

import edward.project.featured.api.v1.auth.models.ReqRegisterJM
import edward.project.featured.api.v1.auth.models.ResRegisterJM
import edward.project.shared.constants.AuthConstant
import edward.project.shared.models.User
import edward.project.shared.repositories.IUserRepo
import io.mockk.every

import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.Test

import io.mockk.mockk
import io.mockk.verify

internal class AuthServiceTest {
    private val userRepo: IUserRepo = mockk()
    private val authService: AuthService = AuthService(userRepo)

    @Test
    fun `register a new user`() {
        //given
        every { userRepo.save(any()) } returns AuthConstant.USER_TEST_INFO

        val registerJM = ReqRegisterJM(
            firstName = AuthConstant.USER_TEST_INFO.firstName,
            lastName = AuthConstant.USER_TEST_INFO.lastName,
            email = AuthConstant.USER_TEST_INFO.email,
            age = AuthConstant.USER_TEST_INFO.age,
        )

        //when
        val result = authService.register(registerJM)

        //then
        verify(exactly = 1) { userRepo.save(any()) };

        assertThat(registerJM).matches { model -> model.firstName == result.firstName}
        assertThat(registerJM).matches { model -> model.lastName == result.lastName}
        assertThat(registerJM).matches { model -> model.email == result.email}
        assertThat(registerJM).matches { model -> model.age == result.age}
    }
}