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
}
