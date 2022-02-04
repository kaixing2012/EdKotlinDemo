package edward.project.featured.api.v1.auth


import edward.project.featured.api.v1.auth.models.ReqRegisterJM
import edward.project.featured.api.v1.auth.models.ResRegisterJM
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/auth")
class AuthApiController(
    private val authApiService: AuthApiService
) {
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody reqRegisterJM: ReqRegisterJM): ResRegisterJM =
        this.authApiService.register(reqRegisterJM)
}