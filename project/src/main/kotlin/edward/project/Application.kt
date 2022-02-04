package edward.project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
private class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
