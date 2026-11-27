package domain_model;

public class QuotaAdministration {

    public int calculateQuota (Member member) {

        if (!member.isActive()) {
            return Quota.PASSIVE_MEMBER;
        }

        if (member.getAgeGroup() == AgeGroup.JUNIOR) {
            return Quota.JUNIOR_MEMBER;
        }

        if (member.getAge() > 60) {
            return Quota.SENIOR_MEMBER * Quota.SENIOR_DISCOUNT_PERCENT / 100;
        }

        return Quota.SENIOR_MEMBER;
    }
}
