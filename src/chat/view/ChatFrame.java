package chat.view;

import javax.swing.JFrame;

import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController app;
	private ChatPanel appPanel;

	public ChatFrame(ChatController app)
	{
		super();

		this.app = app;
		this.appPanel = new ChatPanel(app);

		setupFrame();
	}

	public void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("ChatBot Project!");
		this.setSize(1024, 760);
		this.setResizable(false);
		this.setVisible(true);
	}
}
