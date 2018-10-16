package chat.controller.model;

public class ChatModel
{

	/**
	 * These are the variables I will be using
	 * to call for the user to input responses and
	 * the chat robot will respond back.
	 */

	//Ask for name, ask how the user is doing, favorite color, ask for a hobby, favorite number, and what would you like to be in the future.

	String name;
	String howAreYou;
	String favoriteColor;
	String hobby;
	int favoriteNumber;
	String occupation;


	public ChatModel()
	{

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
	public ChatModel(String userName, String userHowAreYou, String userFavoriteColor, String userHobby, int userFavoriteNumber, String userOccupation)
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
	}

























}
