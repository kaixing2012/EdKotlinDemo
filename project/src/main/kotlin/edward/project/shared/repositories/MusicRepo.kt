package edward.project.shared.repositories

import edward.project.shared.interfaces.IMusicRepo
import edward.project.shared.models.Music
import org.springframework.stereotype.Repository

@Repository
class MusicRepo : IMusicRepo {
    override fun getMusicList(): Collection<Music> {
        TODO("Not yet implemented")
    }
}

@Repository
class MockMusicRepo : IMusicRepo {

    private val musicList = listOf(
        Music(name = "My Way", type = "blue jazz"),
        Music(name = "Someone like you", type = "love song")
    )

    override fun getMusicList(): Collection<Music> = musicList
}