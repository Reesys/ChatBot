package chat.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;

	public ChatPanel(ChatController appController)
	{
		super();

		this.appController = appController;
		appLayout = new SpringLayout();

		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Check Text");

		chatField = new JTextField("Talk to bot here", 50);
		chatArea = new JTextArea("Chat Area", 20, 50);
		chatPane = new JScrollPane();

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

	public void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(new Color(0, 153, 204));
		this.add(chatPane);
		this.add(chatButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(checkerButton);
		this.add(chatField);
	}

	public void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 92, SpringLayout.EAST, loadButton);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 92, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 92, SpringLayout.EAST, checkerButton);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 92, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, 88, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, 87, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, 88, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 35, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 35, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 35, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 35, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, 88, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 414, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatPane, -30, SpringLayout.NORTH, chatField);
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
				String path = "";
				IOController.saveText(appController, path, chatText);
				chatArea.setText("Chat Saved!");
			}
		});


	}

}
