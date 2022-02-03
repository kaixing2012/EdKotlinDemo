package edward.project.featured.api.v1.auth


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/ED0001")
class AuthController(
    private val authService: AuthService
) {

    @GetMapping
    fun getED0001() = this.authService.getUsers();
}