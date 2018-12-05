package chat.view;

import javax.swing.JFrame;

import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController appController;
	private ChatPanel appPanel;

	public ChatFrame(ChatController appController)
	{
		super();

		this.appController = appController;
		this.appPanel = new ChatPanel(appController);

		setupFrame();
	}

	public void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("ChatBot Project!");
		this.setSize(800, 800);
		this.setResizable(false);
		this.setVisible(true);
	}
}
