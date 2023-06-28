package ch6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; // ArrayList를 위한 임포트 추가


public class Game {
	public static void main(String[] ar){
		GameFrame fms = new GameFrame();
	}
}



class GameFrame extends JFrame implements KeyListener, Runnable{

	/* --------- 멤버변수 선언 영역 시작 --------- */
	// 창크기
	int f_width = 800;
	int f_height = 600;
	
	// 캐릭터의 좌표 변수
	int x, y;	
	
	// 리스트들
	ArrayList<Missile> missileList = new ArrayList(); // 미사일
	ArrayList<Enemy> enemyList = new ArrayList(); // 적 비행기
	
    //이미지를 불러오기 위한 툴킷
	Toolkit tk = Toolkit.getDefaultToolkit();
	
	// 이미지 변수들
	Image characterImg;     // 내 비행기 이미지, f15k.png	
	Image missileImg; 	// 미사일 이미지 변수
	Image enemyImg; // 적 이미지를 받아들일 이미지 변수
	
	int e_w = 156; int e_h = 35; //적 이미지의 크기값을 받을 변수
	int m_w = 13; int m_h = 8; //미사일 이미지의 크기값을 받을 변수
	 
	//키보드 입력 처리를 위한 변수들
	boolean KeyUp = false; 
	boolean KeyDown = false;
	boolean KeyLeft = false;
	boolean KeyRight = false;
	boolean KeySpace = false; // 미사일 발사를 위한 키보드 스페이스키 입력을 추가합니다.
	
	//각종 타이밍 조절을 위해 무한 루프를 카운터할 변수
	int cnt = 0; 

	// 실행 스레드
	Thread th;		
	/* --------- 멤버변수 선언 영역 끝 --------- */
	
	
	// 생성자
	GameFrame(){
		
		init();
		start();
	}
 	

	// 윈도창 초기화
	public void init(){
		setTitle("슈팅 게임 만들기"); // 윈도 타이틀
		setSize(f_width, f_height); //윈도크기
	  
		// 스크린 사이즈와 창크기를 계산하여 중앙에 오도록 함.
		Dimension screen = tk.getScreenSize();
	
		int f_xpos = (int)(screen.getWidth() / 2 - f_width / 2);
		int f_ypos = (int)(screen.getHeight() / 2 - f_height / 2);
		
		setLocation(f_xpos, f_ypos);
		setResizable(false);
		setVisible(true);
		
		//프레임 오른쪽 위에 X버튼을 눌렀을때 
		//프로그램이 정상적으로 종료하게 만들어 줍니다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 이미지 로딩
		characterImg = new ImageIcon(this.getClass().getResource("/resources/f15k.png")
			).getImage();
		
		missileImg = new ImageIcon(this.getClass().getResource("/resources/Missile.png")
			).getImage();
		
		enemyImg = new ImageIcon(this.getClass().getResource("/resources/enemy.png")
			).getImage();		
	}	
	
	// 게임 시작
	public void start(){
		//키보드 이벤트 실행
		addKeyListener(this);
		
		// 현재 창의 스레드 생성
		th = new Thread(this);  
		th.start();  
	}	
	
	
	

