package server

import java.rmi.{RemoteException, Remote}

import client.TokyoClient
import shared.Card

trait TokyoServer extends Remote {
  /**
   * connect new client, create Player for him
   * @param client - new client
   * @return
   */
  @throws(classOf[RemoteException]) def connect(client: TokyoClient): Int

  /**
   * start game
   */
  @throws(classOf[RemoteException]) def startGame()

  /**
   * roll all dice, which can be rolled
   */
  @throws(classOf[RemoteException]) def roll()

  /**
   * buy card
   * @param card - which card you want to buy
   */
  @throws(classOf[RemoteException]) def buy(card: Card)

  /**
   * save dice in order not to roll
   * @param id - which dice
   */
  @throws(classOf[RemoteException]) def putOffDice(id: Int)

  /**
   * return saved dice into game for next roll
   * @param id - which dice
   */
  @throws(classOf[RemoteException]) def playDice(id: Int)

  /**
   * if you cant roll again or if you don't want roll again
   */
  @throws(classOf[RemoteException]) def evaluateRoll()

  /**
   * when you have nothing to do, and next player can play
   */
  @throws(classOf[RemoteException]) def endTurn()

}