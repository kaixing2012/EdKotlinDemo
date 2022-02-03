package edward.project.featured.api.v1.ed0001


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/ED0001")
class ED0001Controller(
    private val ed0001Service: ED0001Service
) {

    @GetMapping
    fun getED0001() = this.ed0001Service.getUsers();
}