# Protocol buffers example for JAVA

## Gradle Set up 

```
group 'com.github.lazhari.protobuf'
version '1.0-SNAPSHOT'

apply plugin: 'java'
apply plugin: 'com.google.protobuf'
apply plugin: 'idea'

sourceCompatibility = 1.8

repositories {
    maven { url "https://plugins.gradle.org/m2/" }
}

dependencies {
    compile 'com.google.protobuf:protobuf-java:3.5.1'
    // util dependency to convert to JSON
    compile 'com.google.protobuf:protobuf-java-util:3.5.1'
    testCompile group: 'junit', name: 'junit', version: '4.12'
}

buildscript {
    repositories {
        maven { url "https://plugins.gradle.org/m2/" }
    }
    dependencies {
        classpath 'com.google.protobuf:protobuf-gradle-plugin:0.8.8'
    }
}

protobuf {
    // Configure the protoc executable
    protoc {
        // Download from repositories
        artifact = 'com.google.protobuf:protoc:3.5.1'
    }
}
```

## Structure

```
src
|-- main
|   |-- java
|   |   `-- com
|   |       `-- github
|   |           `-- lazhari
|   |               `-- protobuf
|   |                   |-- ComplexMain.java // Example for nested messages
|   |                   |-- EnumMain.java // Example for enumeration
|   |                   |-- OptionMain.java
|   |                   |-- ProtoToJsonMain.java
|   |                   `-- SimpleMain.java // A simple example
|   |-- proto
|   |   |-- complex.proto // Nested message protocol buffer definition
|   |   |-- enum_example.proto // Enum proto definition
|   |   |-- option_example.proto // option_example message definition
|   |   `-- simple.proto
|   `-- resources
`-- test
    |-- java
    `-- resources

```