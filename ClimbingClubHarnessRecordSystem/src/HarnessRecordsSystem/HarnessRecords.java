package HarnessRecordsSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HarnessRecords {
	public static int MAKE_INDEX = 0;
	public static int MODEL_NUMBER_INDEX = 1;
	public static int TIMES_USED_INDEX = 2;
	public static int CHECKED_BY_INDEX = 3;
	public static int ON_LOAN_INDEX = 4;
	public static int BORROWER_INDEX = 5;
	
	private ArrayList<Harness>harnessRecord;
	
	HarnessRecords(){
		harnessRecord=null;
	}
	HarnessRecords(String inputStreamAddress){
		try {
			FileReader fileR = new FileReader(inputStreamAddress);
			BufferedReader buffR = new BufferedReader(fileR);
			boolean endOfFile = false;
			while(!endOfFile){
        		String line = buffR.readLine();
        		if (line != null) {
        			String[] harnessData = line.split(",");
        			String make = harnessData[MAKE_INDEX];
        			int modelNumber = Integer.parseInt (harnessData[MODEL_NUMBER_INDEX]);
        			int timesUsed = Integer.parseInt (harnessData[TIMES_USED_INDEX]);
        			String checkedBy = harnessData[CHECKED_BY_INDEX];
        			boolean onLoan = Boolean.parseBoolean(harnessData[ON_LOAN_INDEX ]);
        			String borrower = harnessData[BORROWER_INDEX];
        			Harness harness = new Harness(make, modelNumber, timesUsed, checkedBy, onLoan, borrower);
        			harnessRecord.add(harness);
        		} 
        		else {
        			endOfFile = true;
        		}
        	}
        buffR.close();    
        fileR.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	boolean isEmpty(){
		boolean isEmpty = false;
		for (int index=0; index<harnessRecord.size() || isEmpty==true; index++) {
			if (harnessRecord.get(index)==null) {
				isEmpty=true;
			}
		}
		return isEmpty;
	}
	void addHarness(Harness harness) {
		harnessRecord.add(harness);
	}
	Harness findHarness(String make, int modelNumber){
		boolean found = false;
		int index = 0;
		Harness harness = null;
		
		while(!found && index < harnessRecord.size())
		{
			harness = harnessRecord.get(index);
			if((make == harness.getMake()) && (modelNumber == harness.getModelNumber())){
				return harness;
			}
			else
			{
				index++;
			}
		}
		return null;
	}
	Harness checkHarness(String instructor, String make, int modelNumber){
		Harness HarnessToBeChecked = findHarness(make, modelNumber);
		if (HarnessToBeChecked!=null) {
			HarnessToBeChecked.checkHarrness(instructor);
			return HarnessToBeChecked;		
		}
		else {
			return null;
		}
	}
	Harness loanHarness(String borrower){
		boolean finished = false;
		int index=0;
		Harness lending=null;
		while(!finished) {
			if (harnessRecord.get(index).canHarnessBeLoaned()) {
				lending = harnessRecord.get(index);
				lending.loanHarness(borrower);
				finished=true;
			}
			else if (index==harnessRecord.size()-1) {
				finished = true;
			}
			else {
				index++;
			}
		}
		return lending;
	}
	Harness returnHarness(String make, int modelNumber){
		Harness HarnessToBeReturn = findHarness(make, modelNumber);
		if (HarnessToBeReturn!=null) {
			HarnessToBeReturn.returnHarness();
			return HarnessToBeReturn;		
		}
		else {
			return null;
		}
	}
	Harness removeHarness(String make, int modelNumber){
		Harness HarnessToBeRemove = findHarness(make, modelNumber);
		if (HarnessToBeRemove!=null) {
			harnessRecord.remove(HarnessToBeRemove);
			return HarnessToBeRemove;		
		}
		else {
			return null;
		}
	}
	void printHarnessRecords() {
		for(int index = 0; index < harnessRecord.size(); index++)
		{
			Harness details = harnessRecord.get(index);
			System.out.println(index+1 + " - "+details.toString());
		}
	}
}
