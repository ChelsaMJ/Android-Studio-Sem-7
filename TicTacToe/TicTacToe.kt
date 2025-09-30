package com.example.transitions

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TicTacToe: AppCompatActivity() {

    // 0 = empty, 1 = X, 2 = O
    private val board = Array(3) { IntArray(3) { 0 } }
    private lateinit var buttons: Array<Array<Button>>
    private lateinit var statusText: TextView
    private lateinit var resetButton: Button

    private var currentPlayer = 1
    private var moves = 0
    private var gameOver = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)

        statusText = findViewById(R.id.statusText)
        resetButton = findViewById(R.id.resetButton)

        // initialize button references
        buttons = Array(3) { row ->
            Array(3) { col ->
                val id = resources.getIdentifier("btn${row}${col}", "id", packageName)
                findViewById<Button>(id).apply {
                    setOnClickListener { onCellClicked(row, col) }
                }
            }
        }

        resetButton.setOnClickListener { resetGame() }

        updateStatus()
    }

    private fun onCellClicked(row: Int, col: Int) {
        if (gameOver) return
        if (board[row][col] != 0) return

        board[row][col] = currentPlayer
        buttons[row][col].text = if (currentPlayer == 1) "X" else "O"
        buttons[row][col].isEnabled = false
        moves++

        val winner = checkWinner()
        if (winner != 0) {
            gameOver = true
            statusText.text = if (winner == 1) "X wins!" else "O wins!"
            Toast.makeText(this, statusText.text, Toast.LENGTH_SHORT).show()
            highlightWinningLine(winner)
            return
        }

        if (moves == 9) {
            gameOver = true
            statusText.text = "Draw!"
            Toast.makeText(this, "It's a draw!", Toast.LENGTH_SHORT).show()
            return
        }

        // switch player
        currentPlayer = if (currentPlayer == 1) 2 else 1
        updateStatus()
    }

    private fun updateStatus() {
        statusText.text = if (!gameOver) {
            if (currentPlayer == 1) "X's turn" else "O's turn"
        } else {
            statusText.text // keep existing if game over
        }
    }

    /**
     * Returns:
     * 0 - no winner yet
     * 1 - X wins
     * 2 - O wins
     */
    private fun checkWinner(): Int {
        // rows and columns
        for (i in 0..2) {
            // row
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0]
            }
            // column
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i]
            }
        }
        // diagonals
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0]
        }
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2]
        }
        return 0
    }

    // Simple UI highlight for the winning line (disables all buttons but keeps winner text)
    private fun highlightWinningLine(winner: Int) {
        // find winning line and change enabled state / alpha to show result
        for (i in 0..2) {
            if (board[i][0] == winner && board[i][1] == winner && board[i][2] == winner) {
                buttons[i][0].alpha = 1.0f
                buttons[i][1].alpha = 1.0f
                buttons[i][2].alpha = 1.0f
            }
            if (board[0][i] == winner && board[1][i] == winner && board[2][i] == winner) {
                buttons[0][i].alpha = 1.0f
                buttons[1][i].alpha = 1.0f
                buttons[2][i].alpha = 1.0f
            }
        }
        if (board[0][0] == winner && board[1][1] == winner && board[2][2] == winner) {
            buttons[0][0].alpha = 1.0f
            buttons[1][1].alpha = 1.0f
            buttons[2][2].alpha = 1.0f
        }
        if (board[0][2] == winner && board[1][1] == winner && board[2][0] == winner) {
            buttons[0][2].alpha = 1.0f
            buttons[1][1].alpha = 1.0f
            buttons[2][0].alpha = 1.0f
        }

        // disable all cells
        for (r in 0..2) for (c in 0..2) buttons[r][c].isEnabled = false
    }

    private fun resetGame() {
        for (r in 0..2) {
            for (c in 0..2) {
                board[r][c] = 0
                buttons[r][c].text = ""
                buttons[r][c].isEnabled = true
                buttons[r][c].alpha = 1.0f
            }
        }
        currentPlayer = 1
        moves = 0
        gameOver = false
        updateStatus()
    }
}
