package edward.project.featured.api.v1.auth.models

import edward.project.shared.enums.UserRoleEnum

data class ResRegisterJM (
    val firstName: String,
    val lastName: String,
    val email: String,
    val age: Int,
    val isActive: Boolean,
    val roles: List<UserRoleEnum>
)