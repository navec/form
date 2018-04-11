package fr.arolla.core;

/**
 * Created by lenovo_9 on 10/04/2018.
 */
public enum  ProfileCustomer {
    PROFILE_1("P1"), PROFILE_2("P2"), PROFILE_3("P3"), PROFILE_4("P4");

    private final String profile;

    ProfileCustomer(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }

    public static ProfileCustomer form(String profile) {
        for (ProfileCustomer profileCustomer : values()) {
            if (profileCustomer.getProfile().equals(profile)) {
                return profileCustomer;
            }
        }
        return null;
    }
}