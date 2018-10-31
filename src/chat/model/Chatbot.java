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

	public boolean testChatController(String test)
	{
		return false;
	}

	public boolean testSpookyChecker(String test)
	{
		if(test.contains("Halloween"))
		{
			return true;
		}else if(test.contains("Spooky"))
		{
			return true;
		}else
		{
			return false;
		}

		for(String spookyList; spookyList++)
		{
			if(test.contains(Spooky String))
			{

			}
		}
	}

	private void buildTheLists()
	{
		responseList.add("Hi I am not Kim Jong Un.");
		responseList.add("What is your favourite movie?");
		responseList.add("You're just boring.");
		responseList.add("Scooby doo is the best animated show!");
		responseList.add("I like Snoopy.");
		responseList.add("Have you seen cat in the hat?");
		responseList.add("Do you like pizza?");
		responseList.add("Which do you prefer Minecraft or Fortnite?");
		responseList.add("School is an okay place, but I prefer walmart.");
		responseList.add("I like roblox.");

		spookyList.add("Boo! Scared yuh didn't I?");
		spookyList.add("What's your favourite scary movie?");
		spookyList.add("Do you like Werewolfs");
		spookyList.add("What are you dressing up for this Halloween?");
		spookyList.add("What's your favourite candy?");
		spookyList.add("Have you seen the Nightmare Before Christmas?");
	}

	public String processText(String userText)
	{
		String answer = "";

		answer += "You said: " + userText;

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

}
