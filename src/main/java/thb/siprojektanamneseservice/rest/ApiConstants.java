package thb.siprojektanamneseservice.rest;

public class ApiConstants {

    public static final String API = "/api";

    //Patient
    public static final String PATIENT_ROOT = API + "/patients";
    public static final String PATIENT_ITEM = PATIENT_ROOT + "/{patientId}";

    //Address

    //MedicationInTake
    public static final String MEDICATION_IN_TAKE_ROOT = API + "/medication_in_takes";
    public static final String MEDICATION_IN_TAKE_ITEM = MEDICATION_IN_TAKE_ROOT + "/{medicationInTakeId}";
}
