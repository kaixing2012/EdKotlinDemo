package edward.project.shared.repositories.network

import edward.project.shared.models.User
import edward.project.shared.repositories.IUserRepo
import edward.project.shared.repositories.IUserRoleRepo

import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class UserRepoTest() {

    @Autowired(required=true)
    lateinit var entityManager: TestEntityManager

    @Autowired(required=true)
    lateinit var userRepo: IUserRepo;

    @Autowired(required=true)
    lateinit var userRoleRepo: IUserRoleRepo;

    var user = User(
        firstName = "Edward",
        lastName = "Rogers",
        email = "edward@email.com",
        roles = userRoleRepo.findAll(),
        age = 34
    )

    @BeforeEach
    @Test
    fun `insert user`() {
        val userInserted = this.userRepo.save(user)

        assertThat(userInserted).matches { u -> u.firstName == user.firstName }

        user = userInserted
    }

    @Test
    fun `find all user`() {

        val userFound = this.userRepo.getById(user.id)

        assertThat(userFound).matches { u -> u.id == user.id }
    }
}