
/**
 ******************************************************************************
 *                        BINGO
 ******************************************************************************
 *
 * The standard bingo game.
 *
 *
 *
 *
 * Name:         WRITE YOUR NAME HERE !!!!!!!!!!!
 *
 * Date:
 *
 *
 ***************************************************************************** */
import java.util.*;
import java.io.*;
import java.util.Random;

public class Bingo {

    private Random rand = new Random();
    private int[][] card;       //Bingo card configuration
    private int[] stream;       //list of 75 integers
    private boolean[][] marks;  //simulates placing chips on a Bingo card
    ArrayList<Integer> list = new ArrayList<>();

    public Bingo() {
        card = new int[5][5];
        stream = new int[75];
        marks = new boolean[5][5];
    }

    /**
     * This method writes a random Bingo card configuration and a stream of
     * random number between 1 and 75 to the output file.
     *
     * The first column in the table contains only integers between 1 and 15,
     * the second column numbers are all between 16 and 30, the third are 31 to
     * 45, the fourth 46-60, and the fifth 61-75.
     *
     * There are no duplicate numbers on a Bingo card.
     */
    public void write(String outputFile) throws IOException {
        PrintWriter output = new PrintWriter("outputFile");
        for (int x = 1; x < 76; x++) {
            list.add(x);
        }
        this.shuffle(list);
        for (int c = 0; c < 5; c++) {
            ArrayList<Integer> check = new ArrayList<>();
            for (int r = 0; r < 5; r++) {
                switch (c) {
                    case 0:
                        int num = rand.nextInt(15) + 1;
                        check.add(num);
                        boolean find = true;
                        for (int x = 0; x < check.size(); x++) {
                            if (check.get(x) == card[x][0]) {
                                find = false;
                            }
                        }
                        if (find == true) {
                            card[r][c] = num;
                        } else {
                            r--;
                            check.remove(r);
                        }
                        break;
                    case 1:
                        num = rand.nextInt(15) + 16;
                        check.add(num);
                        find = true;
                        for (int x = 0; x < check.size(); x++) {
                            if (check.get(x) == card[x][0]) {
                                find = false;
                            }
                        }
                        if (find == true) {
                            card[r][c] = num;
                        } else {
                            r--;
                            check.remove(r);
                        }
                        break;
                    case 2:
                        num = rand.nextInt(15) + 31;
                        check.add(num);
                        find = true;
                        for (int x = 0; x < check.size(); x++) {
                            if (check.get(x) == card[x][0]) {
                                find = false;
                            }
                        }
                        if (find == true) {
                            card[r][c] = num;
                        } else {
                            r--;
                            check.remove(r);
                        }
                        break;
                    case 3:
                        num = rand.nextInt(15) + 46;
                        check.add(num);
                        find = true;
                        for (int x = 0; x < check.size(); x++) {
                            if (check.get(x) == card[x][0]) {
                                find = false;
                            }
                        }
                        if (find == true) {
                            card[r][c] = num;
                        } else {
                            r--;
                            check.remove(r);
                        }
                        break;
                    case 4:
                        num = rand.nextInt(15) + 61;
                        check.add(num);
                        find = true;
                        for (int x = 0; x < check.size(); x++) {
                            if (check.get(x) == card[x][0]) {
                                find = false;
                            }
                        }
                        if (find == true) {
                            card[r][c] = num;
                        } else {
                            r--;
                            check.remove(r);
                        }
                        break;
                }

            }
        }
        card[3][3] = 0;
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                output.print(card[r][c]);
            }
            output.print("\n");
        }
        output.println(list);
        throw new RuntimeException("You need to implement this method");
    }

    /**
     * Shuffles the list of numbers
     */
    public void shuffle(ArrayList<Integer> list) {
        ArrayList list2 = new ArrayList<Integer>();
        list2 = list;
        int length = list.size();
        int num;
        for (int x = 0; x < length; x++) {
            num = rand.nextInt(list.size());
            list2.add(list.get(num));
            list.remove(num);
        }
        list = list2;
        throw new RuntimeException("You need to implement this method");
    }

    /**
     * This method reads a given inputFile that contains a Bingo card
     * configuration and a stream of numbers between 1 and 75. . A Bingo card
     * configuration is stored in the card array. A list of 75 integers is
     * stored in the stream array.
     */
    public void read(String inputFile) throws IOException {
        File file = new File("test1");
        Scanner input = new Scanner(file);
        int num;
        int fin;
        for (int x = 0; x < 5; x++) {
            String line = input.next();
            int count = 0;
            for (int y = 0; y < line.length(); y++) {
                if (line.substring(y, y + 1).equals(" ")) {
                    if (line.substring(y - 2, y - 1).equals(" ")) {
                        num = Integer.parseInt(line.substring(y - 1, y));
                        card[x][count] = num;
                    } else {
                        num = Integer.parseInt(line.substring(y - 2, y));
                        card[x][count] = num;
                    }
                }
                count++;
            }
            if (line.substring(line.length() - 2, line.length() - 1).equals(" ")) {
                fin = Integer.parseInt(line.substring(line.length() - 1));
                card[x][4] = fin;
            } else {
                fin = Integer.parseInt(line.substring(line.length() - 2));
                card[x][4] = fin;
            }
        }
        String line = input.next();
        int count2 = 0;
        for (int x = 0; x < line.length(); x++) {
            if (line.substring(x, x + 1).equals("")) {
                if (line.substring(x - 2, x - 1).equals("")) {
                    num = Integer.parseInt(line.substring(x - 1, x));
                    stream[count2] = num;
                } else {
                    num = Integer.parseInt(line.substring(x - 2, x));
                    stream[count2] = num;
                }
            }
        }
        if (line.substring(line.length() - 2, line.length() - 1).equals(" ")) {
            fin = Integer.parseInt(line.substring(line.length() - 1));
            stream[74] = fin;
        } else {
            fin = Integer.parseInt(line.substring(line.length() - 2));
            stream[74] = fin;
        }
        input.close();
        throw new RuntimeException("You need to implement this method");
    }

    /**
     * This method returns the first integer from the stream array that gives
     * you the earliest winning condition.
     *
     * - all the spots in a column are marked - all the spots in a row are
     * marked - all the spots in either of the two diagonals are marked - all
     * four corner squares are marked
     */
    public int playGame() {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                marks[x][y] = false;
            }
        }
        boolean done = false;
        for (int count = 0; count < 75 && done == false; count++) {
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (card[r][c] == stream[count]) {
                        marks[r][c] = true;
                    }
                }
            }
            if(marks[0][0] == marks[1][1] == marks[2][2] == marks[3][3] == marks[4][4]){
                done = true;
                return count;
            }else if(marks[0][0] == marks[0][4] == marks[4][0] == marks[4][4]){
                done = true;
                return count;
            }else if(marks[0][0] == marks[0][1] == marks[0][2] == marks[0][3] == marks[0][4]){
                done = true;
                return count;
            }else if(marks[1][0] == marks[1][1] == marks[1][2] == marks[1][3] == marks[1][4]){
                done = true;
                return count;
            }else if(marks[2][0] == marks[2][1] == marks[2][2] == marks[2][3] == marks[2][4]){
                done = true;
                return count;
            }else if(marks[3][0] == marks[3][1] == marks[3][2] == marks[3][3] == marks[3][4]){
                done = true;
                return count;
            }else if(marks[4][0] == marks[4][1] == marks[4][2] == marks[4][3] == marks[4][4]){
                done = true;
                return count;
            }else if(marks[0][0] == marks[1][0] == marks[2][0] == marks[3][0] == marks[4][0]){
                done = true;
                return count;
            }else if(marks[0][1] == marks[1][1] == marks[2][1] == marks[3][1] == marks[4][1]){
                done = true;
                return count;
            }else if(marks[0][2] == marks[1][2] == marks[2][2] == marks[3][2] == marks[4][2]){
                done = true;
                return count;
            }else if(marks[0][3] == marks[1][3] == marks[2][3] == marks[3][3] == marks[4][3]){
                done = true;
                return count;
            }else if(marks[0][4] == marks[1][4] == marks[2][4] == marks[3][4] == marks[4][4]){
                done = true;
                return count;
            }else if(marks[0][4] == marks[1][3] == marks[2][2] == marks[3][1] == marks[4][0]){
                done = true;
                return count;
            }
            
        }
        throw new RuntimeException("You need to implement this method");
    }
}
