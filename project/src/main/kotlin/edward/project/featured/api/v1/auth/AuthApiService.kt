package edward.project.featured.api.v1.auth

import edward.project.featured.api.v1.auth.models.ReqRegisterJM
import edward.project.featured.api.v1.auth.models.ResRegisterJM
import edward.project.shared.enums.UserRoleEnum
import edward.project.shared.models.User
import edward.project.shared.repositories.IUserRepo
import org.springframework.stereotype.Service

@Service
class AuthApiService (
    private val userRepo: IUserRepo
) {
    fun register(reqRegisterJM: ReqRegisterJM): ResRegisterJM {

        val user = User(
            username = reqRegisterJM.username,
            password = reqRegisterJM.password,
            isActive = true,
            roles = listOf(
                UserRoleEnum.NON_SUBSCRIBER
            )
        )

        val newUser = this.userRepo.save(user)

        return ResRegisterJM(
            username = newUser.username,
            password = newUser.password,
            isActive = newUser.isActive,
            roles = newUser.roles
        )
    }
}