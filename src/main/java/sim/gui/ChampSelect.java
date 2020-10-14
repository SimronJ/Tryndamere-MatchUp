package sim.gui;

import com.stirante.lolclient.ClientApi;
import com.stirante.lolclient.ClientConnectionListener;
import com.stirante.lolclient.ClientWebSocket;

import examples.pojo.Player;
import generated.LolChampSelectChampSelectPlayerSelection;
import generated.LolChampSelectChampSelectSession;
import generated.LolSummonerSummoner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;

public class ChampSelect
{
	private WhichChamp whichChamp = new WhichChamp();
	private Getandsetchamps getandsetchamps = new Getandsetchamps();

	private ClientWebSocket socket;

	ArrayList<Integer> allyclone = new ArrayList<Integer>();

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

									if (player.team == 1)
									{
										if (tempchamp != player.championId)
										{
											getandsetchamps.getAllyarray().add(player.championId);
											tempchamp = player.championId;
										}
									}
								});
								getandsetchamps.jlabelUpdate(0);
								getandsetchamps.getAllyarray().clear();

								ListIterator<LolChampSelectChampSelectPlayerSelection> enemyteam = session.theirTeam
										.listIterator();
								enemyteam.forEachRemaining(player ->
								{
									System.out.println(player.cellId + "Team:" + player.team + " Enemy Champ:"
											+ whichChamp.champname(player.championId));
									if (player.team == 2)
									{
										if (tempchamp2 != player.championId)
										{
											getandsetchamps.getEnemyarray().add(player.championId);
											tempchamp2 = player.championId;
										}
									}
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

}
