/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author ADMIN
 */
public class Manager {

    Validation v = new Validation();

    void displayMenu() {
        System.out.println("====== CANDIDATE MANAGEMENT SYSTEM ======\n"
                + "1. Experience\n"
                + "2. Fresher\n"
                + "3. Internship\n"
                + "4. Searching\n"
                + "5. Exit");
    }

    int searchCandicateByID(ArrayList<Candidate> alc, String ID) {
        int index = -1;
        for (int i = 0; i < alc.size(); i++) {
            if (ID.equals(alc.get(i).getID())) {
                index = i;
                break;
            }
        }
        return index;
    }

    void createCandicate(ArrayList<Candidate> alc, int type) {
        while (true) {
            String Id = v.inputString("Enter ID: ");
            String firstName = v.inputString("Enter First Name: ");
            String lastName = v.inputString("Enter Last Name: ");
            int birthDate = v.inputInt("Enter BirthDate: ", 1900, Calendar.getInstance().get(Calendar.YEAR));
            String address = v.inputString("Enter Address: ");
            String phone = v.inputPhone("Enter Phone: ");
            String email = v.inputEmail("Enter Email: ");
            Candidate c = new Candidate(Id, firstName, lastName, address, phone, email, birthDate, type);
            if (searchCandicateByID(alc, Id) == -1) {
                switch (type) {
                    case 0: {
                        createExperience(alc, c);
                        return;
                    }
                    case 1: {
                        createFresher(alc, c);
                        return;
                    }
                    case 2: {
                        createInternship(alc, c);
                        return;
                    }
                }
            } else {
                System.out.println("This ID has already existed!");
            }
        }
    }

    void createExperience(ArrayList<Candidate> alc, Candidate c) {
        int yearOfExperience = v.inputExprience("Enter Year of Experience: ", c.getBirthDate());
        String professionalSkill = v.inputString("Enter Professional Skill: ");
        alc.add(new Experience(yearOfExperience, professionalSkill,
                c.getID(), c.getFirstName(), c.getLastName(), c.getAddress(),
                c.getPhone(), c.getEmail(), c.getType(), c.getBirthDate()));
        System.out.println("Created Experience Successfully!");
    }

    void createInternship(ArrayList<Candidate> alc, Candidate c) {
        String majors = v.inputString("Enter Majors: ");
        String semester = v.inputString("Enter Semester: ");
        String university = v.inputString("Enter University: ");
        alc.add(new Internship(majors, semester, university,
                c.getID(), c.getFirstName(), c.getLastName(), c.getAddress(),
                c.getPhone(), c.getEmail(), c.getType(), c.getBirthDate()));
        System.out.println("Created Internship Successfully!");
    }

    void createFresher(ArrayList<Candidate> alc, Candidate c) {
        String graduationTime = v.inputString("Enter Graduation Time: ");
        String graduationRank = v.inputGraduationRank("Enter Graduation Rank: ");
        String university = v.inputString("Enter University: ");
        alc.add(new Fresher(graduationTime, graduationRank, university,
                c.getID(), c.getFirstName(), c.getLastName(), c.getAddress(),
                c.getPhone(), c.getEmail(), c.getType(), c.getBirthDate()));
        System.out.println("Created Fresher Successfully!");
    }

    void printNameCandidate(ArrayList<Candidate> alc) {
        System.out.println("========= Experience Candidate =========");
        for (int i = 0; i < alc.size(); i++) {
            if (alc.get(i) instanceof Experience) {
                System.out.println(alc.get(i).getFirstName() + " " + alc.get(i).getLastName());
            }
        }
        System.out.println("========= Fresher Candidate ============");
        for (int i = 0; i < alc.size(); i++) {
            if (alc.get(i).getType() == 1) {
                System.out.println(alc.get(i).getFirstName() + " " + alc.get(i).getLastName());
            }
        }
        System.out.println("========= Internship Candidate =========");
        for (int i = 0; i < alc.size(); i++) {
            if (alc.get(i).getType() == 2) {
                System.out.println(alc.get(i).getFirstName() + " " + alc.get(i).getLastName());
            }
        }
    }

    void searchNameCandidate(ArrayList<Candidate> alc) {
        printNameCandidate(alc);
        String searchName = v.inputString("Input Candidate Name(First name or Last name): ");
        int searchType = v.inputInt("Input type of candidate: ", 0, 2);
        for (int i = 0; i < alc.size(); i++) {
            if (alc.get(i).getType() == searchType
                    && (alc.get(i).getFirstName().contains(searchName)
                    || alc.get(i).getLastName().contains(searchName))) {
                System.out.println(alc.get(i).toString());
            }
        }
    }
}
