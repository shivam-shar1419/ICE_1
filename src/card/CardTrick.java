package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = fillMagicHand();
        Card userCard = getUserCard();
        
        if (isCardInHand(magicHand, userCard)) {
            System.out.println("Congratulations, your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");

        if (isCardInHand(magicHand, luckyCard)) {
            System.out.println("The lucky card is in the magic hand!");
        } else {
            System.out.println("The lucky card is not in the magic hand.");
        }
    }

    private static Card[] fillMagicHand() {
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1);
            c.setSuit(Card.SUITS[rand.nextInt(4)]);
            magicHand[i] = c;
        }

        return magicHand;
    }

    private static Card getUserCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a card value (1-13): ");
        int value = scanner.nextInt();
        System.out.print("Enter a suit (0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int suitIndex = scanner.nextInt();
        String suit = Card.SUITS[suitIndex];

        Card userCard = new Card();
        userCard.setValue(value);
        userCard.setSuit(suit);

        return userCard;
    }

    private static boolean isCardInHand(Card[] magicHand, Card cardToFind) {
        for (Card card : magicHand) {
            if (card.getValue() == cardToFind.getValue() && card.getSuit().equals(cardToFind.getSuit())) {
                return true;
            }
        }
        return false;
    }
}
