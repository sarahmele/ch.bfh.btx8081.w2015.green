package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.sql.Date;

public class PatientCaseControllerTest {
	
	public static void main(String[] args) {
		
		PatientCaseController pcc = PatientCaseController.getInstance();
		
		int caseId = 1;
		Date fromdate = java.sql.Date.valueOf( "2010-01-31" );
		Date todate = java.sql.Date.valueOf( "2010-01-31" );
		String patientFirstname = "Patient";
		String patientLastName = "Muster";
		String anamnesis = "Patient Muster hat Schlafmangel";
		String diagnosis = "Patient Muster befindet sich in einer leichten Depression";
		
		pcc.upDateFromDate(fromdate, caseId);
		pcc.upDateToDate(todate, caseId);
		pcc.upDateName(patientFirstname, patientLastName, caseId);
		pcc.upDateAnamnesis(anamnesis , caseId);
		pcc.upDateDiagnosis(diagnosis, caseId);
		
		String newLine = System.getProperty("line.separator");
		
        System.out.println(newLine+"Name should be:" +patientFirstname+" "+patientLastName + newLine+ "-> name is:" + pcc.getPersonName(caseId));
        System.out.println(newLine+"anamnesis should be:" +anamnesis + newLine+ "-> anamnesis is:" + pcc.getAnamnesis(caseId));
        System.out.println(newLine+"diagnosis should be:" + diagnosis + newLine+"-> diagnosis is:" + pcc.getDiagnosis(caseId));
        System.out.println(newLine+"entry date should be:" +fromdate + newLine+"-> entry date is:" + pcc.getFromDate(caseId));
        System.out.println(newLine+"leaving date should be:" + todate +newLine+ "-> leaving date is:" + pcc.getToDate(caseId));
        
    }

}
