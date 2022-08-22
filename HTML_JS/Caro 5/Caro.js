var BOARD = new Array();
var CUR_TURN = 0; //0 player X, 1 player O
const SYMBOLS = ["X", "O"];
const MAX = 10;
const NUM_SYMBOLS_WIN = 5;

function initEmptyBoard() {
    for (i = 0; i < MAX; i++) {
        BOARD[i] = Array(MAX).fill("");
    }
    drawBoardGame();
}

function drawBoardGame() {
    var str = "<table border='1' cellpadding='0' cellspacing='0'>";
    for (let i = 0; i < MAX; i++) {
        str += "<tr>";
        for (let j = 0; j < MAX; j++) {
            str += `<td idx="${[i, j].toString()}" onclick = playGame(event)>${BOARD[i][j]}</td > `;
        }
        str += "</tr>";
    }
    str += "</table>";
    document.getElementById("drawBoard").innerHTML = str;
}
function playGame(event) {
    let cell = event.target;
    let idx = cell.getAttribute("idx").split(",");
    if (BOARD[idx[0]][idx[1]] != "") return;

    let symbol = SYMBOLS[CUR_TURN];
    BOARD[idx[0]][idx[1]] = symbol;
    cell.innerHTML = symbol;

    if (checkWin(idx)) {
        alert(`${symbol} win`);
    }
    CUR_TURN = (CUR_TURN + 1) % 2;
}

function checkPosition(i, j) {
    if (BOARD[i][j] != "") {
        alert("Target was tick");
        return false;
    } else {
        return true;
    }
}

function checkWin(idx) {  //check function value
    let r = parseInt(idx[0]);
    let c = parseInt(idx[1]);
    let symbol = BOARD[r][c];

    //check row
    let i = c;
    let j = c;
    let count = 1;
    while (i > 0 || j < MAX) {
        i--;
        j++;

        if (i >= 0 && BOARD[r][i] == symbol) {
            count++;
        } else {
            i = 0;
        }
        if (j < MAX && BOARD[r][j] == symbol) {
            count++;
        } else {
            j = MAX;
        }
        if (count >= NUM_SYMBOLS_WIN) {
            return true;
        }
    }

    //check col
    i = r;
    j = r;
    count = 1;
    while (i > 0 || j < MAX) {
        i--;
        j++;

        if (i >= 0 && BOARD[i][c] == symbol) {
            count++;
        } else {
            i = 0;
        }

        if (j < MAX && BOARD[j][c] == symbol) {
            count++;
        } else {
            j = MAX;
        }

        if (count >= NUM_SYMBOLS_WIN) {
            return true;
        }
    }

    //check diagonal right \
    i = 0;
    j = 0;
    count = 1;
    let min = Math.min(r, c);
    let max = Math.max(r, c);
    while (min - i > 0 || max + j < MAX) {
        i++;
        j++;
        if ((min - i) >= 0 && BOARD[r - i][c - i] == symbol) {
            count++;
        } else {
            i = min + 1;
        }

        if ((max + j) < MAX && BOARD[r + j][c + j] == symbol) {
            count++;
        } else {
            j = MAX;
        }


        if (count >= NUM_SYMBOLS_WIN) {
            return true;
        }
    }

    //check diagonal left /
    i = 0;
    j = 0;
    count = 1;
    while ((BOARD[r - i] && BOARD[r - i][c + i]) || (BOARD[r + j] && BOARD[r + j][c - j])) {
        i++;
        j++;
        if (BOARD[r - i] && BOARD[r - i][c + i] && BOARD[r - i][c + i] == symbol) {
            count++;
        } else {
            i = r + 1;
        }

        if (BOARD[r + j] && BOARD[r + j][c - j] && BOARD[r + j][c - j] == symbol) {
            count++;
        } else {
            j = MAX;
        }

        if (count >= NUM_SYMBOLS_WIN) {
            return true;
        }
    }

    return false
}
window.onload = () => {
    initEmptyBoard();
}
