package chat.model;

import java.util.ArrayList;

public class Chatbot
{

	/**
	 * These are the variables I will be using
	 * to call for the user to input responses and
	 * the chat robot will respond back.
	 */

	//********************//
	private String joke;
	private String content;
	private String currentUser;
	//********************//

	//Ask for name, ask how the user is doing, favorite color, ask for a hobby, favorite number, and what would you like to be in the future.

	/*String name;
	String howAreYou;
	String favoriteColor;
	String hobby;
	int favoriteNumber;
	String occupation;*/

	private ArrayList<String> responseList;
	private ArrayList<String> spookyList;

	public Chatbot()
	{
		this.joke = "Sticks float, they would.";
		this.content = new String("Something else.");
		this.currentUser = new String("big laugh");

		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();

		buildTheLists();
	}

	public boolean legitimacyChecker(String test)
	{
		boolean legit = true;

		if(test == null)
		{
			legit = false;
		}
		else if (test.length() < 2)
		{
			legit = false;
		}
		else if (test.contains("sdf") || test.contains("cvb"))
		{
			legit = false;
		}

		return legit;
	}

	public Chatbot(String string)
	{
		content = "sample content";
	}

	public boolean spookyChecker(String input)
	{
		boolean random = false;

		if(input.contains("Halloween"))
		{
			random = true;
		}
		else
		{
			random = false;
		}

		for(String spookyString: spookyList)
		{
			if(input.contains(spookyString))
			{
				random = true;
			}
		}
		return random;
	}

	public boolean contentChecker(String userText)
	{
		if(userText.contains("text" + content + "text"))
		{
			return false;
		}
		else if(userText.contains(content + "text"))
		{
			return false;
		}
		else if(userText.contains("text" + content))
		{
			return false;
		}
		else if(userText.contains(content))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private void buildTheLists()
	{
		responseList.add("Hello I am not Kim Jong Un.");
		responseList.add("What is your favourite movie?");
		responseList.add("You're just boring.");
		responseList.add("Scooby doo is the best animated show!");
		responseList.add("I like Snoopy.");
		responseList.add("Have you seen cat in the hat?");
		responseList.add("Do you like pizza?");
		responseList.add("Which do you prefer Minecraft or Fortnite?");
		responseList.add("School is an okay place, but I prefer walmart.");
		responseList.add("I like roblox.");
		responseList.add("Lebron james.");
		responseList.add("Do you like the big bang theory?");
		responseList.add("Cat in the Hat");
		responseList.add("Woof woof.");
		responseList.add("Big wow. ;)");
		responseList.add("Runescape is fun.");
		responseList.add("Hello");

		spookyList.add("Halloween");
		spookyList.add("Boo! Scared yuh didn't I?");
		spookyList.add("What's your favourite scary movie?");
		spookyList.add("Do you like Werewolfs");
		spookyList.add("What are you dressing up for this Halloween?");
		spookyList.add("What's your favourite candy?");
		spookyList.add("Have you seen the Nightmare Before Christmas?");
		spookyList.add("Boo!");
		spookyList.add("Happy halloween!");
		spookyList.add("Want to carve some pumpkins?");
	}

	public String processText(String userText)
	{
		int randomIndex = (int)(Math.random() * responseList.size());

		String answer = "";

		answer += "You said: " + userText + ". Chatbot says: " + responseList.get(randomIndex);

		if(userText != null && userText.contains(content))
		{
			answer = answer + "You said the special words";
		}

		return answer;
	}

	public ArrayList<String> getResponseList()
	{
		return responseList;
	}

	public ArrayList<String> getSpookyList()
	{
		return spookyList;
	}

	public String getCurrentUser()
	{
		return currentUser;
	}

	public String getContent()
	{
		return content;
	}

	public void setCurrentUser()
	{
		this.currentUser = currentUser;
	}

	public void setContent()
	{
		this.content = content;
	}

}
