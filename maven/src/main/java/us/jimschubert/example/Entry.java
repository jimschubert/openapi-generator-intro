package us.jimschubert.example;

import us.jimschubert.client.api.PetsApi;

import java.util.Arrays;

/**
 * Example calling generated client…
 * Install Prism (https://github.com/stoplightio/prism)
 * And start a separate mock server with:
 *     prism mock $PWD/petstore.yaml -d -p 4011
 * Then, run this example.
 *     mvn --quiet compile exec:java -Dexec.mainClass="us.jimschubert.example.Entry"
 */
public class Entry {
    public static void main(String[] args) {
        System.out.println("Example reading from http://127.0.0.1:4011 via generated client…");
        PetsApi api = new PetsApi("http://127.0.0.1:4011");
        Arrays.stream(api.listPets(10)).forEach(System.out::println);
        System.exit(0);
    }
}
