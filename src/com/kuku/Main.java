package com.kuku;

public class Main {

    public static void main(String[] args) {
        Player p1 = new Player("player1");
        Player p2 = new Player("player2");
        Player p3 = new Player("player3");
        Player p4 = new Player("player4");
        Player p5 = new Player("player5");

        Lobby lobby = new Lobby();
        lobby.printInventionThreads();

        lobby.sendInvention(p1);
        lobby.sendInvention(p2);
        lobby.sendInvention(p3);
        lobby.sendInvention(p4);
        lobby.sendInvention(p5);
        lobby.sendInvention(p1);

    }
}
