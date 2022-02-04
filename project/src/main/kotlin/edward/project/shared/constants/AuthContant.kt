package edward.project.shared.constants

import edward.project.shared.enums.UserRoleEnum
import edward.project.shared.models.User
import edward.project.shared.models.UserProfile

class AuthConstant {
    companion object {
        val USER_TEST_INFO = User(
            username = "admin",
            password = "admin123",
            isActive = true,
            roles = "${UserRoleEnum.NON_SUBSCRIBER}"
        )
        val USER_PROFILE_TEST_INFO = UserProfile(
            firstName = "First",
            lastName = "Last",
            email = "test@email.com",
            age = 18,
        )
    }
}