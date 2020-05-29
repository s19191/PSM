import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    GridLayout gl;
    JPanel board;
    Cell[][] cells;
    static Color deadColor;
    static Color aliveColor;
    List<Integer> stayingAliveUhuhuhuu;
    List<Integer> toBeBorn;

    public Board(int size) {
        this.size = size;
        gl = new GridLayout(size, size);
        board = new JPanel(gl);
        deadColor = Color.BLACK;
        aliveColor = Color.RED;
        stayingAliveUhuhuhuu = new ArrayList<>();
        toBeBorn = new ArrayList<>();
        stayingAliveUhuhuhuu.add(2);
        stayingAliveUhuhuhuu.add(3);
        toBeBorn.add(3);
        cells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
                board.add(cells[i][j].getjButton());
            }
        }
    }

    public void nextIteration() {
        Cell[][] tmp = new Cell[size][size];
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                tmp[i][j] = new Cell(cells[i][j].getColor());
            }
        }
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                int living = 0;
                if (i == 0 && j ==0) {
                    if (tmp[size -1][size -1].getColor().equals(aliveColor)) {
                        living++;
                    }
                    if (tmp[size -1][0].getColor().equals(aliveColor)) {
                        living++;
                    }
                    if (tmp[size -1][1].getColor().equals(aliveColor)) {
                        living++;
                    }
                    if (tmp[0][1].getColor().equals(aliveColor)) {
                        living++;
                    }
                    if (tmp[1][1].getColor().equals(aliveColor)) {
                        living++;
                    }
                    if (tmp[1][0].getColor().equals(aliveColor)) {
                        living++;
                    }
                    if (tmp[1][size -1].getColor().equals(aliveColor)) {
                        living++;
                    }
                    if (tmp[0][size -1].getColor().equals(aliveColor)) {
                        living++;
                    }
                } else {
                    if (i == 0 && j == size -1) {
                        if (tmp[size -1][size -2].getColor().equals(aliveColor)) {
                            living++;
                        }
                        if (tmp[size -1][size -1].getColor().equals(aliveColor)) {
                            living++;
                        }
                        if (tmp[size -1][0].getColor().equals(aliveColor)) {
                            living++;
                        }
                        if (tmp[0][0].getColor().equals(aliveColor)) {
                            living++;
                        }
                        if (tmp[1][0].getColor().equals(aliveColor)) {
                            living++;
                        }
                        if (tmp[1][size -1].getColor().equals(aliveColor)) {
                            living++;
                        }
                        if (tmp[1][size -2].getColor().equals(aliveColor)) {
                            living++;
                        }
                        if (tmp[0][size -2].getColor().equals(aliveColor)) {
                            living++;
                        }
                    } else {
                        if (i == size -1 && j == 0) {
                            if (tmp[size -2][size -1].getColor().equals(aliveColor)) {
                                living++;
                            }
                            if (tmp[size -2][0].getColor().equals(aliveColor)) {
                                living++;
                            }
                            if (tmp[size -2][1].getColor().equals(aliveColor)) {
                                living++;
                            }
                            if (tmp[size -1][1].getColor().equals(aliveColor)) {
                                living++;
                            }
                            if (tmp[0][1].getColor().equals(aliveColor)) {
                                living++;
                            }
                            if (tmp[0][0].getColor().equals(aliveColor)) {
                                living++;
                            }
                            if (tmp[0][size -1].getColor().equals(aliveColor)) {
                                living++;
                            }
                            if (tmp[size -1][size -1].getColor().equals(aliveColor)) {
                                living++;
                            }
                        } else {
                            if (i == size -1 && j == size -1) {
                                if (tmp[size -2][size -2].getColor().equals(aliveColor)) {
                                    living++;
                                }
                                if (tmp[size -2][size -1].getColor().equals(aliveColor)) {
                                    living++;
                                }
                                if (tmp[size -2][0].getColor().equals(aliveColor)) {
                                    living++;
                                }
                                if (tmp[size -1][0].getColor().equals(aliveColor)) {
                                    living++;
                                }
                                if (tmp[0][0].getColor().equals(aliveColor)) {
                                    living++;
                                }
                                if (tmp[0][size -1].getColor().equals(aliveColor)) {
                                    living++;
                                }
                                if (tmp[0][size -2].getColor().equals(aliveColor)) {
                                    living++;
                                }
                                if (tmp[size -1][size -2].getColor().equals(aliveColor)) {
                                    living++;
                                }
                            } else {
                                if (i == 0) {
                                    if (tmp[size -1][j -1].getColor().equals(aliveColor)) {
                                        living++;
                                    }
                                    if (tmp[size -1][j].getColor().equals(aliveColor)) {
                                        living++;
                                    }
                                    if (tmp[size -1][j +1].getColor().equals(aliveColor)) {
                                        living++;
                                    }
                                    if (tmp[i][j +1].getColor().equals(aliveColor)) {
                                        living++;
                                    }
                                    if (tmp[i +1][j +1].getColor().equals(aliveColor)) {
                                        living++;
                                    }
                                    if (tmp[i +1][j].getColor().equals(aliveColor)) {
                                        living++;
                                    }
                                    if (tmp[i +1][j -1].getColor().equals(aliveColor)) {
                                        living++;
                                    }
                                    if (tmp[i][j -1].getColor().equals(aliveColor)) {
                                        living++;
                                    }
                                } else {
                                    if (i == size -1) {
                                        if (tmp[i -1][j -1].getColor().equals(aliveColor)) {
                                            living++;
                                        }
                                        if (tmp[i -1][j].getColor().equals(aliveColor)) {
                                            living++;
                                        }
                                        if (tmp[i -1][j +1].getColor().equals(aliveColor)) {
                                            living++;
                                        }
                                        if (tmp[i][j +1].getColor().equals(aliveColor)) {
                                            living++;
                                        }
                                        if (tmp[0][j +1].getColor().equals(aliveColor)) {
                                            living++;
                                        }
                                        if (tmp[0][j].getColor().equals(aliveColor)) {
                                            living++;
                                        }
                                        if (tmp[0][j -1].getColor().equals(aliveColor)) {
                                            living++;
                                        }
                                        if (tmp[i][j -1].getColor().equals(aliveColor)) {
                                            living++;
                                        }
                                    } else {
                                        if (j == 0) {
                                            if (tmp[i -1][size -1].getColor().equals(aliveColor)) {
                                                living++;
                                            }
                                            if (tmp[i -1][j].getColor().equals(aliveColor)) {
                                                living++;
                                            }
                                            if (tmp[i -1][j +1].getColor().equals(aliveColor)) {
                                                living++;
                                            }
                                            if (tmp[i][j +1].getColor().equals(aliveColor)) {
                                                living++;
                                            }
                                            if (tmp[i +1][j +1].getColor().equals(aliveColor)) {
                                                living++;
                                            }
                                            if (tmp[i +1][j].getColor().equals(aliveColor)) {
                                                living++;
                                            }
                                            if (tmp[i +1][size -1].getColor().equals(aliveColor)) {
                                                living++;
                                            }
                                            if (tmp[i][size -1].getColor().equals(aliveColor)) {
                                                living++;
                                            }
                                        } else {
                                            if (j == size -1) {
                                                if (tmp[i -1][j -1].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i -1][j].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i -1][0].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i][0].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i +1][0].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i +1][j].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i +1][j -1].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i][j -1].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                            } else {
                                                if (tmp[i -1][j -1].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i -1][j].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i -1][j +1].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i][j +1].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i +1][j +1].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i +1][j].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i +1][j -1].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                                if (tmp[i][j -1].getColor().equals(aliveColor)) {
                                                    living++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (tmp[i][j].getColor().equals(aliveColor) && !stayingAliveUhuhuhuu.contains(living)) {
                    cells[i][j].setColor(deadColor);
                } else if (tmp[i][j].getColor().equals(deadColor) && toBeBorn.contains(living)) {
                    cells[i][j].setColor(aliveColor);
                }
            }
        }
    }

    public void setNewRule(String firstPart, String secondPart) {
        stayingAliveUhuhuhuu.clear();
        toBeBorn.clear();
        for (int i = 0; i < firstPart.length(); i++) {
            stayingAliveUhuhuhuu.add(Character.getNumericValue(firstPart.charAt(i)));
        }
        for (int i = 0; i < secondPart.length(); i++) {
            toBeBorn.add(Character.getNumericValue(secondPart.charAt(i)));
        }
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j].setColor(deadColor);
            }
        }
    }

    public JPanel getBoard() {
        return board;
    }
}
