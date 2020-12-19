package thb.siprojektanamneseservice.model.constants;

public enum MaritalStatus {
    SINGLE("single"),
    CIVIL_UNION("civil_union"),
    MARRIED("married"),
    DIVORCED("divorced"),
    WIDOWED("widowed");

    private final String maritalStatus;

    MaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
