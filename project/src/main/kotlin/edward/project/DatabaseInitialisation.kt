package edward.project

import edward.project.shared.enums.UserRoleEnum
import edward.project.shared.models.User
import edward.project.shared.repositories.IUserRepo

import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class DatabaseInitialisation(
    private val userRepo: IUserRepo,
    private val passwordEncoder: PasswordEncoder
): CommandLineRunner {

    override fun run(vararg args: String?) {
        userRepo.deleteAll()

        val userList = listOf(
            User(username = "admin", password = passwordEncoder.encode("admin123"), isActive = true, roles = "${UserRoleEnum.ADMIN}"),
            User(username = "edward", password = passwordEncoder.encode("edward123"), isActive = true, roles = "${UserRoleEnum.NON_SUBSCRIBER}"),
            User(username = "sonia", password = passwordEncoder.encode("sonia123"), isActive = true, roles = "${UserRoleEnum.SUBSCRIBER}"),
        )

        userRepo.saveAll(userList)
    }
}