package edward.project.shared.repositories.network

import edward.project.shared.constants.AuthConstant
import edward.project.shared.repositories.IUserRepo

import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class UserRepoTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepo: IUserRepo
) {
    @Test
    fun `insert user`() {
        val userInserted = this.userRepo.save(AuthConstant.USER_TEST_INFO)

        assertThat(userInserted).matches { user -> user == userInserted }
    }
}