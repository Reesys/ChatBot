package chat.controller;

import javax.swing.JOptionPane;

import chat.model.Chatbot;

public class ChatController
{

	private Chatbot simpleBot;

	public void Chatbot()
	{
		simpleBot = new Chatbot();
	}

	public void start()
	{
		quit();
	}

	public  void quit()
	{
		String userInput = "";
		while (!userInput.equals("quit"))
		{
			userInput = JOptionPane.showInputDialog(null, "zac is a coolcat");
		}
	}

	public String interactWithChatbot(String text)
	{
		String output = "";
		String userResponse = JOptionPane.showInputDialog(null, "Hi whats up??");
		output = simpleBot.processText(userResponse);

		return output;
	}

	public Chatbot getChatbot()
	{
		return simpleBot;
	}

}
