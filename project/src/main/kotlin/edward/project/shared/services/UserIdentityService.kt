package edward.project.shared.services

import edward.project.shared.classes.UserIdentity
import edward.project.shared.repositories.IUserRepo

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserIdentityService(
    private val userRepo: IUserRepo
) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepo.findByUsername(username)

        return UserIdentity(user)
    }
}