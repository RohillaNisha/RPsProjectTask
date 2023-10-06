package org.example.Tournament;

import org.example.player.Player;

public class Node {
    Node left, right;
    Player player;

    public Node(Player player) {
        this.player = player;
        this.left = null;
        this.right=null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
