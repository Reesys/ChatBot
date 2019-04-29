package chat.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chat.controller.ChatController;
import chat.controller.IOController;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private SpringLayout appLayout;


	private JButton chatButton;
	private JButton resetButton;
	private JButton checkerButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton tweetButton;
	private JButton searchTwitterButton;


	private ImageIcon saveIcon;
	private ImageIcon loadIcon;
	private ImageIcon chatIcon;
	private ImageIcon checkerIcon;
	private ImageIcon tweetIcon;
	private ImageIcon searchIcon;


	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JPanel buttonPanel;

	public ChatPanel(ChatController app)
	{
		super();

		this.appController = app;
		appLayout = new SpringLayout();

		saveIcon = new ImageIcon(getClass().getResource("/chat/view/images/save.png"));
		loadIcon = new ImageIcon(getClass().getResource("/chat/view/images/load.png"));
		chatIcon = new ImageIcon(getClass().getResource("/chat/view/images/chat.png"));
		checkerIcon = new ImageIcon(getClass().getResource("/chat/view/images/check.png"));
		tweetIcon = new ImageIcon(getClass().getResource("/chat/view/images/tweet.png"));
		searchIcon = new ImageIcon(getClass().getResource("/chat/view/images/searchTwitter.png"));
		loadButton = new JButton("Load", loadIcon);
		chatButton = new JButton("Chat", chatIcon);
		checkerButton = new JButton("Check Text", checkerIcon);
		tweetButton = new JButton("Send Tweet", tweetIcon);
		searchTwitterButton = new JButton("Search Twitter", searchIcon);

		chatField = new JTextField("Talk to bot here", 50);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatField, -50, SpringLayout.EAST, this);
		chatArea = new JTextArea("Chat Area", 20, 50);
		chatPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.SOUTH, chatPane, -384, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 30, SpringLayout.SOUTH, chatPane);

		buttonPanel = new JPanel(new GridLayout(1, 0));
		appLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 51, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.EAST, buttonPanel, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, buttonPanel, 0, SpringLayout.WEST, chatPane);

		setupButtonPanel();
		setupScrollPane();
		setupPanel();
		setupListeners();
		setupLayout();
	}

	public void setupScrollPane()
	{
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(false);
		chatPane.setViewportView(chatArea);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	private void setupButtonPanel()
	{

		saveButton = new JButton("Save", saveIcon);
		buttonPanel.add(saveButton);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 27, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 94, SpringLayout.WEST, this);
		buttonPanel.add(loadButton);
		buttonPanel.add(chatButton);
		buttonPanel.add(checkerButton);
		buttonPanel.add(tweetButton);
		buttonPanel.add(searchTwitterButton);
	}

	public void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(1024, 768));
		this.setBackground(new Color(0, 153, 204));
		buttonPanel.setPreferredSize(new Dimension(900, 150));
		buttonPanel.setBackground(Color.GREEN);
		this.add(buttonPanel);
		this.add(chatPane);
		this.add(chatField);
	}

	private String getPath(String choice)
	{
		String path = ".";
		int result = -99;
		JFileChooser fileChooser = new JFileChooser();
		if (choice.equals("save"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			result = fileChooser.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getCurrentDirectory().getAbsolutePath();
			}
		}
		else
		{
			result = fileChooser.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getSelectedFile().getAbsolutePath();
			}
		}

		return path;
	}

	public void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
	}

	public void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				String input = chatField.getText();
				String output = "";
				output = appController.interactWithChatbot(input);
				chatArea.append(output);
				chatField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}

		});

		saveButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{

				String chatText = chatArea.getText();
				String path = ".";
				IOController.saveText(appController, path, chatText);
				chatArea.setText("Chat Saved!");
			}
		});

		loadButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{

			}
		});

		tweetButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent tweetClick)
			{
				String textToTweet = chatField.getText().trim();
				appController.tweet(textToTweet);
			}
		});
	}

}
