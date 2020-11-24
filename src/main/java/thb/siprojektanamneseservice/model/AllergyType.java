package thb.siprojektanamneseservice.model;


public enum AllergyType {
    ANTIBIOTIKA("antibiotics"),
    FRUCHTZUCKER("fructose"),
    NAHRUNGSMITTEL("foods"),
    POLLEN("pollen"),
    ROENTGENKONTRASTMITTEL("radio_opaque_substance"),
    TIERHAAR("animal_hair"),
    LOKALANAESTHETIKA("local_anaesthetics"),
    MILCHZUCKER("lactose"),
    HAUSSTAUB("House_dust"),
    KONSERVIERUNGSSTOFFE("antidegradant"),
    VITAMIN_B("vitamin_b");

    private final String allergyType;

    AllergyType(String allergyType) {
        this.allergyType = allergyType;
    }
}
