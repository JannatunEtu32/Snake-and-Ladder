import java.awt.Font;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.Color;



public class Game_Board_Snake_Ladder extends JFrame 
{
    
         JPanel c;
	 JLabel lboimg = new JLabel("");
	 JLabel imgdice;
	 JLabel lp1,lp2,lp3,lp4,sp1 , sp2 ,
                 sp3 , sp4 ,showPn , p1g , p2g , p3g , p4g;
         JLabel imgbackgreound;
	 JButton bd, br, bru, binfo, be; 
         ImageIcon icon,img;
        
        
	  JLabel td;
	  JLabel l91, l92, l93, l94, l95, l96, l97, l98, l100, l99, l90, l89, l88, l87, l86, l85, l84, l83,
            l81, l82, l71, l72, l73, l74, l75, l76, l77, l78, l80, l79, l70, l69, l68, l67, l66, l65, l64, l63, l61,
            l62, l51, l52, l53, l54, l55, l56, l57, l58, l60, l59, l50, l49, l48, l47, l46, l45, l44, l43, l41, l42,
            l31, l32, l33, l34, l35, l36, l37, l38, l40, l39, l30, l29, l28, l27, l26, l25, l24, l23, l21, l22, l11,
            l12, l13, l14, l15, l16, l17, l18, l19, l20, l10, l9, l8, l7, l6, l5, l4, l3, l2, l1 ;
            
	
          int f1=0,WinnerRanking=0, diceClick=0;
          int player=1;   
	  int playerpoint=6;
	  int[] startplay= new int[playerpoint];  
          int playernum=4;
	  int[] pp= new int[playernum]; //4 jon player position kothay ace seta show korte
	  int point, score=0, f=0,ranpic=0;
          int playerNo;
	  int count=0;
	  int cpp=0,six=0;
	  String[] PN;
        
	public Game_Board_Snake_Ladder()  
        {
                                        
                                        startGame();
                                        setTitle("Snakes and Ladders");          
                                        setExtendedState(JFrame.MAXIMIZED_BOTH);
                                        setVisible(true);
                                        setResizable(true);
                                        icon = new ImageIcon(getClass().getResource("/Image/icon3.png"));
                                        setIconImage(icon.getImage());
	}
        
