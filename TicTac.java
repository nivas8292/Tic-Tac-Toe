package playerfirst;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class TicTac extends JFrame implements ActionListener
{
int level;
String name;
char t[][];
JButton jb[][];
public TicTac(String name)
{
this.name=name;
t=new char[3][3];
level=0;
this.setTitle("TicTacToe");
this.setLocation(200,200);
this.setSize(400,400);
this.setResizable(false);
this.setVisible(true);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setLayout(new GridLayout(3,3));
jb=new JButton[3][3];
int i,j;
for(i=0;i<3;i++)
	for(j=0;j<3;j++)
	{
	t[i][j]='0';
	}
for(i=0;i<3;i++)
	for(j=0;j<3;j++)
	{
	jb[i][j]=new JButton();
	jb[i][j].setFont(new Font("Arial",Font.BOLD+Font.ITALIC,50));
	this.add(jb[i][j]);
	jb[i][j].addActionListener(this);
	}

}


void winCheck(char c)
{
if(c=='0')
	return;
else if(c=='h')
	{
	JOptionPane.showMessageDialog(null,"\n"+name+" Wins");
	System.exit(0);
	}
	else if(c=='x')
	{
	JOptionPane.showMessageDialog(null,"\nComputer Wins");
	System.exit(0);
	}

}


void displayTable()
{
int i,j;
System.out.println("\n\n\n                      Game Table\n");
	for(i=0;i<3;i++)
	{
		System.out.print("                    ");
		for(j=0;j<3;j++)
		{
			System.out.print(t[i][j]+"      ");
		}
		System.out.println();
	}
}


int placeCom(char c)
{
int m=0,n=0;
while(m<3)
	{
	if((t[m][n]==t[m][n+1]) && t[m][n+2]=='0' && t[m][n]==c)
		{
		t[m][n+2]='x';
	jb[m][n+2].setBackground(Color.pink);
	jb[m][n+2].setText("X");
	
		return 0;
		}
	else if((t[m][n]==t[m][n+2]) && t[m][n+1]=='0' && t[m][n]==c)
		{
		t[m][n+1]='x';
		jb[m][n+1].setBackground(Color.pink);
		jb[m][n+1].setText("X");

		return 0;
		}
	else if((t[m][n+1]==t[m][n+2]) && t[m][n]=='0' && t[m][n+1]==c)
		{
		t[m][n]='x';
	jb[m][n].setBackground(Color.pink);
	jb[m][n].setText("X");

		return 0;
		}
	m++;
	}
	m=0;n=0;
	while(n<3)
	{
	if((t[m][n]==t[m+1][n]) && t[m+2][n]=='0' && t[m][n]==c)
		{
		t[m+2][n]='x';
	jb[m+2][n].setBackground(Color.pink);
	jb[m+2][n].setText("X");

		return 0;
		}
	else if((t[m][n]==t[m+2][n]) && t[m+1][n]=='0' && t[m][n]==c)
		{
		t[m+1][n]='x';
	jb[m+1][n].setBackground(Color.pink);
	jb[m+1][n].setText("X");

		return 0;
		}
	else if((t[m+1][n]==t[m+2][n]) && t[m][n]=='0' && t[m+1][n]==c)
		{
		t[m][n]='x';
	jb[m][n].setBackground(Color.pink);
	jb[m][n].setText("X");

		return 0;
		}
	n++;
	}
	m=0;n=0;
	if((t[m][n]==t[m+1][n+1]) && t[m+2][n+2]=='0' && t[m][n]==c)
		{
		t[m+2][n+2]='x';
	jb[m+2][n+2].setBackground(Color.pink);
	jb[m+2][n+2].setText("X");

		return 0;
		}
	else if((t[m][n]==t[m+2][n+2]) && t[m+1][n+1]=='0' && t[m][n]==c)
		{
		t[m+1][n+1]='x';
	jb[m+1][n+1].setBackground(Color.pink);
	jb[m+1][n+1].setText("X");

		return 0;
		}
	else if((t[m+1][n+1]==t[m+2][n+2]) && t[m][n]=='0' && t[m+1][n+1]==c)
		{
		t[m][n]='x';
	jb[m][n].setBackground(Color.pink);
	jb[m][n].setText("X");

		return 0;
		}
	m=0;n=0;
	if((t[m][n+2]==t[m+1][n+1]) && t[m+2][n]=='0' && t[m][n+2]==c)
		{
		t[m+2][n]='x';
	jb[m+2][n].setBackground(Color.pink);
	jb[m+2][n].setText("X");

		return 0;		
		}
	else if((t[m][n+2]==t[m+2][n]) && t[m+1][n+1]=='0' && t[m][n+2]==c)
		{
		t[m+1][n+1]='x';
	jb[m+1][n+1].setBackground(Color.pink);
	jb[m+1][n+1].setText("X");

		return 0;
		}
	else if((t[m+2][n]==t[m+1][n+1]) && t[m][n+2]=='0' && t[m+1][n+1]==c)
		{
		t[m][n+2]='x';
		jb[m][n+2].setBackground(Color.pink);
		jb[m][n+2].setText("X");

		return 0;
		}
	return 1;
}

void win(int i)
{
int m=0,n=0,j=0;
if(i<5)
	return;
if(i>=6)
	{
	while(m<3)
	{
	if(t[m][n]==t[m][n+1] && t[m][n]==t[m][n+2])
		{
		winCheck(t[m][n]);
		}
	m++;
	}
	m=0;n=0;
	while(n<3)
	{
	if(t[m][n]==t[m+1][n] && t[m][n]==t[m+2][n])
                {
		winCheck(t[m][n]);
                }
        n++;
	}
	m=0;n=0;
	if(t[m][n]==t[m+1][n+1] && t[m][n]==t[m+2][n+2])
	{
	winCheck(t[m][n]);	
	}
	m=0;n=0;
	if(t[m+1][n+1]==t[m][n+2] && t[m+1][n+1]==t[m+2][n])
	{
        winCheck(t[m+1][n+1]);    
	}
	}
	m=0;n=0;
	if(i==7)
	{
		while(m<3)
		{
		if(((t[m][n]==t[m][n+1]) && t[m][n+2]=='0') || ((t[m][n]==t[m][n+2]) && t[m][n+1]=='0') || ((t[m][n+1]==t[m][n+2]) && t[m][n]=='0'))
			return;
		m++;
		}
		m=0;n=0;
		while(n<3)
		{
		if(((t[m][n]==t[m+1][n]) && t[m+2][n]=='0') || ((t[m][n]==t[m+2][n]) && t[m+1][n]=='0') || ((t[m+1][n]==t[m+2][n]) && t[m][n]=='0'))
			return;
		n++;
		}
		m=0;n=0;
		if(((t[m][n]==t[m+1][n+1]) && t[m+2][n+2]=='0') || ((t[m][n]==t[m+2][n+2]) && t[m+1][n+1]=='0') || ((t[m+2][n+2]==t[m+1][n+1]) && t[m][n]=='0'))
			return;
		m=0;n=0;
		if(((t[m][n+2]==t[m+1][n+1]) && t[m][n+2]=='0') || ((t[m][n+2]==t[m+2][n]) && t[m+1][n+1]=='0') || ((t[m+2][n]==t[m+1][n+1]) && t[m][n+2]=='0'))
		return;

		while(m<3)
		{
		if(((t[m][n]==t[m][n+1]) && t[m][n]=='0') || ((t[m][n]==t[m][n+2]) && t[m][n]=='0') || ((t[m][n+1]==t[m][n+2]) && t[m][n+1]=='0'))
			{
		JOptionPane.showMessageDialog(null,"Match Drawn");
		System.exit(0);	
	return;
			}
		m++;
		}
		m=0;n=0;
		while(n<3)
		{
		if(((t[m][n]==t[m+1][n]) && t[m][n]=='0') || ((t[m][n]==t[m+2][n]) && t[m][n]=='0') || ((t[m+1][n]==t[m+2][n]) && t[m+1][n]=='0'))
			{
			JOptionPane.showMessageDialog(null,"Match Drawn");
		System.exit(0);		
	return;
			}
		n++;
		}
		m=0;n=0;

		if(((t[m][n]==t[m+1][n+1]) && t[m][n]=='0') || ((t[m][n]==t[m+2][n+2]) && t[m][n]=='0') || ((t[m+2][n+2]==t[m+1][n+1]) && t[m+1][n+1]=='0'))
			{
		JOptionPane.showMessageDialog(null,"Match Drawn");
	System.exit(0);
		return;
			}
		m=0;n=0;
		if(((t[m][n+2]==t[m+1][n+1]) && t[m+1][n+1]=='0') || ((t[m][n+2]==t[m+2][n]) && t[m+2][n]=='0') || ((t[m+2][n]==t[m+1][n+1]) && t[m+1][n+1]=='0'))
		{
		JOptionPane.showMessageDialog(null,"Match Drawn");
	System.exit(0);
		return;
		}
	}
	if(i==8)
	{
		int x=0,y=0;
		for(x=0;x<3;x++)
			for(y=0;y<3;y++)
				if(t[x][y]=='0')
				{
				t[x][y]='h';
				jb[x][y].setBackground(Color.red);
				jb[x][y].setText("H");
				level++;
				win(level);
	m=0;n=0;			
	while(m<3)
	{
	if(t[m][n]==t[m][n+1] && t[m][n]==t[m][n+2])
		{
		winCheck(t[m][n]);
		}
	m++;
	}
	m=0;n=0;
	while(n<3)
	{
	if(t[m][n]==t[m+1][n] && t[m][n]==t[m+2][n])
                {
		winCheck(t[m][n]);
                }
        n++;
	}
	m=0;n=0;
	if(t[m][n]==t[m+1][n+1] && t[m][n]==t[m+2][n+2])
	{
	winCheck(t[m][n]);	
	}
	m=0;n=0;
	if(t[m+1][n+1]==t[m][n+2] && t[m+1][n+1]==t[m+2][n])
	{
        winCheck(t[m+1][n+1]);    
	}
	
	JOptionPane.showMessageDialog(null,"Match Drawn");
	System.exit(0);
	return;
	}
	}
}






int position(int m,int n)
{
	if(m==0)
	{
		if(n==0)
			return 1;
		else if(n==1)
			return 2;
			return 3;
	}
	else if(m==1)
	{
		if(n==0)
			return 4;
		else if(n==1)
			return 5;
			return 6;

	}
	else
	{
		if(n==0)
			return 7;
		else if(n==1)
			return 8;
			return 9;

	}
}


int[] check(int a)
{
int ch[]=new int[2];
switch(a)
{
case 1:ch[0]=0;ch[1]=0;
	break;
case 2:ch[0]=0;ch[1]=1;
	break;
case 3:ch[0]=0;ch[1]=2;
	break;
case 4:ch[0]=1;ch[1]=0;
	break;
case 5:ch[0]=1;ch[1]=1;
	break;
case 6:ch[0]=1;ch[1]=2;
	break;
case 7:ch[0]=2;ch[1]=0;
	break;
case 8:ch[0]=2;ch[1]=1;
	break;
case 9:ch[0]=2;ch[1]=2;
	break;

}
return ch;
}




void computerGame()
{
int ran[];
int m=0,n=0,i=0;
ran=new int[9];
for(i=0;i<9;i++)
	ran[i]=0;
if(t[1][1]=='0')
{
	t[1][1]='x';
	jb[1][1].setBackground(Color.pink);
	jb[1][1].setText("X");
	level++;
	return;
}

	if(placeCom('x')==0)
		{
		level++;
		return;
		}
	if(placeCom('h')==0)
		{
		level++;
		return;
		}
	i=0;
	for(m=0;m<3;m++)
		for(n=0;n<3;n++)
			if(t[m][n]=='0')
			{
			ran[i++]=position(m,n);
			}
		int len=--i;
	Random r=new Random();
	int a=-99;
	while(a<0)
	{
		a=r.nextInt(876);
		a=a%9;
	}
	int b=(a+45)%len;
	int c[]=new int[2];
	c=check(ran[b]);
	m=c[0];n=c[1];
	t[m][n]='x';
	jb[m][n].setBackground(Color.pink);
	jb[m][n].setText("X");
	level++;
	return;

}




public void actionPerformed(ActionEvent ev)
{
int i,j;
for(i=0;i<3;i++)
	for(j=0;j<3;j++)
	{
	if(ev.getSource()==jb[i][j])
	{
	if(t[i][j]!='0')
		{
		JOptionPane.showMessageDialog(null,"Already placed");
		return;
		}
	else
	{
		jb[i][j].setBackground(Color.red);
		jb[i][j].setText("H");
		level++;
		t[i][j]='h';
		win(level);
		computerGame();
		win(level);
	}
	}
	}
}

}
