package edward.project.featured.api.v1.auth.models

import edward.project.shared.enums.UserRoleEnum

data class ResRegisterJM (
    val username: String,
    val password: String,
    val isActive: Boolean,
    val roles: List<UserRoleEnum>
)