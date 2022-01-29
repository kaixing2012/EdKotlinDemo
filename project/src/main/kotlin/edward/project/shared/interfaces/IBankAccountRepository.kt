package edward.project.shared.interfaces

import edward.project.shared.models.BankAccount

interface IBankAccountRepository {

    fun getBankAccounts(): Collection<BankAccount>
}