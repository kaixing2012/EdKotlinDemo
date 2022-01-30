package edward.project.shared.interfaces

import edward.project.shared.models.Music

interface IMusicRepo {

    fun getMusicList(): Collection<Music>
}