package domain_model;

public class QuotaAdministration {

    public int calculateQuota (Member member) {

        if (!member.isActive()) {
            return Quota.PASSIVE_MEMBER;
        }

        if (member.getAgeGroup() == AgeGroup.JUNIOR) {
            return Quota.JUNIOR_MEMBER;
        }

        return 0;
    }
}
