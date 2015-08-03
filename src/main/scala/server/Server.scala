package server

import java.rmi.Naming
import java.rmi.registry.LocateRegistry
import java.rmi.server.UnicastRemoteObject

import client.TokyoClient
import shared.Card

object Server extends UnicastRemoteObject with TokyoServer{

  def main(args: Array[String]): Unit = {
    LocateRegistry.createRegistry(1099)
    Naming.rebind("TokyoServer", this)
  }

  /**
   * connect new client, create Player for him
   * @param client - new client
   * @return
   */
  override def connect(client: TokyoClient): Int = {
    5
   // throw new RuntimeException("nie si na rade")
  }

  /**
   * start game
   */
  override def startGame(): Unit = {}

  /**
   * if you cant roll again or if you don't want roll again
   */
  override def evaluateRoll(): Unit = {}

  /**
   * buy card
   * @param card - which card you want to buy
   */
  override def buy(card: Card): Unit = {}

  /**
   * when you have nothing to do, and next player can play
   */
  override def endTurn(): Unit = {}

  /**
   * return saved dice into game for next roll
   * @param id - which dice
   */
  override def playDice(id: Int): Unit = {}

  /**
   * roll all dice, which can be rolled
   */
  override def roll(): Unit = {}

  /**
   * save dice in order not to roll
   * @param id - which dice
   */
  override def putOffDice(id: Int): Unit = {}
}
