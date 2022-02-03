package edward.project.shared.repositories

import edward.project.shared.models.UserRole
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IUserRoleRepo : JpaRepository<UserRole, Long>