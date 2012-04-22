package ohtu.intjoukkosovellus;

import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author tonykovanen
 */
public class StdIO implements IO {

    Scanner input = new Scanner(System.in);

    public String nextString() {
        return input.nextLine();
    }

    public int nextInt() {
        while (true) {
            try {
                int luku = Integer.parseInt(input.nextLine());
                return luku;
            } catch (Exception e) {
                this.print("Anna validi luku");
                continue;
            }
        }
    }

    public void print(String teksti) {
        System.out.println(teksti);
    }
}
