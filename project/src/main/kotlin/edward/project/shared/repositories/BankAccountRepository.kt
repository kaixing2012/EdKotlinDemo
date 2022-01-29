package edward.project.shared.repositories

import edward.project.shared.interfaces.IBankAccountRepository
import edward.project.shared.models.BankAccount
import org.springframework.stereotype.Repository

@Repository
class BankAccountRepository : IBankAccountRepository {
    override fun getBankAccounts(): Collection<BankAccount> {
        TODO("Not yet implemented")
    }
}

@Repository
class MockBankAccountRepository : IBankAccountRepository {

    private val accounts = listOf(
        BankAccount(acctName = "001", acctType = "saving", acctAlias = "My Saving", availableBalance = 1000.00),
        BankAccount(acctName = "002", acctType = "deposit", acctAlias = "My Deposit", availableBalance = 10000.00)
    )

    override fun getBankAccounts(): Collection<BankAccount> = accounts
}