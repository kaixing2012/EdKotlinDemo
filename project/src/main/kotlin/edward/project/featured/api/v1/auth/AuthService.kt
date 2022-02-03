package edward.project.featured.api.v1.auth

import edward.project.shared.models.User
import edward.project.shared.repositories.IUserRepo
import org.springframework.stereotype.Service

@Service
class AuthService (
    private val userRepo: IUserRepo
) {
    fun getUsers(): Collection<User> {
        print(this.userRepo.findById(1))

        return this.userRepo.findAll()
    }
}