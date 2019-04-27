# Animate-CSS

Vaadin 13 Java integration of
https://daneden.github.io/animate.css/

## Development instructions

Starting the test/demo server:
```
mvn -Ptest clean package jar:test-jar
java -cp target/animate-css-1.0-tests.jar:target/animate-css-1.0-jar-with-dependencies.jar com.infraleap.animatecss.demo.App
```

This deploys demo at http://localhost:8080


## Deploy instructions

To upload to Vaadin Directory, creates a ZIP in the target directory
```
mvn versions:set
mvn -Pdirectory clean install
```
