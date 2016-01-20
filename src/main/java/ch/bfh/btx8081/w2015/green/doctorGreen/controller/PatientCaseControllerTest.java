package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

public class PatientCaseControllerTest {
	
	public static void main(String[] args) {
		
		PatientCaseController pcc = PatientCaseController.getInstance();
		
		int caseId = 1;
		String fromdate = "1999-07-07";
		String todate = "2016-07-07";
		String patientFirstname = "Patient";
		String patientLastName = "Muster";
		String anamnesis = "Patient Muster hat Schlafmangel";
		String diagnosis = "Patient Muster befindet sich in einer leichten Depression";
		
		pcc.upDateFromDate(fromdate, caseId);
		pcc.upDateToDate(todate, caseId);
		pcc.upDateName(patientFirstname, patientLastName, caseId);
		pcc.upDateAnamnesis(anamnesis , caseId);
		pcc.upDateDiagnosis(diagnosis, caseId);
		
        System.out.println("Name should be:" +patientFirstname+" "+patientLastName + "/n name is:" + pcc.getPersonName(caseId));
        System.out.println("/n anamnesis should be:" +anamnesis + "/n anamnesis is:" + pcc.getAnamnesis(caseId));
        System.out.println("diagnosis should be:" + diagnosis + "/n diagnosis is:" + pcc.getDiagnosis(caseId));
        System.out.println("entry date should be:" +fromdate + "/n entry date is:" + pcc.getFromDate(caseId));
        System.out.println("leaving date should be:" + todate + "/n leaving date is:" + pcc.getToDate(caseId));
        
    }

}
