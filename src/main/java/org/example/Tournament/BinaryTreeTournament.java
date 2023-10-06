package org.example.Tournament;

import org.example.RPSgameLogic;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.*;

public class BinaryTreeTournament {



    public static Node createTournamentList(List<Player> players){
        List<Node> nodes = new ArrayList<>();

        for (Player player: players){
           nodes.add(new Node(player));
        }

        while (nodes.size() > 1) {
            List<Node>
                    upLevelNodes = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i += 2) {
                Node leftNode = nodes.get(i); // give node at index 0 position left
                Node rightNode = (i + 1 < nodes.size() ? nodes.get(i + 1) : null); // give node at index 1 position right
                Node matchNode = new Node(null); // create a match node for left and right above nodes
                matchNode.setLeft(leftNode);
                matchNode.setRight(rightNode);
                upLevelNodes.add(matchNode);
            }
            nodes = upLevelNodes;
        }

        return nodes.get(0);

    }

    public static Player runTournament(Node root){
        if (root == null || root.getPlayer() != null) {
            return root != null ? root.getPlayer() : null;
        }

        Player leftPlayer = runTournament(root.getLeft());
        Player rightPlayer = runTournament(root.getRight());


        if (leftPlayer == null && rightPlayer == null){
            return null;
        } else if (leftPlayer == null) {
            return rightPlayer;
        } else if (rightPlayer == null) {
            return leftPlayer;
        } else {
            Player matchWinner = playGame(leftPlayer, rightPlayer);
            return matchWinner;

        }


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

        System.out.println(player1.getName() + " Plays against " + player2.getName());


        while (true) {
            String player1Move = player1.makeMove(player2);
            String player2Move = player2.makeMove(player1);
            System.out.println(player1.getName() + " throws " + player1Move);
            System.out.println(player2.getName() + " throws " + player2Move);

            if (player1Move.equals(player2Move)) {
                System.out.println("It's a tie! Both players threw same move. Let's try again!  ");
                continue;

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
    }


    @Override
    public String toString() {
        return "BinaryTreeTournament{}";
    }
}
