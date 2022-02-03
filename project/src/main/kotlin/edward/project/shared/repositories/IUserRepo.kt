package edward.project.shared.repositories

import edward.project.shared.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserRepo : JpaRepository<User, Long>