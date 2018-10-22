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
	String joke;
	String content;
	String currentUser;
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

	/**
	 * This defines the parameters.
	 * @param userName - Ask for user name.
	 * @param userHowAreYou - Ask how user is.
	 * @param userFavoriteColor - Ask for color.
	 * @param userHobby - Ask for hobby.
	 * @param userFavoriteNumber - Ask for number.
	 * @param userOccupation - Ask for occupation.
	 */
	/*public ChatModel(String userName, String userHowAreYou, String userFavoriteColor, String userHobby, int userFavoriteNumber, String userOccupation)
	{
		this.name = userName;
		this.howAreYou = userHowAreYou;
		this.favoriteColor = userFavoriteColor;
		this.hobby = userHobby;
		this.favoriteNumber = userFavoriteNumber;
		this.occupation = userOccupation;
	}

	public String getName()
	{
		return name;
	}

	public String getFeeling()
	{
		return howAreYou;
	}

	public String getColor()
	{
		return favoriteColor;
	}

	public String getHobby()
	{
		return hobby;
	}

	public int getNumber()
	{
		return favoriteNumber;
	}

	public String getOccupation()
	{
		return occupation;
	}

	public void setName(String userName)
	{
		this.name = userName;
	}

	public void setFeeling(String userHowAreYou)
	{
		this.howAreYou = userHowAreYou;
	}

	public void setColor(String userFavoriteColor)
	{
		this.favoriteColor = userFavoriteColor;
	}

	public void setHobby(String userHobby)
	{
		this.hobby = userHobby;
	}

	public void setNumber(int userFavoriteNumber)
	{
		this.favoriteNumber = userFavoriteNumber;
	}

	public void setOccupation(String userOccupation)
	{
		this.occupation = userOccupation;
	}*/

}
