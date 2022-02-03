package edward.project.shared.constants

import edward.project.shared.enums.UserRoleEnum
import edward.project.shared.models.User

class AuthConstant {
    companion object {
        val USER_TEST_INFO = User(
            firstName = "First",
            lastName = "Last",
            email = "test@email.com",
            age = 18,
            isActive = true,
            roles = listOf(UserRoleEnum.NON_SUBSCRIBER)
        )
    }
}