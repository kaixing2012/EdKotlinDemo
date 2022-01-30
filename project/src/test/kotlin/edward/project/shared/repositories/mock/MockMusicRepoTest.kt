package edward.project.shared.repositories.mock

import edward.project.shared.repositories.MockMusicRepo

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockMusicRepoTest {

    private val mockBankAccountRepo = MockMusicRepo()

    @Test
    fun `collection of music should not be empty`() {

        val musicList = this.mockBankAccountRepo.getMusicList()

        assertThat(musicList).isNotEmpty
    }

    @Test
    fun `music name should not be blank`() {

        val musicList = this.mockBankAccountRepo.getMusicList()

        assertThat(musicList).allMatch({ m -> m.name.isNotBlank()}, "all music name have value")
    }
}