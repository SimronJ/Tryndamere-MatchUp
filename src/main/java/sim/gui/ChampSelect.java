package sim.gui;

import com.stirante.lolclient.ClientApi;
import com.stirante.lolclient.ClientConnectionListener;
import com.stirante.lolclient.ClientWebSocket;

import generated.LolChampSelectChampSelectPlayerSelection;
import generated.LolChampSelectChampSelectSession;
import generated.LolPerksPerkPageResource;
import generated.LolSummonerSummoner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ChampSelect
{
	private WhichChamp whichChamp = new WhichChamp();
	private Getandsetchamps getandsetchamps = new Getandsetchamps();

	private ClientWebSocket socket;

	ArrayList<Integer> allyclone = new ArrayList<Integer>();
	private LolPerksPerkPageResource[] runePages;

	public ChampSelect(Getandsetchamps getandsetchamps2)
	{
		getandsetchamps = getandsetchamps2;
	}

	/**
	 * Simple example showing how to receive websocket events from client
	 */
	volatile int tempchamp, tempchamp2;

	public void lcuAPIChampSelect() throws Exception
	{
		// Initialize API
		ClientApi api = new ClientApi();
		//Check if user is logged in
//        if (!api.isAuthorized()) {
//            System.out.println("Not logged in!");
//        }
//        
		api.addClientConnectionListener(new ClientConnectionListener()
		{
			@Override
			public void onClientConnected()
			{
				System.out.println("Client connected");
				try
				{
					
					
					// save current summoner display
					String summonerName = api.executeGet("/lol-summoner/v1/current-summoner",
							LolSummonerSummoner.class).displayName;

					System.out.println("Current-SummonerDisplayName: " + summonerName);
					
					//LolPerksPerkPageResource conqueror = new LolPerksPerkPageResource();
					
					try
					{
						 runePages = api.executeGet("/lol-perks/v1/pages", LolPerksPerkPageResource[].class);
						for (int i = 0; i < runePages.length; i++)
						{
							if (runePages[i].isEditable)
							{
//								System.out.println(i+ ": " + runePages[i].name);
//								System.out.println(runePages[i].order);
//								System.out.println(runePages[i].primaryStyleId); 
//								System.out.println(runePages[i].selectedPerkIds);
//								System.out.println(runePages[i].subStyleId);
								getandsetchamps.comboxUpdate(runePages[i].name);
							}
						}

					} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// open web socket
					socket = api.openWebSocket();
					// add event handler, which prints every received event
					socket.setSocketListener(new ClientWebSocket.SocketListener()
					{
						@Override
						public void onEvent(ClientWebSocket.Event event)
						{
							if (event.getUri().equalsIgnoreCase("/lol-champ-select/v1/session"))
							{
								LolChampSelectChampSelectSession session = (LolChampSelectChampSelectSession) event
										.getData();

								ListIterator<LolChampSelectChampSelectPlayerSelection> allyteam = session.myTeam
										.listIterator();
								allyteam.forEachRemaining(player ->
								{
									System.out.println(player.cellId + "Team:" + player.team + " Ally Champ:"
											+ whichChamp.champname(player.championId));

//									if (player.team == 1)
//									{
										if (tempchamp != player.championId)
										{
											getandsetchamps.getAllyarray().add(player.championId);
											tempchamp = player.championId;
										}
//									}
								});
								getandsetchamps.jlabelUpdate(0);
								getandsetchamps.getAllyarray().clear();

								ListIterator<LolChampSelectChampSelectPlayerSelection> enemyteam = session.theirTeam
										.listIterator();
								enemyteam.forEachRemaining(player ->
								{
									System.out.println(player.cellId + "Team:" + player.team + " Enemy Champ:"
											+ whichChamp.champname(player.championId));
//									if (player.team == 2)
//									{
										if (tempchamp2 != player.championId)
										{
											getandsetchamps.getEnemyarray().add(player.championId);
											tempchamp2 = player.championId;
										}
//									}
								});
								getandsetchamps.jlabelUpdate(1);
								getandsetchamps.getEnemyarray().clear();
							}
						}

						@Override
						public void onClose(int code, String reason)
						{
							System.out.println("Socket closed, reason: " + reason);
						}
					});
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}

			@Override
			public void onClientDisconnected()
			{
				System.out.println("Client disconnected");
				socket.close();
			}
		});
		// close socket when user enters something into console
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		reader.readLine();
		api.stop();
		socket.close();
	}

	public void setrunes(int getRunePage, String typeOfRune)
	{
		List<Integer> conPerkIds = Arrays.asList(8010, 9111, 9103, 8299, 8275, 8210, 5005, 5008, 5002);
		List<Integer> lethalPerkIds = Arrays.asList(8008, 9111, 9103, 8299, 8275, 8210, 5005, 5008, 5002);
		List<Integer> fleetPerkIds = Arrays.asList(8021, 9111, 9104, 8299, 8446, 8444, 5005, 5008, 5002);
		List<Integer> grapsPerkIds = Arrays.asList(8437, 8446, 8444, 8453, 9111, 9104, 5005, 5008, 5002);
		
		// Initialize API
				ClientApi api = new ClientApi();
				api.addClientConnectionListener(new ClientConnectionListener()
				{
					@Override
					public void onClientConnected()
					{
						try
						{
							runePages = api.executeGet("/lol-perks/v1/pages", LolPerksPerkPageResource[].class);
							for (int i = 0; i < runePages.length; i++)
							{
								if (runePages[i].isEditable)
								{
									getandsetchamps.comboxUpdate(runePages[i].name);
								}
							}
							
							LolPerksPerkPageResource modifiedRune = runePages[getRunePage];
							
							if(typeOfRune.equalsIgnoreCase("Lethal Tempo Runes"))
							{
								modifiedRune.name = "Trynd Lethal: SimGUI";
								modifiedRune.primaryStyleId = 8000;
								modifiedRune.selectedPerkIds = lethalPerkIds;
								modifiedRune.subStyleId = 8200;
							}
							if(typeOfRune.equalsIgnoreCase("Fleet Footwork Runes"))
							{
								modifiedRune.name = "Trynd Fleet: SimGUI";
								modifiedRune.primaryStyleId = 8000;
								modifiedRune.selectedPerkIds = fleetPerkIds;
								modifiedRune.subStyleId = 8400;
							}
							if(typeOfRune.equalsIgnoreCase("Conqueror Runes"))
							{
								modifiedRune.name = "Trynd Conqueror: SimGUI";
								modifiedRune.primaryStyleId = 8000;
								modifiedRune.selectedPerkIds = conPerkIds;
								modifiedRune.subStyleId = 8200;
							}
							if(typeOfRune.equalsIgnoreCase("Grasp Runes"))
							{
								modifiedRune.name = "Trynd Grasp: SimGUI";
								modifiedRune.primaryStyleId = 8400;
								modifiedRune.selectedPerkIds = grapsPerkIds;
								modifiedRune.subStyleId = 8000;
							}
					            
							api.executeDelete("/lol-perks/v1/pages/" + runePages[getRunePage].id);
							System.out.println(runePages[getRunePage].name + " Deleted!");

							api.executePost("/lol-perks/v1/pages", modifiedRune);
							System.out.println(runePages[getRunePage].name + " Posted!");
							
//							api.executePut("/lol-perks/v1/pages/" + runePages[getRunePage].id, modifiedRune);
//							System.out.println(runePages[getRunePage].name + " Updated!");
							
							runePages = api.executeGet("/lol-perks/v1/pages", LolPerksPerkPageResource[].class);
							getandsetchamps.deleteComboxItem();
							for (int i = 0; i < runePages.length; i++)
							{
								if (runePages[i].isEditable)
								{
									getandsetchamps.comboxUpdate(runePages[i].name);
								}
							}
							
							getandsetchamps.comboBoxPlayerRunesFocus(runePages[getRunePage].name);
						} catch (IOException e)
						{
							e.printStackTrace();
						}
					}

					@Override
					public void onClientDisconnected()
					{
						System.out.println("Client disconnected");
					}
				});
				// close socket when user enters something into console
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try
				{
					reader.readLine();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				api.stop();
	}
}
