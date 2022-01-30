package edward.project.shared.repositories

import edward.project.shared.interfaces.IUserRepo
import edward.project.shared.models.User
import org.springframework.stereotype.Repository

@Repository("network")
abstract class UserRepo : IUserRepo { }

@Repository("mock")
abstract class MockUserRepo : IUserRepo {
    val userList: Collection<User> = listOf(
        User(firstName = "Edward", lastName = "Rogers", email = "edward@email.com", role="subscriber", age = 34),
        User(firstName = "Naomi", lastName = "Watson", email = "naomid@email.com", role="non-subscriber", age = 34)
    )
}