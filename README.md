#ANZ Toy Robot

A simulator program for Robot.

#Development Notes
- The Program has been written using Java8.
- I have used singleton, Factory and Command Patterns.
- I have taken TDD approach.
- I have defined a functional interface with base command and default method and used lambda expressions to implement it
- Place command has different characteristics, so I have extracted the implementation to a separate class
- I have added appropriate junit test cases to cover edge cases and code coverage. 
- The program can be extended easily for any new command by adding the lambda implementation of it.

# Building and running Program

The program can be invoked by running the below mentioned command and using a txt file containing commands, one command per line.
Details of the command can be found in `PROBLEM.md` file.

# Build
To build the project, run command `mvn clean package`.
The built JAR can be found in `./target/` directory.

# Test

Building with `mvn clean package` runs the unit tests.

#Run
I have added three files with name `test1.txt`, `test2.txt`, `test3.txt` that contains commands to run.

Run command `mvn exec:java` from the path where `pom.xml` is present.

Enter any of the file names described above.(You can change the commands of these files) or create a new file and write commands in it.
 - If you are creating your own file, please specify absolute path of the file.

Output will be displayed on the console.

