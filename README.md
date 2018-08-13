Sudoku-Solver

### Run:
    git clone https://github.com/riteshpuj2013/sudoku-solver.git
    cd sudoku-solver
    ./mvnw spring-boot:run

### Test 1:
    curl http://localhost:8080/api/sudoku?input=9,x,x,1,x,x,x,x,5,x,x,5,x,9,x,2,x,1,8,x,x,x,4,x,x,x,x,x,x,x,x,8,x,x,x,x,x,x,x,7,x,x,x,x,x,x,x,x,x,2,6,x,x,9,2,x,x,3,x,x,x,x,6,x,x,x,2,x,x,9,x,x,x,x,1,9,x,4,5,7,x

    Output:
    {"solution":"9,3,4,1,7,2,6,8,5,7,6,5,8,9,3,2,4,1,8,1,2,6,4,5,3,9,7,4,2,9,5,8,1,7,6,3,6,5,8,7,3,9,1,2,4,1,7,3,4,2,6,8,5,9,2,9,7,3,5,8,4,1,6,5,4,6,2,1,7,9,3,8,3,8,1,9,6,4,5,7,2"}

### Test 2:
    curl http://localhost:8080/api/sudoku?input=x,x,x,2,6,x,7,x,x,1,6,8,x,x,7,x,x,9,x,1,9,x,x,x,4,5,x,x,8,2,x,1,x,x,x,4,x,x,x,4,6,x,2,9,x,x,x,5,x,x,x,3,x,2,8,x,x,9,3,x,x,x,7,4,x,4,8,9,5,x,x,3,6,7,x,3,x,1,8,x,x

    Output:
    {"error":"cannot be completed"}

