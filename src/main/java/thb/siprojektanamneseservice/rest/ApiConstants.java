package thb.siprojektanamneseservice.rest;

public class ApiConstants {

    public static final String API = "/api";

    //Patient
    public static final String PATIENT_ROOT = API + "/patients";
    public static final String PATIENT_ITEM = PATIENT_ROOT + "/{patientId}";

    //Patient
    public static final String MARITAL_STATUS_ROOT = API + "/maritalStatuss";
    public static final String MARITAL_STATUS_ITEM = MARITAL_STATUS_ROOT + "/{maritalStatusId}";

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

}
