/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validation v = new Validation();
        ArrayList<Candidate> alc = new ArrayList<>();
        Manager m = new Manager();
        do {
            m.displayMenu();
            int option = v.inputInt("Choose one option: ", 1, 5);
            switch (option) {
                case 1: {
                    m.createCandicate(alc, 0);
                    break;
                }
                case 2: {
                    m.createCandicate(alc, 1);
                    break;
                }
                case 3: {
                    m.createCandicate(alc, 2);
                    break;
                }
                case 4: {
                    m.searchNameCandidate(alc);
                    break;
                }
                case 5: {
                    return;
                }
            }
        } while (v.inputYesNo("Do you want to continue?(Y/N): "));
    }
    
}
