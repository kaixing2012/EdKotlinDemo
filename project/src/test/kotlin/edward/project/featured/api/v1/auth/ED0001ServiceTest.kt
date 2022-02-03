package edward.project.featured.api.v1.auth

import edward.project.shared.repositories.IUserRepo
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class ED0001ServiceTest{
    private val userRepo: IUserRepo = mockk(relaxed = true)
    private val eD0001Service = AuthService(userRepo)

    @Test
    fun `get users`() {
        eD0001Service.getUsers()

        verify(exactly = 1) { userRepo.findAll() }
    }
}