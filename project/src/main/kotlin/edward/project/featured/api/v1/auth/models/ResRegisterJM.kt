package edward.project.featured.api.v1.auth.models

data class ResRegisterJM (
    val username: String,
    val password: String,
    val isActive: Boolean,
    val roles: String,
)