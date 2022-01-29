package edward.project.shared.repositories.mock

import edward.project.shared.repositories.MockBankAccountRepository

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockBankAccountRepositoryTest {

    private val mockBankAccountRepo = MockBankAccountRepository()

    @Test
    fun `collection of bank account should not be empty`() {

        val accounts = this.mockBankAccountRepo.getBankAccounts()

        assertThat(accounts).isNotEmpty
    }

    @Test
    fun `account name should not be blank`() {

        val accounts = this.mockBankAccountRepo.getBankAccounts()

        assertThat(accounts).allMatch({ acct -> acct.acctName.isNotBlank() }, "all account name have value")
    }
}