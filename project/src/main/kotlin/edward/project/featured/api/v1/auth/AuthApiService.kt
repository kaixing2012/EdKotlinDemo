package edward.project.featured.api.v1.auth

import edward.project.featured.api.v1.auth.models.ReqRegisterJM
import edward.project.featured.api.v1.auth.models.ResRegisterJM
import edward.project.shared.enums.UserRoleEnum
import edward.project.shared.models.User
import edward.project.shared.repositories.IUserRepo

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthApiService (
    private val userRepo: IUserRepo,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(reqRegisterJM: ReqRegisterJM): ResRegisterJM {

        val user = User(
            username = reqRegisterJM.username,
            password = passwordEncoder.encode(reqRegisterJM.password),
            isActive = true,
            roles = "${UserRoleEnum.NON_SUBSCRIBER}"
        )

        val newUser = this.userRepo.save(user)

        return ResRegisterJM(
            username = newUser.username,
            password = newUser.password,
            isActive = newUser.isActive,
            roles = newUser.roles
        )
    }

    fun getUsers(): List<User> {
        return this.userRepo.findAll()
    }
}