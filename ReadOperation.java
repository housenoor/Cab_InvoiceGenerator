package com.bridgelabz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class ReadOperation {
	public int readDataCount(String filePathRead, String fileNameUser) throws CensusException {
		AtomicBoolean firstLine = new AtomicBoolean(true);
		AtomicInteger count = new AtomicInteger();

		try {
			File file = new File(filePathRead);
			String fileName = file.getName();
			String fileNameWithoutExtension = " ";
			int pos = fileName.lastIndexOf(".");
			if (pos > 0 && pos < (fileName.length() - 1)) {
				fileNameWithoutExtension = fileName.substring(0, pos);
			}

			if (!fileNameWithoutExtension.equals(fileNameUser)) {
				throw new CensusException("Please enter a proper file name!",
						CensusException.Message.IMPROPER_FILE_NAME);
			}

			if (!fileName.contains(".csv"))
				throw new CensusException("Please enter a proper file type!",
						CensusException.Message.IMPROPER_FILE_TYPE);

			Files.lines(Paths.get(filePathRead)).forEach(lines -> {
				if (lines.startsWith("State"))
					firstLine.set(false);
				else {
					lines.split("\n");
					count.getAndIncrement();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(String.valueOf(count));
	}

	/**
	 * Purpose : Check whether the delimiter entered in correct or not If false,
	 * return Customized Exception
	 *
	 * @param filePath
	 * @param delimiter
	 * @return
	 */
	public boolean readDelimiter(String filePath, String delimiter) throws IOException {
		Scanner input = new Scanner(Paths.get(filePath));
		boolean flag = true;
		try {
			input.useDelimiter(",");
			Pattern result = input.delimiter();

			if (result.pattern().equals(delimiter))
				flag = true;
			else {
				flag = false;
				throw new CensusException("Please enter a correct delimiter!",
						CensusException.Message.IMPROPER_DELIMITER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean readHeader(String filePath, List<String> stringName) throws IOException, CensusException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));

		// Reading header
		String line = br.readLine();
		String[] header = line.split(",");
		boolean flag = true;
		for (int i = 0; i < header.length && i < stringName.size(); i++) {
			if (stringName.get(i).equals(header[i]))
				flag = true;
			else {
				flag = false;
				throw new CensusException("Please enter the correct header!", CensusException.Message.IMPROPER_HEADER);
			}
		}
		return flag;
	}
}