# GameOfLife
The universe of the Game of Life is an infinite two dimensional orthogonal grid of squarecells, each of which is in one of two possible states, alive or dead. 
Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent.

### Rules
At each step in time, the following transitions occur:
1. Any live cell with fewer than two live neighbours dies, as if caused by under­population.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overcrowding.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

### Pattern
Following the Glider pattern placed in a middle of grid sized of 25 * 25



## Local Development

### Requirements

You need to have the following setup to be able to run the application
on your local host:

- OpenJDK 11 (Hotspot): https://adoptopenjdk.net/archive.html?variant=openjdk11&jvmVariant=hotspot

Verify your setup by running `./mvnw --version` from the command line.

### Build and run the API

- `./mvnw clean install` builds the project and to run tests.
- `./mvnw spring-boot:run` runs the service.