	/* --------- 오버라이드 메서드 영역 시작 ---------- */
	// JFrame derive 클래스의 그리기 함수, 최초 생성시 실행 및 repaint 시에 실행
	public void paint(Graphics g){
		drawCharacter(g);
		drawMissile(g);
		drawEnemy(g);
	}
	
	
	// KeyListener Implement 클래스의 기본 메소드 들
	// 키보드가 눌러졌을때 이벤트 처리하는 곳 
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP :
				KeyUp = true;
				break;
			case KeyEvent.VK_DOWN :
				KeyDown = true;
				break;
			case KeyEvent.VK_LEFT :
				KeyLeft = true;
				break;
			case KeyEvent.VK_RIGHT :
				KeyRight = true;
				break;
			case KeyEvent.VK_SPACE : // 스페이스키 입력 처리 추가
				KeySpace = true;
				break;				
		}
	}
	
	// 키보드가 눌러졌다가 때어졌을때 이벤트 처리하는 곳
	public void keyReleased(KeyEvent e){	  
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP :
				KeyUp = false;
				break;
			case KeyEvent.VK_DOWN :
				KeyDown = false;
				break;
			case KeyEvent.VK_LEFT :
				KeyLeft = false;
				break;
			case KeyEvent.VK_RIGHT :
				KeyRight = false;
				break;
			case KeyEvent.VK_SPACE : // 스페이스키 입력 처리 추가
				KeySpace = false;
				break;				
		}
	}
	
	// 키보드가 타이핑 될때 이벤트 처리하는 곳
	public void keyTyped(KeyEvent e){}
	
	
	// Runnable Implement 클래스의 스레드 실행영역 
	public void run(){ 
		// 예외옵션 설정으로 에러 방지
		try{
			// 스레드가 무한 루프될 부분
			while(true){ // while 문으로 무한 루프 시키기
				// 키보드 입력처리를 하여 x,y 갱신
				keyProcess();
				// 미사일 처리
				missileProcess();
				// 적 비행기 처리
				enemyProcess();
				
				// 갱신된 x,y값으로 이미지 새로 그리기
				repaint(); 
				
				//무한 루프 카운터
				cnt ++;
				// 20 milli sec 로 스레드 돌리기
				Thread.sleep(20);
			}
		} catch (Exception e){
			
		}
	}	
	/* --------- 오버라이드 메서드 영역 끝 ---------- */
	
	
	
	/* ---------------- 사용자정의 메서드  시작 --------------- */
	
	// 키 입력후 좌표값 처리
	public void keyProcess(){
		
		//키 입력시마다 5만큼의 이동을 시킨다.
		if(KeyUp == true)  y -= 5;
		if(KeyDown == true) y += 5;
		if(KeyLeft == true)  x -= 5;
		if(KeyRight == true) x += 5;		
	   
	}
	
	// 미사일 처리 메소드
	public void missileProcess(){ 
		if ( KeySpace ){ // 스페이스바 키 상태가 true 면
			missileList.add(new Missile(x + 150, y + 30));    // 해당 미사일 추가
		}
		
		for ( int i = 0 ; i < missileList.size() ; ++i){
			// 미사일 이동
			Missile ms = missileList.get(i);
			ms.move();
			
			// 미사일이 화면 밖으로 나갔을 시에 삭제
			if ( ms.pos.getX() > f_width - 20 ){
				missileList.remove(i);
			}
			
			for (int j = 0 ; j < enemyList.size(); ++ j){
				Enemy en = enemyList.get(j);
				if (crash(ms.pos.x, ms.pos.y, en.x, en.y, 
						m_w, m_h, e_w, e_h)){
					//미사일과 적 객체를 하나하나 판별하여
					//접촉했을시 미사일과 적을 화면에서 지웁니다.
					//판별엔 crash 메소드에서 계산하는 방식을 씁니다.
					missileList.remove(i);
					enemyList.remove(j);
				}
			}
		}	
	}
	
	// 적 행동 처리 메소드
	public void enemyProcess(){
		for (int i = 0 ; i < enemyList.size() ; ++i ){ 
			Enemy en = enemyList.get(i); 
			//해당 적을 이동시킨다.
			en.move(); 
			//적의 좌표가 화면 밖으로 넘어가면
			if(en.x < -200){ 
				// 해당 적을 배열에서 삭제
				enemyList.remove(i); 
				}
		}
		
		//루프 카운트 300회 마다
		if ( cnt % 300 == 0 ){
			//﻿각 좌표로 적을 생성한 후 배열에 추가한다.
			enemyList.add(new Enemy(f_width + 100, 100)); 
			enemyList.add(new Enemy(f_width + 100, 200));
			enemyList.add(new Enemy(f_width + 100, 300));
			enemyList.add(new Enemy(f_width + 100, 400));
			enemyList.add(new Enemy(f_width + 100, 500));
		}
	
	}	
	
	// 충돌 판별
	public boolean crash(int x1, int y1, int x2, int y2, int w1, int h1, int w2, int h2){
		//﻿충돌 판정을 위한 새로운 Crash 메소드를 만들었습니다.
		//판정을 위해 충돌할 두 사각 이미지의 좌표 및 
		//넓이와 높이값을 받아들입니다.
		//여기서 이미지의 넓이, 높이값을 계산하기 위해 밑에 보면
		//이미지 크기 계산용 메소드를 또 추가했습니다.
		boolean check = false;

		if ( Math.abs( ( x1 + w1 / 2 )  - ( x2 + w2 / 2 ))  <  ( w2 / 2 + w1 / 2 )  
		&& Math.abs( ( y1 + h1 / 2 )  - ( y2 + h2 / 2 ))  <  ( h2 / 2 + h1/ 2 ) ){
		//충돌 계산식입니다. 사각형 두개의 거리및 겹치는 여부를 확인
		//하는 방식이라고 알고 있는데, 만들다보니 생각보다 식이 
		//복잡해진것 같습니다.
		//이보다 더 간편한 방식이 있을 것도 같은데 
		//일단 이렇게 해봤습니다.
		check = true;//위 값이 true면 check에 true를 전달합니다.
		}else{ check = false;}

		return check; //check의 값을 메소드에 리턴 시킵니다.
	}
			
	
	
	
	// 내 비행기 그리기
	public void drawCharacter(Graphics g) {
		// 0,0 에서 위에서 정한 해상도 크기만큼 화면을 지웁니다.
		g.clearRect(0, 0, f_width, f_height);

		//g.drawString("Hello World", 100, 100);
		//프레임에 characterImg에 저장된 f15k.png 이미지를  x=100, y=100 좌표로 그려넣습니다.
		g.drawImage(characterImg, x, y, this);		
	}
	
	// 미사일 그리기
	public void drawMissile(Graphics g){ 	
		for (int i = 0 ; i < missileList.size()  ; ++i){
			Missile ms = (missileList.get(i));
			// 현재 좌표에 미사일 그리기.
			// 이미지 크기를 감안한 미사일 발사 좌표는 수정됨.
			g.drawImage(missileImg, ms.pos.x, ms.pos.y, this); 
		}		
				
	}	
	
	// 적 비행기 그리는 부분
	public void drawEnemy(Graphics g){ 
		for (int i = 0 ; i < enemyList.size() ; ++i ){
			//배열에 생성된 각 적을 판별하여 이미지 그리기
			Enemy en = enemyList.get(i);
			g.drawImage(enemyImg, en.x, en.y, this);
		}
	}
	
	/* ---------------- 사용자정의 메서드  끝 --------------- */
	
	
	// 미사일 위치 파악 및 이동을 위한 클래스 추가
	class Missile{  

		//미사일 좌표 변수
		Point pos; 		 
		
		//미사일 좌표를 입력 받는 생성자
		Missile(int x, int y){ 
			pos = new Point(x, y); 
		}
		
		//미사일 이동을 위한 메소드
		public void move(){
			//x 좌표에 10만큼 미사일 이동
			pos.x += 10; 
		}
	}
	
	// 적 위치 파악 및 이동을 위한 클래스
	class Enemy{ 
		int x, y;

		// 적좌표를 받아 객체화 시키기 위한 생성자
		Enemy(int x, int y){ 
			this.x = x;
			this.y = y;
		}
		
		// x좌표 -3 만큼 이동 시키는 명령 메소드
		public void move(){ 
			x -= 3;
		}
	}	
}