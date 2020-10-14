package sim.gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class Expertimentgui
{
	private static Getandsetchamps getandsetchamps = new Getandsetchamps();
	private static ChampSelect champselect = new ChampSelect(getandsetchamps);
	private static WhichChamp whichChamp = new WhichChamp();

	private static JFrame frame = new JFrame();
	private static JPanel ctpMainBackground;
	private static int imginewh = 70;

	public static JLabel lblAllyPlayer1;
	public static JLabel lblAllyPlayer5;
	public static JLabel lblAllyPlayer4;
	public static JLabel lblAllyPlayer3;
	public static JLabel lblAllyPlayer2;

	public static JLabel lblEnemyPlayer1;
	public static JLabel lblEnemyPlayer2;
	public static JLabel lblEnemyPlayer3;
	public static JLabel lblEnemyPlayer4;
	public static JLabel lblEnemyPlayer5;

	private static ArrayList<JLabel> gJLabels = new ArrayList<JLabel>();
	private static ArrayList<JLabel> gJLabels2 = new ArrayList<JLabel>();
	private static JTextArea champTextPane;
	private static JScrollPane champTextPaneSP;
	private static JLabel lblDiffLabel;
	private static JLabel lblChampLabel;
	private static JButton btnStopButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e)
		{
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					guiframe();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */

	public static void guiframe()
	{
		frame.setTitle("Simron GuideOutLoud");
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Expertimentgui.class.getResource("/sim/resources/Tryndamere_Poro_Icon.png")));
		initComponents();
		createEvents();
		// getandsetchamps.jlabelUpdate();
		frame.setVisible(true);
	}

	//////////////////////////////////////////////
	// Code for init components
	/////////////////////////////////////////////
	private static void initComponents()
	{
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>()
		{
			@Override
			protected Void doInBackground() throws Exception
			{
				champselect.lcuAPIChampSelect();
				return null;
			}
		};
		worker.execute();

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 592, 491);
		ctpMainBackground = new JPanel();
		ctpMainBackground.setBackground(UIManager.getColor("Button.background"));
		ctpMainBackground.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(ctpMainBackground);

		lblAllyPlayer5 = new JLabel("");
		lblAllyPlayer5.setForeground(Color.BLACK);
		lblAllyPlayer5.setBackground(SystemColor.desktop);
		lblAllyPlayer5.setIcon(new ImageIcon(
				new javax.swing.ImageIcon(Expertimentgui.class.getResource("/sim/resources/champs/none.png")).getImage()
						.getScaledInstance(imginewh, imginewh, Image.SCALE_SMOOTH)));

		lblAllyPlayer4 = new JLabel("");
		lblAllyPlayer4.setForeground(Color.BLACK);
		lblAllyPlayer4.setBackground(SystemColor.desktop);
		lblAllyPlayer4.setIcon(new ImageIcon(
				new javax.swing.ImageIcon(Expertimentgui.class.getResource("/sim/resources/champs/none.png")).getImage()
						.getScaledInstance(imginewh, imginewh, Image.SCALE_SMOOTH)));

		lblAllyPlayer3 = new JLabel("");
		lblAllyPlayer3.setForeground(Color.BLACK);
		lblAllyPlayer3.setBackground(SystemColor.desktop);
		lblAllyPlayer3.setIcon(new ImageIcon(
				new javax.swing.ImageIcon(Expertimentgui.class.getResource("/sim/resources/champs/none.png")).getImage()
						.getScaledInstance(imginewh, imginewh, Image.SCALE_SMOOTH)));

		lblAllyPlayer2 = new JLabel("");
		lblAllyPlayer2.setForeground(Color.BLACK);
		lblAllyPlayer2.setBackground(SystemColor.desktop);
		lblAllyPlayer2.setIcon(new ImageIcon(
				new javax.swing.ImageIcon(Expertimentgui.class.getResource("/sim/resources/champs/none.png")).getImage()
						.getScaledInstance(imginewh, imginewh, Image.SCALE_SMOOTH)));

		lblAllyPlayer1 = new JLabel("");
		lblAllyPlayer1.setForeground(Color.BLACK);
		lblAllyPlayer1.setBackground(SystemColor.desktop);
		lblAllyPlayer1.setIcon(new ImageIcon(
				new javax.swing.ImageIcon(Expertimentgui.class.getResource("/sim/resources/champs/none.png")).getImage()
						.getScaledInstance(imginewh, imginewh, Image.SCALE_SMOOTH)));

		JLabel lblAllyText = new JLabel("Your Team");
		lblAllyText.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblEnemyTeam = new JLabel("Enemy Team");
		lblEnemyTeam.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblEnemyPlayer1 = new JLabel("");
		lblEnemyPlayer1.setLabelFor(lblEnemyPlayer1);
		lblEnemyPlayer1.setForeground(Color.BLACK);
		lblEnemyPlayer1.setBackground(SystemColor.desktop);
		lblEnemyPlayer1.setIcon(new ImageIcon(
				new javax.swing.ImageIcon(Expertimentgui.class.getResource("/sim/resources/champs/none.png")).getImage()
						.getScaledInstance(imginewh, imginewh, Image.SCALE_SMOOTH)));

		lblEnemyPlayer2 = new JLabel("");
		lblEnemyPlayer2.setForeground(Color.BLACK);
		lblEnemyPlayer2.setBackground(SystemColor.desktop);
		lblEnemyPlayer2.setIcon(new ImageIcon(
				new javax.swing.ImageIcon(Expertimentgui.class.getResource("/sim/resources/champs/none.png")).getImage()
						.getScaledInstance(imginewh, imginewh, Image.SCALE_SMOOTH)));

		lblEnemyPlayer3 = new JLabel("");
		lblEnemyPlayer3.setForeground(Color.BLACK);
		lblEnemyPlayer3.setBackground(SystemColor.desktop);
		lblEnemyPlayer3.setIcon(new ImageIcon(
				new javax.swing.ImageIcon(Expertimentgui.class.getResource("/sim/resources/champs/none.png")).getImage()
						.getScaledInstance(imginewh, imginewh, Image.SCALE_SMOOTH)));

		lblEnemyPlayer4 = new JLabel("");
		lblEnemyPlayer4.setForeground(Color.BLACK);
		lblEnemyPlayer4.setBackground(SystemColor.desktop);
		lblEnemyPlayer4.setIcon(new ImageIcon(
				new javax.swing.ImageIcon(Expertimentgui.class.getResource("/sim/resources/champs/none.png")).getImage()
						.getScaledInstance(imginewh, imginewh, Image.SCALE_SMOOTH)));

		lblEnemyPlayer5 = new JLabel("");
		lblEnemyPlayer5.setForeground(Color.BLACK);
		lblEnemyPlayer5.setBackground(SystemColor.desktop);
		lblEnemyPlayer5.setIcon(new ImageIcon(
				new javax.swing.ImageIcon(Expertimentgui.class.getResource("/sim/resources/champs/none.png")).getImage()
						.getScaledInstance(imginewh, imginewh, Image.SCALE_SMOOTH)));

		champTextPane = new JTextArea();
		champTextPane.setEditable(false);
		champTextPane.setWrapStyleWord(true);
		champTextPane.setLineWrap(true);
		// champTextPane.setFocusable(false);
		// champTextPane.setOpaque(false);
		champTextPaneSP = new JScrollPane(champTextPane, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		lblDiffLabel = new JLabel("Difficulity");
		lblDiffLabel.setForeground(Color.BLACK);
		lblDiffLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblChampLabel = new JLabel("Champion");
		lblChampLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

		JButton btnReadButton = new JButton("Read it");

		btnStopButton_1 = new JButton("Stop");

		// lblNewLabel.setIcon(resizeble(lblNewLabel, "/sim/resources/none.jpg"));

		GroupLayout gl_ctpMainBackground = new GroupLayout(ctpMainBackground);
		gl_ctpMainBackground.setHorizontalGroup(
			gl_ctpMainBackground.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ctpMainBackground.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ctpMainBackground.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAllyPlayer5, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
						.addComponent(lblAllyPlayer4, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
						.addComponent(lblAllyPlayer3, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
						.addComponent(lblAllyPlayer2, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
						.addComponent(lblAllyPlayer1, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
						.addGroup(gl_ctpMainBackground.createSequentialGroup()
							.addGap(6)
							.addComponent(lblAllyText)))
					.addGroup(gl_ctpMainBackground.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_ctpMainBackground.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_ctpMainBackground.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_ctpMainBackground.createSequentialGroup()
									.addComponent(btnReadButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnStopButton_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addGap(192))
								.addGroup(gl_ctpMainBackground.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_ctpMainBackground.createSequentialGroup()
										.addGap(117)
										.addGroup(gl_ctpMainBackground.createParallelGroup(Alignment.LEADING)
											.addComponent(lblChampLabel, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
											.addGroup(gl_ctpMainBackground.createSequentialGroup()
												.addComponent(lblDiffLabel, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
												.addGap(2)))
										.addGap(131))
									.addComponent(champTextPaneSP, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)))
							.addGap(38)
							.addGroup(gl_ctpMainBackground.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnemyPlayer1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
								.addComponent(lblEnemyPlayer2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
								.addComponent(lblEnemyPlayer3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
								.addComponent(lblEnemyPlayer4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
								.addComponent(lblEnemyPlayer5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
						.addGroup(gl_ctpMainBackground.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEnemyTeam)))
					.addContainerGap())
		);
		gl_ctpMainBackground.setVerticalGroup(
			gl_ctpMainBackground.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ctpMainBackground.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_ctpMainBackground.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_ctpMainBackground.createSequentialGroup()
							.addComponent(lblEnemyTeam, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEnemyPlayer1, GroupLayout.PREFERRED_SIZE, 67, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(lblEnemyPlayer2, GroupLayout.PREFERRED_SIZE, 67, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(lblEnemyPlayer3, GroupLayout.PREFERRED_SIZE, 67, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(lblEnemyPlayer4, GroupLayout.PREFERRED_SIZE, 67, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(lblEnemyPlayer5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_ctpMainBackground.createSequentialGroup()
							.addGroup(gl_ctpMainBackground.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_ctpMainBackground.createSequentialGroup()
									.addComponent(lblChampLabel, GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblDiffLabel)
									.addGap(18)
									.addComponent(champTextPaneSP, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_ctpMainBackground.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnReadButton)
										.addComponent(btnStopButton_1)))
								.addGroup(gl_ctpMainBackground.createSequentialGroup()
									.addComponent(lblAllyText)
									.addGap(8)
									.addComponent(lblAllyPlayer1, GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(lblAllyPlayer2, GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblAllyPlayer3, GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblAllyPlayer4, GroupLayout.PREFERRED_SIZE, 71, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblAllyPlayer5, GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE)))
					.addContainerGap())
		);
		ctpMainBackground.setLayout(gl_ctpMainBackground);
	}

	//////////////////////////////////////////////
	// Code for creating events
	/////////////////////////////////////////////
	private static void createEvents()
	{
		lblEnemyPlayer1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String[] tem;
				if (lblEnemyPlayer1.getName() == null)
				{
					tem = whichChamp.getChampFromTSV("none");
				} else
				{
					tem = whichChamp.getChampFromTSV(lblEnemyPlayer1.getName());
				}
				lblChampLabel.setText(tem[0]);
				if (tem[1].equals("Easy"))
				{
					lblDiffLabel.setForeground(Color.GREEN);
				}
				;
				if (tem[1].equals("Medium"))
				{
					lblDiffLabel.setForeground(Color.BLUE);
				}
				;
				if (tem[1].equals("Hard"))
				{
					lblDiffLabel.setForeground(Color.RED);
				}
				;
				if (tem[1].equals("INTeresting"))
				{
					lblDiffLabel.setForeground(Color.MAGENTA);
				}
				;
				if (tem[1].equals("Trolling"))
				{
					lblDiffLabel.setForeground(Color.CYAN);
				}
				;
				if (tem[1].equals("Unknown"))
				{
					lblDiffLabel.setForeground(Color.DARK_GRAY);
				}
				;
				lblDiffLabel.setText(tem[1]);
				champTextPane.setText(tem[2]);
			}
		});

		lblEnemyPlayer2.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String[] tem;
				if (lblEnemyPlayer2.getName() == null)
				{
					tem = whichChamp.getChampFromTSV("none");
				} else
				{
					tem = whichChamp.getChampFromTSV(lblEnemyPlayer2.getName());
				}
				lblChampLabel.setText(tem[0]);
				if (tem[1].equals("Easy"))
				{
					lblDiffLabel.setForeground(Color.GREEN);
				}
				;
				if (tem[1].equals("Medium"))
				{
					lblDiffLabel.setForeground(Color.BLUE);
				}
				;
				if (tem[1].equals("Hard"))
				{
					lblDiffLabel.setForeground(Color.RED);
				}
				;
				if (tem[1].equals("INTeresting"))
				{
					lblDiffLabel.setForeground(Color.MAGENTA);
				}
				;
				if (tem[1].equals("Trolling"))
				{
					lblDiffLabel.setForeground(Color.CYAN);
				}
				;
				if (tem[1].equals("Unknown"))
				{
					lblDiffLabel.setForeground(Color.DARK_GRAY);
				}
				;
				lblDiffLabel.setText(tem[1]);
				champTextPane.setText(tem[2]);
			}
		});

		lblEnemyPlayer3.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String[] tem;
				if (lblEnemyPlayer3.getName() == null)
				{
					tem = whichChamp.getChampFromTSV("none");
				} else
				{
					tem = whichChamp.getChampFromTSV(lblEnemyPlayer3.getName());
				}
				lblChampLabel.setText(tem[0]);
				if (tem[1].equals("Easy"))
				{
					lblDiffLabel.setForeground(Color.GREEN);
				}
				;
				if (tem[1].equals("Medium"))
				{
					lblDiffLabel.setForeground(Color.BLUE);
				}
				;
				if (tem[1].equals("Hard"))
				{
					lblDiffLabel.setForeground(Color.RED);
				}
				;
				if (tem[1].equals("INTeresting"))
				{
					lblDiffLabel.setForeground(Color.MAGENTA);
				}
				;
				if (tem[1].equals("Trolling"))
				{
					lblDiffLabel.setForeground(Color.CYAN);
				}
				;
				if (tem[1].equals("Unknown"))
				{
					lblDiffLabel.setForeground(Color.DARK_GRAY);
				}
				;
				lblDiffLabel.setText(tem[1]);
				champTextPane.setText(tem[2]);
			}
		});

		lblEnemyPlayer4.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String[] tem;
				if (lblEnemyPlayer4.getName() == null)
				{
					tem = whichChamp.getChampFromTSV("none");
				} else
				{
					tem = whichChamp.getChampFromTSV(lblEnemyPlayer4.getName());
				}
				lblChampLabel.setText(tem[0]);
				if (tem[1].equals("Easy"))
				{
					lblDiffLabel.setForeground(Color.GREEN);
				}
				;
				if (tem[1].equals("Medium"))
				{
					lblDiffLabel.setForeground(Color.BLUE);
				}
				;
				if (tem[1].equals("Hard"))
				{
					lblDiffLabel.setForeground(Color.RED);
				}
				;
				if (tem[1].equals("INTeresting"))
				{
					lblDiffLabel.setForeground(Color.MAGENTA);
				}
				;
				if (tem[1].equals("Trolling"))
				{
					lblDiffLabel.setForeground(Color.CYAN);
				}
				;
				if (tem[1].equals("Unknown"))
				{
					lblDiffLabel.setForeground(Color.DARK_GRAY);
				}
				;
				lblDiffLabel.setText(tem[1]);
				champTextPane.setText(tem[2]);
			}
		});

		lblEnemyPlayer5.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String[] tem;
				if (lblEnemyPlayer5.getName() == null)
				{
					tem = whichChamp.getChampFromTSV("none");
				} else
				{
					tem = whichChamp.getChampFromTSV(lblEnemyPlayer5.getName());
				}
				lblChampLabel.setText(tem[0]);
				if (tem[1].equals("Easy"))
				{
					lblDiffLabel.setForeground(Color.GREEN);
				}
				;
				if (tem[1].equals("Medium"))
				{
					lblDiffLabel.setForeground(Color.BLUE);
				}
				;
				if (tem[1].equals("Hard"))
				{
					lblDiffLabel.setForeground(Color.RED);
				}
				;
				if (tem[1].equals("INTeresting"))
				{
					lblDiffLabel.setForeground(Color.MAGENTA);
				}
				;
				if (tem[1].equals("Trolling"))
				{
					lblDiffLabel.setForeground(Color.CYAN);
				}
				;
				if (tem[1].equals("Unknown"))
				{
					lblDiffLabel.setForeground(Color.DARK_GRAY);
				}
				;
				lblDiffLabel.setText(tem[1]);
				champTextPane.setText(tem[2]);
			}
		});
	}

	private ImageIcon resizeble(JLabel label, String ImginePath)
	{
		// Read the picture as a BufferedImage
		BufferedImage img = null;
		try
		{
			img = ImageIO.read(Expertimentgui.class.getResource(ImginePath));
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		// Resize the BufferedImage
		Image dimg = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);

		// Create an ImageIcon
		ImageIcon imageIcon = new ImageIcon(dimg);
		return imageIcon;

	}

	public int getImginewh()
	{
		return imginewh;
	}

	public JLabel getLblAllyPlayer1()
	{
		return lblAllyPlayer1;
	}

	public JLabel getLblAllyPlayer5()
	{
		return lblAllyPlayer5;
	}

	public JLabel getLblAllyPlayer4()
	{
		return lblAllyPlayer4;
	}

	public JLabel getLblAllyPlayer3()
	{
		return lblAllyPlayer3;
	}

	public JLabel getLblAllyPlayer2()
	{
		return lblAllyPlayer2;
	}

	public static ArrayList<JLabel> getgJLabels()
	{
		return gJLabels;
	}

	public static ArrayList<JLabel> getgJLabels2()
	{
		return gJLabels2;
	}
}
