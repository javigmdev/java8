package com.java.collections.model;

import java.util.List;

public class Player implements Comparable<Player>{

    private String name;
    private Integer age;
    private Position mainPosition;
    private List<Position> alternativePositions;

    public Player(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Player(String name, Integer age, Position mainPosition) {
        this.name = name;
        this.age = age;
        this.mainPosition = mainPosition;
    }

    public Player(String name, Integer age, Position mainPosition, List<Position> alternativePositions) {
        this.name = name;
        this.age = age;
        this.mainPosition = mainPosition;
        this.alternativePositions = alternativePositions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Position getMainPosition() {
        return mainPosition;
    }

    public void setMainPosition(Position mainPosition) {
        this.mainPosition = mainPosition;
    }

    public List<Position> getAlternativePositions() {
        return alternativePositions;
    }

    public void setAlternativePositions(List<Position> alternativePositions) {
        this.alternativePositions = alternativePositions;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Player player) {
        if(getAge().equals(player.getAge()))
            return 0;
        else if(getAge() < player.getAge())
            return -1;
        return 1;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((mainPosition == null) ? 0 : mainPosition.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (mainPosition != other.mainPosition)
            return false;
        return true;
    }

    public static Player eldest(Player player1, Player player2){
        return player1.getAge() > player2.getAge() ? player1 : player2;
    }

    public static int compareByAgeAndNameLength(Player player1, Player player2){
        if(player1.getAge() <= player2.getAge()) {
            if(player1.getName().length() <= player2.getName().length())
                return -1;
            else
                return 1;
        }
        else
            return 1;
    }

    public void print(){
        System.out.println(this);
    }

}
