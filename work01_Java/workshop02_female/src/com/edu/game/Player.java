package com.edu.game;

public class Player {

	private int playerInput;
	private int winCnt;
	private int loseCnt;

    public Player() {}

    public int getPlayerInput() {return playerInput;}
    public int getWinCnt() {return winCnt;}
    public int getLoseCnt() {return loseCnt;}

    public void addWinCnt() {this.winCnt++;}
    public void addLoseCnt() {this.loseCnt++;}

    public void setPlayerInput(String str) {

        if (str.equals("가위")) {
            this.playerInput = 1;
        }
        else if (str.equals("바위")) {
            this.playerInput = 2;
        }
        else if (str.equals("보")) {
            this.playerInput = 3;
        }
        else {
        	System.out.println("잘못선택했습니다.");
        	this.playerInput = 0;
        }
    }



}
