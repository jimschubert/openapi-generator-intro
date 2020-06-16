#!/bin/sh

export OPENAPI_GENERATOR_VERSION="5.0.0-SNAPSHOT"

./cli.sh generate -g go-experimental -t "$PWD"/go-experimental -o generated -i \
    https://raw.githubusercontent.com/OpenAPITools/openapi-generator/53eff431848291f294cdbd7941fe7ff8dedbaea2/modules/openapi-generator/src/test/resources/3_0/petstore.yaml

