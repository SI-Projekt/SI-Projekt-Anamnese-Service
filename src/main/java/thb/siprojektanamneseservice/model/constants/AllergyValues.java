package thb.siprojektanamneseservice.model.constants;


public enum AllergyValues {
    ANTIBIOTICS("Antibiotikum"),
    FRUCTOSE("Fruktose"),
    FOODS("Nahrungsmittel"),
    POLLEN("Pollen"),
    RADIO_OPAQUE_SUBSTANCE("Radiodurchlässige Substanz"),
    ANIMAL_HAIR("Tierhaare"),
    LOCAL_ANAESTHETICS("Anästhesie"),
    LACTOSE("Laktose"),
    HOUSE_DUST("Hausstaub"),
    PRESERVATIVES("Kondome"),
    VITAMIN_B("B-Vitamine");

    private final String allergyValue;

    AllergyValues(String allergyValue) {
        this.allergyValue = allergyValue;
    }
}
