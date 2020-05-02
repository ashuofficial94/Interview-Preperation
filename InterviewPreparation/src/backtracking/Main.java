package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());

            NQueen nq = new NQueen(num);
            nq.nQueenSol(0);

            for(char x[] : nq.board) {
                    for(char y: x) {
                            System.out.print(y+" ");
                    }
                    System.out.println();
            }
    }
}