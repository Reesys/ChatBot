package chat.controller;

import javax.swing.JOptionPane;

import chat.model.Chatbot;
import chat.view.ChatFrame;

public class ChatController
{
	private ChatFrame appFrame;
	private Chatbot simpleBot;

	public ChatController()
	{
		simpleBot = new Chatbot();
		appFrame = new ChatFrame(this);
	}

	public void start()
	{

	}

	public String useChatbotCheckers(String text)
	{
		String testedValues = "The following checkers passed: ";
		if(simpleBot.contentChecker(text))
		{
			testedValues += "\nContent Checker";
		}
		if(simpleBot.spookyChecker(text))
		{
			testedValues += "\nSpooky Checker Happy Halloween";
		}
		if(simpleBot.legitimacyChecker(text))
		{
			testedValues += "\nValidityCheker";
		}

		return testedValues;

		/*boolean isValid = false;

		if(text.contains("spooky"))
		{
			isValid = true;
		}*/

	}

	public void handleErrors(Exception error)
	{
		JOptionPane.showMessageDialog(appFrame, error.getMessage());
	}

	public String interactWithChatbot(String text)
	{
		String output = "";
		//String userResponse = JOptionPane.showInputDialog(null, "Hi whats up??");
		output += simpleBot.processText(text);

		return output;
	}

	public void handleerrors(Exception error)
	{
		JOptionPane.showMessageDialog(appFrame, error.getMessage());
	}

	public Chatbot getChatbot()
	{
		return simpleBot;
	}

}
