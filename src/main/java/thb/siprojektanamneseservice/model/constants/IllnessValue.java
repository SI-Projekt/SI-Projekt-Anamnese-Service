package thb.siprojektanamneseservice.model.constants;

public enum IllnessValue {

    BLOOD_COAGULATION_DISORDER("Blutgerinnungsstörung"),
    EAR_DISEASE("Ohrerkrankung"),
    EYE_DISEASE("Augenerkrankung"),
    GASTRO_OR_INTESTINAL_DISEASE("Magen- und(oder) Darmerkrankung"),
    HEART_DISEASE("Herzkrankheit"),
    JOINT_DISEASE("Gelenkerkrankung"),
    KIDNEY_DISEASE("Nierenerkrankungen"),
    LIVER_DISEASE("Lebererkrankung"),
    MENTAL_ILLNESS("Geisteskrankheit oder psychische Krankheit"),
    PULMONARY_DISEASE("Lungenerkrankung"),
    SKIN_DISEASE("Hauterkrankung"),
    THYROID_DISEASE("Schilddrüsenerkrankung"),
    URIC_ACID_METABOLISM_DISORDER("Harnsäure- oder Stoffwechselstörung"),
    VASCULAR_DISEASES("Gefäßerkrankungen");

    private final String preExistingIllnesValue;

    IllnessValue(String preExistingIllnesValue) {
        this.preExistingIllnesValue = preExistingIllnesValue;
    }
}
