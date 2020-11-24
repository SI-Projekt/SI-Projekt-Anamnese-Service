package thb.siprojektanamneseservice.model;

public enum TypeOfExamination {

    COMPUTER_TOMOGRAM("CT"),
    Magnetic_Resonance_Imaging("MRI"),
    PALPATION("palpation");

    private final String typeOfExamination;

    TypeOfExamination(String typeOfExamination) {
        this.typeOfExamination = typeOfExamination;
    }
}
