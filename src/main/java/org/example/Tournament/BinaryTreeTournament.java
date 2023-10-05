package org.example.Tournament;

import org.example.RPSgameLogic;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.*;

public class BinaryTreeTournament {
   // Function to insert a player into the binary tree randomly
    public static Node insertRandomly(Node root, Player player){
        if ( root == null) {
            return new Node(player);
        } else{
            Random random = new Random();
            if(random.nextBoolean()){
                root.left = insertRandomly(root.left, player);
            }else {
                root.right = insertRandomly(root.right, player);
            }
            return root;
        }
    }

    public static Node createTournamentTree(List<Player> players) {
        Node root = null;
        Collections.shuffle(players);
        for(Player player: players){
            root = insertRandomly(root, player);
        }
        return root;
    }

    // To print In-order transversal of the tournament binary tree
    public static void inOrderTransversal(Node root){
        if(root != null) {
            inOrderTransversal(root.left);
            System.out.println(root.player.getName());
            inOrderTransversal(root.right);
        }
    }


    public static Player playGame(Player player1, Player player2){
        if(player1 == null){
            return player2;
        }
        if(player2 == null){
            return player1;
        }
      String player1Move =  player1.makeMove(player2);
        String player2Move =   player2.makeMove(player1);
        if (player1Move.equals(player2Move)) {
            return null ;
        } else if ((player1Move.equals("rock") && player2Move.equals("scissors"))
                || (player1Move.equals("paper") && player2Move.equals("rock"))
                || (player1Move.equals("scissors") && player2Move.equals("paper"))) {
            System.out.println(player1.getName() + " Wins !");
            return player1;
        } else {
            System.out.println(player2.getName() + " wins!");
            return player2;
        }

    }

    public static Player runGame(Node root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root.player;
        }
        Player winnerLeft = runGame(root.left);
        Player winnerRight = runGame(root.right);
        System.out.println("left is " + winnerLeft);
        System.out.println("right is " + winnerRight);


        return playGame(winnerLeft, winnerRight);
    }

    @Override
    public String toString() {
        return "BinaryTreeTournament{}";
    }
}
