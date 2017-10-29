import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here
 * 					資管四乙	B0344209          蕭瑞文
 * Try to write some comments for your codes (methods, 15 points)
 * Card 每張卡片會有一種花色(♣、♦、♥、♠)跟一個點數(1~13)
 * printCard 用來印出每一張Card
 * Deck 就是每副牌 須放入52張 Card (共4種花色*13個點數)
 * printDeck 依據輸入N副牌 會執行N次  每次印出一整副Deck
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		for(int n=0; n<nDeck; n++) {						// 有 N副牌
			for(int i=1; i<=4; i++) {						// Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
				for(int j=1; j<=13; j++){					// 1~13
					Card card=new Card(i,j);	
					cards.add(card);
					}
				}
			}
		}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		int n=1;	// 從第一副牌開始
		for(int i=0;i<cards.size();i++) {
			if(i%52==0) {	// 每發52張牌就是下一副牌
				System.out.print("\n第"+n+"副牌:\n");
				n++;
			}
			cards.get(i).printCard();
		}
		System.out.println("");				//	純粹想換行
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, ♣ Clubs=1, ♦ Diamonds=2, ♥ Hearts=3, ♠ Spades=4
	private int rank; //1~13	
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		// 轉換後列印
		String su="";       // 花色  String Type
		String ra="";		// 點數  String Type
		switch (suit) {
        case 4:
        	su="♠";		// Spades 黑桃
        	switch (rank){
        	case 13:
        		ra="K";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	case 12:
        		ra="Q";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	case 11:
        		ra="J";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	case 1:
        		ra="A";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	default:
        		System.out.print("("+su+" "+getRank()+") ");
        		//					花色			點數
        		break;
        		}
        	break;
        case 3:
        	su="♥";		// Hearts 愛心
        	switch (rank){
        	case 13:
        		ra="K";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	case 12:
        		ra="Q";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	case 11:
        		ra="J";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	case 1:
        		ra="A";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	default:
        		System.out.print("("+su+" "+getRank()+") ");
        		//					花色			點數
        		break;
        		}
        	break;
        case 2:
        	su="♦";		// Diamonds 方塊
        	switch (rank){
        	case 13:
        		ra="K";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	case 12:
        		ra="Q";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	case 11:
        		ra="J";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	case 1:
        		ra="A";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	default:
        		System.out.print("("+su+" "+getRank()+") ");
        		//					花色			點數
        		break;
        		}
        	break;
        case 1:
        	su="♣";		// Clubs 梅花
        	switch (rank){
        	case 13:
        		ra="K";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	case 12:
        		ra="Q";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	case 11:
        		ra="J";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	case 1:
        		ra="A";
        		System.out.print("("+su+" "+ra+") ");
        		//					花色		點數
        		break;
        	default:
        		System.out.print("("+su+" "+getRank()+") ");
        		//					花色			點數
        		break;
        		}
        	break;
        	}
		}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
