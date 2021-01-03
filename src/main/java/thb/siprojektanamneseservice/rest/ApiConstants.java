package thb.siprojektanamneseservice.rest;

public class ApiConstants {

    public static final String API = "/api";

    //Person
    public static final String PATIENT_ROOT = API + "/persons";
    public static final String PATIENT_ITEM = PATIENT_ROOT + "/{personId}";

    //MedicationInTake
    public static final String MEDICATION_IN_TAKE_ROOT = API + "/medication_in_takes";
    public static final String MEDICATION_IN_TAKE_ITEM = MEDICATION_IN_TAKE_ROOT + "/{medicationInTakeId}";

    //PreExistingIllnesses
    public static final String PRE_EXISTING_ILLNESS_ROOT = API + "/preExistingIllnesses";
    public static final String PRE_EXISTING_ILLNESS_ITEM = PRE_EXISTING_ILLNESS_ROOT + "/{preExistingIllnessId}";

    //AllergyType
    public static final String ALLERGY_TYPE_ROOT = API + "/allergyTypes";
    public static final String ALLERGY_TYPE_ITEM = ALLERGY_TYPE_ROOT + "/{allergyTypeId}";

    //Diagnosis
    public static final String DIAGNOSIS_ROOT = API + "/diagnoses";
    public static final String DIAGNOSIS_ITEM = DIAGNOSIS_ROOT + "/{diagnosisId}";

    //Address
    public static final String ADDRESS_ROOT = API + "/addresses";
    public static final String ADDRESS_ITEM = ADDRESS_ROOT + "/{addressId}";

    //Vegetative anamnesis
    public static final String VEGETATIVEANAMNESIS_ROOT = API + "/vegetativeAnamnesis";
    public static final String VEGETATIVEANAMNESIS_ITEM = VEGETATIVEANAMNESIS_ROOT + "/{vegetativeAnamnesisId}";

    //FamilyAnamnesis
    public static final String FAMILYANAMNESIS_ROOT = API + "/familyAnamnesis";
    public static final String FAMILYANAMNESIS_ITEM = FAMILYANAMNESIS_ROOT + "/{familyAnamnesisId}";

    //Disease
    public static final String DISEASE_ROOT = API + "/diseases";
    public static final String DISEASE_ITEM = DISEASE_ROOT + "/{diseaseId}";

    //Security
    public static final String SECURITY_ROOT = API + "/securities";
    public static final String SECURITY_ITEM = SECURITY_ROOT + "/{securityId}";
}
