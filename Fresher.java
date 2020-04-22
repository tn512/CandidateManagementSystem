/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

/**
 *
 * @author ADMIN
 */
public class Fresher extends Candidate{
    private String graduationDate;
    private String graduationRank, university;
    
    public Fresher() {
        super();
    }

    public Fresher(String graduationDate, String graduationRank, String university, String ID, String firstName, String lastName, String address, String phone, String email, int type, int birthDate) {
        super(ID, firstName, lastName, address, phone, email, type, birthDate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }
    
}
