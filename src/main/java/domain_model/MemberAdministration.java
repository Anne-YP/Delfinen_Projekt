package domain_model;

import java.time.LocalDate;
import java.util.ArrayList;

public class MemberAdministration {
    private ArrayList<Member> members;
    private int nextMemberId;

    //US3: Tilddel medlemsnummer automatisk
    public MemberAdministration() {
        members = new ArrayList<>();
        nextMemberId = 1000;
    }

    public void addMember(String name, LocalDate dateOfBirth, boolean isActive, boolean isCompetitive, ArrayList<Discipline> disciplines) {
        Member member;
        if (isCompetitive) {
            member = new CompetitiveSwimmer(name, dateOfBirth, nextMemberId, isActive, isCompetitive, disciplines, 0);

        }
        else {
            member = new Member(name, dateOfBirth, nextMemberId, isActive, isCompetitive);
        }
        members.add(member);
        nextMemberId++;
    }

    /* Ved ikke om vi også skal bruge den her:
    public void addMember(Member member) {
    members.add(member);
    }
     */

    public ArrayList<Member> getMembers() {
        return members;
    }
}


/* METODER:
1. Opret medlem (+ tildel medlemsform, hold og evt. disciplin)
    1.5 Opret konkurrencesvømmer
        1.75 Tildel træningstid og stævneresultat
2. Rediger medlem
3. Slet medlem
4. Se medlemsoversigt
5. Se medlems kontingent
6. Registrer medlemsbetaling
 */