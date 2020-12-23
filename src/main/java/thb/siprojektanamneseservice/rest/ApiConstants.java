package thb.siprojektanamneseservice.rest;

public class ApiConstants {

    public static final String API = "/api";

    //Patient
    public static final String PATIENT_ROOT = API + "/patients";
    public static final String PATIENT_ITEM = PATIENT_ROOT + "/{patientId}";

    //Address

    //Patient
    public static final String MARITAL_STATUS_ROOT = API + "/maritalStatuss";
    public static final String MARITAL_STATUS_ITEM = MARITAL_STATUS_ROOT + "/{maritalStatusId}";

    //MedicationInTake
    public static final String MEDICATION_IN_TAKE_ROOT = API + "/medication_in_takes";
    public static final String MEDICATION_IN_TAKE_ITEM = MEDICATION_IN_TAKE_ROOT + "/{medicationInTakeId}";

    //PreExistingIllnesses
    public static final String PRE_EXISTING_ILLNESS_ROOT = API + "/preExistingIllnesses";
    public static final String PRE_EXISTING_ILLNESS_ITEM = PRE_EXISTING_ILLNESS_ROOT + "/{preExistingIllnessId}";
}
