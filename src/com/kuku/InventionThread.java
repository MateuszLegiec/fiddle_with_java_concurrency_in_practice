package com.kuku;

import java.util.Objects;

public class InventionThread implements Runnable {

    private final Player player;
    private final Lobby lobby;

    InventionThread(Player player, Lobby lobby){
        this.player = player;
        this.lobby = lobby;
    }

    @Override
    public void run() {
        sleep();
        System.out.println("Invention send to: " + player.getName());
        sleep();
        System.out.println("Waiting for " + player.getName() + " acceptation...");
        sleep();
        System.out.println(player.getName() + " accept invention!");
        sleep();
        lobby.addPlayer(player);
        sleep();
        lobby.printPlayersInLobby(player.getName() + " thread");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventionThread)) return false;
        InventionThread thread = (InventionThread) o;
        return Objects.equals(player, thread.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }

    @Override
    public String toString() {
        return "InventionThread{" +
                "player=" + player +
                ", lobby=" + lobby +
                '}';
    }

    private void sleep(){
        try {
//            Thread.sleep(ThreadLocalRandom.current().nextInt(400, 601));
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
