package edward.project.featured.api.v1.ed0001

import edward.project.shared.models.User
import edward.project.shared.repositories.IUserRepo
import org.springframework.stereotype.Service

@Service
class ED0001Service (
    private val userRepo: IUserRepo
) {
    fun getUsers(): Collection<User> {
        print(this.userRepo.findById(1))

        return this.userRepo.findAll()
    }
}