package edward.project.featured.api.v1.ed0001

import edward.project.shared.repositories.MockBankAccountRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/ED0001")
class ED0001Controller {

    private val mockBankAccountRepo = MockBankAccountRepository()

    @GetMapping
    fun getED0001() = mockBankAccountRepo.getBankAccounts()
}