package thb.siprojektanamneseservice.model;

public enum VegetativeAnamnesisDecision {

    BURNING("burning"),
    DIARRHEA("diarrhea"),
    DIARRHEA_WITH_BLOOD("diarrhea_With_blood"),
    NORMAL("normal"),
    FREQUENTLY("frequently"),
    TEETHING_TROUBLES("teething_troubles"),
    INCREASED("increased");

    private final String anamnesisDecision;

    VegetativeAnamnesisDecision(String anamnesisDecision) {
        this.anamnesisDecision = anamnesisDecision;
    }
}
