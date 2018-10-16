package chat.controller.main;

import javax.swing.JOptionPane;

public class ChatController
{

	public void start()
	{
		//guiPrompt();
		quit();
	}

	public void guiPrompt()
	{

	}

	public  void quit()
	{
		String userInput = "";
		while (!userInput.equals("quit"))
		{
			userInput = JOptionPane.showInputDialog(null, "zac is a coolcat");
		}
	}

}
