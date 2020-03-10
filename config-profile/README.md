# config-profile

## Basic structure
 1. ConfigProfile: main class to run
 2. DBConfig: class for set different property by active profile
 3. Param: class to store parameter's name and value

## Run
 1. mvn package
 2. java -jar target/config-profile-0.0.1-SNAPSHOT.jar
 3. java -jar -Dspring.profiles.active=prod target/config-profile-0.0.1-SNAPSHOT.jar
