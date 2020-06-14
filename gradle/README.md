# OpenAPI Generator Example: Gradle + Kotlin

This example demonstrates usage of the [OpenAPI Generator Gradle Plugin](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin).
It generates the [kotlin client](https://openapi-generator.tech/docs/generators/kotlin) within an existing Gradle project, and invokes that client from a Kotlin entrypoint.

To run this project, install [prism](https://github.com/stoplightio/prism) to mock out the API defined in petstore.yaml.

Then, start prism with:

```bash
prism mock $PWD/petstore.yaml -d -p 4011
```

In another terminal, run this example from this root directory:

```bash
./gradlew run
```

You may also separately validate any changes to your specification document by running the `openApiValidate` task:

```bash
./gradlew openApiValidate
```

You may invoke the custom `buildDocs` task which generates static HTML documentation from the openAPI document:

```bash
./gradlew buildDocs
```

Run `./gradlew tasks --all` to see all available tasks under the "OpenAPI Tools tasks" tasks group.

## Notes

The gradle plugin allows you to generate into any target directory. This example generates sources directly into the project root using the same package to match the `Entry#main`.

This example follows this pattern to demonstrate:

* Using the `.openapi-generator-ignore` file. When this file exists in the target directory of your generated code, the tooling will honor those ignores and skip generation of any file(s) matching these patterns. This follows the same syntax as `.gitignore`.
  - To understand what files may need to be ignored, you may do a dry-run via command line or check similar [sample output](https://github.com/OpenAPITools/openapi-generator/tree/master/samples/client/petstore) in the tooling's repository.
* Integrating code generation tasks into the build lifecycle via `dependsOn`
* Supplying tooling configuration and configuration options (`configOptions`) within the `openApiGenerate` project extension/task
* Specifying `ignoreFileOverride` to limit target files at generation time
  - Note: paths should either be relative to the target directory (e.g. `index.html`) or glob subdirectories (e.g. `**/index.html`); paths are evaluated from the output directory root, not from the ignore file location.
* Creating custom tasks (see `buildDocs`) 
