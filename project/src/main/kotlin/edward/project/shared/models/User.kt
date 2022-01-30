package edward.project.shared.models

data class User(
    val id: String,
    val name: String,
    val nickName: String,
    var age: Int,
    val role: String,
)
