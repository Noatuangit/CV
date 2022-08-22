let BOARD = new Array();
const MAX = 4;
let flg = true;
let count = 0;

function initBoard() {
    for (i = 0; i < MAX; i++) {
        BOARD[i] = Array(MAX).fill("");
    }
    console.log(BOARD);
    drawBoardGame();
}

function drawBoardGame(i, j) {
    var str = "<table border='1' cellpadding='0' cellspacing='0'>";
    for (i = 0; i < MAX - 1; i++) {
        str += "<tr>";
        for (j = 0; j < MAX - 1; j++) {
            str += "<td onclick = playGame(" + i + "," + j + ")> " + BOARD[i][j] + "</td > ";
        }
        str += "</tr>";
    }
    str += "</table>";
    document.getElementById("drawBoard").innerHTML = str;
}

function playGame(i, j) {
    if (flg && checkPosition(i, j)) {
        BOARD[i][j] = "X";
        flg = false;
        count++;
    } else if (!flg && checkPosition(i, j)) {
        BOARD[i][j] = "O";
        flg = true;
        count++
    }
    drawBoardGame();
    if (checkWin(BOARD[i][j])) {
        alert(BOARD[i][j] + " win");
    }
    if (count == 9 && !checkWin(BOARD[i][j])){
        alert("Draw");
    }
}

function checkPosition(i, j) {
    if (BOARD[i][j] != "") {
        alert("Target was tick");
        return false;
    } else {
        return true;
    }
}

function checkWin(value) {  //check function value
    for (i = 0; i < MAX; i++) {
        for (j = 0; j < MAX; j++) {
            if (BOARD[i][j] == value) {
                if (BOARD[i][j + 1] == value && BOARD[i][j + 2] == value) {
                    return true;
                }
                if (BOARD[i + 1][j] == value && BOARD[i + 2][j] == value) {
                    return true;
                }
                if (BOARD[i + 1][j + 1] == value && BOARD[i + 2][j + 2] == value) {
                    return true;
                }
                if (BOARD[i + 1][j - 1] == value && BOARD[i + 2][j - 2] == value) {
                    return true;
                }
            }
        }
    }
    return false;
}

window.onload = () => {
    initBoard();
}
