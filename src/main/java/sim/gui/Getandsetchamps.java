package sim.gui;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Getandsetchamps extends Expertimentgui
{
	private ArrayList<Integer> allyarray = new ArrayList<Integer>();
	private ArrayList<Integer> enemyarray = new ArrayList<Integer>();
	private String allyplayer1 = "none", allyplayer2 = "none", allyplayer3 = "none", allyplayer4 = "none",
			allyplayer5 = "none";
	private String enemyplayer1 = "none", enemyplayer2 = "none", enemyplayer3 = "none", enemyplayer4 = "none",
			enemyplayer5 = "none";
	private String[] allyplayerArray =
	{ allyplayer1, allyplayer2, allyplayer3, allyplayer4, allyplayer5, enemyplayer1, enemyplayer2, enemyplayer3,
			enemyplayer4, enemyplayer5 };

	private WhichChamp whichChamp = new WhichChamp();

	public String getAllyplayer1()
	{
		return allyplayer1;
	}

	public void setAllyplayer1(String allyplayer1)
	{
		this.allyplayer1 = allyplayer1;
	}

	public String getAllyplayer2()
	{
		return allyplayer2;
	}

	public void setAllyplayer2(String allyplayer2)
	{
		this.allyplayer2 = allyplayer2;
	}

	public String getAllyplayer3()
	{
		return allyplayer3;
	}

	public void setAllyplayer3(String allyplayer3)
	{

		this.allyplayer3 = allyplayer3;
	}

	public String getAllyplayer4()
	{
		return allyplayer4;
	}

	public void setAllyplayer4(String allyplayer4)
	{
		this.allyplayer4 = allyplayer4;
	}

	public String getAllyplayer5()
	{
		return allyplayer5;
	}

	public void setAllyplayer5(String allyplayer5)
	{
		this.allyplayer5 = allyplayer5;
	}

	public String getEnemyplayer1()
	{
		return enemyplayer1;
	}

	public void setEnemyplayer1(String enemyplayer1)
	{
		this.enemyplayer1 = enemyplayer1;
	}

	public String getEnemyplayer2()
	{
		return enemyplayer2;
	}

	public void setEnemyplayer2(String enemyplayer2)
	{
		this.enemyplayer2 = enemyplayer2;
	}

	public String getEnemyplayer3()
	{
		return enemyplayer3;
	}

	public void setEnemyplayer3(String enemyplayer3)
	{
		this.enemyplayer3 = enemyplayer3;
	}

	public String getEnemyplayer4()
	{
		return enemyplayer4;
	}

	public void setEnemyplayer4(String enemyplayer4)
	{
		this.enemyplayer4 = enemyplayer4;
	}

	public String getEnemyplayer5()
	{
		return enemyplayer5;
	}

	public void setEnemyplayer5(String enemyplayer5)
	{
		this.enemyplayer5 = enemyplayer5;
	}

	public ArrayList<Integer> getAllyarray()
	{
		return allyarray;
	}

	public ArrayList<Integer> getEnemyarray()
	{
		return enemyarray;
	}
	
	public void resetBTN(int champ)
	{
		getgJLabels().clear();
		getgJLabels().add(0, lblAllyPlayer1);
		getgJLabels().add(1, lblAllyPlayer2);
		getgJLabels().add(2, lblAllyPlayer3);
		getgJLabels().add(3, lblAllyPlayer4);
		getgJLabels().add(4, lblAllyPlayer5);
		
		getgJLabels2().clear();
		getgJLabels2().add(0, lblEnemyPlayer1);
		getgJLabels2().add(1, lblEnemyPlayer2);
		getgJLabels2().add(2, lblEnemyPlayer3);
		getgJLabels2().add(3, lblEnemyPlayer4);
		getgJLabels2().add(4, lblEnemyPlayer5);
		
		for (int i = 0; i < 5; i++)
		{
			getgJLabels().get(i).removeAll();
			getgJLabels().get(i).revalidate();
			getgJLabels().get(i).repaint();
			getgJLabels().get(i).setName(whichChamp.champname(champ));
			getgJLabels().get(i)
					.setIcon(new ImageIcon(new javax.swing.ImageIcon(
							getClass().getResource("/sim/resources/champs/" + whichChamp.champname(champ) + ".png"))
									.getImage().getScaledInstance(getImginewh(), getImginewh(), Image.SCALE_SMOOTH)));
			
			getgJLabels2().get(i).removeAll();
			getgJLabels2().get(i).revalidate();
			getgJLabels2().get(i).repaint();
			getgJLabels2().get(i).setName(whichChamp.champname(champ));
			getgJLabels2().get(i)
					.setIcon(new ImageIcon(new javax.swing.ImageIcon(
							getClass().getResource("/sim/resources/champs/" + whichChamp.champname(champ) + ".png"))
									.getImage().getScaledInstance(getImginewh(), getImginewh(), Image.SCALE_SMOOTH)));
			getgJLabels().get(i).setName(Integer.toString(champ));
		}
	}
	
	public void jlabelRefresh(int index, int champ, int choice)
	{
		if (choice == 0)
		{
			getgJLabels().clear();
			getgJLabels().add(0, lblAllyPlayer1);
			getgJLabels().add(1, lblAllyPlayer2);
			getgJLabels().add(2, lblAllyPlayer3);
			getgJLabels().add(3, lblAllyPlayer4);
			getgJLabels().add(4, lblAllyPlayer5);

			getgJLabels().get(index).removeAll();
			getgJLabels().get(index).revalidate();
			getgJLabels().get(index).repaint();
			getgJLabels().get(index).setName(whichChamp.champname(champ));
			getgJLabels().get(index)
					.setIcon(new ImageIcon(new javax.swing.ImageIcon(
							getClass().getResource("/sim/resources/champs/" + whichChamp.champname(champ) + ".png"))
									.getImage().getScaledInstance(getImginewh(), getImginewh(), Image.SCALE_SMOOTH)));
		} else if (choice == 1)
		{
			getgJLabels2().clear();
			getgJLabels2().add(0, lblEnemyPlayer1);
			getgJLabels2().add(1, lblEnemyPlayer2);
			getgJLabels2().add(2, lblEnemyPlayer3);
			getgJLabels2().add(3, lblEnemyPlayer4);
			getgJLabels2().add(4, lblEnemyPlayer5);

			getgJLabels2().get(index).removeAll();
			getgJLabels2().get(index).revalidate();
			getgJLabels2().get(index).repaint();
			getgJLabels2().get(index).setName(whichChamp.champname(champ));
			getgJLabels2().get(index)
					.setIcon(new ImageIcon(new javax.swing.ImageIcon(
							getClass().getResource("/sim/resources/champs/" + whichChamp.champname(champ) + ".png"))
									.getImage().getScaledInstance(getImginewh(), getImginewh(), Image.SCALE_SMOOTH)));
			getgJLabels().get(index).setName(Integer.toString(champ));
		}
	}

	volatile int i;
	public void jlabelUpdate(int num)
	{
		i = 0;
		if (num == 0)
		{
			allyarray.listIterator().forEachRemaining(champ ->
			{
				jlabelRefresh(i, champ, 0);
				i++;
				if (i > 4)
				{
					i = 0;
				}
			});
		} else if (num == 1)
		{
			i = 0;
			enemyarray.listIterator().forEachRemaining(champ ->
			{
				jlabelRefresh(i, champ, 1);
				i++;
				if (i > 4)
				{
					i = 0;
				}
			});
		}
	}

	public void comboxUpdate(String item)
	{
		comboBoxPlayerRunes.addItem(item);
	}
	
	public void comboBoxPlayerRunesFocus(String item)
	{
		//comboBoxPlayerRunes.requestFocus();
		//comboBoxPlayerRunes.showPopup();
		comboBoxPlayerRunes.setSelectedItem(item);
	}
	
	public void deleteComboxItem()
	{
		comboBoxPlayerRunes.removeAllItems();
	}

}

class ComboItemAdd
{
    private String key;
    private String value;

    public ComboItemAdd(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}
