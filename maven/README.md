# OpenAPI Generator Example: Maven + Kotlin

This example demonstrates usage of the [OpenAPI Generator Maven Plugin](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin).
It generates the [kotlin client](https://openapi-generator.tech/docs/generators/kotlin) within a Maven project, and invokes that client from a Java entrypoint.

To run this project, install [prism](https://github.com/stoplightio/prism) to mock out the API defined in petstore.yaml.

Then, start prism with:

```bash
prism mock $PWD/petstore.yaml -d -p 4011
```

In another terminal, execute this example from this root directory:

```bash
mvn --quiet compile exec:java -Dexec.mainClass="us.jimschubert.example.Entry"
```

## Notes

The maven plugin allows you to generate into any target directory. This example generates sources directly into the project root using the same package to match the `Entry#main`.

This example follows this pattern to demonstrate:

* Using the `.openapi-generator-ignore` file. When this file exists in the target directory of your generated code, the tooling will honor those ignores and skip generation of any file(s) matching these patterns. This follows the same syntax as `.gitignore`.
  - To understand what files may need to be ignored, you may do a dry-run via command line or check similar [sample output](https://github.com/OpenAPITools/openapi-generator/tree/master/samples/client/petstore) in the tooling's repository.
* Using `generate` goal of the `generate-sources` phase to explicitly demonstrate where source code generation may go.
  - Alternatively, if you're building docs from an OpenAPI document created by statically analyzed source, you may choose another phase/goal (see below).
* Supplying tooling configuration (e.g. `<configuration><inputSpec/></configuration>`) vs configuration options specific to the generator (those under `<configOptions/>`)

Most users will likely want to stick with the `generate` goal.

You can view phases and goals in the order they'd execute by running:

```bash
mvn fr.jcgay.maven.plugins:buildplan-maven-plugin:list
```

This is how that looks for this project.


PLUGIN                         | PHASE                  | ID                    | GOAL         |
-------------------------------|------------------------|-----------------------|--------------|
openapi-generator-maven-plugin | generate-sources       | default               | generate     |
maven-resources-plugin         | process-resources      | default-resources     | resources    |
kotlin-maven-plugin            | compile                | compile               | compile      |
maven-compiler-plugin          | compile                | java-compile          | compile      |
maven-resources-plugin         | process-test-resources | default-testResources | testResources|
kotlin-maven-plugin            | test-compile           | test-compile          | test-compile |
maven-compiler-plugin          | test-compile           | java-test-compile     | testCompile  |
maven-surefire-plugin          | test                   | default-test          | test         |
maven-jar-plugin               | package                | default-jar           | jar          |
maven-install-plugin           | install                | default-install       | install      |
maven-deploy-plugin            | deploy                 | default-deploy        | deploy       |
