package com.kuku;

import java.util.HashSet;
import java.util.Set;

class Lobby {

    private Set<Player> players;
    private Set<InventionThread> inventionThreads;

    Lobby() {
        this.players = new HashSet<>();
        this.inventionThreads = new HashSet<>();
    }

    synchronized
    void addPlayer(Player p){
        if (players.size() < 3){
            players.add(p);
            System.out.println("Player " + p.getName() + " added");
        }else {
            System.out.println("Lobby is full, there is no place for " + p.getName());
        }
    }

    synchronized
    void sendInvention(Player player){
        InventionThread inventionThread = new InventionThread(player,this);
        if (players.contains(player)){
            System.out.println("Player " + player.getName() + " already in lobby");
        }else if (inventionThreads.contains(inventionThread)){
            System.out.println("Invention to " + player.getName() + " already send");
        } else {
            inventionThreads.add(inventionThread);
            Thread thread = new Thread(inventionThread);
            thread.start();
        }
    }

    synchronized
    void printPlayersInLobby(String playerThreadName){
        System.out.println("---------" + playerThreadName + "---------");
        this.players.forEach(System.out::println);
        System.out.println("--------------------------------");
    }

    void printInventionThreads(){
        this.inventionThreads.forEach(System.out::println);
    }
}
