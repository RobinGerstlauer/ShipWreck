/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Beny
 */
public class CShip {
    private int StartCoordinate;
    private int EndCoordinate;
    public CShip(int startCoordinate, int endCoordinate){
        StartCoordinate = startCoordinate;
        EndCoordinate = endCoordinate;
    }
    
    public int getStartCoordinate() {
        return StartCoordinate;
    }
    
    public int getEndCoordinate() {
        return EndCoordinate;
    }
    
    public int[] getCoordinates() {
        int increment = 1;
        if(StartCoordinate / 10 != EndCoordinate / 10){
            increment = 10;
        }
        if(StartCoordinate > EndCoordinate){
            increment *= -1;
        }
        int[] coordinates = new int[]{-1, -1, -1, -1, -1};
        int i = 0;
        int coordinate = StartCoordinate;
        while(coordinate != EndCoordinate + increment){
            coordinates[i++] = coordinate;
            coordinate += increment;
        }
        return coordinates;
    }
}
