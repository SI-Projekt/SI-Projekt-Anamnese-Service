package thb.siprojektanamneseservice.model.constants;

public enum ExaminationValues {

    COMPUTER_TOMOGRAM("CT"),
    Magnetic_Resonance_Imaging("MRI"),
    PALPATION("palpation");

    private final String typeOfExaminationValue;

    ExaminationValues(String typeOfExaminationValue) {
        this.typeOfExaminationValue = typeOfExaminationValue;
    }
}
