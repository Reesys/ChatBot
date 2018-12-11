package chat.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class IOController
{
	public static void saveText(ChatController app, String path, String textToSave)
	{
		try
		{
			String filename = path;
			Calendar date = Calendar.getInstance();
			filename += "/" + date.get(Calendar.MONTH) + " " + date.get(Calendar.DAY_OF_MONTH); //This get's the day and month.
			filename += date.get(Calendar.HOUR) + "-" + date.get(Calendar.MINUTE); //This get's hour and minutes.
			filename += " chatbot save.txt";

			/*
			 * This saves the Text.
			 */
			File saveFile = new File(filename);
			Scanner textScanner = new Scanner(textToSave);
			PrintWriter saveText = new PrintWriter(saveFile);

			/*
			 * Scans the Text.
			 */
			while(textScanner.hasNext())
			{
				String currentLine = textScanner.nextLine();
				saveText.println(currentLine);
			}

			textScanner.close();
			saveText.close();

		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		catch(Exception genericError)
		{
			app.handleErrors(genericError);
		}

	}

	public static String loadFile(ChatController app, String path)
	{
		String contents = "";

		try
		{
			File saveFile = new File(path);
			Scanner fileScanner;
			if(saveFile.exists())
			{
				fileScanner = new Scanner(saveFile);
				while (fileScanner.hasNext())
				{
					contents += fileScanner.nextLine() + "\n";
				}
			}
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		catch(Exception genericError)
		{
			app.handleErrors(genericError);
		}
		return contents;
	}
}
