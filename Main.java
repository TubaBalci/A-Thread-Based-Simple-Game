package ummak;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JFrame;

public class Main extends JFrame implements KeyListener {

	public static ArrayList<Monster> monster = new ArrayList<>();
	public static int X=240,Y=240;
	protected static boolean gameOn=true;
	public static Monster main;
	static ReentrantLock lock=new ReentrantLock();
	public static void main(String[] args) {

		int number_of_monsters = Integer.parseInt(args[0]);
		System.out.println(number_of_monsters);
		Main m = new Main();

		Monster [] monsters = new Monster[number_of_monsters];

		Random r = new Random();

		for(int i=0;i<number_of_monsters;i++)
		{
			monsters[i] = m.new Monster(Math.abs(r.nextInt()%500),Math.abs(r.nextInt()%500));
		}

		for(int i=0;i<number_of_monsters;i++)
			monsters[i].start();

		try {
			for(int i=0;i<number_of_monsters;i++)
				monsters[i].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_A -> {
				if (X != 20)
					X -= 10;
			}
			case KeyEvent.VK_D -> {
				if (X != 480)
					X += 10;
			}
			case KeyEvent.VK_W -> {
				if (Y != 20)
					Y -= 10;
			}
			case KeyEvent.VK_S -> {
				if (Y != 480)
					Y += 10;
			}
			default -> {
			}
		}
		repaint();
	}


	public void keyReleased(KeyEvent e) {
	}


	public Main(){
		setSize(500,500);
		setEnabled(true);
		setBackground(Color.white);
		this.addKeyListener(this);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main= new Monster(){

			public void run() {
				while (gameOn)
					try{
						sleep(100);
						repaint();
					}
				catch (InterruptedException e){
						e.printStackTrace();
				}
			}


			public void start() {
				super.start();
			}

		};
		monster.add(main);
		main.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.clearRect(0,0,500,500);
		g.setColor(Color.green);
		g.fillRect(X,Y, 20, 20);
		for (Monster m:monster)
		{
			g.setColor(Color.blue);
			g.fillRect(m.x,m.y,20,20);
		}
	}

	 class Monster extends Thread {

		int x,y;
		 public Monster(){
			 super();
			 monster.add(this);
		 }
		public Monster(int a, int b){
			super();
			x=a; y=b;
			if (a>480)
				x=480;
			if(b>480)
				y=480;
			monster.add(this);
		}
		public void run() {
			while (gameOn){
				if (Math.abs(this.y-Y)<20){
					if(X>this.x)
						this.x += 10;
					else if (X<this.x)
						this.x -= 10;
				}
				else if (Math.abs(this.x-X)<20)
				{
					if (Y > this.y)
						this.y += 10;
					else
						this.y -= 10;
				}
				else if (Math.abs(this.y-Y) < Math.abs(this.x-X)) {
					if(Y>this.y)
						this.y += 10;
					else
						this.y -= 10;
				}
				else if (Math.abs(this.y-Y) > Math.abs(this.x-X))  {
					if(X>this.x)
						this.x += 10;
					else
						this.x -= 10;
				}
				if (!this.alive())
				{
					try {
						this.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.exit(0);
				}
				try {
					if (this!=main)
					sleep(1000);
				}
				catch (InterruptedException e){
					e.printStackTrace();
				}


			}

		}

		 public boolean alive(){
			 if ((0<=(X-x)&&(X-x)<=20)&&(0<=(Y-y)&&(Y-y)<=20))
				 return false;
			 if (0<=(x-X)&&(x-X)<=20&&0<=(Y-y)&&(Y-y)<=20)
				 return false;
			 if (0<=(X-x)&&(X-x)<=20&&0<=(y-Y)&&(y-Y)<=20)
				 return false;
			 if (0<=(x-X)&&(x-X)<=20&&0<=(y-Y)&&(y-Y)<=20)
				 return false;
			 return true;
		 }
		public void start(){
			super.start();
		}

	}
}
