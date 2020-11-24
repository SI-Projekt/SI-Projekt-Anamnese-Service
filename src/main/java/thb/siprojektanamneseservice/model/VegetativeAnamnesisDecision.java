package thb.siprojektanamneseservice.model;

public enum VegetativeAnamnesisDecision {

    BRENNEN("burning"),
    DURCHFALL("diarrhea"),
    DURCHFALL_MIT_BLUT("diarrhea_With_blood"),
    NORMAL("normal"),
    OEFTER("frequently"),
    START_SCHWIERIGKEITEN("teething_troubles"),
    VERMEHRT("increased");

    private final String anamnesisDecision;

    VegetativeAnamnesisDecision(String anamnesisDecision) {
        this.anamnesisDecision = anamnesisDecision;
    }
}
