package java.chapter1.interfaces;

public interface IMember {
    // All interface member types:

    String SECRET_PHRASE = "Hey";

    void showMemberID();

    default void memberResponsibilities() {
        System.out.println("All members have to be honest");
    }

    static void shareMoney() { // implicitly public
        System.out.println("Members do not share money");
    }

    private static void organizationCode() {
        System.out.println("No one knows organization code except the ruler");
    }

    private void memberPrivacy() {
        System.out.println("All members have their own privacy");
    }
}
