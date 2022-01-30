package edward.project.shared.repositories

import edward.project.shared.interfaces.IUserRepo
import edward.project.shared.models.User

class UserRepo : IUserRepo {
    override fun getUser(user: User): User {
        TODO("Not yet implemented")
    }
}