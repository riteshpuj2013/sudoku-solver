package com.profitbricks.sudokusolver.rest;

import com.profitbricks.sudokusolver.model.SudokuError;
import com.profitbricks.sudokusolver.model.SudokuSolution;
import com.profitbricks.sudokusolver.service.SudokuService;
import com.profitbricks.sudokusolver.util.InputUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/sudoku")
public class SudokuController {

    @Autowired
    private SudokuService service;

    @GetMapping
    public ResponseEntity<?> solveSudoku(@RequestParam("input") String puzzle) {
        try {
            if (puzzle != null && puzzle.length() > 0) {
                String[] numbers = puzzle.replaceAll("\\s+","").split(",");
                if (numbers.length != 81) {
                    ResponseEntity.badRequest().body(new SudokuError("incomplete data to create sudoku grid"));
                }
                int[][] board = InputUtil.convertStringArrayTo2DIntArray(numbers);
                service.setBoard(board);
                if (service.solve()) {
                    return ResponseEntity.ok(new SudokuSolution(service.getBoardString()));
                } else {
                    return ResponseEntity.ok(new SudokuError("cannot be completed"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body(new SudokuError("invalid input"));
    }
}
