package edward.project.featured.api.v1.auth

import edward.project.featured.api.v1.auth.models.ReqRegisterJM
import edward.project.shared.constants.AuthConstant
import edward.project.shared.repositories.IUserRepo

import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.Test

import io.mockk.mockk
import io.mockk.verify
import io.mockk.every

internal class AuthApiServiceTest {
    private val userRepo: IUserRepo = mockk()
    private val authApiService: AuthApiService = AuthApiService(userRepo)

    @Test
    fun `Register a New User`() {
        //given
        every { userRepo.save(any()) } returns AuthConstant.USER_TEST_INFO

        val registerJM = ReqRegisterJM(
            firstName = AuthConstant.USER_TEST_INFO.firstName,
            lastName = AuthConstant.USER_TEST_INFO.lastName,
            email = AuthConstant.USER_TEST_INFO.email,
            age = AuthConstant.USER_TEST_INFO.age,
        )

        //when
        val result = authApiService.register(registerJM)

        //then
        verify(exactly = 1) { userRepo.save(any()) };

        assertThat(registerJM).matches { model -> model.firstName == result.firstName}
        assertThat(registerJM).matches { model -> model.lastName == result.lastName}
        assertThat(registerJM).matches { model -> model.email == result.email}
        assertThat(registerJM).matches { model -> model.age == result.age}
    }
}