package edward.project.shared.repositories

import edward.project.shared.interfaces.IMusicRepo
import edward.project.shared.models.Music
import org.springframework.stereotype.Repository

@Repository
class MusicRepo : IMusicRepo {
    override fun getMusics(): Collection<Music> {
        TODO("Not yet implemented")
    }
}

@Repository
class MockMusicRepo : IMusicRepo {

    private val accounts = listOf(
        Music(acctName = "001", acctType = "saving", acctAlias = "My Saving", availableBalance = 1000.00),
        Music(acctName = "002", acctType = "deposit", acctAlias = "My Deposit", availableBalance = 10000.00)
    )

    override fun getMusics(): Collection<Music> = accounts
}