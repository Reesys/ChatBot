package chat.controller;

import javax.swing.JOptionPane;

import chat.model.Chatbot;
import chat.view.ChatFrame;

public class ChatController
{
	private ChatFrame appFrame;
	private Chatbot simpleBot;

	public void Chatbot()
	{
		simpleBot = new Chatbot();
		appFrame = new ChatFrame(this);
	}

	public void start()
	{
		quit();
	}

	public void useChatbotCheckers(String text)
	{
		boolean isValid = false;

		if(text.contains("spooky"))
		{
			isValid = true;
		}

	}

	public void quit()
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
