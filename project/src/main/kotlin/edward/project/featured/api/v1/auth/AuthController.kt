package edward.project.featured.api.v1.auth


import edward.project.featured.api.v1.auth.models.ReqRegisterJM
import edward.project.featured.api.v1.auth.models.ResRegisterJM
import edward.project.shared.models.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody reqRegisterJM: ReqRegisterJM): ResRegisterJM =
        this.authService.register(reqRegisterJM)
}