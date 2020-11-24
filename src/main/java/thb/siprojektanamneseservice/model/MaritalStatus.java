package thb.siprojektanamneseservice.model;

public enum MaritalStatus {
    SINGLE("single"),
    PARTNERSCHAFT("civil_union"),
    VERHEIRATET("married"),
    GESCHIEDEN("divorced"),
    VERWITWET("widowed");

    private final String maritalStatus;

    MaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
