package sim.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

public class WhichChamp
{
	public void filechecktoseeifallthechampisthere()
	{
		for (int i = 0; i < 1000; i++)
		{
			if(champname(i) != "")
			{
				File file = new File("C:\\Users\\ssimr\\Downloads\\champspics\\"+champname(i)+".png");
				 // renaming the file and moving it to a new location 
		        if(file.renameTo 
		           (new File("C:\\Users\\ssimr\\Downloads\\champspics\\good\\"+champname(i)+".png"))) 
		        { 
		            // if file copied successfully then delete the original file 
		            file.delete(); 
		            System.out.println("File moved successfully: " + i + "|" + champname(i)); 
		        } 
		        else
		        { 
		            System.out.println("None was found based on: " + champname(i)); 
		        }
			}
			else
			{
				continue;
			}
			 
		}
	}
	
	public String champname (int id) 
	{
		String name = "";
		switch(id)
		{
		case 0: name = "none"; break;
		case 523: name = "Aphelios"; break;
		case 350: name = "Yuumi"; break;
		case 142: name = "Zoe"; break;
		case 498: name = "Xayah"; break;
		case 517: name = "Sylas"; break;
		case 875: name = "Sett"; break;
		case 235: name = "Senna"; break;
		case 360: name = "Samira"; break;
		case 497: name = "Rakan"; break;
		case 246: name = "Qiyana"; break;
		case 555: name = "Pyke"; break;
		case 516: name = "Ornn"; break;
		case 518: name = "Neeko"; break;
		case 876: name = "Lillia"; break;
		case 141: name = "Kayn"; break;
		case 145: name = "Kaisa"; break;
		case 164: name = "Camille"; break;
		case 777: name = "Yone"; break;
		case 266: name = "Aatrox"; break;
	    case 412: name = "Thresh"; break;
	    case 23: name = "Tryndamere"; break;
	    case 79: name = "Gragas"; break;
	    case 69: name = "Cassiopeia"; break;
	    case 136: name = "AurelionSol"; break;
	    case 13: name = "Ryze"; break;
	    case 78: name = "Poppy"; break;
	    case 14: name = "Sion"; break;
	    case 1: name = "Annie"; break;
	    case 202: name = "Jhin"; break;
	    case 43: name = "Karma"; break;
	    case 111: name = "Nautilus"; break;
	    case 240: name = "Kled"; break;
	    case 99: name = "Lux"; break;
	    case 103: name = "Ahri"; break;
	    case 2: name = "Olaf"; break;
	    case 112: name = "Viktor"; break;
	    case 34: name = "Anivia"; break;
	    case 27: name = "Singed"; break;
	    case 86: name = "Garen"; break;
	    case 127: name = "Lissandra"; break;
	    case 57: name = "Maokai"; break;
	    case 25: name = "Morgana"; break;
	    case 28: name = "Evelynn"; break;
	    case 105: name = "Fizz"; break;
	    case 74: name = "Heimerdinger"; break;
	    case 238: name = "Zed"; break;
	    case 68: name = "Rumble"; break;
	    case 82: name = "Mordekaiser"; break;
	    case 37: name = "Sona"; break;
	    case 96: name = "KogMaw"; break;
	    case 55: name = "Katarina"; break;
	    case 117: name = "Lulu"; break;
	    case 22: name = "Ashe"; break;
	    case 30: name = "Karthus"; break;
	    case 12: name = "Alistar"; break;
	    case 122: name = "Darius"; break;
	    case 67: name = "Vayne"; break;
	    case 110: name = "Varus"; break;
	    case 77: name = "Udyr"; break;
	    case 89: name = "Leona"; break;
	    case 126: name = "Jayce"; break;
	    case 134: name = "Syndra"; break;
	    case 80: name = "Pantheon"; break;
	    case 92: name = "Riven"; break;
	    case 121: name = "Khazix"; break;
	    case 42: name = "Corki"; break;
	    case 268: name = "Azir"; break;
	    case 51: name = "Caitlyn"; break;
	    case 76: name = "Nidalee"; break;
	    case 85: name = "Kennen"; break;
	    case 3: name = "Galio"; break;
	    case 45: name = "Veigar"; break;
	    case 432: name = "Bard"; break;
	    case 150: name = "Gnar"; break;
	    case 90: name = "Malzahar"; break;
	    case 104: name = "Graves"; break;
	    case 254: name = "Vi"; break;
	    case 10: name = "Kayle"; break;
	    case 39: name = "Irelia"; break;
	    case 64: name = "LeeSin"; break;
	    case 420: name = "Illaoi"; break;
	    case 60: name = "Elise"; break;
	    case 106: name = "Volibear"; break;
	    case 20: name = "Nunu"; break;
	    case 4: name = "TwistedFate"; break;
	    case 24: name = "Jax"; break;
	    case 102: name = "Shyvana"; break;
	    case 429: name = "Kalista"; break;
	    case 36: name = "DrMundo"; break;
	    case 427: name = "Ivern"; break;
	    case 131: name = "Diana"; break;
	    case 223: name = "TahmKench"; break;
	    case 63: name = "Brand"; break;
	    case 113: name = "Sejuani"; break;
	    case 8: name = "Vladimir"; break;
	    case 154: name = "Zac"; break;
	    case 421: name = "RekSai"; break;
	    case 133: name = "Quinn"; break;
	    case 84: name = "Akali"; break;
	    case 163: name = "Taliyah"; break;
	    case 18: name = "Tristana"; break;
	    case 120: name = "Hecarim"; break;
	    case 15: name = "Sivir"; break;
	    case 236: name = "Lucian"; break;
	    case 107: name = "Rengar"; break;
	    case 19: name = "Warwick"; break;
	    case 72: name = "Skarner"; break;
	    case 54: name = "Malphite"; break;
	    case 157: name = "Yasuo"; break;
	    case 101: name = "Xerath"; break;
	    case 17: name = "Teemo"; break;
	    case 75: name = "Nasus"; break;
	    case 58: name = "Renekton"; break;
	    case 119: name = "Draven"; break;
	    case 35: name = "Shaco"; break;
	    case 50: name = "Swain"; break;
	    case 91: name = "Talon"; break;
	    case 40: name = "Janna"; break;
	    case 115: name = "Ziggs"; break;
	    case 245: name = "Ekko"; break;
	    case 61: name = "Orianna"; break;
	    case 114: name = "Fiora"; break;
	    case 9: name = "Fiddlesticks"; break;
	    case 31: name = "ChoGath"; break;
	    case 33: name = "Rammus"; break;
	    case 7: name = "LeBlanc"; break;
	    case 16: name = "Soraka"; break;
	    case 26: name = "Zilean"; break;
	    case 56: name = "Nocturne"; break;
	    case 222: name = "Jinx"; break;
	    case 83: name = "Yorick"; break;
	    case 6: name = "Urgot"; break;
	    case 203: name = "Kindred"; break;
	    case 21: name = "MissFortune"; break;
	    case 62: name = "Wukong"; break;
	    case 53: name = "Blitzcrank"; break;
	    case 98: name = "Shen"; break;
	    case 201: name = "Braum"; break;
	    case 5: name = "XinZhao"; break;
	    case 29: name = "Twitch"; break;
	    case 11: name = "MasterYi"; break;
	    case 44: name = "Taric"; break;
	    case 32: name = "Amumu"; break;
	    case 41: name = "Gangplank"; break;
	    case 48: name = "Trundle"; break;
	    case 38: name = "Kassadin"; break;
	    case 161: name = "Velkoz"; break;
	    case 143: name = "Zyra"; break;
	    case 267: name = "Nami"; break;
	    case 59: name = "JarvanIV"; break;
	    case 81: name = "Ezreal"; break;
	    //default: System.out.println("Champ: " + id + " not found"); break;
		}
		return name;
	}

