package com.example.javasystemapp;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shaker {
    private static TranslateTransition translateTransition;

    public Shaker(Node node){
   translateTransition = new TranslateTransition(Duration.millis(50), node);
   translateTransition.setFromX(0f);
   translateTransition.setByX(10f);
   translateTransition.setCycleCount(2);
   translateTransition.setAutoReverse(true);
    }
    public void shake(){
        translateTransition.playFromStart();
    }
}
