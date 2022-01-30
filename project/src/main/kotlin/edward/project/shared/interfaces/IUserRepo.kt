package edward.project.shared.interfaces

import edward.project.shared.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository("network")
interface IUserRepo : JpaRepository<User, Long>