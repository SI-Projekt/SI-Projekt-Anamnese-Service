package thb.siprojektanamneseservice.model;

public enum Examinations {

    COMPUTER_TOMOGRAM("CT"),
    Magnetic_Resonance_Imaging("MRI"),
    PALPATION("palpation");

    private final String typeOfExamination;

    Examinations(String typeOfExamination) {
        this.typeOfExamination = typeOfExamination;
    }
}