	public static void main(String[] args) {
                
                            Game_Board_Snake_Ladder frame = new Game_Board_Snake_Ladder();
	}



	
	public void Dice()
        {
            
                Random rn = new Random();
                point = rn.nextInt(6)+1;
		String dice = String.valueOf(point);
		String location = "/Image/dice "+dice+".png";
		imgdice.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));
                
                
		if(point==1) 
                startplay[player-1]=1;    
		if(startplay[player-1]==1)
                    diceMove();
		
	}
	public void diceMove()
        {
		if(point==6)
                {
                    six++;
		}
                
                else 
                    six=0;
		
		if(six>0)
                {
		cpp=pp[player-1];
		showPn.setText(PN[player-1]);
		count=1;
		 colorChange();
		}
                
                
		if(count==1 & six==0)
                {
			if(player==playernum)
                            showPn.setText(PN[0]);
			
	 		else 
                            showPn.setText(PN[player]);
			count=0;
		}

		if(pp[player-1]+point >100)
                {   
			pp[player-1]= pp[player-1] ;
		}	
		
                
		else if(six==3)
                {
			pp[player-1]=cpp;
                }
		
		
		else
                {	
                int a= pp[player-1];
		int b= pp[player-1]+point;
		pp[player-1]+=point;          
                for(int i=a;i<b;i++)
                {
        	try {
        		imgDlt(i);
        		Thread.sleep(100);
            	       Imgsetup(i+1, player);
				Thread.sleep(100);
			} 
                catch (Exception e) {
				
                    
			}
                                    }
                           
                              mgs_of_snake_ladder(pp[player-1]); 
		       if(pp[player-1] != snakeLadder(pp[player-1]))
                            {     
			imgDlt(pp[player-1]);
			pp[player-1]=snakeLadder(pp[player-1]);
			Imgsetup(pp[player-1], player);
		               }  
		              winnerM();     
		              setScore();     
	
		           }
	                   }
        
        
	           public void colorChange(){
		       if(player==1){
	 			showPn.setForeground(Color.red); 
	 		}
	 		if(player==2){
	 			showPn.setForeground(Color.black); 
	 		}
	 		if(player==3){
	 			showPn.setForeground(Color.red); 
	 		}
	 		if(player==4){
	 			
	 			showPn.setForeground(Color.black); 
	 		}
	                                       }




	        public void SamePositionCheck(int num)
                {        
		for(int i=0; i<playernum; i++)
                {
			if(pp[i] == num && pp[i] != 0 && player != i+1)
                        {
				Imgsetup(num, i+1);
			}
		}
	        }
                
                
                    public void winnerM(){

                                 if(pp[player-1]==100)
                                     WinnerRanking++;

                                 if(pp[player-1] ==100 && f1==0)
                                 {   
                                         JOptionPane.showMessageDialog(null, "Player "+player+" won!!");
                                         f1=1;
                                 }
	   
                                          }
   
                  public void setScore(){
	   
		            if(player==1)
                            {
			    if(pp[player-1]==100)
                            sp1.setText("Winner "+WinnerRanking);
			     else 
                            sp1.setText(String.valueOf(pp[player-1]));
		            }
		
		           else if(player==2){
			
			  if(pp[player-1]==100) 
                             sp2.setText("Winner "+WinnerRanking);
			else 
			sp2.setText(String.valueOf(pp[player-1]));	
		             }
                           
		         else if(player==3){
			
			  if(pp[player-1]==100) sp3.setText("Winner "+WinnerRanking);
				else 
				sp3.setText(String.valueOf(pp[player-1]));	 	
		             }
		         else if(player==4){
	
			
			 if(pp[player-1]==100) sp4.setText("Winner "+WinnerRanking);
				else 
				sp4.setText(String.valueOf(pp[player-1]));	 	
		}
	   
   }



    public void mgs_of_snake_ladder(int score){            
           if(score == 6 || score == 10  || score == 17  || score == 41 || score == 67 ){
	
	JOptionPane.showMessageDialog(null, PN[player-1]+" Climbed Ladder at "+String.valueOf(score));
            }
            else if(score == 99  ||score == 94 ||  score == 89 || score == 65  ||score == 53  || score == 47  || score == 39 ){

	JOptionPane.showMessageDialog(null, PN[player-1]+" Eaten by Snake at "+String.valueOf(score));
            }
    }
    
    
    
        public int snakeLadder(int score){
		if(score == 99)
			return 79;
		else if(score == 94)
			return 63;
		else if(score == 89)
			return 54;
		else if(score == 65)
			return 40;
		else if(score == 53)
			return 12;
		else if(score == 47)
			return 16;
		else if(score == 39)
			return 3;
		else if(score == 41)
			return 97;
		else if(score == 67)
			return 88;
		else if(score == 17)
			return 43;
		else if(score == 6)
			return 44;
                else if(score == 10)
			return 32;

		else
			return score;

	}

        
        public void imgDlt(int Num){
            
                if(Num == 1){l1.setVisible(false);} else if(Num == 2){l2.setVisible(false);} else if(Num == 3){l3.setVisible(false);} else if(Num == 4){l4.setVisible(false);}
                else if(Num == 5){l5.setVisible(false);} else if(Num == 6){ l6.setVisible(false);} else if(Num == 7){l7.setVisible(false);}else if(Num == 8){l8.setVisible(false);}
                else if(Num == 9){l9.setVisible(false);} else if(Num == 10){l10.setVisible(false);} else if(Num == 11){l11.setVisible(false);} else if(Num == 12){l12.setVisible(false);}
                else if(Num == 13){l13.setVisible(false);} else if(Num == 14){l14.setVisible(false);} else if(Num == 15){l15.setVisible(false);} else if(Num == 16){l16.setVisible(false);}
                else if(Num == 17){l17.setVisible(false);} else if(Num == 18){l18.setVisible(false);} else if(Num == 19){l19.setVisible(false);} else if(Num == 20){l20.setVisible(false);}
                else if(Num == 21){l21.setVisible(false);} else if(Num == 22){l22.setVisible(false);} else if(Num == 23){l23.setVisible(false);} else if(Num == 24){l24.setVisible(false);}
                else if(Num == 25){l25.setVisible(false);} else if(Num == 26){l26.setVisible(false);} else if(Num == 27){l27.setVisible(false);} else if(Num == 28){l28.setVisible(false);}
                else if(Num == 29){l29.setVisible(false);} else if(Num == 30){l30.setVisible(false);} else if(Num == 31){l31.setVisible(false);} else if(Num == 32){l32.setVisible(false);}
                else if(Num == 33){l33.setVisible(false);} else if(Num == 34){l34.setVisible(false);} else if(Num == 35){l35.setVisible(false);} else if(Num == 36){l36.setVisible(false);}
                else if(Num == 37){l37.setVisible(false);} else if(Num == 38){l38.setVisible(false);} else if(Num == 39){l39.setVisible(false);} else if(Num == 40){l40.setVisible(false);}
                else if(Num == 41){l41.setVisible(false);} else if(Num == 42){l42.setVisible(false);} else if(Num == 43){l43.setVisible(false);} else if(Num == 44){l44.setVisible(false);}
                else if(Num == 45){l45.setVisible(false);} else if(Num == 46){l46.setVisible(false);} else if(Num == 47){l47.setVisible(false);} else if(Num == 48){l48.setVisible(false);}
                else if(Num == 49){l49.setVisible(false);} else if(Num == 50){l50.setVisible(false);} else if(Num == 51){l51.setVisible(false);} else if(Num == 52){l52.setVisible(false);}
                else if(Num == 53){l53.setVisible(false);} else if(Num == 54){l54.setVisible(false);} else if(Num == 55){l55.setVisible(false);} else if(Num == 56){l56.setVisible(false);}
                else if(Num == 57){l57.setVisible(false);} else if(Num == 58){l58.setVisible(false);} else if(Num == 59){l59.setVisible(false);} else if(Num == 60){l60.setVisible(false);}
                else if(Num == 61){l61.setVisible(false);} else if(Num == 62){l62.setVisible(false);} else if(Num == 63){l63.setVisible(false);} else if(Num == 64){l64.setVisible(false);}
                else if(Num == 65){l65.setVisible(false);} else if(Num == 66){l66.setVisible(false);} else if(Num == 67){l67.setVisible(false);} else if(Num == 68){l68.setVisible(false);}
                else if(Num == 69){l69.setVisible(false);} else if(Num == 70){l70.setVisible(false);} else if(Num == 71){l71.setVisible(false);} else if(Num == 72){l72.setVisible(false);}
                else if(Num == 73){l73.setVisible(false);} else if(Num == 74){l74.setVisible(false);} else if(Num == 75){l75.setVisible(false);} else if(Num == 76){l76.setVisible(false);}
                else if(Num == 77){l77.setVisible(false);} else if(Num == 78){l78.setVisible(false);} else if(Num == 79){l79.setVisible(false);} else if(Num == 80){l80.setVisible(false);}
                else if(Num == 81){l81.setVisible(false);} else if(Num == 82){l82.setVisible(false);}else if(Num == 83){l83.setVisible(false);} else if(Num == 84){l84.setVisible(false);}
                else if(Num == 85){l85.setVisible(false);} else if(Num == 86){l86.setVisible(false);} else if(Num == 87){l87.setVisible(false);} else if(Num == 88){l88.setVisible(false);}
                else if(Num == 89){l89.setVisible(false);} else if(Num == 90){l90.setVisible(false);} else if(Num == 91){l91.setVisible(false);} else if(Num == 92){l92.setVisible(false);}
                else if(Num == 93){l93.setVisible(false);} else if(Num == 94){l94.setVisible(false);} else if(Num == 95){l95.setVisible(false);} else if(Num == 96){l96.setVisible(false);}
                else if(Num == 97){l97.setVisible(false);} else if(Num == 98){l98.setVisible(false);} else if(Num == 99){l99.setVisible(false);} else if(Num == 100){l100.setVisible(false);}

		SamePositionCheck(Num);  

	}


	public void Imgsetup(int num, int pi){  


	    String p=String.valueOf(pi);

		String location = "/Image/Player "+p+".png";


		     if(num == 1){			
                    l1.setVisible(true);			
                    l1.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 2){			
                    l2.setVisible(true);			
                    l2.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 3){			
                    l3.setVisible(true);			
                    l3.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 4){			
                    l4.setVisible(true);			
                    l4.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 5){			
                    l5.setVisible(true);			
                    l5.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 6){			
                    l6.setVisible(true);			
                    l6.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 7){			
                    l7.setVisible(true);			
                    l7.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 8){			
                    l8.setVisible(true);			
                    l8.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 9){		
                    l9.setVisible(true);			
                    l9.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 10){			
                    l10.setVisible(true);			
                    l10.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 11){			
                    l11.setVisible(true);			
                    l11.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 12){			
                    l12.setVisible(true);			
                    l12.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 13){			
                    l13.setVisible(true);			
                    l13.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 14){			
                    l14.setVisible(true);			
                    l14.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 15){			
                    l15.setVisible(true);			
                    l15.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 16){			
                    l16.setVisible(true);			
                    l16.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 17){			
                    l17.setVisible(true);			
                    l17.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 18){			
                    l18.setVisible(true);			
                    l18.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 19){			
                    l19.setVisible(true);			
                    l19.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 20){			
                    l20.setVisible(true);			
                    l20.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 21){			
                    l21.setVisible(true);			
                    l21.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 22){			
                    l22.setVisible(true);			
                    l22.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 23){			
                    l23.setVisible(true);			
                    l23.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 24){			
                    l24.setVisible(true);			
                    l24.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 25){			
                    l25.setVisible(true);			
                    l25.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 26){			
                    l26.setVisible(true);		
                    l26.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 27){			
                    l27.setVisible(true);			
                    l27.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 28){			
                    l28.setVisible(true);			
                    l28.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 29){			
                    l29.setVisible(true);			
                    l29.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 30){			
                    l30.setVisible(true);			
                    l30.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 31){			
                    l31.setVisible(true);			
                    l31.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 32){			
                    l32.setVisible(true);			
                    l32.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 33){			
                    l33.setVisible(true);			
                    l33.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 34){			
                    l34.setVisible(true);			
                    l34.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 35){			
                    l35.setVisible(true);			
                    l35.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 36){			
                    l36.setVisible(true);			
                    l36.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 37){			
                    l37.setVisible(true);			
                    l37.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 38){			
                    l38.setVisible(true);			
                    l38.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 39){			
                    l39.setVisible(true);			
                    l39.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 40){			
                    l40.setVisible(true);			
                    l40.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 41){			
                    l41.setVisible(true);			
                    l41.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 42){			
                    l42.setVisible(true);			
                    l42.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 43){			
                    l43.setVisible(true);			
                    l43.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 44){			
                    l44.setVisible(true);			
                    l44.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 45){			
                    l45.setVisible(true);			
                    l45.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 46){			
                    l46.setVisible(true);			
                    l46.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 47){			
                    l47.setVisible(true);			
                    l47.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 48){			
                    l48.setVisible(true);			
                    l48.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 49){			
                    l49.setVisible(true);			
                    l49.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 50){			
                    l50.setVisible(true);			
                    l50.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 51){			
                    l51.setVisible(true);			
                    l51.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 52){			
                    l52.setVisible(true);			
                    l52.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 53){			
                    l53.setVisible(true);			
                    l53.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 54){			
                    l54.setVisible(true);			
                    l54.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 55){			
                    l55.setVisible(true);			
                    l55.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 56){			
                    l56.setVisible(true);			
                    l56.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 57){			
                    l57.setVisible(true);			
                    l57.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 58){			
                    l58.setVisible(true);			
                    l58.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 59){			
                    l59.setVisible(true);			
                    l59.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 60){			
                    l60.setVisible(true);			
                    l60.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 61){			
                    l61.setVisible(true);			
                    l61.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 62){			
                    l62.setVisible(true);			
                    l62.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 63){			
                    l63.setVisible(true);			
                    l63.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 64){			
                    l64.setVisible(true);			
                    l64.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 65){			
                    l65.setVisible(true);			
                    l65.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 66){			
                    l66.setVisible(true);			
                    l66.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 67){			
                    l67.setVisible(true);			
                    l67.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 68){			
                    l68.setVisible(true);			
                    l68.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 69){			
                    l69.setVisible(true);			
                    l69.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 70){			
                    l70.setVisible(true);			
                    l70.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 71){			
                    l71.setVisible(true);			
                    l71.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 72){			
                    l72.setVisible(true);			
                    l72.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 73){			
                    l73.setVisible(true);			
                    l73.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 74){			
                    l74.setVisible(true);			
                    l74.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 75){			
                    l75.setVisible(true);			
                    l75.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));	
                }		else if(num == 76){			
                    l76.setVisible(true);			
                    l76.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 77){			
                    l77.setVisible(true);			
                    l77.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 78){			
                    l78.setVisible(true);			
                    l78.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 79){			
                    l79.setVisible(true);			
                    l79.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 80){			
                    l80.setVisible(true);			
                    l80.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 81){			
                    l81.setVisible(true);			
                    l81.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 82){			
                    l82.setVisible(true);			
                    l82.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 83){			
                    l83.setVisible(true);			
                    l83.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 84){			
                    l84.setVisible(true);			
                    l84.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 85){			l85.setVisible(true);			
                l85.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 86){			l86.setVisible(true);			
                l86.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 87){			l87.setVisible(true);			
                l87.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 88){			l88.setVisible(true);			
                l88.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 89){			l89.setVisible(true);			
                l89.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 90){			l90.setVisible(true);			
                l90.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 91){			l91.setVisible(true);			
                l91.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 92){			l92.setVisible(true);			
                l92.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 93){			l93.setVisible(true);			
                l93.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 94){			l94.setVisible(true);			
                l94.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 95){			l95.setVisible(true);			
                l95.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 96){			l96.setVisible(true);			
                l96.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 97){			l97.setVisible(true);			
                l97.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 98){			l98.setVisible(true);			
                l98.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 99){			l99.setVisible(true);			
                l99.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }		else if(num == 100){			l100.setVisible(true);			
                l100.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource(location)));		
                }

	}


	public void startGame(){    
		
		
		try{
			do{
                playernum = Integer.parseInt(JOptionPane.showInputDialog("Enter No of players\nPlayers must be between 2-4"));
			}
                        while(playernum < 2 || playernum > 4);
		}
                         catch(Exception e){
			JOptionPane.showMessageDialog(null, "Invalid players");
			System.exit(0);
		}


		
	c = new JPanel();
        setContentPane(c);
        c.setLayout(null);
        img = new ImageIcon(getClass().getResource("/Image/background.png"));
        imgbackgreound = new JLabel(img);
        imgbackgreound.setBounds(0, 0, 1925, 1080);
        c.add(imgbackgreound);

         l1 = new JLabel("");
        l1.setBounds(190, 850, 90, 90);
        imgbackgreound.add(l1);

        l2 = new JLabel("");
        l2.setBounds(280, 850, 90, 90);
        imgbackgreound.add(l2);

        l3 = new JLabel("");
        l3.setBounds(370, 850, 90, 90);
        imgbackgreound.add(l3);

        l4 = new JLabel("");
        l4.setBounds(460, 850, 90, 90);
        imgbackgreound.add(l4);

        l5 = new JLabel("");
        l5.setBounds(550, 850, 90, 90);
        imgbackgreound.add(l5);

        l6 = new JLabel("");
        l6.setBounds(640, 850, 90, 90);
        imgbackgreound.add(l6);

        l7 = new JLabel("");
        l7.setBounds(740, 850, 90, 90);
        imgbackgreound.add(l7);

        l8 = new JLabel("");
        l8.setBounds(840, 850, 90, 90);
        imgbackgreound.add(l8);

        l9 = new JLabel("");
        l9.setBounds(930, 850, 90, 90);
        imgbackgreound.add(l9);

        l10 = new JLabel("");
        l10.setBounds(1020, 850, 90, 90);
        imgbackgreound.add(l10);

        l11 = new JLabel("");
        l11.setBounds(1020, 760, 90, 90);
        imgbackgreound.add(l11);

        l12 = new JLabel("");
        l12.setBounds(920, 760, 90, 90);
        imgbackgreound.add(l12);

        l13 = new JLabel("");
        l13.setBounds(830, 760, 90, 90);
        imgbackgreound.add(l13);

        l14 = new JLabel("");
        l14.setBounds(740, 760, 90, 90);
        imgbackgreound.add(l14);

        l15 = new JLabel("");
        l15.setBounds(640, 750, 90, 90);
        imgbackgreound.add(l15);

        l16 = new JLabel("");
        l16.setBounds(550, 760, 90, 90);
        imgbackgreound.add(l16);

        l17 = new JLabel("");
        l17.setBounds(450, 760, 90, 90);
        imgbackgreound.add(l17);

        l18 = new JLabel("");
        l18.setBounds(350, 760, 90, 90);
        imgbackgreound.add(l18);

        l19 = new JLabel("");
        l19.setBounds(260, 760, 90, 90);
        imgbackgreound.add(l19);

        l20 = new JLabel("");
        l20.setBounds(170, 760, 90, 90);
        imgbackgreound.add(l20);

        l21 = new JLabel("");
        l21.setBounds(170, 670, 90, 90);
        imgbackgreound.add(l21);

        l22 = new JLabel("");
        l22.setBounds(260, 670, 90, 90);
        imgbackgreound.add(l22);

        l23 = new JLabel("");
        l23.setBounds(350, 670, 90, 90);
        imgbackgreound.add(l23);

        l24 = new JLabel("");
        l24.setBounds(440, 670, 90, 90);
        imgbackgreound.add(l24);

        l25 = new JLabel("");
        l25.setBounds(540, 670, 90, 90);
        imgbackgreound.add(l25);

        l26 = new JLabel("");
        l26.setBounds(650, 670, 90, 90);
        imgbackgreound.add(l26);

        l27 = new JLabel("");
        l27.setBounds(750, 670, 90, 90);
        imgbackgreound.add(l27);

        l28 = new JLabel("");
        l28.setBounds(850, 670, 90, 90);
        imgbackgreound.add(l28);

        l29 = new JLabel("");
        l29.setBounds(920, 670, 90, 90);
        imgbackgreound.add(l29);

        l30 = new JLabel("");
        l30.setBounds(1020, 670, 90, 90);
        imgbackgreound.add(l30);

        l31 = new JLabel("");
        l31.setBounds(1020, 590, 90, 90);
        imgbackgreound.add(l31);

        l32 = new JLabel("");
        l32.setBounds(920, 590, 90, 90);
        imgbackgreound.add(l32);

        l33 = new JLabel("");
        l33.setBounds(830, 590, 90, 90);
        imgbackgreound.add(l33);
        
        l34 = new JLabel("");
        l34.setBounds(730, 590, 90, 90);
        imgbackgreound.add(l34);

        l35 = new JLabel("");
        l35.setBounds(640, 590, 90, 90);
        imgbackgreound.add(l35);

        l36 = new JLabel("");
        l36.setBounds(540, 590, 90, 90);
        imgbackgreound.add(l36);

        l37 = new JLabel("");
        l37.setBounds(440, 590, 90, 90);
        imgbackgreound.add(l37);

        l38 = new JLabel("");
        l38.setBounds(350, 590, 90, 90);
        imgbackgreound.add(l38);

        l39 = new JLabel("");
        l39.setBounds(260, 590, 90, 90);
        imgbackgreound.add(l39);

        l40 = new JLabel("");
        l40.setBounds(170, 590, 90, 90);
        imgbackgreound.add(l40);

        l41 = new JLabel("");
        l41.setBounds(170, 500, 90, 90);
        imgbackgreound.add(l41);

        l42 = new JLabel("");
        l42.setBounds(260, 500, 90, 90);
        imgbackgreound.add(l42);

        l43 = new JLabel("");
        l43.setBounds(350, 500, 90, 90);
        imgbackgreound.add(l43);

        l44 = new JLabel("");
        l44.setBounds(450, 500, 90, 90);
        imgbackgreound.add(l44);

        l45 = new JLabel("");
        l45.setBounds(550, 500, 90, 90);
        imgbackgreound.add(l45);

        l46 = new JLabel("");
        l46.setBounds(640, 500, 90, 90);
        imgbackgreound.add(l46);

        l47 = new JLabel("");
        l47.setBounds(730, 500, 90, 90);
        imgbackgreound.add(l47);

        l48 = new JLabel("");
        l48.setBounds(830, 500, 90, 90);
        imgbackgreound.add(l48);

        l49 = new JLabel("");
        l49.setBounds(930, 500, 90, 90);
        imgbackgreound.add(l49);

        l50 = new JLabel("");
        l50.setBounds(1020, 500, 90, 90);
        imgbackgreound.add(l50);

        l51 = new JLabel("");
        l51.setBounds(1020, 410, 90, 90);
        imgbackgreound.add(l51);

        l52 = new JLabel("");
        l52.setBounds(930, 410, 90, 90);
        imgbackgreound.add(l52);

        l53 = new JLabel("");
        l53.setBounds(820, 410, 90, 90);
        imgbackgreound.add(l53);

        l54 = new JLabel("");
        l54.setBounds(730, 410, 90, 90);
        imgbackgreound.add(l54);

        l55 = new JLabel("");
        l55.setBounds(640, 410, 90, 90);
        imgbackgreound.add(l55);

        l56 = new JLabel("");
        l56.setBounds(530, 410, 90, 90);
        imgbackgreound.add(l56);

        l57 = new JLabel("");
        l57.setBounds(440, 410, 90, 90);
        imgbackgreound.add(l57);

        l58 = new JLabel("");
        l58.setBounds(350, 410, 90, 90);
        imgbackgreound.add(l58);  
        
        l59 = new JLabel("");
        l59.setBounds(260, 410, 90, 90);
        imgbackgreound.add(l59);

        l60 = new JLabel("");
        l60.setBounds(170, 410, 90, 90);
        imgbackgreound.add(l60);

        l61 = new JLabel("");
        l61.setBounds(170, 320, 90, 90);
        imgbackgreound.add(l61);

        l62 = new JLabel("");
        l62.setBounds(260, 320, 90, 90);
        imgbackgreound.add(l62);

        l63 = new JLabel("");
        l63.setBounds(350, 320, 90, 90);
        imgbackgreound.add(l63);

        l64 = new JLabel("");
        l64.setBounds(440, 320, 90, 90);
        imgbackgreound.add(l64);

        l65 = new JLabel("");
        l65.setBounds(540, 320, 90, 90);
        imgbackgreound.add(l65);

        l66 = new JLabel("");
        l66.setBounds(640, 320, 90, 90);
        imgbackgreound.add(l66);

        l67 = new JLabel("");
        l67.setBounds(730, 320, 90, 90);
        imgbackgreound.add(l67);

        l68 = new JLabel("");
        l68.setBounds(840, 320, 90, 90);
        imgbackgreound.add(l68);

        l69 = new JLabel("");
        l69.setBounds(930, 320, 90, 90);
        imgbackgreound.add(l69);

        l70 = new JLabel("");
        l70.setBounds(1020, 320, 90, 90);
        imgbackgreound.add(l70);

        l71 = new JLabel("");
        l71.setBounds(1030, 230, 90, 90);
        imgbackgreound.add(l71);

        l72 = new JLabel("");
        l72.setBounds(920, 230, 90, 90);
        imgbackgreound.add(l72);

        l73 = new JLabel("");
        l73.setBounds(830, 230, 90, 90);
        imgbackgreound.add(l73);

        l74 = new JLabel("");
        l74.setBounds(730, 230, 90, 90);
        imgbackgreound.add(l74);

        l75 = new JLabel("");
        l75.setBounds(630, 230, 90, 90);
        imgbackgreound.add(l75);

        l76 = new JLabel("");
        l76.setBounds(530, 230, 90, 90);
        imgbackgreound.add(l76);

        l77 = new JLabel("");
        l77.setBounds(440, 230, 90, 90);
        imgbackgreound.add(l77);

        l78 = new JLabel("");
        l78.setBounds(350, 230, 90, 90);
        imgbackgreound.add(l78);

        l79 = new JLabel("");
        l79.setBounds(260, 230, 90, 90);
        imgbackgreound.add(l79);

        l80 = new JLabel("");
        l80.setBounds(170, 230, 90, 90);
        imgbackgreound.add(l80);

        l81 = new JLabel("");
        l81.setBounds(170, 140, 90, 90);
        imgbackgreound.add(l81);

        l82 = new JLabel("");
        l82.setBounds(260, 140, 90, 90);
        imgbackgreound.add(l82);

        l83 = new JLabel("");
        l83.setBounds(350, 140, 90, 90);
        imgbackgreound.add(l83);

        l84 = new JLabel("");
        l84.setBounds(440, 140, 90, 90);
        imgbackgreound.add(l84);

        l85 = new JLabel("");
        l85.setBounds(530, 140, 90, 90);
        imgbackgreound.add(l85);

        l86 = new JLabel("");
        l86.setBounds(640, 140, 90, 90);
        imgbackgreound.add(l86);

        l87 = new JLabel("");
        l87.setBounds(730, 140, 90, 90);
        imgbackgreound.add(l87);

        l88 = new JLabel("");
        l88.setBounds(830, 140, 90, 90);
        imgbackgreound.add(l88);

        l89 = new JLabel("");
        l89.setBounds(930, 140, 90, 90);
        imgbackgreound.add(l89);

        l90 = new JLabel("");
        l90.setBounds(1020, 140, 90, 90);
        imgbackgreound.add(l90);

        l91 = new JLabel("");
        l91.setBounds(1020, 60, 90, 90);
        imgbackgreound.add(l91);

        l92 = new JLabel("");
        l92.setBounds(920, 60, 90, 90);
        imgbackgreound.add(l92);

        l93 = new JLabel("");
        l93.setBounds(840, 60, 90, 90);
        imgbackgreound.add(l93);

        l94 = new JLabel("");
        l94.setBounds(730, 60, 90, 90);
        imgbackgreound.add(l94);

        l95 = new JLabel("");
        l95.setBounds(640, 60, 90, 90);
        imgbackgreound.add(l95);

        l96 = new JLabel("");
        l96.setBounds(540, 60, 90, 90);
        imgbackgreound.add(l96);

        l97 = new JLabel("");
        l97.setBounds(450, 60, 90, 90);
        imgbackgreound.add(l97);

        l98 = new JLabel("");
        l98.setBounds(350, 60, 90, 90);
        imgbackgreound.add(l98);

        l99 = new JLabel("");
        l99.setBounds(260, 60, 90, 90);
        imgbackgreound.add(l99);

        l100 = new JLabel("");
        l100.setBounds(170, 60, 90, 90);
        imgbackgreound.add(l100);

		 td = new JLabel("Through Dice Now :");
		 td.setFont(new Font("Font size", Font.BOLD, 25));
		 td.setForeground(Color.MAGENTA);
		 td.setBounds(1170, 77, 250, 50);
		 imgbackgreound.add(td);

		 bd = new JButton("Roll Dice");
		 bd.setFont(new Font("", Font.BOLD, 30));
		 bd.setForeground(Color.WHITE);
		 bd.setBackground(Color.red);
		 bd.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) 
                 {
                     
                    diceClick++;
                                          
                     try {
                         Thread.sleep(900);
                     } 
                     catch (InterruptedException ex) 
                     {
                        
                     }
                                                                                                    
		 		bd.setBackground(Color.red);
		 		if(six==0){
                                    
		 		if(WinnerRanking==playernum-1){
		 			int confirm = JOptionPane.showConfirmDialog(null, "Replay?", "", JOptionPane.YES_NO_OPTION);
					if(confirm == JOptionPane.YES_OPTION){
						dispose();
						Game_Board_Snake_Ladder frame = new Game_Board_Snake_Ladder();
						frame.setVisible(true);
					}
					else{
						setVisible(false);
						dispose(); 	
					}
		 		                          }
		 		if(player==playernum)
                                {
                                    showPn.setText(PN[0]);
                                }
	
	 		        else {
                                    showPn.setText(PN[player]);
                                     }
		 		
		 		
		 		if(player==1){
                                     JOptionPane.showMessageDialog(null,"Now Player 1 roll dice");
		 			showPn.setForeground(Color.blue);         
		 		}
                               
		 		if(player==2){
                                    JOptionPane.showMessageDialog(null,"Now Player 2 roll dice");
		 			showPn.setForeground(Color.DARK_GRAY); 
                                        
		 		}
                                
		 		if(player==3){
                                   JOptionPane.showMessageDialog(null,"Now Player 3 roll dice");
		 			showPn.setForeground(Color.black); 
                                         
		 		}
                                
		 		if(player==4){
		 			JOptionPane.showMessageDialog(null,"Now Player 4 roll dice");
		 			showPn.setForeground(Color.RED); 
                                        
		 		}
		 		}
		 		
		 		Dice();     
		 		if(six==0)
		 		{
		 			player++;
                                        
		 		    if(player==playernum+1)
                                    {
                                        player=1;
                                    } 
		 		}
		 	}
		 });
                 
		bd.setBackground(Color.black);
		bd.setBounds(1265, 190, 210, 65);
		imgbackgreound.add(bd);


		c.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "EXIT");
                c.getRootPane().getActionMap().put("EXIT", new AbstractAction(){
                public void actionPerformed(ActionEvent e)
                	{
                		
                		bd.doClick();
                	}
                });


		lp1 = new JLabel("Player1-");
		lp1.setForeground(Color.red);
		lp1.setFont(new Font("Font Size", Font.BOLD, 25));
		lp1.setBounds(1190, 460, 200, 50);
		imgbackgreound.add(lp1);

		imgdice = new JLabel(".");
		imgdice.setHorizontalAlignment(SwingConstants.CENTER);
		imgdice.setBounds(1310, 290, 132, 129);
		imgbackgreound.add(imgdice);

        sp1 = new JLabel("Score");
        sp1.setFont(new Font("Font Size", Font.BOLD, 25));
        sp1.setForeground(Color.red);
        sp1.setBounds(1455, 460, 120, 50);
        imgbackgreound.add(sp1);

        lp2 = new JLabel("Player2-");
        lp2.setFont(new Font("Font Size", Font.BOLD, 25));
        lp2.setForeground(Color.blue);
        lp2.setBounds(1190, 550, 200, 50);
        imgbackgreound.add(lp2);

        sp2 = new JLabel("Score");
        sp2.setFont(new Font("Font Size", Font.BOLD, 25));
        sp2.setForeground(Color.red);
        sp2.setBounds(1455, 550, 120, 50);
        imgbackgreound.add(sp2);
        
        lboimg.setBounds(130, 50, 950, 900);
        lboimg.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource("/Image/luduboard.png")));
        imgbackgreound.add(lboimg);
        
       
        lp3 = new JLabel("Player3-");
        lp3.setFont(new Font("Font Size", Font.BOLD, 25));
        lp3.setForeground(Color.red);
        lp3.setBounds(1190, 640, 200, 50);
        imgbackgreound.add(lp3);

        sp3 = new JLabel("Score");
        sp3.setFont(new Font("Font Size", Font.BOLD, 25));
        sp3.setForeground(Color.BLUE);
        sp3.setBounds(1455, 640, 120, 50);
        imgbackgreound.add(sp3);

        lp4 = new JLabel("Player4-");
        lp4.setForeground(Color.blue);
        lp4.setFont(new Font("Font Size", Font.BOLD, 25));
        lp4.setBounds(1190, 730, 200, 50);
        imgbackgreound.add(lp4);

        sp4 = new JLabel("Score");
        sp4.setFont(new Font("Font size", Font.BOLD, 25));
        sp4.setForeground(Color.blue);
        sp4.setBounds(1455, 730, 120, 50);
        imgbackgreound.add(sp4);

        showPn = new JLabel("");
        showPn.setForeground(new Color(255, 0, 0));
        showPn.setFont(new Font("Font size", Font.BOLD | Font.ITALIC, 25));
        showPn.setBounds(1490, 77, 250, 50);
        imgbackgreound.add(showPn);

        p1g = new JLabel("");
        p1g.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource("/Image/player 1.png")));
        p1g.setBounds(1630, 460, 60, 60);
        imgbackgreound.add(p1g);

        p2g = new JLabel("");
        p2g.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource("/Image/player 2.png")));
        p2g.setBounds(1630, 550, 60, 60);
        imgbackgreound.add(p2g);

        p3g = new JLabel("");
        p3g.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource("/Image/player 3.png")));
        p3g.setBounds(1630, 640, 60, 60);
        imgbackgreound.add(p3g);

        p4g = new JLabel("");
        p4g.setIcon(new ImageIcon(Game_Board_Snake_Ladder.class.getResource("/Image/player 4.png")));
        p4g.setBounds(1630, 730, 60, 60);
        imgbackgreound.add(p4g);


       
        

        br = new JButton("Restart Game");
        br.setBackground( Color.cyan);
        br.setForeground( Color.black); 
        br.setFont(new Font("Font Size", Font.BOLD, 25));
        br.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Restart?", "Restart!", JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION){
					dispose();
					Game_Board_Snake_Ladder frame = new Game_Board_Snake_Ladder();
					frame.setVisible(true);
				}
        	}
        });
        br.setBounds(1125, 887, 230, 60);
        imgbackgreound.add(br);
       
        
        bru = new JButton("Rules");
        bru.setBackground(Color.blue);
        bru .setForeground( Color.WHITE);
        bru.setFont(new Font("Font Size", Font.BOLD, 25));
        bru.setBounds(1395, 887, 110, 60);
        imgbackgreound.add(bru);
        bru.addActionListener(new ActionListener() {
            
                    
                    public void actionPerformed(ActionEvent e) 
                    {
                        
                        
                        Rules x = new Rules();
                        
                    }
                });
        
        
        binfo = new JButton("Info");
        binfo.setBackground(Color.red);
        binfo.setForeground( Color.WHITE);
        binfo.setFont(new Font("Font size", Font.BOLD, 25));
        binfo.setBounds(1545, 887, 110, 60);
        imgbackgreound.add(binfo);
        binfo.addActionListener(new ActionListener() {
                   
                    public void actionPerformed(ActionEvent e) {
                           My_Info x = new My_Info();
                    }
                });
        
        
        be = new JButton("Exit");
        be.setBackground(Color.black);
        be.setForeground(Color.WHITE);
        be.setFont(new Font("Font Size", Font.BOLD, 23));
        be.setBounds(1695, 887, 150, 60);
        imgbackgreound.add(be);
        be.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
        
        inputName();     
        showPn.setText(PN[0]); 

        for(int i=0;i<playernum;i++)
        {
        	pp[i]=0;
        }
	}

	
	public void inputName(){
		
	     // Initialize variables

     	PN = new String[playernum];
     	
     		for(int i=0; i<playernum; i++){

     			PN[i] = "Player "+String.valueOf(i+1);

     		}

     // Input Names
        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to skip names?", "Name", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.NO_OPTION){
                for(int i=0; i<playernum; i++){
     	try{
                           PN[i] = JOptionPane.showInputDialog("Enter Name of Player "+ String.valueOf(i+1)+" :");
                           JOptionPane.showMessageDialog(null, PN[i]);
                           } catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Invalid name");
                                PN[i] = "Player "+ String.valueOf(i+1);
                                                              }
                                        }
     	}
     	
     		if(playernum == 2){
     			lp1.setText(PN[0]);
     			lp2.setText(PN[1]);
     			
     			p3g.setVisible(false);
     			lp3.setVisible(false);
     			sp3.setVisible(false);
     			
     			p4g.setVisible(false);
     			lp4.setVisible(false);
     			sp4.setVisible(false);
     			
     		}
     		else if(playernum == 3){
     			lp1.setText(PN[0]);
     			lp2.setText(PN[1]);
     			lp3.setText(PN[2]);
     			
     			p4g.setVisible(false);
     			lp4.setVisible(false);
     			sp4.setVisible(false);
     			
     		}
     		else if(playernum == 4){
     			lp1.setText(PN[0]);
     			lp2.setText(PN[1]);
     			lp3.setText(PN[2]);
     			lp4.setText(PN[3]);
     			

     		}
		
	}
}
