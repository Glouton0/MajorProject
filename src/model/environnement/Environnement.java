package model.environnement;

import java.util.*;
import java.math.*;

import model.Coord;

/**
 * Class Environnement
 * @author justine.devaux and thibaut.chataing
 */
public class Environnement {

  private Coord size;
  private Integer obstaclePercent;
  private Integer speedBumpPercent;
  private Map map;
 
  
  /**
   * 
   * @param size of the environment (X*Y)
   * @param obstaclePercent number between 0 and 100
   * @param speedBumpPercent number between 0 and 100
   * The repartition of the case are like that :
   * 	- obstaclePercent defined the number of obstacle
   * 	- speedBumpPercent defined the number of speed bump
   * 	- the rest are free
   */
  public Environnement (Coord size, Integer obstaclePercent, Integer speedBumpPercent) { 
	  this.size=size;
	  this.obstaclePercent=obstaclePercent;
	  this.speedBumpPercent=speedBumpPercent;
	  map= new Map(size);
	  Integer nbObstaclePratique=0;
	  Integer nbSpeedBumpPratique=0;
	  Integer nbCase=size.x*size.y;
	  Integer nbObstacleTheorique=nbCase*obstaclePercent/100;
	  Integer nbSpeedBumpTheorique=nbCase*speedBumpPercent/100;
	  
	  for (Case case1 : map.getListCase()){
		  double numero= Math.random() * 100;
		  double choice = Math.random();
		  
		  if (numero < obstaclePercent + speedBumpPercent) {
			  if ((numero <= obstaclePercent) && (nbObstacleTheorique > nbObstaclePratique)){
				  case1.setEtat(Etat.OBSTACLE);
				  nbObstaclePratique= nbObstaclePratique+1;
				  
			  }
			  else if ((numero <= speedBumpPercent + obstaclePercent) && (nbSpeedBumpTheorique > nbSpeedBumpPratique)){
				  case1.setEtat(Etat.SPEEDBUMP);
				  nbSpeedBumpPratique= nbSpeedBumpPratique+1;
				  
			  }
		  }
		  else {
			  case1.setEtat(Etat.FREE);
		  }
			  
	  }
	  
  };
  
  /**
   * Constructor to generate an environment with the state UNKNOWN everywhere
   * @param size
   */
  public Environnement (Coord size){
	  this.size = size;
	  this.obstaclePercent=0;
	  this.speedBumpPercent=0;
	  this.map= new Map(size);
	  for (Case case1 : map.getListCase()){
		  case1.setEtat(Etat.UNKNOWN);
	  }
	  
  }
  

  /**
   * Set the value of size
   * @param newVar the new value of size
   */
  public void setSize (Coord size) {
    this.size = size;
  }

  /**
   * Get the value of size
   * @return the value of size
   */
  public Coord getSize () {
    return size;
  }
  
  /**
   * Set the value of etat
   * @param c
   * @param e
   */
  public void setEtat(Coord c, Etat e){
	  map.setEtatCase(c, e);
  }

  /**
   * Get the value of obstaclePercent
   * @return the value of obstaclePercent
   */
  public Integer getObstaclePercent () {
    return obstaclePercent;
  }
  
  /**
   * Get the state of the case in the chosen coordinate
   * @param coord
   * @return
   */
  public Etat getEtat (Coord coord){
	  Etat etatCase= Etat.UNKNOWN;
	  etatCase=map.getEtatCase(coord);
	  return etatCase;
  }
  
  /**
   * Convert an environment to a board with label FREE/UNKW/OBST/SPBP
   * @return String[][]
   */
  public String[][] environmentToMatrixTest(){
	  String[][] matrix = new String[size.x][size.y];
	  for (int j = 0 ; j < getSize().x ; j++ ){
		  for (int i = 0 ; i < getSize().x ; i++ ){
			 matrix[i][j] = getEtat(new Coord(i, j)).toString();
		  }
	  }
	return matrix; 
  }
  
  /**
   * Convert an environment to a board with label ./#/?/~
   * @return String[][]
   */
  public String[][] environmentToMatrixAff(){
	  String[][] matrix = new String[size.x][size.y];
	  for (int j = 0 ; j < getSize().x ; j++ ){
		  for (int i = 0 ; i < getSize().x ; i++ ){
			 matrix[i][j] = getEtat(new Coord(i, j)).toAff();
		  }
	  }
	return matrix; 
  }
  
  public static void main(String[] args) {
	Environnement e = new Environnement(new Coord(10, 10), 10 , 10);
}
}


