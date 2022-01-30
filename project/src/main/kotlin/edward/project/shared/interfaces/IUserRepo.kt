package edward.project.shared.interfaces

import edward.project.shared.models.User

interface IUserRepo {

    fun getUser(user: User): User
}