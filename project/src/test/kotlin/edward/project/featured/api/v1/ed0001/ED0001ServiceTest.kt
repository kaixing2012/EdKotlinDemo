package edward.project.featured.api.v1.ed0001

import edward.project.shared.repositories.IUserRepo
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ED0001ServiceTest{
    private val userRepo: IUserRepo = mockk(relaxed = true)
    private val eD0001Service = ED0001Service(userRepo)

    @Test
    fun `get users`() {
        eD0001Service.getUsers()

        verify(exactly = 1) { userRepo.findAll() }
    }
}