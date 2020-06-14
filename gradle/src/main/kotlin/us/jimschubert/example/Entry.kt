package us.jimschubert.example

import us.jimschubert.client.api.PetsApi
import java.util.*


/**
 * Example calling generated client…
 * Install Prism (https://github.com/stoplightio/prism)
 * And start a separate mock server with:
 * prism mock $PWD/petstore.yaml -d -p 4011
 * Then, run this example.
 * mvn --quiet compile exec:java -Dexec.mainClass="us.jimschubert.example.Entry"
 */
object Entry {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Example reading from http://127.0.0.1:4011 via generated client…")
        val api = PetsApi("http://127.0.0.1:4011")
        Arrays.stream(api.listPets(10)).forEach(System.out::println)
        System.exit(0)
    }
}