	private List<String[]> allRows;
	public  String[] getChampFromTSV(String s)
	{

		String fileinput = this.getClass().getResource("/sim/resources/TryndaUpdate101720.tsv").getPath();
	
		TsvParserSettings settings = new TsvParserSettings();
		settings.getFormat().setLineSeparator("\n");
		TsvParser parser = new TsvParser(settings);
		
		// parses all rows in one go.
		try
		{
			allRows = parser.parseAll(new FileReader(fileinput));
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		String[] tempch = null, returnch = {"Unknown", "Unknown", "Unknown"} ;
		for (int i = 0; i < allRows.size(); i++)
		{
			tempch = allRows.get(i);
			switch (tempch[0].length())
			{
			case 2:  if (tempch[0].equals(s) ){returnch = allRows.get(i); System.out.println("Found it! " + tempch[0]);} break;
			case 3:  if (tempch[0].equals(s)){returnch = allRows.get(i); System.out.println("Found it! " + tempch[0]);} break;
			case 4:  if (tempch[0].equals(s)){returnch = allRows.get(i); System.out.println("Found it! " + tempch[0]);} break;
			case 5:  if (tempch[0].equals(s)){returnch = allRows.get(i); System.out.println("Found it! " + tempch[0]);} break;

			default: 
				if(s.equals("ChoGath")) {
					if(tempch[0].equals("Cho' Gath")) {returnch = allRows.get(i); System.out.println("Found! " + tempch[0]);}
				}
				if(s.length() >= 6)
				{
					if (s.subSequence(0, 4).equals(tempch[0].subSequence(0, 4)))
					{
						returnch = allRows.get(i); 
						System.out.println("Found it 1! " + tempch[0]);
					}
				}
				break;
			}
		}
		return returnch;
	}
}
