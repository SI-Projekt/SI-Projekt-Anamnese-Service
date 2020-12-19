package thb.siprojektanamneseservice.model.constants;


public enum AllergyType {
    ANTIBIOTICS("antibiotics"),
    FRUCTOSE("fructose"),
    FOODS("foods"),
    POLLEN("pollen"),
    RADIO_OPAQUE_SUBSTANCE("radio_opaque_substance"),
    ANIMAL_HAIR("animal_hair"),
    LOCAL_ANAESTHETICS("local_anaesthetics"),
    LACTOSE("lactose"),
    HOUSE_DUST("House_dust"),
    PRESERVATIVES("preservatives"),
    VITAMIN_B("vitamin_b");

    private final String allergyType;

    AllergyType(String allergyType) {
        this.allergyType = allergyType;
    }
}
