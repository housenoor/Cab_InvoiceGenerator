package com.bridgelabz;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CensusAnalyserTest {
	private Assertions Assert;

	ReadOperation readObj = new ReadOperation();
	String fileName = "IndiaStateCensusData";

	@Test
	public void givenStateCensusCSVFileCorrect_EnsureNumberOfRecordsMatch() throws CensusException {
		String filePathRead = "C:\\Users\\admin\\IdeaProjects\\IndianStatesCensusAnalyser\\IndianStateCensusData";
		try {
			int count = readObj.readDataCount(filePathRead, fileName);
			Assert.assertEquals(29, count);
		} catch (CensusException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenStateCensusCSVFile_WhenFileNameIncorrectShouldThrowException() {
		String filePathRead = "C:\\Users\\admin\\IdeaProjects\\IndianStatesCensusAnalyser\\IndianStateCensusData";

		try {
			int count = readObj.readDataCount(filePathRead, fileName);
			Assert.assertEquals(29, count);
		} catch (CensusException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenStateCensusCSVFile_WhenFileTypeIncorrectShouldThrowException() {
		String filePathRead = "C:\\Users\\admin\\IdeaProjects\\IndianStatesCensusAnalyser\\IndianStateCensusData";
		try {
			int count = readObj.readDataCount(filePathRead, fileName);
			Assert.assertEquals(29, count);
		} catch (CensusException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenStateCensusCSVFileCorrect_ButDelimiterIncorrectShouldThrowException() {
		String filePathRead = "C:\\Users\\admin\\IdeaProjects\\IndianStatesCensusAnalyser\\IndianStateCensusData";
		String delimiter = ".";
		try {
			if (delimiter.equals(","))
				Assert.assertTrue(readObj.readDelimiter(filePathRead, delimiter));
			else
				Assert.assertFalse(readObj.readDelimiter(filePathRead, delimiter));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenStateCensusCSVFileCorrect_ButHeaderIncorrectShouldThowException() {
		List<String> stringName = new ArrayList<>();
		String filePathRead = "C:\\Users\\Dell\\java\\Indian States Census\\IndiaStateCensusData.csv";
		stringName.add("State");
		stringName.add("Population");
		stringName.add("AreaInSqKm");
		stringName.add("Density");

		try {
			boolean flag = readObj.readHeader(filePathRead, stringName);
			if (flag == true)
				Assert.assertTrue(flag);
			else
				Assert.assertFalse(flag);
		} catch (IOException | CensusException e) {
			e.printStackTrace();
		}
	}
}