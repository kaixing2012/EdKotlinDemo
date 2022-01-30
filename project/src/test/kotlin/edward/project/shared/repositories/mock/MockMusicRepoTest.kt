package edward.project.shared.repositories.mock

import edward.project.shared.repositories.MockMusicRepo

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockMusicRepoTest {

    private val mockBankAccountRepo = MockMusicRepo()

    @Test
    fun `collection of bank account should not be empty`() {

        val musics = this.mockBankAccountRepo.getMusics()

        assertThat(musics).isNotEmpty
    }

    @Test
    fun `account name should not be blank`() {

        val musics = this.mockBankAccountRepo.getMusics()

        assertThat(musics).allMatch({ acct -> acct.acctName.isNotBlank() }, "all account name have value")
    }
}